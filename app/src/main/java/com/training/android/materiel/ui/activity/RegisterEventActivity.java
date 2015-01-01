package com.training.android.materiel.ui.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
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
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import butterknife.*;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.validation.RegexpValidator;
import com.training.android.materiel.R;

import java.util.ArrayList;
import java.util.List;

public class RegisterEventActivity extends Activity {

    private static final String TAG = RegisterEventActivity.class.getSimpleName();

    @InjectView(R.id.register_event_medt_name) MaterialEditText medtName;
    @InjectView(R.id.register_event_medt_location) MaterialEditText medtLocation;
    @InjectView(R.id.register_event_medt_from_date) MaterialEditText medtFromDate;
    @InjectView(R.id.register_event_medt_from_time) MaterialEditText medtFromTime;
    @InjectView(R.id.register_event_medt_to_date) MaterialEditText medtToDate;
    @InjectView(R.id.register_event_medt_to_time) MaterialEditText medtToTime;
    @InjectView(R.id.register_event_medt_timezone) MaterialEditText medtTimezone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_event);
        ButterKnife.inject(this);
        ActionBar toolbar = getActionBar();
        if (toolbar != null) {
            toolbar.setDisplayShowTitleEnabled(false);
            toolbar.setDisplayHomeAsUpEnabled(true);
        }

        StateListDrawable arrowSelector = new StateListDrawable();
        Drawable arrow;
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

    @OnClick(R.id.register_event_medt_from_date)
    protected void onFromDateEditTextClick() {
        Log.d(TAG, "register_event_medt_from_date");
    }

    @OnClick(R.id.register_event_medt_from_time)
    protected void onFromTimeEditTextClick() {
        Log.d(TAG, "register_event_medt_from_time");
    }

    @OnClick(R.id.register_event_medt_to_date)
    protected void onToDateEditTextClick() {
        Log.d(TAG, "register_event_medt_to_date");
    }

    @OnClick(R.id.register_event_medt_to_time)
    protected void onToTimeEditTextClick() {
        Log.d(TAG, "register_event_medt_to_time");
    }

    @OnClick(R.id.register_event_medt_timezone)
    protected void onTimezoneEditTextClick() {
        Log.d(TAG, "register_event_medt_timezone");
    }
}
