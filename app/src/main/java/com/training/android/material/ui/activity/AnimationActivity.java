package com.training.android.material.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.training.android.material.R;
import com.training.android.material.persistence.preference.AppPrefs;
import com.training.android.material.ui.fragment.*;
import com.training.android.material.ui.tile.Tile;

public class AnimationActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = AnimationActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            int id = getIntent().getIntExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.content, getSelectedFragment(id)).commit();
        }
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_ANIMATION_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_animation);
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
            case NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID:
                fragment = new AuthenticMotionCardFragment();
                break;
            case NAVDRAWER_CHILD_RESPONSIVE_INTERACTION_ID:
                fragment = new ResponsiveInteractionCardFragment();
                break;
            case NAVDRAWER_CHILD_MEANINGFUL_TRANSITIONS_ID:
                fragment = new MeaningfulTransitionsCardFragment();
                break;
            case NAVDRAWER_CHILD_DELIGHTFUL_DETAILS_ID:
                fragment = new DelightfulDetailsCardFragment();
                break;
        }
        if (fragment != null) {
            AppPrefs.putLastVisitedChildId(this, id);
        }
        return fragment;
    }
}
