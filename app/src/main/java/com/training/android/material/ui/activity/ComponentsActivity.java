package com.training.android.material.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.training.android.material.R;
import com.training.android.material.persistence.preference.AppPrefs;
import com.training.android.material.ui.fragment.*;
import com.training.android.material.ui.tile.Tile;

public class ComponentsActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = ComponentsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            int id = getIntent().getIntExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, -1);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.content, getSelectedFragment(id)).commit();
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
    protected boolean goToNavigationDrawerItem(Tile item) {
        int id = item.getId();
        Fragment fragment = getSelectedFragment(id);
        if (fragment != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment).commit();
            return true;
        }
        return super.goToNavigationDrawerItem(item);
    }

    private Fragment getSelectedFragment(int id) {
        Fragment fragment = null;
        switch (id) {
            case NAVDRAWER_CHILD_BOTTOM_SHEETS_ID:
                fragment =  new BottomSheetsFragment();
                break;
            case NAVDRAWER_CHILD_BUTTONS_ID:
                fragment =  new ButtonsRecyclerFragment();
                break;
            case NAVDRAWER_CHILD_CARDS_ID:
                fragment =  new DummyFragment();
                break;
            case NAVDRAWER_CHILD_CHIPS_ID:
                fragment =  new DummyFragment();
                break;
            case NAVDRAWER_CHILD_DIALOGS_ID:
                fragment =  new DummyFragment();
                break;
            case NAVDRAWER_CHILD_DIVIDERS_ID:
                fragment =  new DummyFragment();
                break;
            case NAVDRAWER_CHILD_GRIDS_ID:
                fragment =  new DummyFragment();
                break;
            case NAVDRAWER_CHILD_LISTS_ID:
                fragment =  new ListsFragment();
                break;
            case NAVDRAWER_CHILD_LIST_CONTROLS_ID:
                fragment =  new DummyFragment();
                break;
            case NAVDRAWER_CHILD_MENUS_ID:
                fragment =  new DummyFragment();
                break;
            case NAVDRAWER_CHILD_PICKERS_ID:
                fragment =  new DummyFragment();
                break;
            case NAVDRAWER_CHILD_PROGRESS_AND_ACTIVITY_ID:
                fragment =  new DummyFragment();
                break;
            case NAVDRAWER_CHILD_SLIDERS_ID:
                fragment =  new DummyFragment();
                break;
            case NAVDRAWER_CHILD_SNACKBARS_AND_TOASTS_ID:
                fragment =  new DummyFragment();
                break;
            case NAVDRAWER_CHILD_SUBHEADERS_ID:
                fragment =  new DummyFragment();
                break;
            case NAVDRAWER_CHILD_SWITCHES_ID:
                fragment =  new DummyFragment();
                break;
            case NAVDRAWER_CHILD_TABS_ID:
                fragment =  new TabsRecyclerFragment();
                break;
            case NAVDRAWER_CHILD_TEXT_FIELDS_ID:
                fragment =  new TextFieldsCardFragment();
                break;
            case NAVDRAWER_CHILD_TOOLTIPS_ID:
                fragment = new DummyFragment();
                break;
        }
        if (fragment != null) {
            AppPrefs.putLastVisitedChildId(this, id);
        }
        return fragment;
    }
}
