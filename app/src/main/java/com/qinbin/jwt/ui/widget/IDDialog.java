package com.qinbin.jwt.ui.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.qinbin.jwt.R;

public class IDDialog extends AlertDialog {
	/** 身份证 */
	public static final int TYPE_IDCARD = 1;
	/** 车牌号 */
	public static final int TYPE_CARID = 2;

	static private String[] numsIdcard = new String[] { "1", "2", "3", "4",
			"5", "6", "7", "8", "9", "X", "0", "" };
	static private String[] numsCarId = new String[] { "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "", "0", "" };
	static private String[] chars = new String[] { "A", "B", "C", "D", "E",
			"F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
			"S", "T", "U", "V", "W", "X", "Y", "Z", "" };
	static private String[] provinces = new String[] { "鄂", "湘", "川", "渝", "豫",
			"皖", "沪", "京", "浙", "云", "粤", "新", "苏", "陕", "琼", "青", "宁", "闽",
			"蒙", "鲁", "辽", "晋", "津", "冀", "吉", "黑", "桂", "贵", "赣", "甘", "鄂",
			"藏" };

	interface OnChooseListener {
		void onChoose(String s);
	}

	private OnChooseListener oclr;

	public void setOnChooseListener(OnChooseListener oclr) {
		this.oclr = oclr;
	}

	private int type;
	private int index = 1;
	private View contentView;
	private EditText inputEt;
	private Button numBtn;
	private Button charBtn;
	private Button provienceBtn;
	private Button[] btns;
	private String old;

	protected IDDialog(Context context, String old, int type) {
		super(context);

		this.old = old;
		this.type = type;
		initView();

	}

	@Override
	public void show() {
		super.show();

	}

	private void initView() {
		contentView = View.inflate(getContext(),
				R.layout.dialog_input_assitant, null);
		inputEt = (EditText) contentView.findViewById(R.id.assistant_et);
		contentView.findViewById(R.id.assistant_btn_start).setOnClickListener(
				controlOcl);
		contentView.findViewById(R.id.assistant_btn_left).setOnClickListener(
				controlOcl);
		contentView.findViewById(R.id.assistant_btn_right).setOnClickListener(
				controlOcl);
		contentView.findViewById(R.id.assistant_btn_end).setOnClickListener(
				controlOcl);
		contentView.findViewById(R.id.assistant_btn_delete).setOnClickListener(
				controlOcl);

		numBtn = (Button) contentView.findViewById(R.id.assistant_btn_num);
		charBtn = (Button) contentView.findViewById(R.id.assistant_btn_char);
		provienceBtn = (Button) contentView
				.findViewById(R.id.assistant_btn_provience);

		numBtn.setOnClickListener(typeOcl);
		charBtn.setOnClickListener(typeOcl);
		provienceBtn.setOnClickListener(typeOcl);

		btns = new Button[] { numBtn, charBtn, provienceBtn };

		numVG = (ViewGroup) contentView
				.findViewById(R.id.input_assistant_num_vg);
		charVG = (ViewGroup) contentView
				.findViewById(R.id.input_assistant_char_vg);
		provienceVG = (ViewGroup) contentView
				.findViewById(R.id.input_assistant_provience_vg);

		vgs = new ViewGroup[] { numVG, charVG, provienceVG };

		setView(contentView);
		switch (type) {
		case TYPE_IDCARD:
			setupSFZ();
			break;
		case TYPE_CARID:
			setupCPH();
			break;
		default:
			throw new IllegalArgumentException("类型不对！" + type);
		}
		setButton(DialogInterface.BUTTON_POSITIVE, "sure", diocl);
		setButton(DialogInterface.BUTTON_NEGATIVE, "cancle", diocl);
	}

	DialogInterface.OnClickListener diocl = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case BUTTON_POSITIVE:
				oclr.onChoose(inputEt.getText().toString());
				break;
			case BUTTON_NEGATIVE:

				break;
			}
			dismiss();
		}
	};

	public void setupSFZ() {
		setTitle("请输入身份证号");
		index = 0;
		updateView();
		addItem(numVG, numsIdcard);
		inputEt.setText(old);
		setView(contentView);
	}

	public void setupCPH() {
		setTitle("请输入车牌号");
		index = 2;
		updateView();
		addItem(numVG, numsCarId);
		addItem(charVG, chars);
		addItem(provienceVG, provinces);
		inputEt.setText(old);
		setView(contentView);
	}

	private void addItem(ViewGroup vg, String[] strs) {
		LinearLayout line = null;
		for (int i = 0; i < strs.length; i++) {
			if (i % 3 == 0) {
				line = new LinearLayout(getContext());
			} else if (i % 3 == 2) {
				if(vg instanceof ScrollView){
					((LinearLayout)vg.getChildAt(0)).addView(line);
				}else{
					vg.addView(line);
				}
			}
			line.addView(getNewButton(strs[i], inputOcl));
		}

	}

	private void updateView() {
		for (int i = 0; i < 3; i++) {
			if (i == index) {
				btns[i].setSelected(true);
				vgs[i].setVisibility(View.VISIBLE);
			} else {
				btns[i].setSelected(false);
				vgs[i].setVisibility(View.GONE);
			}
		}

		if (type == TYPE_IDCARD) {
			charBtn.setEnabled(false);
			provienceBtn.setEnabled(false);
		}

	}

	private View.OnClickListener controlOcl = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.assistant_btn_start:
				inputEt.setSelection(0);
				break;
			case R.id.assistant_btn_end:
				inputEt.setSelection(inputEt.getText().length());
				break;
			case R.id.assistant_btn_left:
				int start = inputEt.getSelectionStart();
				if (start > 0) {
					inputEt.setSelection(start - 1);
				}
				break;
			case R.id.assistant_btn_right:
				int end = inputEt.getSelectionStart();
				if (end < inputEt.getText().length()) {
					inputEt.setSelection(end + 1);
				}
				break;
			case R.id.assistant_btn_delete:
				int start2 = inputEt.getSelectionEnd();
				if (start2 > 0) {
					inputEt.getText().delete(start2 - 1, start2);
				}
				break;
			}
		}
	};
	private View.OnClickListener typeOcl = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			int myIndex = 0;
			switch (v.getId()) {
			case R.id.assistant_btn_num:
				myIndex = 0;
				break;
			case R.id.assistant_btn_char:
				myIndex = 1;
				break;
			case R.id.assistant_btn_provience:
				myIndex = 2;
				break;
			}
			if (myIndex == index) {
				return;
			} else {
				index = myIndex;
				updateView();
			}

		}
	};
	private View.OnClickListener inputOcl = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			String c = ((Button) v).getText().toString();
			if (allowMore()) {
				inputEt.getText().insert(inputEt.getSelectionStart(), c);
			}
		}

	};

	private boolean allowMore() {
		if (type == TYPE_CARID) {
			if (inputEt.getText().toString().length() < 7)
				return true;
		} else if (type == TYPE_IDCARD) {
			if (inputEt.getText().toString().length() < 18)
				return true;
		}
		return false;
	}

	private ViewGroup numVG;
	private ViewGroup charVG;
	private ViewGroup provienceVG;
	private ViewGroup[] vgs;

	private Button getNewButton(String text, View.OnClickListener ocl) {
		LinearLayout.LayoutParams btnLayoutParams = new LinearLayout.LayoutParams(
				0, getContext().getResources().getDimensionPixelSize(
						R.dimen.input_assistant_btn_height), 1);
		int marginPixel = getContext().getResources().getDimensionPixelOffset(
				R.dimen.input_assistant_margin_between);
		btnLayoutParams.setMargins(marginPixel, marginPixel, marginPixel,
				marginPixel);
		float btnTextSize = getContext().getResources().getDimension(
				R.dimen.input_assistant_btn_ts);

		Button btn = new Button(getContext());
		btn.setLayoutParams(btnLayoutParams);
		btn.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize);
		btn.setTextColor(0xFFFFFFFF);
		btn.setPadding(0, 0, 0, 0);
		btn.setGravity(Gravity.CENTER);
		btn.setBackgroundResource(R.drawable.assistant_btn_ctrl);
		String strInBtn = text == null ? "" : text;
		btn.setText(strInBtn);
		btn.setOnClickListener(ocl);
		return btn;
	}
}
