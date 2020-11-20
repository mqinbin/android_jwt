package com.qinbin.jwt.util;

import java.lang.reflect.Field;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qinbin.jwt.R;
import com.qinbin.jwt.anno.AnnoSetBDFS;
import com.qinbin.jwt.anno.Form;
import com.qinbin.jwt.anno.Show;
import com.qinbin.jwt.domin.DictItem;
import com.qinbin.jwt.ui.widget.SmartInputLine;

public class UiUtils {

	public static <T> void fillFormByBean(LinearLayout line, T t) {
		if (line.getOrientation() != LinearLayout.VERTICAL || line.getChildCount() != 0) {
			throw new IllegalArgumentException("LinearLayout line should　be VERTICAL and has no child in");
		}
		AnnoSetBDFS[] bdfss = ReflectUtil.getOrderedAnnoBDFS(t.getClass());
		if (bdfss.length == 0) {
			throw new IllegalArgumentException("I can do nothing with your bean.\n"
					+ "Please add annotation @Basic @Form @Show @Dict to some of field");
		}

		for (int i = 0; i < bdfss.length; i++) {
			AnnoSetBDFS bdfs = bdfss[i];
			Form form = bdfs.getForm();
			if (form == null || form.show() == false) {
				continue;
			}
			SmartInputLine sil = new SmartInputLine(line.getContext());
			sil.setType(form.type());
			if (bdfs.getDict() != null) {
				sil.setDictName(bdfs.getDict().value());
			}
			sil.setTitle(bdfs.getBasic().title());
			sil.setLines(bdfs.getBasic().lines());
			String content = ReflectUtil.getFieldStringValue(bdfs.getField(), t);
			if (!TextUtils.isEmpty(content)) {
				sil.setContent(content);
			}
			sil.setNessary(form.necessary());
			sil.setTag(bdfs.getField().getName());

			line.addView(sil);
		}
	}

	public static <T> void fillBeanByForm(LinearLayout line, T t) {
		if (line.getOrientation() != LinearLayout.VERTICAL || line.getChildCount() == 0) {
			throw new IllegalArgumentException("LinearLayout line should　be VERTICAL and has child in");
		}
		AnnoSetBDFS[] bdfss = ReflectUtil.getOrderedAnnoBDFS(t.getClass());
		if (bdfss.length == 0) {
			throw new IllegalArgumentException("I can do nothing with your bean.\n"
					+ "Please add annotation @Basic @Form @Show @Dict to some of field");
		}

		for (int i = 0; i < bdfss.length; i++) {
			AnnoSetBDFS bdfs = bdfss[i];
			Form form = bdfs.getForm();
			if (form == null || form.show() == false) {
				continue;
			}
			Field field = bdfs.getField();
			SmartInputLine sil = (SmartInputLine) line.findViewWithTag(bdfs.getField().getName());
			ReflectUtil.setFieldValue(field, t, sil.getContent());
		}
	}

