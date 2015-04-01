package com.training.android.material.ui.activity;

import com.squareup.spoon.Spoon;
import com.training.android.material.R;

public class UsabilityActivityTest extends NavigationDrawerActivityTest<UsabilityActivity> {

    private UsabilityActivity activity;

    public UsabilityActivityTest() {
        super(UsabilityActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testShowAccessibilityFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_accessibility));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowBidirectionalityFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_bidirectionality));
        Spoon.screenshot(activity, "initial_state");
    }
}
