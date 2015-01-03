package com.training.android.materiel.ui.activity;

import android.app.*;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.*;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.validation.RegexpValidator;
import com.training.android.materiel.R;
import com.training.android.materiel.ui.dialog.DatePickerDialogFragment;
import com.training.android.materiel.ui.dialog.TimePickerDialogFragment;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Set;
import java.util.TimeZone;

public class RegisterEventActivity extends Activity implements DatePickerDialogFragment.OnDateSetListener, TimePickerDialogFragment.OnTimeSetListener {

    private static final String TAG = RegisterEventActivity.class.getSimpleName();

    private static final String TAG_FROM_DATE_PICKER = "from_date_picker";
    private static final String TAG_FROM_TIME_PICKER = "from_time_picker";
    private static final String TAG_TO_DATE_PICKER = "to_date_picker";
    private static final String TAG_TO_TIME_PICKER = "to_time_picker";

    @InjectView(R.id.register_event_medt_email) MaterialEditText medtEmail;
    @InjectView(R.id.register_event_medt_name) MaterialEditText medtName;
    @InjectView(R.id.register_event_medt_location) MaterialEditText medtLocation;
    @InjectView(R.id.register_event_medt_from_date) MaterialEditText medtFromDate;
    @InjectView(R.id.register_event_medt_from_time) MaterialEditText medtFromTime;
    @InjectView(R.id.register_event_medt_to_date) MaterialEditText medtToDate;
    @InjectView(R.id.register_event_medt_to_time) MaterialEditText medtToTime;
    @InjectView(R.id.register_event_medt_timezone) MaterialEditText medtTimezone;

    private DateTimeFormatter mDateFormatter;
    private DateTimeFormatter mTimeFormatter;

    private DateTime mFromDateTime = new DateTime();
    private DateTime mToDateTime = new DateTime().plusHours(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_event);

        mDateFormatter = DateTimeFormat.forPattern("E, MMM d y");
        mTimeFormatter = DateTimeFormat.forPattern("h:mm a");

        ButterKnife.inject(this);
        ActionBar toolbar = getActionBar();
        if (toolbar != null) {
            toolbar.setDisplayShowTitleEnabled(false);
        }

