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
import android.widget.FullwidthEditText;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;
import com.training.android.material.util.ThemeUtils;

public class ComposeEmailActivity extends ActionBarActivity {

    @InjectView(R.id.compose_email_edt_from) FullwidthEditText edtFrom;

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

        arrow = getResources().getDrawable(R.drawable.ic_arrow_drop_down_black_24dp);
        arrow.mutate().setColorFilter(ThemeUtils.obtainColorPrimary(this), PorterDuff.Mode.SRC_ATOP);
        arrowSelector.addState(new int[]{ android.R.attr.state_pressed }, arrow);
        arrowSelector.addState(new int[]{ android.R.attr.state_focused }, arrow);

        arrow = getResources().getDrawable(R.drawable.ic_arrow_drop_down_grey600_24dp);
        arrowSelector.addState(StateSet.WILD_CARD, arrow);

        edtFrom.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector.getConstantState().newDrawable(), null);

        // Adjust padding due to drawable bounds
        int dimen_16dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics());
        edtFrom.setBasePadding(0, dimen_16dp, 0, dimen_16dp);
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
