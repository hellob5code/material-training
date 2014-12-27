package com.training.android.materiel.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.training.android.materiel.R;
import com.training.android.materiel.ui.fragment.DataFormatsFragment;
import com.training.android.materiel.ui.fragment.ErrorsFragment;

public class PatternsActivity extends MaterialTrainingNavDrawerActivity {

    private static final String TAG = PatternsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int id = getIntent().getIntExtra(EXTRA_SELECTED_CHILD_ID, NAVDRAWER_ITEM_PATTERNS_DATA_FORMATS_ID);
        if (id == NAVDRAWER_ITEM_PATTERNS_DATA_FORMATS_ID) {
            getFragmentManager().beginTransaction().add(R.id.content, new DataFormatsFragment()).commit();
        } else if (id == NAVDRAWER_ITEM_PATTERNS_ERRORS_ID) {
            getFragmentManager().beginTransaction().add(R.id.content, new ErrorsFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getSelectedNavigationDrawerItemId() {
        return getIntent().getIntExtra(EXTRA_SELECTED_CHILD_ID, NAVDRAWER_ITEM_PATTERNS_DATA_FORMATS_ID);
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_PATTERNS;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_patterns);
    }

    @Override
    protected boolean onNavDrawerItemSelected(NavDrawerItem item) {
        int id = item.getId();
        if (id == NAVDRAWER_ITEM_PATTERNS_DATA_FORMATS_ID) {
            getFragmentManager().beginTransaction().replace(R.id.content, new DataFormatsFragment()).commit();
            return true;
        } else if (id == NAVDRAWER_ITEM_PATTERNS_ERRORS_ID) {
            getFragmentManager().beginTransaction().replace(R.id.content, new ErrorsFragment()).commit();
            return true;
        }
        return super.onNavDrawerItemSelected(item);
    }
}
