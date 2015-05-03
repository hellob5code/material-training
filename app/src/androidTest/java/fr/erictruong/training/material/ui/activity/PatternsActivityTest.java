package fr.erictruong.training.material.ui.activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.squareup.spoon.Spoon;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.activity.PatternsActivity;
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
public class PatternsActivityTest extends NavigationDrawerActivityTest {

    @Rule
    public ActivityTestRule<PatternsActivity> activityRule = new ActivityTestRule<>(PatternsActivity.class);

    private PatternsActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = activityRule.getActivity();
    }

    @Test
    public void showDataFormatsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_data_formats));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showErrorsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_errors));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showGesturesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_gestures));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showLoadingImagesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_loading_images));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showNavigationDrawerFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_navigation_drawer));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showNavigationalTransitionsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_navigational_transitions));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showScrollingTechniquesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_scrolling_techniques));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showSearchFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_search));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showSelectionFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_selection));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showSettingsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_settings));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showSwipeToRefreshFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_swipe_to_refresh));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }
}
