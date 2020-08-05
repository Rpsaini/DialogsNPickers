package com.app.dialogsnpickers;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class MyDatePickerDialog
{
    private int mYear, mMonth, mDay, mHour, mMinute;



    public void showDatePickerDialog(AppCompatActivity appCompatActivity,final DatePickerCallbacks datePickerCallbacks)
    {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(appCompatActivity,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth)
                    {

                        int month=(monthOfYear + 1);
                        datePickerCallbacks.dateSelectedListener(dayOfMonth,month,year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }



    public void showTimePicker(AppCompatActivity appCompatActivity,final TimePickerCallback timePickerCallback)
    {
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(appCompatActivity,
                new TimePickerDialog.OnTimeSetListener()
                {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute)
                    {

                        timePickerCallback.selectedTime(hourOfDay,minute,00,"");

                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }



}






