package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.EnvironmentFragment;
import fr.erictruong.training.material.ui.fragment.MaterialPropertiesFragment;
import fr.erictruong.training.material.ui.fragment.ObjectsIn3dSpaceFragment;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;

public class WhatIsMaterialActivity extends MaterialTrainingActivity {

    private static final String TAG = WhatIsMaterialActivity.class.getSimpleName();

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_WHAT_IS_MATERIAL_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_what_is_material);
    }

    @Override
    protected int getDefaultSelectedFragment() {
        return NAVDRAWER_CHILD_ENVIRONMENT_ID;
    }

    @Override
    protected Fragment getSelectedFragment(int navdrawerItemId) {
        switch (navdrawerItemId) {
            case NAVDRAWER_CHILD_ENVIRONMENT_ID:
                return new EnvironmentFragment();
            case NAVDRAWER_CHILD_MATERIAL_PROPERTIES_ID:
                return new MaterialPropertiesFragment();
            case NAVDRAWER_CHILD_OBJECTS_IN_3D_SPACE_ID:
                return new ObjectsIn3dSpaceFragment();
            default:
                return null;
        }
    }

    @Override
    protected NavigationDrawerChild getPreviousNavigationDrawerItem() {
        switch (getSelectedNavigationDrawerItemId()) {
            case NAVDRAWER_CHILD_ENVIRONMENT_ID:
                return new NavigationDrawerChild(NAVDRAWER_GROUP_MATERIAL_DESIGN_ID, NAVDRAWER_CHILD_INTRODUCTION_ID, null);
            case NAVDRAWER_CHILD_MATERIAL_PROPERTIES_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_ENVIRONMENT_ID, null);
            case NAVDRAWER_CHILD_OBJECTS_IN_3D_SPACE_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_MATERIAL_PROPERTIES_ID, null);
            default:
                return null;
        }
    }

    @Override
    protected NavigationDrawerChild getNextNavigationDrawerItem() {
        switch (getSelectedNavigationDrawerItemId()) {
            case NAVDRAWER_CHILD_ENVIRONMENT_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_MATERIAL_PROPERTIES_ID, null);
            case NAVDRAWER_CHILD_MATERIAL_PROPERTIES_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_OBJECTS_IN_3D_SPACE_ID, null);
            case NAVDRAWER_CHILD_OBJECTS_IN_3D_SPACE_ID:
                return new NavigationDrawerChild(NAVDRAWER_GROUP_ANIMATION_ID, NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID, null);
            default:
                return null;
        }
    }
}
