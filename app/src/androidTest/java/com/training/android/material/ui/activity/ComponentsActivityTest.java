package com.training.android.material.ui.activity;

import com.squareup.spoon.Spoon;
import com.training.android.material.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ComponentsActivityTest extends NavigationDrawerActivityTest<ComponentsActivity> {

    private ComponentsActivity activity;

    public ComponentsActivityTest() {
        super(ComponentsActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testShowBottomSheetsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_bottom_sheets));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowButtonsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_buttons));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowCardsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_cards));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowChipsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_chips));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowDialogsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_dialogs));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowDividersFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_dividers));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowGridsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_grids));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowListsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_lists));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowListControlsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_list_controls));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowMenusFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_menus));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowPickersFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_pickers));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowProgressAndActivityFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_progress_and_activity));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowSlidersFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_sliders));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowSnackbarsAndToastsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_snackbars_and_toasts));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowSubheadersFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_subheaders));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowSwitchesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_switches));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowTabsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_tabs));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowTextFieldsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_text_fields));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    public void testShowTooltipsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_tooltips));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }
}