        setupAccountViews();
        setupDateTimeViews();
        setupTimezoneViews();
    }

    private void setupAccountViews() {
        // TODO:
        Drawable arrow;
        StateListDrawable arrowSelector = new StateListDrawable();

        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.colorPrimary, tv, true) && tv.resourceId > 0) {
            int selectedColor = getResources().getColor(tv.resourceId);
            arrow = getResources().getDrawable(R.drawable.navigation_ic_arrow_drop_down);
            arrow.mutate().setColorFilter(selectedColor, PorterDuff.Mode.SRC_IN);
            arrowSelector.addState(new int[]{ android.R.attr.state_pressed }, arrow);
        }
        if (getTheme().resolveAttribute(android.R.attr.textColorSecondary, tv, true) && tv.resourceId > 0) {
            int secondaryColor = getResources().getColor(tv.resourceId);
            arrow = getResources().getDrawable(R.drawable.navigation_ic_arrow_drop_down);
            arrow.mutate().setColorFilter(secondaryColor, PorterDuff.Mode.SRC_IN);
            arrowSelector.addState(StateSet.WILD_CARD, arrow);
        }

        medtEmail.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector, null);
    }

    private void setupDateTimeViews() {
        Drawable arrow;
        StateListDrawable arrowSelector = new StateListDrawable();

        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.colorPrimary, tv, true) && tv.resourceId > 0) {
            int selectedColor = getResources().getColor(tv.resourceId);
            arrow = getResources().getDrawable(R.drawable.navigation_ic_arrow_drop_down);
            arrow.mutate().setColorFilter(selectedColor, PorterDuff.Mode.SRC_IN);
            arrowSelector.addState(new int[]{ android.R.attr.state_pressed }, arrow);
        }
        if (getTheme().resolveAttribute(android.R.attr.textColorSecondary, tv, true) && tv.resourceId > 0) {
            int secondaryColor = getResources().getColor(tv.resourceId);
            arrow = getResources().getDrawable(R.drawable.navigation_ic_arrow_drop_down);
            arrow.mutate().setColorFilter(secondaryColor, PorterDuff.Mode.SRC_IN);
            arrowSelector.addState(StateSet.WILD_CARD, arrow);
        }

        medtFromDate.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector, null);
        medtFromTime.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector, null);
        medtToDate.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector, null);
        medtToTime.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector, null);
        medtTimezone.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector, null);

        String dateString;
        String timeString;

        dateString = mDateFormatter.print(mFromDateTime);
        medtFromDate.setText(dateString);
        timeString = mTimeFormatter.print(mFromDateTime);
        medtFromTime.setText(timeString);

        dateString = mDateFormatter.print(mToDateTime);
        medtToDate.setText(dateString);
        timeString = mTimeFormatter.print(mToDateTime);
        medtToTime.setText(timeString);
    }

    private void setupTimezoneViews() {
        // TODO:
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_validate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        } else if (id == R.id.action_validate) {
            if (medtName.validateWith(new RegexpValidator("Cannot be empty!", "\\w+"))) {
                // TODO: Perform action.
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("from_datetime", mFromDateTime);
        outState.putSerializable("to_datetime", mToDateTime);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mFromDateTime = (DateTime) savedInstanceState.getSerializable("from_datetime");
        mToDateTime = (DateTime) savedInstanceState.getSerializable("to_datetime");
    }

    @OnClick(R.id.register_event_medt_from_date)
    protected void onFromDateEditTextClick() {
        if (getFragmentManager().findFragmentByTag(TAG_FROM_DATE_PICKER) == null) {
            DialogFragment newFragment = newDatePickerDialogFragment(mFromDateTime);
            newFragment.show(getFragmentManager(), TAG_FROM_DATE_PICKER);
        }
    }

    @OnClick(R.id.register_event_medt_from_time)
    protected void onFromTimeEditTextClick() {
        if (getFragmentManager().findFragmentByTag(TAG_FROM_TIME_PICKER) == null) {
            DialogFragment newFragment = newTimePickerDialogFragment(mFromDateTime);
            newFragment.show(getFragmentManager(), TAG_FROM_TIME_PICKER);
        }
    }

    @OnClick(R.id.register_event_medt_to_date)
    protected void onToDateEditTextClick() {
        if (getFragmentManager().findFragmentByTag(TAG_TO_DATE_PICKER) == null) {
            DialogFragment newFragment = newDatePickerDialogFragment(mToDateTime);
            newFragment.show(getFragmentManager(), TAG_TO_DATE_PICKER);
        }
    }

    @OnClick(R.id.register_event_medt_to_time)
    protected void onToTimeEditTextClick() {
        if (getFragmentManager().findFragmentByTag(TAG_TO_TIME_PICKER) == null) {
            DialogFragment newFragment = newTimePickerDialogFragment(mToDateTime);
            newFragment.show(getFragmentManager(), TAG_TO_TIME_PICKER);
        }
    }

    private DialogFragment newDatePickerDialogFragment(DateTime dateTime) {
        DialogFragment fragment = new DatePickerDialogFragment();

        Bundle args = new Bundle();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, dateTime.getYear());
        c.set(Calendar.MONTH, dateTime.getMonthOfYear() - 1);
        c.set(Calendar.DAY_OF_MONTH, dateTime.getDayOfMonth());
        args.putSerializable(DatePickerDialogFragment.ARG_CALENDAR_DATE, c);
        fragment.setArguments(args);

        return fragment;
    }

    private DialogFragment newTimePickerDialogFragment(DateTime dateTime) {
        DialogFragment fragment = new TimePickerDialogFragment();

        Bundle args = new Bundle();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, dateTime.getHourOfDay());
        c.set(Calendar.MINUTE, dateTime.getMinuteOfHour());
        args.putSerializable(TimePickerDialogFragment.ARG_CALENDAR_TIME, c);
        fragment.setArguments(args);

        return fragment;
    }

    @OnClick(R.id.register_event_medt_timezone)
    protected void onTimezoneEditTextClick() {
        Log.d(TAG, "register_event_medt_timezone");
    }

    @Override
    public void onDateSet(DatePickerDialogFragment fragment, int year, int monthOfYear, int dayOfMonth) {
        Object tag = fragment.getTag();
        String dateString = mDateFormatter.print(new DateTime(year, monthOfYear + 1, dayOfMonth, 0, 0, 0));

        if (tag.equals(TAG_FROM_DATE_PICKER)) {
            mFromDateTime = copyDate(mFromDateTime, year, monthOfYear, dayOfMonth);
            medtFromDate.setText(dateString);

        } else if (tag.equals(TAG_TO_DATE_PICKER)) {
            mToDateTime = copyDate(mToDateTime, year, monthOfYear, dayOfMonth);
            medtToDate.setText(dateString);
        }
    }

    @Override
    public void onTimeSet(TimePickerDialogFragment fragment, int hourOfDay, int minute) {
        Object tag = fragment.getTag();
        String timeString = mTimeFormatter.print(new DateTime(0, 1, 1, hourOfDay, minute, 0));

        if (tag.equals(TAG_FROM_TIME_PICKER)) {
            mFromDateTime = copyTime(mFromDateTime, hourOfDay, minute);
            medtFromTime.setText(timeString);

        } else if (tag.equals(TAG_TO_TIME_PICKER)) {
            mToDateTime = copyTime(mToDateTime, hourOfDay, minute);
            medtToTime.setText(timeString);
        }
    }

    /**
     * The {@link java.util.Calendar} date used by {@link android.widget.DatePicker} has a month value between 0-11 for compatibility
     * with {@link org.joda.time.DateTime} we offset by 1.
     */
    private DateTime copyDate(DateTime dateTime, int year, int monthOfYear, int dayOfMonth) {
        return dateTime.withYear(year)
                .withMonthOfYear(monthOfYear + 1)
                .withDayOfMonth(dayOfMonth)
                .withHourOfDay(dateTime.getHourOfDay())
                .withMinuteOfHour(dateTime.getMinuteOfHour());
    }

    private DateTime copyTime(DateTime dateTime, int hourOfDay, int minute) {
        return dateTime.withYear(dateTime.getYear())
                .withMonthOfYear(dateTime.getMonthOfYear())
                .withDayOfMonth(dateTime.getDayOfMonth())
                .withHourOfDay(hourOfDay)
                .withMinuteOfHour(minute);
    }
}
