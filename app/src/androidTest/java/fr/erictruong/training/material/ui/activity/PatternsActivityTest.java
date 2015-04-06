package fr.erictruong.training.material.ui.activity;

import com.squareup.spoon.Spoon;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.activity.PatternsActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

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

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowErrorsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_errors));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowGesturesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_gestures));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowLoadingImagesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_loading_images));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowNavigationDrawerFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_navigation_drawer));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowNavigationalTransitionsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_navigational_transitions));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowScrollingTechniquesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_scrolling_techniques));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowSearchFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_search));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowSelectionFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_selection));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowSettingsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_settings));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowSwipeToRefreshFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_swipe_to_refresh));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }
}