	public static <T> void fillTitleByClass(LinearLayout line, Class<T> klass, boolean absolute) {
		if (line.getOrientation() != LinearLayout.HORIZONTAL || line.getChildCount() != 0) {
			throw new IllegalArgumentException("LinearLayout line should　be HORIZONTAL and has no child in");
		}

		AnnoSetBDFS[] bdfss = ReflectUtil.getOrderedAnnoBDFS(klass);
		for (AnnoSetBDFS bsfs : bdfss) {
			if (bsfs.getShow() == null || bsfs.getShow().simple() == false) {
				continue;
			}

			TextView tv = new TextView(line.getContext());
			if (absolute) {
				float width = (float) (line.getContext().getResources().getDimension(R.dimen.list_one_height) * bsfs
						.getShow().weight());
				tv.setLayoutParams(new LinearLayout.LayoutParams((int) width, ViewGroup.LayoutParams.WRAP_CONTENT));
			} else {
				tv.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, (float) bsfs
						.getShow().weight()));
			}
			tv.setText(bsfs.getBasic().title());
			tv.setTextSize(line.getContext().getResources().getDimension(R.dimen.list_text_size));
			line.addView(tv);
		}
	}

	public static <T> void fillListItemByBean(LinearLayout line, T bean, boolean absolute) {
		if (line.getOrientation() != LinearLayout.HORIZONTAL) {
			throw new IllegalArgumentException("LinearLayout line should　be HORIZONTAL ");
		}
		Class klass = bean.getClass();
		AnnoSetBDFS[] bdfss = ReflectUtil.getOrderedAnnoBDFS(klass);
		int tvCount = 0;
		for (AnnoSetBDFS bdfs : bdfss) {
			if (bdfs.getShow() != null && bdfs.getShow().simple()) {
				tvCount++;
			}
		}

		if (line.getChildCount() == 0) {

			for (AnnoSetBDFS bsfs : bdfss) {
				if (bsfs.getShow() == null || bsfs.getShow().simple() == false) {
					continue;
				}

				TextView tv = new TextView(line.getContext());
				if (absolute) {
					float width = (float) (line.getContext().getResources().getDimension(R.dimen.list_one_height) * bsfs
							.getShow().weight());
					tv.setLayoutParams(new LinearLayout.LayoutParams((int) width, ViewGroup.LayoutParams.WRAP_CONTENT));
				} else {
					tv.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,
							(float) bsfs.getShow().weight()));
				}
				tv.setText(getShowValue(line.getContext(), bean, bsfs));
				tv.setTextSize(line.getContext().getResources().getDimension(R.dimen.list_text_size));
				line.addView(tv);
			}
		} else {
			if (line.getChildCount() != tvCount) {
				throw new IllegalArgumentException("LinearLayout child view is not match");
			}
			int index = 0;
			for (AnnoSetBDFS bsfs : bdfss) {
				if (bsfs.getShow() == null || bsfs.getShow().simple() == false) {
					continue;
				}
				TextView tv = (TextView) line.getChildAt(index);
				tv.setText(getShowValue(line.getContext(), bean, bsfs));
				index++;
			}

		}
	}

	private static <T> String getShowValue(Context context, T bean, AnnoSetBDFS bdfs) {
		Object objValue = null;
		try {
			objValue = bdfs.getField().get(bean);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		String strValue = objValue == null ? "" : objValue.toString();
		if (bdfs.getDict() != null) {
			List<DictItem> dis = DictUtils.transKeysToDI(context, bdfs.getDict().value(), strValue);
			return DictUtils.transDIToValue(context, bdfs.getDict().value(), dis);
		} else {
			return strValue;
		}

	}

	public static <T> boolean valiaWithNotify(LinearLayout line) {
		if (line.getOrientation() != LinearLayout.VERTICAL) {
			throw new IllegalArgumentException("LinearLayout line should　be VERTICAL and has no child in");
		}
		for (int i = 0; i < line.getChildCount(); i++) {
			if (!(line.getChildAt(i) instanceof SmartInputLine)) {
				continue;
			}

			final SmartInputLine sil = (SmartInputLine) line.getChildAt(i);
			if (sil.isNessary() && TextUtils.isEmpty(sil.getContent())) {
				AlertDialog.Builder adBuild = new AlertDialog.Builder(line.getContext());
				adBuild.setTitle("请检查输入").setMessage(sil.getTitle() + "不能为空。")
						.setPositiveButton("知道啦", new AlertDialog.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								dialog.dismiss();
								Animation aniLeft = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -0.05f,
										Animation.RELATIVE_TO_SELF, 0.05f, Animation.RELATIVE_TO_SELF, 0,
										Animation.RELATIVE_TO_SELF, 0);
								aniLeft.setInterpolator(new CycleInterpolator(10f));
								aniLeft.setDuration(500);
								sil.startAnimation(aniLeft);
							}
						});
				adBuild.show();
				return false;
			}
		}
		return true;
	}

	public static <T> void fillShowByBean(LinearLayout line, T bean) {
		if (line.getOrientation() != LinearLayout.VERTICAL || line.getChildCount() != 0) {
			throw new IllegalArgumentException("LinearLayout line should　be VERTICAL and has no child in");
		}
		AnnoSetBDFS[] bdfss = ReflectUtil.getOrderedAnnoBDFS(bean.getClass());
		if (bdfss.length == 0) {
			throw new IllegalArgumentException("I can do nothing with your bean.\n"
					+ "Please add annotation @Basic @Form @Show @Dict to some of field");
		}

		for (int i = 0; i < bdfss.length; i++) {
			AnnoSetBDFS bdfs = bdfss[i];
			Show show = bdfs.getShow();
			if (show == null || show.detail() == false) {
				continue;
			}
			SmartInputLine sil = new SmartInputLine(line.getContext());
			sil.setType(SmartInputLine.TYPE_TEXT);
			if (bdfs.getDict() != null) {
				sil.setDictName(bdfs.getDict().value());
			}
			sil.setTitle(bdfs.getBasic().title());
			sil.setLines(bdfs.getBasic().lines());
			String showValue = getShowValue(line.getContext(), bean, bdfs);
			sil.setContent(showValue);
			line.addView(sil);
		}

	}
}
