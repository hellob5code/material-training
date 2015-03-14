package com.training.android.material.ui.activity;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FullwidthEditText;
import android.widget.Spinner;
import android.widget.Toast;
import butterknife.*;
import android.widget.MaterialEditText;
import com.training.android.material.R;
import com.training.android.material.ui.dialog.DatePickerDialogFragment;
import com.training.android.material.ui.dialog.TimePickerDialogFragment;
import com.training.android.material.util.ThemeUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;

public class RegisterEventActivity extends ActionBarActivity implements DatePickerDialogFragment.OnDateSetListener, TimePickerDialogFragment.OnTimeSetListener {

    private static final String TAG = RegisterEventActivity.class.getSimpleName();

    private static final String TAG_FROM_DATE_PICKER = "from_date_picker";
    private static final String TAG_FROM_TIME_PICKER = "from_time_picker";
    private static final String TAG_TO_DATE_PICKER = "to_date_picker";
    private static final String TAG_TO_TIME_PICKER = "to_time_picker";

    @InjectView(R.id.register_event_spi_email) Spinner spiEmail;
    @InjectView(R.id.register_event_edt_name) MaterialEditText edtName;
    @InjectView(R.id.register_event_edt_location) MaterialEditText edtLocation;
    @InjectView(R.id.register_event_edt_from_date) MaterialEditText edtFromDate;
    @InjectView(R.id.register_event_edt_from_time) MaterialEditText edtFromTime;
    @InjectView(R.id.register_event_edt_to_date) MaterialEditText edtToDate;
    @InjectView(R.id.register_event_edt_to_time) MaterialEditText edtToTime;
    @InjectView(R.id.register_event_edt_timezone) MaterialEditText edtTimezone;

    private DateTimeFormatter dateFormatter;
    private DateTimeFormatter timeFormatter;

    private DateTime fromDateTime = new DateTime();
    private DateTime toDateTime = new DateTime().plusHours(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_event);

        dateFormatter = DateTimeFormat.forPattern("E, MMM d y");
        timeFormatter = DateTimeFormat.forPattern("h:mm a");

        ButterKnife.inject(this);
        ActionBar toolbar = getSupportActionBar();
        if (toolbar != null) {
            toolbar.setDisplayShowTitleEnabled(false);
            toolbar.setDisplayHomeAsUpEnabled(true);
        }

        setupAccountView();
        setupDropdownViews();
        setupTimezoneView();

        edtFromDate.setText(dateFormatter.print(fromDateTime));
        edtFromTime.setText(timeFormatter.print(fromDateTime));

