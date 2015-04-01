package com.training.android.material.ui.activity;

import com.squareup.spoon.Spoon;
import com.training.android.material.R;

public class StyleActivityTest extends NavigationDrawerActivityTest<StyleActivity> {

    private StyleActivity activity;

    public StyleActivityTest() {
        super(StyleActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testShowColorFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_color));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowIconsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_icons));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowImageryFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_imagery));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowTypographyFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_typography));
        Spoon.screenshot(activity, "initial_state");
    }
}
