package com.training.android.material.ui.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.training.android.material.R;
import com.training.android.material.ui.fragment.*;
import com.training.android.material.ui.tile.Tile;

public class ComponentsActivity extends MaterialTrainingNavDrawerActivity {

    private static final String TAG = ComponentsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            int id = getIntent().getIntExtra(EXTRA_SELECTED_CHILD_ID, NAVDRAWER_CHILD_BUTTONS_ID);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (id == NAVDRAWER_CHILD_BOTTOM_SHEETS_ID) {
                ft.add(R.id.content, new BottomSheetsFragment()).commit();
            } else if (id == NAVDRAWER_CHILD_BUTTONS_ID) {
                ft.add(R.id.content, new ButtonsRecyclerFragment()).commit();
            } else if (id == NAVDRAWER_CHILD_LISTS_ID) {
                ft.add(R.id.content, new ListsFragment()).commit();
            } else if (id == NAVDRAWER_CHILD_TABS_ID) {
                ft.add(R.id.content, new TabsRecyclerFragment()).commit();
            } else if (id == NAVDRAWER_CHILD_TEXT_FIELDS_ID) {
                ft.add(R.id.content, new TextFieldsRecyclerFragment()).commit();
            }
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
    protected int getSelectedNavDrawerGroupId() {
        return NAVDRAWER_GROUP_COMPONENTS;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_components);
    }

    @Override
    protected boolean onNavDrawerItemSelected(Tile item) {
        int id = item.getId();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (id == NAVDRAWER_CHILD_BOTTOM_SHEETS_ID) {
            ft.replace(R.id.content, new BottomSheetsFragment()).commit();
            return true;
        } else if (id == NAVDRAWER_CHILD_BUTTONS_ID) {
            ft.replace(R.id.content, new ButtonsRecyclerFragment()).commit();
            return true;
        } else if (id == NAVDRAWER_CHILD_LISTS_ID) {
            ft.replace(R.id.content, new ListsFragment()).commit();
            return true;
        } else if (id == NAVDRAWER_CHILD_TABS_ID) {
            ft.replace(R.id.content, new TabsRecyclerFragment()).commit();
            return true;
        } else if (id == NAVDRAWER_CHILD_TEXT_FIELDS_ID) {
            ft.replace(R.id.content, new TextFieldsRecyclerFragment()).commit();
            return true;
        }
        return super.onNavDrawerItemSelected(item);
    }
}
