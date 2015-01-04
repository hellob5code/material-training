package com.training.android.material.ui.activity;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.training.android.material.R;

public class ComposeEmailActivity extends ActionBarActivity {

    @InjectView(R.id.compose_email_medt_from) MaterialEditText medtFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_email);
        ButterKnife.inject(this);
        ActionBar toolbar = getSupportActionBar();
        if (toolbar != null) {
            toolbar.setDisplayHomeAsUpEnabled(true);
        }
        setupAccountViews();
    }

    private void setupAccountViews() {
        // TODO:
        Drawable arrow;
        StateListDrawable arrowSelector = new StateListDrawable();

        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(R.attr.colorPrimary, tv, true) && tv.resourceId > 0) {
            int selectedColor = getResources().getColor(tv.resourceId);
            arrow = getResources().getDrawable(R.drawable.navigation_ic_arrow_drop_down);
            arrow.mutate().setColorFilter(selectedColor, PorterDuff.Mode.SRC_IN);
            arrowSelector.addState(new int[]{ android.R.attr.state_pressed }, arrow);
        }
        arrow = getResources().getDrawable(R.drawable.navigation_ic_arrow_drop_down);
        arrowSelector.addState(StateSet.WILD_CARD, arrow);

        medtFrom.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_compose_email, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_send) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
