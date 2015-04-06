package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.*;

public class ComponentsActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = ComponentsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setupContent(NAVDRAWER_CHILD_BOTTOM_SHEETS_ID);
        }
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_COMPONENTS_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_components);
    }

    @Override
    protected  Fragment getSelectedFragment(int navdrawerItemId) {
        switch (navdrawerItemId) {
            case NAVDRAWER_CHILD_BOTTOM_SHEETS_ID:
                return new BottomSheetsCardFragment();
            case NAVDRAWER_CHILD_BUTTONS_ID:
                return new ButtonsCardFragment();
            case NAVDRAWER_CHILD_CARDS_ID:
                return new CardsCardFragment();
            case NAVDRAWER_CHILD_CHIPS_ID:
                return new ChipsCardFragment();
            case NAVDRAWER_CHILD_DIALOGS_ID:
                return new DialogsCardFragment();
            case NAVDRAWER_CHILD_DIVIDERS_ID:
                return new DividersCardFragment();
            case NAVDRAWER_CHILD_GRIDS_ID:
                return new GridsCardFragment();
            case NAVDRAWER_CHILD_LISTS_ID:
                return new ListsCardFragment();
            case NAVDRAWER_CHILD_LIST_CONTROLS_ID:
                return new ListControlsCardFragment();
            case NAVDRAWER_CHILD_MENUS_ID:
                return new MenusCardFragment();
            case NAVDRAWER_CHILD_PICKERS_ID:
                return new PickersCardFragment();
            case NAVDRAWER_CHILD_PROGRESS_AND_ACTIVITY_ID:
                return new ProgressAndActivityCardFragment();
            case NAVDRAWER_CHILD_SLIDERS_ID:
                return new SlidersCardFragment();
            case NAVDRAWER_CHILD_SNACKBARS_AND_TOASTS_ID:
                return new SnackbarsAndToastsCardFragment();
            case NAVDRAWER_CHILD_SUBHEADERS_ID:
                return new SubheadersCardFragment();
            case NAVDRAWER_CHILD_SWITCHES_ID:
                return new SwitchesCardFragment();
            case NAVDRAWER_CHILD_TABS_ID:
                return new TabsCardFragment();
            case NAVDRAWER_CHILD_TEXT_FIELDS_ID:
                return new TextFieldsCardFragment();
            case NAVDRAWER_CHILD_TOOLTIPS_ID:
                return new TooltipsCardFragment();
            default:
                return super.getSelectedFragment(navdrawerItemId);
        }
    }
}
