package com.qinbin.jwt.ui.activity;

import java.io.Serializable;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.qinbin.jwt.R;
import com.qinbin.jwt.ui.adapter.MyListAdapter;
import com.qinbin.jwt.util.ReflectUtil;
import com.qinbin.jwt.util.UiUtils;

public class ListActivity extends Activity {
	private LinearLayout titleLine;
	private ListView contentLv;
	private Class<?> klass;
	private List beans;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_list);
		titleLine = (LinearLayout) findViewById(R.id.list_title);
		contentLv = (ListView) findViewById(R.id.list_listview);

		Intent intent = getIntent();
		klass = (Class<?>) intent.getSerializableExtra("class");
		beans = (List) intent.getSerializableExtra("beans");

		setTitle(ReflectUtil.getTitlte(klass) + "列表");

		UiUtils.fillTitleByClass(titleLine, klass, true);
		final MyListAdapter adapter = new MyListAdapter(this, beans, true);
		contentLv.setAdapter(adapter);
		contentLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// Toast.makeText(parent.getContext(), "" + position,
				// Toast.LENGTH_SHORT).show();
				DetailActivity.startMe(ListActivity.this, adapter.getItem(position));
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			finish();
		}

	}

	public static void startMe(Context context, Class<?> beanClass, List beans) {
		Intent intent = new Intent(context, ListActivity.class);
		intent.putExtra("class", beanClass);
		if (beans instanceof Serializable) {
			intent.putExtra("beans", (Serializable) beans);
		} else {
			throw new IllegalArgumentException("传入的集合需要序列化。");
		}
		context.startActivity(intent);
	}
}
