package com.training.android.material.ui.activity;

import com.squareup.spoon.Spoon;
import com.training.android.material.R;

public class PatternsActivityTest extends NavigationDrawerActivityTest<PatternsActivity> {

    private PatternsActivity activity;

    public PatternsActivityTest() {
        super(PatternsActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testShowDataFormatsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_data_formats));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowErrorsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_errors));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowGesturesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_gestures));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowLoadingImagesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_loading_images));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowNavigationDrawerFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_navigation_drawer));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowNavigationalTransitionsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_navigational_transitions));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowScrollingTechniquesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_scrolling_techniques));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowSearchFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_search));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowSelectionFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_selection));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowSettingsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_settings));
        Spoon.screenshot(activity, "initial_state");
    }

    public void testShowSwipeToRefreshFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_swipe_to_refresh));
        Spoon.screenshot(activity, "initial_state");
    }
}
