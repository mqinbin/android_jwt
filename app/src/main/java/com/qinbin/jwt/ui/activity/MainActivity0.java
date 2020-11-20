package com.qinbin.jwt.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import com.qinbin.jwt.R;
import com.qinbin.jwt.util.FileUtils;

public class MainActivity0 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main1);
		copyDbIfNessary();
	}

	private void copyDbIfNessary() {

		FileUtils.copyFileFromAssetsToDbpath(this, "dict.db");
	}
}
