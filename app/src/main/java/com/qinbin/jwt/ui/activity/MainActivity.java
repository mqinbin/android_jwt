package com.qinbin.jwt.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.qinbin.jwt.R;
import com.qinbin.jwt.domin.Jdc;
import com.qinbin.jwt.domin.JgJbxx;
import com.qinbin.jwt.domin.RyJbxx;
import com.qinbin.jwt.util.FileUtils;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		findViewById(R.id.main_add_jdc_btn).setOnClickListener(this);
		findViewById(R.id.main_view_btn).setOnClickListener(this);
		findViewById(R.id.main_add_ry_btn).setOnClickListener(this);
		findViewById(R.id.main_add_jg_btn).setOnClickListener(this);

		setTitle("警务通");
		copyDbIfNessary();
	}

	private void copyDbIfNessary() {

		FileUtils.copyFileFromAssetsToDbpath(this, "dict.db");
	}

	public void onClick(View v) {
		Class c = null;
		switch (v.getId()) {
		case R.id.main_add_jdc_btn:
			c = Jdc.class;
			break;
		case R.id.main_add_ry_btn:
			c = RyJbxx.class;
			break;
		case R.id.main_add_jg_btn:
			c = JgJbxx.class;
			break;
		case R.id.main_view_btn:
			Intent intent = new Intent(this, SummaryActivity.class);
			startActivity(intent);
			return;
		}

		AddActivity.startMe(this, c);

	}
}
