package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.*;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;
import fr.erictruong.training.material.ui.tile.NavigationDrawerGroup;
import fr.erictruong.training.material.ui.tile.Tile;

public class ComponentsActivity extends MaterialTrainingActivity {

    private static final String TAG = ComponentsActivity.class.getSimpleName();

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_COMPONENTS_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_components);
    }

    @Override
    protected int getDefaultSelectedFragment() {
        return NAVDRAWER_CHILD_BOTTOM_SHEETS_ID;
    }

    @Override
    protected  Fragment getSelectedFragment(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_BOTTOM_SHEETS_ID:
                return new BottomSheetsFragment();
            case NAVDRAWER_CHILD_BUTTONS_ID:
                return new ButtonsFragment();
            case NAVDRAWER_CHILD_BUTTONS_FLOATING_ACTION_BUTTON_ID:
                return new ButtonsFloatingActionButtonFragment();
            case NAVDRAWER_CHILD_CARDS_ID:
                return new CardsFragment();
            case NAVDRAWER_CHILD_CHIPS_ID:
                return new ChipsFragment();
            case NAVDRAWER_CHILD_DATA_TABLES_ID:
                return new DataTablesFragment();
            case NAVDRAWER_CHILD_DIALOGS_ID:
                return new DialogsFragment();
            case NAVDRAWER_CHILD_DIVIDERS_ID:
                return new DividersFragment();
            case NAVDRAWER_CHILD_GRID_LISTS_ID:
                return new GridListsFragment();
            case NAVDRAWER_CHILD_LISTS_ID:
                return new ListsFragment();
            case NAVDRAWER_CHILD_LISTS_CONTROLS_ID:
                return new ListsControlsFragment();
            case NAVDRAWER_CHILD_MENUS_ID:
                return new MenusFragment();
            case NAVDRAWER_CHILD_PICKERS_ID:
                return new PickersFragment();
            case NAVDRAWER_CHILD_PROGRESS_AND_ACTIVITY_ID:
                return new ProgressAndActivityFragment();
            case NAVDRAWER_CHILD_SELECTION_CONTROLS_ID:
                return new SelectionControlsFragment();
            case NAVDRAWER_CHILD_SLIDERS_ID:
                return new SlidersFragment();
            case NAVDRAWER_CHILD_SNACKBARS_AND_TOASTS_ID:
                return new SnackbarsAndToastsFragment();
            case NAVDRAWER_CHILD_SUBHEADERS_ID:
                return new SubheadersFragment();
            case NAVDRAWER_CHILD_TABS_ID:
                return new TabsFragment();
            case NAVDRAWER_CHILD_TEXT_FIELDS_ID:
                return new TextFieldsFragment();
            case NAVDRAWER_CHILD_TOOLBARS_ID:
                return new ToolbarsFragment();
            case NAVDRAWER_CHILD_TOOLTIPS_ID:
                return new TooltipsFragment();
            default:
                return null;
        }
    }

    @Override
    protected NavigationDrawerChild getPreviousNavigationDrawerItem(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_BOTTOM_SHEETS_ID:
                return new NavigationDrawerChild(NAVDRAWER_GROUP_LAYOUT_ID, NAVDRAWER_CHILD_STRUCTURE_ID, null);
            case NAVDRAWER_CHILD_BUTTONS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_BOTTOM_SHEETS_ID, null);
            case NAVDRAWER_CHILD_BUTTONS_FLOATING_ACTION_BUTTON_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_BUTTONS_ID, null);
            case NAVDRAWER_CHILD_CARDS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_BUTTONS_FLOATING_ACTION_BUTTON_ID, null);
            case NAVDRAWER_CHILD_CHIPS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_CARDS_ID, null);
            case NAVDRAWER_CHILD_DATA_TABLES_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_CHIPS_ID, null);
            case NAVDRAWER_CHILD_DIALOGS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_DATA_TABLES_ID, null);
            case NAVDRAWER_CHILD_DIVIDERS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_DIALOGS_ID, null);
            case NAVDRAWER_CHILD_GRID_LISTS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_DIVIDERS_ID, null);
            case NAVDRAWER_CHILD_LISTS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_GRID_LISTS_ID, null);
            case NAVDRAWER_CHILD_LISTS_CONTROLS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_LISTS_ID, null);
            case NAVDRAWER_CHILD_MENUS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_LISTS_CONTROLS_ID, null);
            case NAVDRAWER_CHILD_PICKERS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_MENUS_ID, null);
            case NAVDRAWER_CHILD_PROGRESS_AND_ACTIVITY_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_PICKERS_ID, null);
            case NAVDRAWER_CHILD_SELECTION_CONTROLS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_PROGRESS_AND_ACTIVITY_ID, null);
            case NAVDRAWER_CHILD_SLIDERS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SELECTION_CONTROLS_ID, null);
            case NAVDRAWER_CHILD_SNACKBARS_AND_TOASTS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SLIDERS_ID, null);
            case NAVDRAWER_CHILD_SUBHEADERS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SNACKBARS_AND_TOASTS_ID, null);
            case NAVDRAWER_CHILD_TABS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SUBHEADERS_ID, null);
            case NAVDRAWER_CHILD_TEXT_FIELDS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_TABS_ID, null);
            case NAVDRAWER_CHILD_TOOLBARS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_TEXT_FIELDS_ID, null);
            case NAVDRAWER_CHILD_TOOLTIPS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_TOOLBARS_ID, null);
            default:
                return null;
        }
    }

    @Override
    protected NavigationDrawerChild getNextNavigationDrawerItem(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_BOTTOM_SHEETS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_BUTTONS_ID, null);
            case NAVDRAWER_CHILD_BUTTONS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_BUTTONS_FLOATING_ACTION_BUTTON_ID, null);
            case NAVDRAWER_CHILD_BUTTONS_FLOATING_ACTION_BUTTON_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_CARDS_ID, null);
            case NAVDRAWER_CHILD_CARDS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_CHIPS_ID, null);
            case NAVDRAWER_CHILD_CHIPS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_DATA_TABLES_ID, null);
            case NAVDRAWER_CHILD_DATA_TABLES_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_DIALOGS_ID, null);
            case NAVDRAWER_CHILD_DIALOGS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_DIVIDERS_ID, null);
            case NAVDRAWER_CHILD_DIVIDERS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_GRID_LISTS_ID, null);
            case NAVDRAWER_CHILD_GRID_LISTS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_LISTS_ID, null);
            case NAVDRAWER_CHILD_LISTS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_LISTS_CONTROLS_ID, null);
            case NAVDRAWER_CHILD_LISTS_CONTROLS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_MENUS_ID, null);
            case NAVDRAWER_CHILD_MENUS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_PICKERS_ID, null);
            case NAVDRAWER_CHILD_PICKERS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_PROGRESS_AND_ACTIVITY_ID, null);
            case NAVDRAWER_CHILD_PROGRESS_AND_ACTIVITY_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SELECTION_CONTROLS_ID, null);
            case NAVDRAWER_CHILD_SELECTION_CONTROLS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SLIDERS_ID, null);
            case NAVDRAWER_CHILD_SLIDERS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SNACKBARS_AND_TOASTS_ID, null);
            case NAVDRAWER_CHILD_SNACKBARS_AND_TOASTS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SUBHEADERS_ID, null);
            case NAVDRAWER_CHILD_SUBHEADERS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_TABS_ID, null);
            case NAVDRAWER_CHILD_TABS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_TEXT_FIELDS_ID, null);
            case NAVDRAWER_CHILD_TEXT_FIELDS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_TOOLBARS_ID, null);
            case NAVDRAWER_CHILD_TOOLBARS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_TOOLTIPS_ID, null);
            case NAVDRAWER_CHILD_TOOLTIPS_ID:
                return new NavigationDrawerChild(NAVDRAWER_GROUP_PATTERNS_ID, NAVDRAWER_CHILD_APP_STRUCTURE_ID, null);
            default:
                return null;
        }
    }
}
