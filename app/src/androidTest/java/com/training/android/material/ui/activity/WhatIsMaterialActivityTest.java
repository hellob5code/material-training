package com.training.android.material.ui.activity;

import com.squareup.spoon.Spoon;
import com.training.android.material.R;

public class WhatIsMaterialActivityTest extends NavigationDrawerActivityTest<WhatIsMaterialActivity> {

    private WhatIsMaterialActivity activity;

    public WhatIsMaterialActivityTest() {
        super(WhatIsMaterialActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testShowEnvironmentFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_environment));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowMaterialPropertiesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_material_properties));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowObjectsIn3dSpaceFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_objects_in_3d_space));
        Spoon.screenshot(activity, "initial_state");
    }
}
