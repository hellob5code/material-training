package com.training.android.material.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.training.android.material.R;
import com.training.android.material.ui.fragment.DataFormatsFragment;
import com.training.android.material.ui.fragment.DummyFragment;
import com.training.android.material.ui.fragment.ErrorsFragment;
import com.training.android.material.ui.tile.Tile;

public class PatternsActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = PatternsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            int id = getIntent().getIntExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, NAVDRAWER_CHILD_DATA_FORMATS_ID);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.content, getSelectedFragment(id)).commit();
        }
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_PATTERNS_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_patterns);
    }

    @Override
    protected boolean goToNavigationDrawerItem(Tile item) {
        int id = item.getId();
        if (getSelectedFragment(id) != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content, getSelectedFragment(id)).commit();
            return true;
        }
        return super.goToNavigationDrawerItem(item);
    }

    private Fragment getSelectedFragment(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_DATA_FORMATS_ID:
                return new DataFormatsFragment();
            case NAVDRAWER_CHILD_ERRORS_ID:
                return new ErrorsFragment();
            case NAVDRAWER_CHILD_GESTURES_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_LOADING_IMAGES_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_NAVIGATION_DRAWER_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_NAVIGATIONAL_TRANSITIONS_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_SCROLLING_TECHNIQUES_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_SEARCH_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_SELECTION_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_SETTINGS_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_SWIPE_TO_REFRESH_ID:
                return new DummyFragment();
            default:
                return null;
        }
    }
}
