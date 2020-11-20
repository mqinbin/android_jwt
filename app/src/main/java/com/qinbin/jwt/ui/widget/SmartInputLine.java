package com.qinbin.jwt.ui.widget;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qinbin.jwt.R;
import com.qinbin.jwt.domin.DictItem;
import com.qinbin.jwt.util.DictUtils;

public class SmartInputLine extends LinearLayout implements
		View.OnClickListener {

	public static final float WEIGHT_LEFT = 3;
	public static final int WEIGHT_RIGHT = 7;

	public static final int TYPE_TEXT = 0;
	public static final int TYPE_EDIT = 1;
	public static final int TYPE_NUM = 2;
	public static final int TYPE_PHONE = 3;
	public static final int TYPE_DATE = 4;
	public static final int TYPE_CARID = 5;
	public static final int TYPE_IDCARD = 6;
	public static final int TYPE_DICT = 7;
	public static final int TYPE_DICTS = 8;
	private static final SimpleDateFormat yyyyMMddSDF = new SimpleDateFormat(
			"yyyyMMdd", Locale.CHINA);
	private String title;
	private String dictName;
	private boolean nessary;
	private int lines;
	private int type;

	private Object content;
	private TextView titleTv;
	private TextView leftEt;

	public SmartInputLine(Context context, AttributeSet attrs) {
		super(context, attrs);
		initThis();
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.sil);
		setType(ta.getInt(R.styleable.sil_type, 0));
		setTitle(ta.getString(R.styleable.sil_title));
		setNessary(ta.getBoolean(R.styleable.sil_nessary, false));
		setLines(ta.getInt(R.styleable.sil_lines, 1));
		setDictName(ta.getString(R.styleable.sil_dict_name));

		String c = ta.getString(R.styleable.sil_content);
		if (c != null) {
			setContent(c);
		}
		ta.recycle();
	}

	public SmartInputLine(Context context) {
		super(context);
		initThis();
	}

	private void initThis() {
		setOrientation(LinearLayout.HORIZONTAL);
		setPadding(0,
				(int) (getResources().getDimension(R.dimen.sil_margin_next)),
				0, (int) (getResources().getDimension(R.dimen.sil_margin_next)));
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		lp.gravity = Gravity.CENTER_VERTICAL;
		setLayoutParams(lp);
		setFocusableInTouchMode(true);
	}

	private void addTitleView() {
		titleTv = new TextView(getContext());
		LayoutParams lp = new LinearLayout.LayoutParams(0, (int) getResources()
				.getDimension(R.dimen.sil_one_height), WEIGHT_LEFT);
		lp.gravity = Gravity.CENTER_VERTICAL;
		lp.setMargins(0, 0, 0, 0);
		titleTv.setLayoutParams(lp);
		titleTv.setGravity(Gravity.CENTER_VERTICAL);
		titleTv.setBackgroundColor(getResources().getColor(
				android.R.color.white));
		titleTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources()
				.getDimension(R.dimen.sil_text_size));
		titleTv.setTypeface(Typeface.DEFAULT_BOLD, Typeface.BOLD);
		addView(titleTv);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		titleTv.setText(title);
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public boolean isNessary() {
		return nessary;
	}

	public void setNessary(boolean nessary) {
		this.nessary = nessary;
		if (this.nessary) {
			titleTv.setTextColor(getResources().getColor(
					android.R.color.holo_red_dark));
		} else {
			titleTv.setTextColor(getResources().getColor(android.R.color.black));
		}
	}

	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {

		addTitleView();
		System.out.println("setType");
		switch (type) {
		case TYPE_TEXT:
			leftEt = new TextView(getContext());
			break;
		case TYPE_EDIT:
		case TYPE_NUM:
		case TYPE_PHONE:
		case TYPE_CARID:
		case TYPE_IDCARD:
		case TYPE_DATE:
			leftEt = new EditText(getContext());
			leftEt.setBackgroundResource(R.drawable.smart_edit_text);
			break;
		case TYPE_DICT:
		case TYPE_DICTS:

			leftEt = new EditText(getContext());
			leftEt.setBackgroundResource(R.drawable.smart_edit_text);
			leftEt.setFocusable(false);
			leftEt.setCompoundDrawablesWithIntrinsicBounds(0, 0,
					R.drawable.choose_icon, 0);
			break;
		default:
			throw new IllegalArgumentException("wrong type:" + type);
		}
		this.type = type;
		LayoutParams lp = new LayoutParams(0, (int) getResources()
				.getDimension(R.dimen.sil_one_height), WEIGHT_RIGHT);
		lp.gravity = Gravity.CENTER_VERTICAL;
		leftEt.setLayoutParams(lp);
		leftEt.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources()
				.getDimension(R.dimen.sil_text_size));
		leftEt.setTextColor(getResources().getColor(android.R.color.black));
		leftEt.setGravity(Gravity.CENTER_VERTICAL);
		setInputType();
		addView(leftEt);
		setOnLeftClickListener();

		if (type == TYPE_TEXT || type == TYPE_DATE || type == TYPE_DICT
				|| type == TYPE_DICTS || type == TYPE_CARID
				|| type == TYPE_IDCARD) {
			leftEt.setFocusableInTouchMode(false);
		}
	}

	private void setInputType() {
		switch (type) {
		case TYPE_EDIT:
			leftEt.setInputType(InputType.TYPE_CLASS_TEXT);
			break;
		case TYPE_NUM:
			leftEt.setInputType(InputType.TYPE_CLASS_NUMBER);
			break;
		case TYPE_PHONE:
			leftEt.setInputType(InputType.TYPE_CLASS_PHONE);
			break;
		}
	}

	private void setOnLeftClickListener() {
		leftEt.setOnClickListener(this);
	}

	public String getContent() {

		switch (type) {
		case TYPE_TEXT:
		case TYPE_EDIT:
		case TYPE_NUM:
		case TYPE_PHONE:
		case TYPE_CARID:
		case TYPE_IDCARD:
			content = leftEt.getText().toString();
			return (String) content;
		}

		if (content == null) {
			return "";
		}
		switch (type) {
		case TYPE_DATE:
			return yyyyMMddSDF.format(((Calendar) content).getTime());
		case TYPE_DICT:
			return ((DictItem) content).getKey();
		case TYPE_DICTS:
			return DictUtils.transDITokey(getContext(), getDictName(),
					(List<DictItem>) content);
		default:
			throw new IllegalArgumentException("wrong type:" + type);
		}
	}

	public void setContent(String content) {
		switch (type) {
		case TYPE_TEXT:
		case TYPE_EDIT:
		case TYPE_NUM:
		case TYPE_PHONE:
		case TYPE_CARID:
		case TYPE_IDCARD:
			this.content = content;
			leftEt.setText(content);
			break;
		case TYPE_DATE:
			try {
				Calendar c = Calendar.getInstance();
				c.setTime(yyyyMMddSDF.parse(content));
				this.content = c;
			} catch (ParseException e) {
				e.printStackTrace();
				this.content = null;
			}
			break;
		case TYPE_DICT:
			if (content == null) {
				leftEt.setText("");
			} else {
				DictItem di = DictUtils.query(getContext(), getDictName(),
						content);
				this.content = di;
				if (di == null) {
					leftEt.setText(content); // TODO
				} else {
					leftEt.setText(di.getValue());
				}
			}
			break;
		case TYPE_DICTS:
			if (content == null) {
				leftEt.setText("");
			} else {
				List<DictItem> dis = DictUtils.transKeysToDI(getContext(),
						getDictName(), content);
				this.content = dis;
				if (dis == null) {
					leftEt.setText(content); // TODO
				} else {
					leftEt.setText(DictUtils.transDIToValue(getContext(),
							getDictName(), dis));
				}
			}
			break;
		default:
			throw new IllegalArgumentException("wrong type:" + type);
		}

	}

	@Override
	public void onClick(View v) {
		switch (type) {
		case TYPE_CARID:
			IDDialog idDialog = new IDDialog(getContext(), (String) content,
					IDDialog.TYPE_CARID);
			idDialog.setOnChooseListener(new IDDialog.OnChooseListener() {
				@Override
				public void onChoose(String s) {
					content = s;
					leftEt.setText(s);
				}
			});
			idDialog.setCancelable(false);
			idDialog.show();

			break;
		case TYPE_IDCARD:
			IDDialog idDialog2 = new IDDialog(getContext(), (String) content,
					IDDialog.TYPE_IDCARD);
			idDialog2.setOnChooseListener(new IDDialog.OnChooseListener() {
				@Override
				public void onChoose(String s) {
					content = s;
					leftEt.setText(s);
				}
			});
			idDialog2.setCancelable(false);
			idDialog2.show();
			break;
		case TYPE_DATE:

			final DateChooseDialog datecd = new DateChooseDialog(getContext());
			Calendar c = Calendar.getInstance();
			if (content != null) {
				c = (Calendar) content;
			}
			datecd.setDate(c);
			datecd.setOnChooseListener(new DateChooseDialog.OnChooseListener() {
				@Override
				public void onChoose(Calendar calendar) {
					content = calendar;
					if (content == null) {
						leftEt.setText("");
					} else {
						leftEt.setText(yyyyMMddSDF.format(calendar.getTime()));
					}
					datecd.dismiss();
				}
			});
			datecd.show();
			break;
		case TYPE_DICT:
			final DictChooseDialog dictcd = new DictChooseDialog(getContext(),
					dictName);
			dictcd.setOnChooseListener(new DictChooseDialog.OnChooseListener() {
				@Override
				public void onChoose(DictItem di) {
					content = di;
					if (content == null) {
						leftEt.setText("");
					} else {
						leftEt.setText(di.getValue());
					}
					dictcd.dismiss();
				}
			});
			dictcd.show();
			break;
		case TYPE_DICTS:
			final DictsChooseDialog dictscd = new DictsChooseDialog(
					getContext(), getDictName(), (List<DictItem>) content);
			dictscd.setOnChooseListener(new DictsChooseDialog.OnChooseListener() {
				@Override
				public void onChoose(List<DictItem> chooses) {
					content = chooses;
					if (content == null) {
						leftEt.setText("");
					} else {
						leftEt.setText(DictUtils.transDIToValue(getContext(),
								getDictName(), (List<DictItem>) content));
					}
					dictscd.dismiss();
				}
			});
			dictscd.show();
			break;
		}
	}

}
