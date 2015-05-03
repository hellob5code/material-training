package fr.erictruong.training.material.ui.activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.squareup.spoon.Spoon;
import fr.erictruong.training.material.R;
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
public class ComponentsActivityTest extends NavigationDrawerActivityTest {

    @Rule
    public ActivityTestRule<ComponentsActivity> activityRule = new ActivityTestRule<>(ComponentsActivity.class);

    private ComponentsActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = activityRule.getActivity();
    }

    @Test
    public void showBottomSheetsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_bottom_sheets));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showButtonsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_buttons));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showButtonsFloatingActionButtonFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_buttons_floating_action_button));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showCardsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_cards));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showChipsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_chips));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showDataTablesFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_data_tables));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showDialogsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_dialogs));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showDividersFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_dividers));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showGridListsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_grid_lists));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showListsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_lists));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showListControlsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_lists_controls));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showMenusFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_menus));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showPickersFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_pickers));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showProgressAndActivityFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_progress_and_activity));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showSelectionControlsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_selection_controls));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showSlidersFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_sliders));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showSnackbarsAndToastsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_snackbars_and_toasts));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showSubheadersFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_subheaders));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showTabsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_tabs));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showTextFieldsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_text_fields));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showToolbarsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_toolbars));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }

    @Test
    public void showTooltipsFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_tooltips));
        Spoon.screenshot(activity, "initial_state");

        openDrawer(R.id.drawer_layout);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        Spoon.screenshot(activity, "drawer_opened");
    }
}
