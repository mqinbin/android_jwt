package com.qinbin.jwt.ui.widget;

import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.qinbin.jwt.R;
import com.qinbin.jwt.constant.DictConstant;
import com.qinbin.jwt.domin.DictItem;
import com.qinbin.jwt.ui.adapter.DictAdapter;
import com.qinbin.jwt.util.DictUtils;

public class DictChooseDialog extends AlertDialog {

	interface OnChooseListener {
		void onChoose(DictItem di);
	}

	private String dictName;
	private View topView;
	private ListView bottomLv;
	List<DictItem> toshow;
	int clickCount = 0;

	protected DictChooseDialog(Context context, String dictName) {
		super(context);
		this.dictName = dictName;
		setTitle("请选择");
		View v = View.inflate(getContext(), R.layout.layout_dict_choose, null);
		setView(v);
		topView = v.findViewById(R.id.dict_choose_rl_up);
		bottomLv = (ListView) v.findViewById(R.id.dict_choose_lv_down);

		setButton(DialogInterface.BUTTON_POSITIVE, "empty", ocl);
		setButton(DialogInterface.BUTTON_NEGATIVE, "cancel", ocl);
	}

	@Override
	public void show() {
		super.show();
		new DictUtils.DictQueryTast(getContext()) {
			@Override
			protected void onPreExecute() {
				topView.setVisibility(View.VISIBLE);
				bottomLv.setVisibility(View.INVISIBLE);
			}

			@Override
			protected void onPostExecute(List<DictItem> result) {
				System.out.println("onPostExecute");
				final List<DictItem> showDi;
				if (DictConstant.isLevelDict(dictName)) {
					showDi = DictUtils.queryNextLevel(getContext(), dictName, null, 0);
				}else{
					showDi = result;
				}

				final DictAdapter dictAdapter = new DictAdapter(getContext(), showDi);
				bottomLv.setAdapter(dictAdapter);
				bottomLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						clickCount++;
						if (DictConstant.isLevelDict(dictName)) {
							if (clickCount == DictConstant.dictLvs(dictName).length) {
								oclr.onChoose(dictAdapter.getItem(position));
								dismiss();
							} else {
								List<DictItem> toShowDi = DictUtils.queryNextLevel(getContext(), dictName,
										dictAdapter.getItem(position), clickCount);
								if (toShowDi.size() == 1) {
									oclr.onChoose(toShowDi.get(0));
									dismiss();
								} else {
									showDi.clear();
									showDi.addAll(toShowDi);
									dictAdapter.notifyDataSetChanged();
								}

							}

						} else {
							oclr.onChoose(dictAdapter.getItem(position));
							dismiss();
						}

					}
				});

				topView.setVisibility(View.INVISIBLE);
				bottomLv.getParent().requestLayout();
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
				oclr.onChoose(null);
				dismiss();
				break;
			case BUTTON_NEGATIVE:
				dismiss();
				break;
			}
		}
	};

}
