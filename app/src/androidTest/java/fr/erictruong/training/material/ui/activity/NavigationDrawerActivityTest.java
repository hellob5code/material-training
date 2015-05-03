package fr.erictruong.training.material.ui.activity;

import fr.erictruong.training.material.R;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static fr.erictruong.training.material.matcher.CustomMatchers.withNavigationDrawerChildText;

public class NavigationDrawerActivityTest  {

    protected void clickNavigationDrawerItem(String string) {
        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        onData(withNavigationDrawerChildText(string)).perform(click());
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));
    }
}
