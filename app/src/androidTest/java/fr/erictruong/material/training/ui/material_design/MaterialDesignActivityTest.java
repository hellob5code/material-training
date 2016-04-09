package fr.erictruong.material.training.ui.material_design;

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
import static fr.erictruong.material.training.action.NavigationViewActions.navigateTo;

@RunWith(AndroidJUnit4.class)
public class MaterialDesignActivityTest {

    @Rule
    public ActivityTestRule<MaterialDesignActivity> activityRule = new ActivityTestRule<>(MaterialDesignActivity.class);

    private MaterialDesignActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = activityRule.getActivity();
    }

    @Test
    public void navigateTo_Introduction() {
        onView(withId(R.id.drawer_layout)).perform(open()).check(matches(isOpen()));
        onView(withId(R.id.drawer_navigation)).perform(navigateTo(R.id.nav_introduction));
        Spoon.screenshot(activity, "initial_state");

        onView(withId(R.id.drawer_layout)).check(matches(isClosed())).perform(open()).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }
}
