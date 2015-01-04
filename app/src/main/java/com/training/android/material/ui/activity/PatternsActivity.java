package com.training.android.material.ui.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.training.android.material.R;
import com.training.android.material.ui.fragment.DataFormatsFragment;
import com.training.android.material.ui.fragment.ErrorsFragment;
import com.training.android.material.ui.tile.Tile;

public class PatternsActivity extends MaterialTrainingNavDrawerActivity {

    private static final String TAG = PatternsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int id = getIntent().getIntExtra(EXTRA_SELECTED_CHILD_ID, NAVDRAWER_CHILD_DATA_FORMATS_ID);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (id == NAVDRAWER_CHILD_DATA_FORMATS_ID) {
            ft.add(R.id.content, new DataFormatsFragment()).commit();
        } else if (id == NAVDRAWER_CHILD_ERRORS_ID) {
            ft.add(R.id.content, new ErrorsFragment()).commit();
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
    protected int getSelectedNavDrawerGroupId() {
        return NAVDRAWER_GROUP_PATTERNS;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_patterns);
    }

    @Override
    protected boolean onNavDrawerItemSelected(Tile item) {
        int id = item.getId();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (id == NAVDRAWER_CHILD_DATA_FORMATS_ID) {
            ft.replace(R.id.content, new DataFormatsFragment()).commit();
            return true;
        } else if (id == NAVDRAWER_CHILD_ERRORS_ID) {
            ft.replace(R.id.content, new ErrorsFragment()).commit();
            return true;
        }
        return super.onNavDrawerItemSelected(item);
    }
}
