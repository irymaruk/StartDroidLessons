package com.igorja.p0581_timepickerdialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import static android.app.DatePickerDialog.OnDateSetListener;
import static android.app.TimePickerDialog.OnTimeSetListener;

public class MainActivity extends Activity {

    int DIALOG_TIME = 1;
    int DIALOG_DATE = 2;
    int myHour = 14;
    int myMinute = 35;
    TextView tvTime;
    private int myYear = Calendar.getInstance().get(Calendar.YEAR);
    private int myMonth = Calendar.getInstance().get(Calendar.MONTH);
    private int myDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    private TextView tvDate;

    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvDate = (TextView) findViewById(R.id.tvDate);
    }

    public void onclick(View view) {
        showDialog(DIALOG_TIME);
    }

    public void onclickDate(View view) {
        showDialog(DIALOG_DATE);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_TIME) {
            TimePickerDialog tpd = new TimePickerDialog(this, myCallBack, myHour, myMinute, true);
            return tpd;
        }
        if (id == DIALOG_DATE) {
            DatePickerDialog dpd = new DatePickerDialog(this, myCallBackDate, myYear, myMonth, myDay);
            return dpd;
        }
        return super.onCreateDialog(id);
    }

    OnTimeSetListener myCallBack = new OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;
            tvTime.setText("Time is " + myHour + " hours " + myMinute + " minutes");
        }
    };

    OnDateSetListener myCallBackDate = new OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myYear = year;
            myMonth = monthOfYear;
            myDay = dayOfMonth;
            tvDate.setText("date is:" + myYear + "/" + myMonth + "/" + myDay);
        }
    };
}