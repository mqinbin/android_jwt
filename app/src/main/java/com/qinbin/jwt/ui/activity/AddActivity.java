package com.qinbin.jwt.ui.activity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.qinbin.jwt.R;
import com.qinbin.jwt.dao.DBHelper;
import com.qinbin.jwt.util.ReflectUtil;
import com.qinbin.jwt.util.UiUtils;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;

public class AddActivity extends Activity implements OnClickListener {

	private LinearLayout line;
	private Object bean;
	private OrmLiteSqliteOpenHelper helper;
	private Dao dao;
	private Class<?> klass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);

		klass = (Class<?>) getIntent().getSerializableExtra("class");
		if (klass == null) {
			throw new IllegalArgumentException("");
		}
		helper = OpenHelperManager.getHelper(this, DBHelper.class);
		try {
			dao = helper.getDao(klass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setTitle(ReflectUtil.getTitlte(klass) + "注册");

		line = (LinearLayout) findViewById(R.id.add_container_line);
		bean = newBean(klass);
		UiUtils.fillFormByBean(line, bean);

		findViewById(R.id.add_save_btn).setOnClickListener(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		OpenHelperManager.releaseHelper();

	}

	public static void startMe(Context contenxt, Class<?> klass) {
		if (klass == null) {
			throw new IllegalArgumentException("klass can't be null");
		}
		Intent intent = new Intent(contenxt, AddActivity.class);
		intent.putExtra("class", klass);
		contenxt.startActivity(intent);
	}

	private <T> T newBean(Class<T> klass) {
		try {
			Constructor<T> constructor = klass.getConstructor();
			return constructor.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException("klass no public args free constructor!");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.add_save_btn:
			if (UiUtils.valiaWithNotify(line)) {
				UiUtils.fillBeanByForm(line, bean);
				try {
					dao.create(bean);
					Toast.makeText(v.getContext(), "添加成功", Toast.LENGTH_SHORT).show();
				} catch (SQLException e) {
					Toast.makeText(v.getContext(), "添加失败", Toast.LENGTH_LONG).show();
				}
				cleanLine();
			}

			break;

		}
	}

	private void cleanLine() {
		line.removeAllViews();
		bean = newBean(klass);
		UiUtils.fillFormByBean(line, bean);
	}
}
