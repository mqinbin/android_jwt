package com.qinbin.jwt.ui.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.qinbin.jwt.R;
import com.qinbin.jwt.domin.DictItem;

public class DictAdapter extends BaseAdapter {
	private List<DictItem> dis;
	private Context ctx;

	public DictAdapter(Context ctx, List<DictItem> dis) {
		this.dis = dis;
		this.ctx = ctx;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(ctx, R.layout.item_dict, null);
			ViewHolder vh = new ViewHolder();
			vh.left = (TextView) convertView.findViewById(R.id.item_di_key);
			vh.right = (TextView) convertView.findViewById(R.id.item_di_value);
			convertView.setTag(vh);
		}
		ViewHolder vh = (ViewHolder) convertView.getTag();
		vh.left.setText(dis.get(position).getKey());
		vh.right.setText(dis.get(position).getValue());
		return convertView;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public DictItem getItem(int position) {
		return dis.get(position);
	}

	@Override
	public int getCount() {
		if (dis == null) {
			return 0;
		} else {
			return dis.size();
		}
	}

	private static class ViewHolder {
		TextView left;
		TextView right;
	}
}