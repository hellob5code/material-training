package com.training.android.material.ui.dialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public interface OnDateSetListener {
        public void onDateSet(DatePickerDialogFragment fragment, int year, int monthOfYear, int dayOfMonth);
    }

    public static final String ARG_CALENDAR_DATE = "calendar_date";

    private OnDateSetListener callback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (OnDateSetListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement DatePickerDialogFragment.OnDateSetListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int year;
        int month;
        int day;

        Calendar arg = (Calendar) getArguments().getSerializable(ARG_CALENDAR_DATE);
        if (arg != null) {
            year = arg.get(Calendar.YEAR);
            month = arg.get(Calendar.MONTH);
            day = arg.get(Calendar.DAY_OF_MONTH);
        } else {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
        }

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        callback.onDateSet(this, year, monthOfYear, dayOfMonth);
    }
}