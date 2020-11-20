package com.qinbin.jwt.ui.activity;

import java.io.Serializable;
import java.sql.SQLException;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.qinbin.jwt.R;
import com.qinbin.jwt.dao.DBHelper;
import com.qinbin.jwt.util.ReflectUtil;
import com.qinbin.jwt.util.UiUtils;

public class DetailActivity extends Activity implements OnClickListener {
	private LinearLayout containerLine;
	private Object bean;
	private Dao dao;
	private DBHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		Intent intent = getIntent();
		bean = intent.getSerializableExtra("bean");

		helper = OpenHelperManager.getHelper(this, DBHelper.class);
		try {
			dao = helper.getDao(bean.getClass());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		containerLine = (LinearLayout) findViewById(R.id.detail_container_line);
		UiUtils.fillShowByBean(containerLine, bean);

		setTitle(ReflectUtil.getTitlte(bean.getClass()) + "详情");

		findViewById(R.id.detail_delete_btn).setOnClickListener(this);

	}

	public static <T> void startMe(Activity context, T bean) {
		if (!(bean instanceof Serializable)) {
			throw new IllegalArgumentException("bean sould be imp Serializable");
		}
		Intent intent = new Intent(context, DetailActivity.class);
		intent.putExtra("bean", (Serializable) bean);
		context.startActivityForResult(intent, 1);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.detail_delete_btn:
			try {
				dao.delete(bean);
				setResult(RESULT_OK);
				finish();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;

		}

	}

}
