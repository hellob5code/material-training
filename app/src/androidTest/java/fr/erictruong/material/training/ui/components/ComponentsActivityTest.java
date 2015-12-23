package fr.erictruong.material.training.ui.components;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.squareup.spoon.Spoon;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.erictruong.material.training.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static fr.erictruong.material.training.custom.action.NavigationViewActions.navigateTo;

@RunWith(AndroidJUnit4.class)
public class ComponentsActivityTest {

    @Rule
    public ActivityTestRule<ComponentsActivity> activityRule = new ActivityTestRule<>(ComponentsActivity.class);

    private ComponentsActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = activityRule.getActivity();
    }

    @Test
    public void navigateTo_Cards() {
        onView(withId(R.id.drawer_layout)).perform(open()).check(matches(isOpen()));
        onView(withId(R.id.drawer_navigation)).perform(navigateTo(R.id.nav_cards));
        Spoon.screenshot(activity, "initial_state");

        onView(withId(R.id.drawer_layout)).check(matches(isClosed())).perform(open()).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void navigateTo_Lists() {
        onView(withId(R.id.drawer_layout)).perform(open()).check(matches(isOpen()));
        onView(withId(R.id.drawer_navigation)).perform(navigateTo(R.id.nav_lists));
        Spoon.screenshot(activity, "initial_state");

        onView(withId(R.id.drawer_layout)).check(matches(isClosed())).perform(open()).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void navigateTo_ListsControls() {
        onView(withId(R.id.drawer_layout)).perform(open()).check(matches(isOpen()));
        onView(withId(R.id.drawer_navigation)).perform(navigateTo(R.id.nav_lists_controls));
        Spoon.screenshot(activity, "initial_state");

        onView(withId(R.id.drawer_layout)).check(matches(isClosed())).perform(open()).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void navigateTo_Steppers() {
        onView(withId(R.id.drawer_layout)).perform(open()).check(matches(isOpen()));
        onView(withId(R.id.drawer_navigation)).perform(navigateTo(R.id.nav_steppers));
        Spoon.screenshot(activity, "initial_state");

        onView(withId(R.id.drawer_layout)).check(matches(isClosed())).perform(open()).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void navigateTo_Subheaders() {
        onView(withId(R.id.drawer_layout)).perform(open()).check(matches(isOpen()));
        onView(withId(R.id.drawer_navigation)).perform(navigateTo(R.id.nav_subheaders));
        Spoon.screenshot(activity, "initial_state");

        onView(withId(R.id.drawer_layout)).check(matches(isClosed())).perform(open()).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void navigateTo_Tabs() {
        onView(withId(R.id.drawer_layout)).perform(open()).check(matches(isOpen()));
        onView(withId(R.id.drawer_navigation)).perform(navigateTo(R.id.nav_tabs));
        Spoon.screenshot(activity, "initial_state");

        onView(withId(R.id.drawer_layout)).check(matches(isClosed())).perform(open()).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }
}
