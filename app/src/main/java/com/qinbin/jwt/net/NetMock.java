package com.qinbin.jwt.net;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;
import android.os.SystemClock;

import com.qinbin.jwt.dao.DBHelper;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

public class NetMock {
	public static final int PAGE_SIZE = 10;
	private static DBHelper helper;

	public static void init(Context ctx) {
		helper = OpenHelperManager.getHelper(ctx, DBHelper.class);

	}

	public static <T> int queryCount(Class<T> klass) {
		// SystemClock.sleep((long) (Math.random() * 1000));
		System.out.println(klass + "queryCount");
		try {
			Dao<T, ?> dao = helper.getDao(klass);
			QueryBuilder<T, ?> qb = dao.queryBuilder();
			qb.countOf();
			return (int) dao.countOf(qb.prepare());
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static <T> List<T> queryContent(Class<T> klass) {
		// SystemClock.sleep((long) (Math.random() * 1000));
		System.out.println(klass + "queryContent");

		try {
			Dao<T, ?> dao = helper.getDao(klass);
			List result  = dao.queryForAll();
			System.out.println("--result" + result);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
