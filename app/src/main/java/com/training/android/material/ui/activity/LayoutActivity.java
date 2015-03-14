package com.training.android.material.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.training.android.material.R;
import com.training.android.material.persistence.preference.AppPrefs;
import com.training.android.material.ui.fragment.DummyFragment;
import com.training.android.material.ui.fragment.MetricsAndKeylinesCardFragment;
import com.training.android.material.ui.fragment.PrinciplesCardFragment;
import com.training.android.material.ui.fragment.StructureCardFragment;
import com.training.android.material.ui.tile.Tile;

public class LayoutActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = LayoutActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            int id = getIntent().getIntExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, NAVDRAWER_CHILD_PRINCIPLES_ID);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.content, getSelectedFragment(id)).commit();
        }
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_LAYOUT_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_layout);
    }

    @Override
    protected boolean goToNavigationDrawerItem(Tile item) {
        int id = item.getId();
        Fragment fragment = getSelectedFragment(id);
        if (fragment != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment).commit();
            return true;
        }
        return super.goToNavigationDrawerItem(item);
    }

    private Fragment getSelectedFragment(int id) {
        Fragment fragment = null;
        switch (id) {
            case NAVDRAWER_CHILD_PRINCIPLES_ID:
                fragment = new PrinciplesCardFragment();
                break;
            case NAVDRAWER_CHILD_METRICS_AND_KEYLINES_ID:
                fragment = new MetricsAndKeylinesCardFragment();
                break;
            case NAVDRAWER_CHILD_STRUCTURE_ID:
                fragment = new StructureCardFragment();
                break;
        }
        if (fragment != null) {
            AppPrefs.putLastVisitedChildId(this, id);
        }
        return fragment;
    }
}
