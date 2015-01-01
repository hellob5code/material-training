package com.training.android.materiel.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerDialogFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    public interface OnTimeSetListener {
        public void onTimeSet(TimePickerDialogFragment fragment, int hourOfDay, int minute);
    }

    public static final String ARG_CALENDAR_TIME = "calendar_time";

    private OnTimeSetListener callback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (OnTimeSetListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement TimePickerDialogFragment.OnTimeSetListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int hour;
        int minute;

        Calendar arg = (Calendar) getArguments().getSerializable(ARG_CALENDAR_TIME);
        if (arg != null) {
            hour = arg.get(Calendar.HOUR_OF_DAY);
            minute = arg.get(Calendar.MINUTE);
        } else {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            hour = c.get(Calendar.HOUR_OF_DAY);
            minute = c.get(Calendar.MINUTE);
        }

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        callback.onTimeSet(this, hourOfDay, minute);
    }
}
