package com.training.android.material.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.training.android.material.R;
import com.training.android.material.ui.fragment.DummyFragment;
import com.training.android.material.ui.fragment.EnvironmentCardFragment;
import com.training.android.material.ui.fragment.MaterialPropertiesCardFragment;
import com.training.android.material.ui.fragment.ObjectsIn3dSpaceCardFragment;
import com.training.android.material.ui.tile.Tile;

public class WhatIsMaterialActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = WhatIsMaterialActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            int id = getIntent().getIntExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, NAVDRAWER_CHILD_ENVIRONMENT_ID);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.content, getSelectedFragment(id)).commit();
        }
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_WHAT_IS_MATERIAL_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_what_is_material);
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
            case NAVDRAWER_CHILD_ENVIRONMENT_ID:
                return new EnvironmentCardFragment();
            case NAVDRAWER_CHILD_MATERIAL_PROPERTIES_ID:
                return new MaterialPropertiesCardFragment();
            case NAVDRAWER_CHILD_OBJECTS_IN_3D_SPACE_ID:
                return new ObjectsIn3dSpaceCardFragment();
            default:
                return null;
        }
    }
}
