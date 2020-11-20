package com.qinbin.jwt.ui.widget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.qinbin.jwt.R;
import com.qinbin.jwt.domin.DictItem;
import com.qinbin.jwt.ui.adapter.DictsAdapter;
import com.qinbin.jwt.ui.adapter.DictsAdapter.ChooseHolder;
import com.qinbin.jwt.ui.adapter.DictsAdapter.ViewHolder;
import com.qinbin.jwt.util.DictUtils;

public class DictsChooseDialog extends AlertDialog {

	interface OnChooseListener {
		void onChoose(List<DictItem> chooses);
	}

	private String dictName;
	private View topView;
	private ListView bottomLv;
	private List<DictItem> hasChoosed;
	private List<DictItem> myChoosed;

	protected DictsChooseDialog(Context context, String dictName, List<DictItem> hasChoosed) {
		super(context);
		this.dictName = dictName;
		if (hasChoosed == null) {
			this.hasChoosed = new ArrayList<DictItem>();
		} else {
			this.hasChoosed = hasChoosed;
		}

		myChoosed = new ArrayList<DictItem>(this.hasChoosed);
		setTitle("请选择");
		View v = View.inflate(getContext(), R.layout.layout_dict_choose, null);
		setView(v);
		topView = v.findViewById(R.id.dict_choose_rl_up);
		bottomLv = (ListView) v.findViewById(R.id.dict_choose_lv_down);
		setButton(DialogInterface.BUTTON_POSITIVE, "sure", ocl);
		setButton(DialogInterface.BUTTON_NEUTRAL, "empty", ocl);
		setButton(DialogInterface.BUTTON_NEGATIVE, "cancel", ocl);
	}

	@Override
	public void show() {
		super.show();
		new DictUtils.DictQueryTast(getContext() ) {
			@Override
			protected void onPreExecute() {
				topView.setVisibility(View.VISIBLE);
				bottomLv.setVisibility(View.INVISIBLE);
			}

			@Override
			protected void onPostExecute(List<DictItem> result) {
				final DictsAdapter dictsAdapter = new DictsAdapter(getContext(), result, hasChoosed);
				bottomLv.setAdapter(dictsAdapter);
				bottomLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						ChooseHolder ch = dictsAdapter.getItem(position);
						ch.checked = !ch.checked;
						DictsAdapter.ViewHolder vh = (ViewHolder) view.getTag();
						vh.getCb().toggle();
						if (ch.checked) {
							myChoosed.add(ch.dictItem);
						} else {
							myChoosed.remove(ch.dictItem);
						}
					}
				});
				topView.setVisibility(View.INVISIBLE);
				bottomLv.setVisibility(View.VISIBLE);
			}
		}.execute(dictName);
	}

	private OnChooseListener oclr;

	public void setOnChooseListener(OnChooseListener oclr) {
		this.oclr = oclr;
	}

	DialogInterface.OnClickListener ocl = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case BUTTON_POSITIVE:
				Collections.sort(myChoosed);
				oclr.onChoose(myChoosed);
				break;
			case BUTTON_NEUTRAL:
				oclr.onChoose(null);
			case BUTTON_NEGATIVE:
				break;
			}
			dismiss();
		}
	};

}
