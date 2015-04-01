package com.training.android.material.ui.activity;

import com.squareup.spoon.Spoon;
import com.training.android.material.R;

public class LayoutActivityTest extends NavigationDrawerActivityTest<LayoutActivity> {

    private LayoutActivity activity;

    public LayoutActivityTest() {
        super(LayoutActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testShowPrinciplesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_principles));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowMetricsAndKeylinesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_metrics_and_keylines));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowStructureFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_structure));
        Spoon.screenshot(activity, "initial_state");
    }
}
