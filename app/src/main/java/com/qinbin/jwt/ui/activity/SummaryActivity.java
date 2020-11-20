package com.qinbin.jwt.ui.activity;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qinbin.jwt.R;
import com.qinbin.jwt.domin.RwtxEnum;
import com.qinbin.jwt.net.NetMock;

import com.readystatesoftware.viewbadger.BadgeView;

public class SummaryActivity extends Activity implements OnClickListener {
	private LinearLayout containerLine;
	private static final int ICON＿PER_LINE = 3;
	private ProgressDialog pd;
	private int queryTaskNum;

	private HashMap<String, BadgeView> bvMap = new HashMap<String, BadgeView>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
		setTitle("任务提醒");
		containerLine = (LinearLayout) findViewById(R.id.summary_container_line);

		NetMock.init(this);
		int lines = (RwtxEnum.values().length - 1) / ICON＿PER_LINE + 1;

		for (int i = 0; i < lines; i++) {
			LinearLayout l = new LinearLayout(this);
			l.setOrientation(LinearLayout.HORIZONTAL);
			l.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT));
			for (int j = 0; j < ICON＿PER_LINE; j++) {
				int position = i * ICON＿PER_LINE + j;
				if (position < RwtxEnum.values().length) {
					l.addView(getIcon(RwtxEnum.values()[position]));
				} else {
					l.addView(getNullIcon());
				}
			}
			containerLine.addView(l);
		}
		
	}

	@Override
	protected void onResume() {
		super.onResume();
		startQueryNum();
	}

	private void startQueryNum() {
		showDialog();
		queryTaskNum = RwtxEnum.values().length;

		for (final RwtxEnum rw : RwtxEnum.values()) {
			new QueryNumTask() {
				BadgeView bv;

				protected void onPreExecute() {
					View target = containerLine.findViewWithTag(rw);

					if (target.getTag() instanceof RwtxEnum) {
						System.out.println("target.getTag() instanceof RwtxEnum");
						if (!bvMap.containsKey(((RwtxEnum) target.getTag()).getType())) {
							bvMap.put(((RwtxEnum) target.getTag()).getType(), new BadgeView(SummaryActivity.this,
									target));
						}
						bv = bvMap.get(((RwtxEnum) target.getTag()).getType());
					} else {
						System.out.println("!!!!target.getTag() instanceof RwtxEnum");
						bv = new BadgeView(SummaryActivity.this, target);
					}
					// bv = new BadgeView(SummaryActivity.this,);

					bv.setBadgeBackgroundColor(Color.GRAY);
					
					bv.setText("0");
					bv.show();
				};

				protected void onPostExecute(Integer result) {
					bv.setBadgeBackgroundColor(Color.RED);
					queryTaskNum--;
					if (queryTaskNum == 0) {
						dismissDialog();
					}
					Animation ani = new AlphaAnimation(0.5f, 1f);
					bv.setText("" + result);
					ani.setDuration(300);
					bv.show(ani);

				};
			}.execute(rw.getKlass());
		}

	}

	private void showDialog() {
		pd = new ProgressDialog(this);
		pd.setMessage("正在努力查询!");
		pd.setCancelable(false);
		pd.show();
	}

	private void dismissDialog() {
		pd.dismiss();
	}

	private View getIcon(RwtxEnum xx) {

		LinearLayout line = new LinearLayout(this);
		line.setPadding(0, 30, 0, 30);
		line.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams lineLp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
		lineLp.gravity = Gravity.CENTER;
		line.setLayoutParams(lineLp);

		ImageView iv = new ImageView(this);
		LinearLayout.LayoutParams ivLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		ivLp.gravity = Gravity.CENTER;
		iv.setLayoutParams(ivLp);
		iv.setOnClickListener(this);
		iv.setTag(xx);
		iv.setImageResource(xx.getIconRes());
		line.addView(iv);

		TextView tv = new TextView(this);
		LinearLayout.LayoutParams tvLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		tvLp.gravity = Gravity.CENTER;
		tv.setLayoutParams(tvLp);
		tv.setText(xx.getType());
		line.addView(tv);

		return line;
	}

	private View getNullIcon() {

		LinearLayout l = new LinearLayout(this);
		l.setPadding(0, 30, 0, 30);
		l.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams lineLp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
		lineLp.gravity = Gravity.CENTER;
		l.setLayoutParams(lineLp);

		return l;
	}

	@Override
	public void onClick(View v) {
		jumpView(v);
		Object xx = v.getTag();
		if (xx instanceof RwtxEnum) {
			final RwtxEnum rw = (RwtxEnum) xx;

			// Toast.makeText(this, "startActivity", Toast.LENGTH_SHORT).show();
			new QueryContentTask() {
				protected void onPreExecute() {
					showDialog();
				};

				protected void onPostExecute(List result) {
					dismissDialog();
					ListActivity.startMe(SummaryActivity.this, rw.getKlass(), result);
				};
			}.execute(rw.getKlass());

		}
	}

	public void jumpView(View v) {
		long oneDuration = 200;
		float offset = -0.07f;

		Animation jump = new TranslateAnimation(0, 0, 0, 0, TranslateAnimation.RELATIVE_TO_SELF, 0,
				TranslateAnimation.RELATIVE_TO_SELF, offset);
		jump.setInterpolator(new Interpolator() {
			@Override
			public float getInterpolation(float input) {
				return 1 - input * input;
			}
		});
		jump.setDuration(oneDuration);
		Animation fall = new TranslateAnimation(0, 0, 0, 0, TranslateAnimation.RELATIVE_TO_SELF, offset,
				TranslateAnimation.RELATIVE_TO_SELF, 0);
		fall.setInterpolator(new Interpolator() {
			@Override
			public float getInterpolation(float input) {
				return input * input;
			}
		});
		fall.setDuration(oneDuration);
		fall.setStartOffset(oneDuration);
		AnimationSet a = new AnimationSet(true);
		a.addAnimation(jump);
		a.addAnimation(fall);
		v.startAnimation(a);

	}

	static class QueryNumTask extends AsyncTask<Class<?>, Void, Integer> {
		@Override
		protected Integer doInBackground(Class<?>... params) {
			return NetMock.queryCount(params[0]);
		}

	}

	static class QueryContentTask extends AsyncTask<Class<?>, Void, List> {

		@Override
		protected List doInBackground(Class<?>... params) {
			return NetMock.queryContent(params[0]);
		}

	}

}
