package com.qinbin.jwt.ui.adapter;

import java.util.List;

import com.qinbin.jwt.util.UiUtils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

public class MyListAdapter extends BaseAdapter {
	private List beans;
	private Context context;
	private boolean absolute;

	public MyListAdapter(Context context, List beans, boolean absolute) {
		this.beans = beans;
		this.context = context;
		this.absolute = absolute;
	}

	@Override
	public int getCount() {
		if (beans == null) {
			return 0;
		} else {
			return beans.size();
		}
	}

	@Override
	public Object getItem(int position) {
		return beans.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = new LinearLayout(context);
			LayoutParams lp = null;
			if (absolute) {
				lp = new AbsListView.LayoutParams(AbsListView.LayoutParams.WRAP_CONTENT,
						AbsListView.LayoutParams.WRAP_CONTENT);
			} else {
				lp = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
						AbsListView.LayoutParams.WRAP_CONTENT);
			}
			convertView.setLayoutParams(lp);
			((LinearLayout) convertView).setOrientation(LinearLayout.HORIZONTAL);
			
		}

		UiUtils.fillListItemByBean((LinearLayout) convertView, getItem(position), absolute);
		return convertView;
	}

}
