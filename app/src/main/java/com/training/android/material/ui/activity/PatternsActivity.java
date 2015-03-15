package com.training.android.material.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.training.android.material.R;
import com.training.android.material.persistence.preference.AppPrefs;
import com.training.android.material.ui.fragment.*;
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
            case NAVDRAWER_CHILD_DATA_FORMATS_ID:
                fragment = new DataFormatsCardFragment();
                break;
            case NAVDRAWER_CHILD_ERRORS_ID:
                fragment = new ErrorsCardFragment();
                break;
            case NAVDRAWER_CHILD_GESTURES_ID:
                fragment = new GesturesCardFragment();
                break;
            case NAVDRAWER_CHILD_LOADING_IMAGES_ID:
                fragment = new LoadingImagesCardFragment();
                break;
            case NAVDRAWER_CHILD_NAVIGATION_DRAWER_ID:
                fragment = new NavigationDrawerCardFragment();
                break;
            case NAVDRAWER_CHILD_NAVIGATIONAL_TRANSITIONS_ID:
                fragment = new NavigationalTransitionsCardFragment();
                break;
            case NAVDRAWER_CHILD_SCROLLING_TECHNIQUES_ID:
                fragment = new ScrollingTechniquesCardFragment();
                break;
            case NAVDRAWER_CHILD_SEARCH_ID:
                fragment = new SearchCardFragment();
                break;
            case NAVDRAWER_CHILD_SELECTION_ID:
                fragment = new SelectionCardFragment();
                break;
            case NAVDRAWER_CHILD_SETTINGS_ID:
                fragment = new SettingsCardFragment();
                break;
            case NAVDRAWER_CHILD_SWIPE_TO_REFRESH_ID:
                fragment = new SwipeToRefreshCardFragment();
                break;
        }
        if (fragment != null) {
            AppPrefs.putLastVisitedChildId(this, id);
        }
        return fragment;
    }
}
