package fr.erictruong.training.material.ui.activity;

import com.squareup.spoon.Spoon;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.activity.WhatIsMaterialActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

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

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowMaterialPropertiesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_material_properties));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowObjectsIn3dSpaceFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_objects_in_3d_space));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }
}
