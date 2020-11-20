package com.qinbin.jwt.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.LruCache;
import com.qinbin.jwt.constant.DictConstant;
import com.qinbin.jwt.domin.DictItem;

public class DictUtils {
	/**
	 * this method will take some time , use it in thread better.
	 * */
	private static final String DB_NAME = "dict.db";
	private static final String[] COLS = new String[] { "DM", "MC" };

	public static List<DictItem> queryDict(Context ctx, String dictName) {
		List<DictItem> dis = null;

		if (shortCache.containsKey(dictName)) {
			dis = shortCache.get(dictName);
		} else if (longCache.get(dictName) != null) {
			dis = longCache.get(dictName);
		} else {
			dis = new ArrayList<DictItem>();
//			SystemClock.sleep(1000);
			Cursor cursor = getDb(ctx).query(dictName, COLS, null, null, null, null, null);
			while (cursor.moveToNext()) {
				dis.add(new DictItem(cursor.getString(0), cursor.getString(1)));
			}
			cursor.close();
			Collections.sort(dis);
			dis = Collections.unmodifiableList(dis);
			if (dis.size() <= 10) {
				shortCache.put(dictName, dis);
			} else {
				longCache.put(dictName, dis);
			}
		}
		return dis;
	}

	private static Map<String, List<DictItem>> shortCache = new HashMap<String, List<DictItem>>();
	private static LruCache<String, List<DictItem>> longCache = new LruCache<String, List<DictItem>>(5);

	public static DictItem query(Context ctx, String dictName, String key) {
		for (DictItem di : queryDict(ctx, dictName)) {
			if (di.getKey().equals(key)) {
				return di;
			}
		}
		return null;
	}

	public static class DictQueryTast extends AsyncTask<String, Void, List<DictItem>> {

		private Context ctx;
		private String dictName;

		public DictQueryTast(Context ctx) {
			this.ctx = ctx;
		}

		@Override
		protected List<DictItem> doInBackground(String... params) {
			dictName = params[0];
			return queryDict(ctx, dictName);
		}
	}

	public static List<DictItem> transKeysToDI(Context context, String dictName, String keyString) {
		List<DictItem> allDis = queryDict(context, dictName);
		List<DictItem> result = new ArrayList<DictItem>();
		if (DictConstant.isBitDict(dictName)) {
			if (keyString != null && keyString.length() != 0) {
				for (int i = 0; i < keyString.length() && i < result.size(); i++) {
					if (!keyString.substring(i, i + 1).equals("0")) {
						result.add(allDis.get(i));
					}
				}
			}
		} else {
			if (keyString != null && keyString.length() != 0) {
				String[] keys = keyString.split(",");
				for (String key : keys) {
					for (DictItem di : allDis) {
						if (di.getKey().equals(key)) {
							result.add(di);
						}
					}
				}
			}
		}
		return result;
	}

	public static String transDITokey(Context context, String dictName, List<DictItem> dis) {
		StringBuilder sb = new StringBuilder();
		if (DictConstant.isBitDict(dictName)) {
			List<DictItem> allDis = queryDict(context, dictName);
			if (dis == null || dis.size() == 0) {
				for (int i = 0; i < allDis.size(); i++) {
					sb.append("0");
				}
			} else {
				for (DictItem di : allDis) {
					sb.append(dis.contains(di) ? "1" : "0");
				}
			}

		} else {
			if (dis != null && dis.size() > 0) {
				for (DictItem di : dis) {
					sb.append(di.getKey() + ",");
				}
				sb.deleteCharAt(sb.length() - 1);
			}
		}

		return sb.toString();
	}

	public static String transDIToValue(Context context, String dictName, List<DictItem> dis) {
		StringBuilder sb = new StringBuilder();
		if (dis != null && dis.size() > 0) {
			for (DictItem di : dis) {
				sb.append(di.getValue() + ",");
			}
			sb.deleteCharAt(sb.length() - 1);
		}

		return sb.toString();
	}

	public static List<DictItem> queryNextLevel(Context context, String dictName, DictItem chooseDi, int level) {
		if (!DictConstant.isLevelDict(dictName)) {
			throw new IllegalArgumentException("this dict is not levelDict");
		}
		int[] lvs = DictConstant.dictLvs(dictName);
		if (level > lvs.length - 1) {
			throw new IllegalArgumentException("the level given is larger than ??: level." + level + " lvs.length."
					+ lvs.length);
		}

		StringBuilder sb = new StringBuilder();
		if (level != 0) {
			sb.append(chooseDi.getKey().substring(0, sum(Arrays.copyOfRange(lvs, 0, level))));
		}

		sb.append(".{" + lvs[level] + "}");

		int t = sum(Arrays.copyOfRange(lvs, level + 1, lvs.length));
		if(t !=0){
			sb.append(String.format("%0" + t + "d", 0));
		}

		Pattern p = Pattern.compile(sb.toString());

		List<DictItem> allDi = queryDict(context, dictName);
		List<DictItem> result = new ArrayList<DictItem>();
		for (DictItem dictItem : allDi) {
			if (p.matcher(dictItem.getKey()).matches()) {
				result.add(dictItem);
			}
		}
		return result;
	}

	private static int sum(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result += nums[i];
		}
		return result;
	}

	private static SQLiteDatabase db;

	private static SQLiteDatabase getDb(Context ctx) {
		if (db == null) {
			db = ctx.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
		}
		return db;
	}
}
