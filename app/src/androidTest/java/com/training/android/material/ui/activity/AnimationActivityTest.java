package com.training.android.material.ui.activity;

import com.squareup.spoon.Spoon;
import com.training.android.material.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class AnimationActivityTest extends NavigationDrawerActivityTest<AnimationActivity> {

    private AnimationActivity activity;

    public AnimationActivityTest() {
        super(AnimationActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testShowAuthenticMotionFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_authentic_motion));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowResponsiveInteractionFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_responsive_interaction));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowMeaningfulTransitionsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_meaningful_transitions));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowDelightfulDetailsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_delightful_details));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }
}
