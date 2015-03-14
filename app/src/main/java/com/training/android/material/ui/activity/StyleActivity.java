package com.training.android.material.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.training.android.material.R;
import com.training.android.material.persistence.preference.AppPrefs;
import com.training.android.material.ui.fragment.*;
import com.training.android.material.ui.tile.Tile;

public class StyleActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = StyleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            int id = getIntent().getIntExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, NAVDRAWER_CHILD_COLOR_ID);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.content, getSelectedFragment(id)).commit();
        }
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_STYLE_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_style);
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
            case NAVDRAWER_CHILD_COLOR_ID:
                fragment = new ColorCardFragment();
                break;
            case NAVDRAWER_CHILD_ICONS_ID:
                fragment = new IconsCardFragment();
                break;
            case NAVDRAWER_CHILD_IMAGERY_ID:
                fragment = new ImageryCardFragment();
                break;
            case NAVDRAWER_CHILD_TYPOGRAPHY_ID:
                fragment = new TypographyCardFragment();
                break;
        }
        if (fragment != null) {
            AppPrefs.putLastVisitedChildId(this, id);
        }
        return fragment;
    }
}
