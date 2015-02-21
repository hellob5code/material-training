package com.training.android.material.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.training.android.material.R;
import com.training.android.material.ui.fragment.DummyFragment;
import com.training.android.material.ui.tile.Tile;

public class AnimationActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = AnimationActivity.class.getSimpleName();

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
        if (getSelectedFragment(id) != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content, getSelectedFragment(id)).commit();
            return true;
        }
        return super.goToNavigationDrawerItem(item);
    }

    private Fragment getSelectedFragment(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_RESPONSIVE_INTERACTION_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_MEANINGFUL_TRANSITIONS_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_DELIGHTFUL_DETAILS_ID:
                return new DummyFragment();
            default:
                return null;
        }
    }
}
