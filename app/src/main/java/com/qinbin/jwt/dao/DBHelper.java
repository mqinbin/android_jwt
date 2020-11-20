package com.qinbin.jwt.dao;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.qinbin.jwt.domin.Jdc;
import com.qinbin.jwt.domin.JgJbxx;
import com.qinbin.jwt.domin.RyJbxx;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DBHelper extends OrmLiteSqliteOpenHelper {
	private static final String DB_NAME = "content.db";
	private static final int DB_VERSION = 1;

	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, Jdc.class);
			TableUtils.createTable(connectionSource, RyJbxx.class);
			TableUtils.createTable(connectionSource, JgJbxx.class);
		} catch (SQLException e) {
			throw new RuntimeException("table create failed:" + e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			TableUtils.dropTable(connectionSource, Jdc.class, true);
			TableUtils.dropTable(connectionSource, RyJbxx.class, true);
			TableUtils.dropTable(connectionSource, JgJbxx.class, true);

			TableUtils.createTable(connectionSource, Jdc.class);
			TableUtils.createTable(connectionSource, RyJbxx.class);
			TableUtils.createTable(connectionSource, JgJbxx.class);
		} catch (SQLException e) {
			throw new RuntimeException("table upgrade failed:" + e);
		}
	}

}
