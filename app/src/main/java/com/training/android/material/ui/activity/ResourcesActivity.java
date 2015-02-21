package com.training.android.material.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.training.android.material.R;
import com.training.android.material.ui.fragment.DataFormatsFragment;
import com.training.android.material.ui.fragment.DummyFragment;
import com.training.android.material.ui.fragment.ErrorsFragment;
import com.training.android.material.ui.tile.Tile;

public class ResourcesActivity extends MaterialTrainingNavDrawerActivity {

    private static final String TAG = ResourcesActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            int id = getIntent().getIntExtra(EXTRA_SELECTED_CHILD_ID, NAVDRAWER_CHILD_COLOR_PALETTES_ID);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.content, getSelectedFragment(id)).commit();
        }
    }

    @Override
    protected int getSelectedNavDrawerGroupId() {
        return NAVDRAWER_GROUP_RESOURCES_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_resources);
    }

    @Override
    protected boolean onNavDrawerItemSelected(Tile item) {
        int id = item.getId();
        if (getSelectedFragment(id) != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content, getSelectedFragment(id)).commit();
            return true;
        }
        return super.onNavDrawerItemSelected(item);
    }

    private Fragment getSelectedFragment(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_COLOR_PALETTES_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_LAYOUT_TEMPLATES_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_ROBOTO_AND_NOTO_FONTS_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_STICKER_SHEETS_AND_ICONS_ID:
                return new DummyFragment();
            default:
                return null;
        }
    }
}
