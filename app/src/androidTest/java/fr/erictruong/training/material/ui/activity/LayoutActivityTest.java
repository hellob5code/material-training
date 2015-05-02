package fr.erictruong.training.material.ui.activity;

import com.squareup.spoon.Spoon;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.activity.LayoutActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

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

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowUnitsAndMeasurementsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_units_and_measurements));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowMetricsAndKeylinesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_metrics_and_keylines));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowStructureFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_structure));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }
}
