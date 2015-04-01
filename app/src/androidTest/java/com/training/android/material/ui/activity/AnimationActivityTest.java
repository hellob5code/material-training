package com.training.android.material.ui.activity;

import com.squareup.spoon.Spoon;
import com.training.android.material.R;

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
    }

    public void testShowResponsiveInteractionFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_responsive_interaction));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowMeaningfulTransitionsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_meaningful_transitions));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowDelightfulDetailsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_delightful_details));
        Spoon.screenshot(activity, "initial_state");
    }
}
