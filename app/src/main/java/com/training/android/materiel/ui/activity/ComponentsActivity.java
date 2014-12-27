package com.training.android.materiel.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.training.android.materiel.R;
import com.training.android.materiel.ui.fragment.BottomSheetsFragment;
import com.training.android.materiel.ui.fragment.ButtonsFragment;
import com.training.android.materiel.ui.fragment.ListsFragment;

public class ComponentsActivity extends MaterialTrainingNavDrawerActivity {

    private static final String TAG = ComponentsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int id = getIntent().getIntExtra(EXTRA_SELECTED_CHILD_ID, NAVDRAWER_ITEM_COMPONENTS_LISTS_ID);
        if (id == NAVDRAWER_ITEM_COMPONENTS_BOTTOM_SHEETS_ID) {
            getFragmentManager().beginTransaction().add(R.id.content, new BottomSheetsFragment()).commit();
        } else if (id == NAVDRAWER_ITEM_COMPONENTS_BUTTONS_ID) {
            getFragmentManager().beginTransaction().add(R.id.content, new ButtonsFragment()).commit();
        } else if (id == NAVDRAWER_ITEM_COMPONENTS_LISTS_ID) {
            getFragmentManager().beginTransaction().add(R.id.content, new ListsFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getSelectedNavigationDrawerItemId() {
        return getIntent().getIntExtra(EXTRA_SELECTED_CHILD_ID, NAVDRAWER_ITEM_COMPONENTS_BOTTOM_SHEETS_ID);
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_COMPONENTS;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_components);
    }

    @Override
    protected boolean onNavDrawerItemSelected(NavDrawerItem item) {
        int id = item.getId();
        if (id == NAVDRAWER_ITEM_COMPONENTS_BOTTOM_SHEETS_ID) {
            getFragmentManager().beginTransaction().replace(R.id.content, new BottomSheetsFragment()).commit();
            return true;
        } else if (id == NAVDRAWER_ITEM_COMPONENTS_BUTTONS_ID) {
            getFragmentManager().beginTransaction().replace(R.id.content, new ButtonsFragment()).commit();
            return true;
        } else if (id == NAVDRAWER_ITEM_COMPONENTS_LISTS_ID) {
            getFragmentManager().beginTransaction().replace(R.id.content, new ListsFragment()).commit();
            return true;
        }
        return super.onNavDrawerItemSelected(item);
    }
}
