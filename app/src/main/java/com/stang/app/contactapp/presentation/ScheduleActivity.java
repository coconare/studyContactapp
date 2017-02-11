package com.stang.app.contactapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.stang.app.contactapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton rbCalender, rbClock;
    CalendarView cvSet;
    TimePicker tpSet;
    TextView tvToday, tvYear, tvMonth, tvDate, tvHour, tvMinute;
    Button btSet;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        rbCalender = (RadioButton) findViewById(R.id.rbCalender);
        rbClock = (RadioButton) findViewById(R.id.rbClock);
        cvSet = (CalendarView) findViewById(R.id.cvSet);
        tpSet = (TimePicker) findViewById(R.id.tpSet);
        tvToday = (TextView) findViewById(R.id.tvToday);
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);
        btSet = (Button) findViewById(R.id.btSet);
        cvSet.setVisibility(View.INVISIBLE);
        tpSet.setVisibility(View.INVISIBLE);
        rbCalender.setOnClickListener(this);
        rbClock.setOnClickListener(this);
        btSet.setOnClickListener(this);
        date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        tvToday.setText("TODAY: " + date);
        cvSet.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date = year+"-"+(month+1)+"-"+dayOfMonth;
            }
        });
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.rbCalender :
               cvSet.setVisibility(View.VISIBLE);
               tpSet.setVisibility(View.INVISIBLE);
               break;
           case R.id.rbClock :
               cvSet.setVisibility(View.INVISIBLE);
               tpSet.setVisibility(View.VISIBLE);
               break;
           case R.id.btSet :
               String[] arry = date.split("-");
               tvYear.setText(arry[0]);
               tvMonth.setText(arry[1]);
               tvDate.setText(arry[2]);
               tvHour.setText(Integer.toString(tpSet.getHour()));
               tvMinute.setText(Integer.toString(tpSet.getMinute()));
               break;
       }
    }
}
