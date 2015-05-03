package fr.erictruong.training.material.ui.activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.squareup.spoon.Spoon;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.activity.LayoutActivity;
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
public class LayoutActivityTest extends NavigationDrawerActivityTest {

    @Rule
    public ActivityTestRule<LayoutActivity> activityRule = new ActivityTestRule<>(LayoutActivity.class);

    private LayoutActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = activityRule.getActivity();
    }

    @Test
    public void showPrinciplesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_principles));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showUnitsAndMeasurementsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_units_and_measurements));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showMetricsAndKeylinesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_metrics_and_keylines));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showStructureFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_structure));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }
}
