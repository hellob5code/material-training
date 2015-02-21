package com.training.android.material.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.training.android.material.R;
import com.training.android.material.ui.fragment.*;
import com.training.android.material.ui.tile.Tile;

public class UsabilityActivity extends MaterialTrainingNavDrawerActivity {

    private static final String TAG = UsabilityActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            int id = getIntent().getIntExtra(EXTRA_SELECTED_CHILD_ID, NAVDRAWER_CHILD_ACCESSIBILITY_ID);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.content, getSelectedFragment(id)).commit();
        }
    }

    @Override
    protected int getSelectedNavDrawerGroupId() {
        return NAVDRAWER_GROUP_USABILITY_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_usability);
    }

    @Override
    protected boolean onNavDrawerItemSelected(Tile item) {
        int id = item.getId();
        if (getSelectedFragment(id) != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content, getSelectedFragment(id)).commit();
            return true;
        }
        return super.onNavDrawerItemSelected(item);
    }

    private Fragment getSelectedFragment(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_ACCESSIBILITY_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_BIDIRECTIONALITY_ID:
                return new DummyFragment();
            default:
                return null;
        }
    }
}
