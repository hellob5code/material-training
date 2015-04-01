package com.training.android.material.ui.activity;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import com.training.android.material.R;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.training.android.material.matcher.CustomMatchers.withNavigationDrawerChildText;

public class NavigationDrawerActivityTest<T extends Activity> extends ActivityInstrumentationTestCase2<T> {

    public NavigationDrawerActivityTest(Class<T> activityClass) {
        super(activityClass);
    }

    protected void clickNavigationDrawerItem(String string) {
        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        onData(withNavigationDrawerChildText(string)).perform(click());
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));
    }
}
