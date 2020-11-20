package com.qinbin.jwt.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.qinbin.jwt.R;
import com.qinbin.jwt.domin.DictItem;

public class DictsAdapter extends BaseAdapter {
	private List<DictItem> allDi;
	private Context ctx;
//	private List<DictItem> choosedDi;
	private ArrayList<ChooseHolder> chooseHolders;

	public static class ChooseHolder {
		public DictItem dictItem;
		public boolean checked;

		public ChooseHolder(DictItem dictItem, boolean checked) {
			this.dictItem = dictItem;
			this.checked = checked;
		}
	}

	public DictsAdapter(Context ctx, List<DictItem> allDi, List<DictItem> choosedDi) {
		this.allDi = allDi;
		this.ctx = ctx;
//		this.choosedDi = choosedDi;
		this.chooseHolders = new ArrayList<ChooseHolder>();
		for (DictItem di : allDi) {
			chooseHolders.add(new ChooseHolder(di, choosedDi.contains(di)));
		}

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(ctx, R.layout.item_dicts, null);
			ViewHolder vh = new ViewHolder();
			vh.cb = (CheckBox) convertView.findViewById(R.id.item_dis_cb);
			vh.left = (TextView) convertView.findViewById(R.id.item_dis_key);
			vh.right = (TextView) convertView.findViewById(R.id.item_dis_value);
			convertView.setTag(vh);
		}
		ViewHolder vh = (ViewHolder) convertView.getTag();
		vh.cb.setChecked(chooseHolders.get(position).checked);
		vh.left.setText(allDi.get(position).getKey());
		vh.right.setText(allDi.get(position).getValue());
		return convertView;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public ChooseHolder getItem(int position) {
		return chooseHolders.get(position);
	}

	@Override
	public int getCount() {
		if (allDi == null) {
			return 0;
		} else {
			return allDi.size();
		}
	}

	public static class ViewHolder {
		CheckBox cb;
		TextView left;
		TextView right;
		public CheckBox getCb() {
			return cb;
		}
		
	}
}
