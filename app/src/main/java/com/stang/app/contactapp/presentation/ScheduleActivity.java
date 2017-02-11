package com.stang.app.contactapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.stang.app.contactapp.R;

public class ScheduleActivity extends AppCompatActivity {
    RadioButton rbCalender, rbClock;
    CalendarView cvSet;
    TimePicker tpSet;
    TextView tvYear, tvMonth, tvDate, tvHour, tvMinute;
    Button btSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
    }
}
