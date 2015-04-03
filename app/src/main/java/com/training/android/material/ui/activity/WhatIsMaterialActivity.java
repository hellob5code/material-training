package com.training.android.material.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import com.training.android.material.R;
import com.training.android.material.ui.fragment.EnvironmentCardFragment;
import com.training.android.material.ui.fragment.MaterialPropertiesCardFragment;
import com.training.android.material.ui.fragment.ObjectsIn3dSpaceCardFragment;

public class WhatIsMaterialActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = WhatIsMaterialActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setupContent(NAVDRAWER_CHILD_ENVIRONMENT_ID);
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
    protected Fragment getSelectedFragment(int navdrawerItemId) {
        switch (navdrawerItemId) {
            case NAVDRAWER_CHILD_ENVIRONMENT_ID:
                return new EnvironmentCardFragment();
            case NAVDRAWER_CHILD_MATERIAL_PROPERTIES_ID:
                return new MaterialPropertiesCardFragment();
            case NAVDRAWER_CHILD_OBJECTS_IN_3D_SPACE_ID:
                return new ObjectsIn3dSpaceCardFragment();
            default:
                return super.getSelectedFragment(navdrawerItemId);
        }
    }
}
