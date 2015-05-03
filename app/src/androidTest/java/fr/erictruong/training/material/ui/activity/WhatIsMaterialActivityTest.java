package fr.erictruong.training.material.ui.activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.squareup.spoon.Spoon;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.activity.WhatIsMaterialActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class WhatIsMaterialActivityTest extends NavigationDrawerActivityTest {

    @Rule
    public ActivityTestRule<WhatIsMaterialActivity> activityRule = new ActivityTestRule<>(WhatIsMaterialActivity.class);

    private WhatIsMaterialActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = activityRule.getActivity();
    }

    @Test
    public void showEnvironmentFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_environment));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showMaterialPropertiesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_material_properties));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showObjectsIn3dSpaceFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_objects_in_3d_space));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }
}