        edtToDate.setText(dateFormatter.print(toDateTime));
        edtToTime.setText(timeFormatter.print(toDateTime));
    }

    private void setupAccountView() {
        // TODO:
    }

    private void setupDropdownViews() {
        Drawable arrow;
        StateListDrawable arrowSelector = new StateListDrawable();

        arrow = getResources().getDrawable(R.drawable.ic_arrow_drop_down_black_24dp);
        arrow.mutate().setColorFilter(ThemeUtils.obtainColorPrimary(this), PorterDuff.Mode.SRC_ATOP);
        arrowSelector.addState(new int[]{ android.R.attr.state_pressed }, arrow);
        arrowSelector.addState(new int[]{ android.R.attr.state_focused }, arrow);

        arrow = getResources().getDrawable(R.drawable.ic_arrow_drop_down_grey600_24dp);
        arrowSelector.addState(StateSet.WILD_CARD, arrow);

        edtFromDate.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector.getConstantState().newDrawable(), null);
        edtFromTime.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector.getConstantState().newDrawable(), null);
        edtToDate.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector.getConstantState().newDrawable(), null);
        edtToTime.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector.getConstantState().newDrawable(), null);
        edtTimezone.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector.getConstantState().newDrawable(), null);

        edtFromDate.setFocusableInTouchMode(false);
        edtFromTime.setFocusableInTouchMode(false);
        edtToDate.setFocusableInTouchMode(false);
        edtToTime.setFocusableInTouchMode(false);
        edtTimezone.setFocusableInTouchMode(false);
    }

    private void setupTimezoneView() {
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
            boolean canProceed = true;
            if (edtName.length() == 0) {
                edtName.setError("Cannot be empty!");
                canProceed = false;
            } else {
                edtName.setError(null);
            }

            if (canProceed) {
                // TODO: Perform action after true validation.
                Toast.makeText(this, "Added!", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnTextChanged(R.id.register_event_edt_name)
    void onTextChanged(CharSequence text) {
        edtName.setError(null);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("from_datetime", fromDateTime);
        outState.putSerializable("to_datetime", toDateTime);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        fromDateTime = (DateTime) savedInstanceState.getSerializable("from_datetime");
        toDateTime = (DateTime) savedInstanceState.getSerializable("to_datetime");
    }

    @OnClick(R.id.register_event_edt_from_date)
    protected void onFromDateEditTextClicked() {
        if (getSupportFragmentManager().findFragmentByTag(TAG_FROM_DATE_PICKER) == null) {
            DialogFragment newFragment = newDatePickerDialogFragment(fromDateTime);
            newFragment.show(getSupportFragmentManager(), TAG_FROM_DATE_PICKER);
        }
    }

    @OnClick(R.id.register_event_edt_from_time)
    protected void onFromTimeEditTextClicked() {
        if (getSupportFragmentManager().findFragmentByTag(TAG_FROM_TIME_PICKER) == null) {
            DialogFragment newFragment = newTimePickerDialogFragment(fromDateTime);
            newFragment.show(getSupportFragmentManager(), TAG_FROM_TIME_PICKER);
        }
    }

    @OnClick(R.id.register_event_edt_to_date)
    protected void onToDateEditTextClicked() {
        if (getSupportFragmentManager().findFragmentByTag(TAG_TO_DATE_PICKER) == null) {
            DialogFragment newFragment = newDatePickerDialogFragment(toDateTime);
            newFragment.show(getSupportFragmentManager(), TAG_TO_DATE_PICKER);
        }
    }

    @OnClick(R.id.register_event_edt_to_time)
    protected void onToTimeEditTextClicked() {
        if (getSupportFragmentManager().findFragmentByTag(TAG_TO_TIME_PICKER) == null) {
            DialogFragment newFragment = newTimePickerDialogFragment(toDateTime);
            newFragment.show(getSupportFragmentManager(), TAG_TO_TIME_PICKER);
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

    @OnClick(R.id.register_event_edt_timezone)
    protected void onTimezoneEditTextClicked() {
        Log.d(TAG, "register_event_edt_timezone");
    }

    @Override
    public void onDateSet(DatePickerDialogFragment fragment, int year, int monthOfYear, int dayOfMonth) {
        Object tag = fragment.getTag();
        String dateString = dateFormatter.print(new DateTime(year, monthOfYear + 1, dayOfMonth, 0, 0, 0));

        if (tag.equals(TAG_FROM_DATE_PICKER)) {
            fromDateTime = copyDate(fromDateTime, year, monthOfYear, dayOfMonth);
            edtFromDate.setText(dateString);

        } else if (tag.equals(TAG_TO_DATE_PICKER)) {
            toDateTime = copyDate(toDateTime, year, monthOfYear, dayOfMonth);
            edtToDate.setText(dateString);
        }
    }

    @Override
    public void onTimeSet(TimePickerDialogFragment fragment, int hourOfDay, int minute) {
        Object tag = fragment.getTag();
        String timeString = timeFormatter.print(new DateTime(0, 1, 1, hourOfDay, minute, 0));

        if (tag.equals(TAG_FROM_TIME_PICKER)) {
            fromDateTime = copyTime(fromDateTime, hourOfDay, minute);
            edtFromTime.setText(timeString);

        } else if (tag.equals(TAG_TO_TIME_PICKER)) {
            toDateTime = copyTime(toDateTime, hourOfDay, minute);
            edtToTime.setText(timeString);
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
