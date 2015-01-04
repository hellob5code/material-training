package com.training.android.material.ui.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.training.android.material.R;
import com.training.android.material.ui.fragment.BottomSheetsFragment;
import com.training.android.material.ui.fragment.ButtonsFragment;
import com.training.android.material.ui.fragment.ListsFragment;
import com.training.android.material.ui.fragment.TextFieldsFragment;
import com.training.android.material.ui.row.ListRow;

public class ComponentsActivity extends MaterialTrainingNavDrawerActivity {

    private static final String TAG = ComponentsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int id = getIntent().getIntExtra(EXTRA_SELECTED_CHILD_ID, NAVDRAWER_CHILD_TEXT_FIELDS_ID);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (id == NAVDRAWER_CHILD_BOTTOM_SHEETS_ID) {
            ft.add(R.id.content, new BottomSheetsFragment()).commit();
        } else if (id == NAVDRAWER_CHILD_BUTTONS_ID) {
            ft.add(R.id.content, new ButtonsFragment()).commit();
        } else if (id == NAVDRAWER_CHILD_LISTS_ID) {
            ft.add(R.id.content, new ListsFragment()).commit();
        } else if (id == NAVDRAWER_CHILD_TEXT_FIELDS_ID) {
            ft.add(R.id.content, new TextFieldsFragment()).commit();
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
    protected boolean onNavDrawerItemSelected(ListRow item) {
        int id = item.getId();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (id == NAVDRAWER_CHILD_BOTTOM_SHEETS_ID) {
            ft.replace(R.id.content, new BottomSheetsFragment()).commit();
            return true;
        } else if (id == NAVDRAWER_CHILD_BUTTONS_ID) {
            ft.replace(R.id.content, new ButtonsFragment()).commit();
            return true;
        } else if (id == NAVDRAWER_CHILD_LISTS_ID) {
            ft.replace(R.id.content, new ListsFragment()).commit();
            return true;
        } else if (id == NAVDRAWER_CHILD_TEXT_FIELDS_ID) {
            ft.replace(R.id.content, new TextFieldsFragment()).commit();
            return true;
        }
        return super.onNavDrawerItemSelected(item);
    }
}
