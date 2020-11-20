package com.qinbin.jwt.ui.widget;

import java.util.Calendar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.DatePicker;

public class DateChooseDialog extends AlertDialog {

	private DatePicker datePicker;

	interface OnChooseListener {
		void onChoose(Calendar calendar);
	}

	OnChooseListener oclr;

	public DateChooseDialog(Context context) {
		super(context);
		setTitle("请选择日期");
		datePicker = new DatePicker(getContext());
		datePicker.setCalendarViewShown(false);
		datePicker.setSpinnersShown(true);
		setView(datePicker);
		setButton(DialogInterface.BUTTON_POSITIVE, "sure", ocl);
		setButton(DialogInterface.BUTTON_NEGATIVE, "cancel", ocl);
		setButton(DialogInterface.BUTTON_NEUTRAL, "empty", ocl);
	}

	public void setOnChooseListener(OnChooseListener oclr) {
		this.oclr = oclr;
	}

	public void setDate(Calendar calendar) {
		datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));
	}

	DialogInterface.OnClickListener ocl = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			if (oclr != null) {
				switch (which) {
				case BUTTON_POSITIVE:
					Calendar calendar = Calendar.getInstance();
					calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
					oclr.onChoose(calendar);
					break;
				case BUTTON_NEGATIVE:
					dismiss();
					break;
				case BUTTON_NEUTRAL:
					oclr.onChoose(null);
					break;
				}
			}

		}
	};

}
