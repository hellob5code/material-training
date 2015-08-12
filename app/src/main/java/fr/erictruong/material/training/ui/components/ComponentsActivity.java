package fr.erictruong.material.training.ui.components;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.components.lists.ListsFragment;
import fr.erictruong.material.training.ui.components.lists_controls.ListsControlsFragment;
import fr.erictruong.material.training.ui.components.tabs.TabsFragment;
import fr.erictruong.material.training.ui.core.BaseDrawerActivity;
import fr.erictruong.material.training.ui.core.fragment.DummyFragment;

public class ComponentsActivity extends BaseDrawerActivity {

    /**
     * Start an {@link ComponentsActivity} with extras.
     *
     * @param context The Android context.
     * @param id      (Extra) The navigation menu item ID of the desired content.
     */
    public static void start(Context context, int id) {
        Intent starter = new Intent(context, ComponentsActivity.class);
        starter.putExtra(EXTRA_NAV_ID, id);
        context.startActivity(starter);
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case R.id.nav_bottom_sheets:
                return DummyFragment.newInstance();
            case R.id.nav_buttons:
                return DummyFragment.newInstance();
            case R.id.nav_buttons_floating_action_button:
                return DummyFragment.newInstance();
            case R.id.nav_cards:
                return DummyFragment.newInstance();
            case R.id.nav_chips:
                return DummyFragment.newInstance();
            case R.id.nav_data_tables:
                return DummyFragment.newInstance();
            case R.id.nav_dialogs:
                return DummyFragment.newInstance();
            case R.id.nav_dividers:
                return DummyFragment.newInstance();
            case R.id.nav_grid_lists:
                return DummyFragment.newInstance();
            case R.id.nav_lists:
                return ListsFragment.newInstance();
            case R.id.nav_lists_controls:
                return ListsControlsFragment.newInstance();
            case R.id.nav_menus:
                return DummyFragment.newInstance();
            case R.id.nav_pickers:
                return DummyFragment.newInstance();
            case R.id.nav_progress_and_activity:
                return DummyFragment.newInstance();
            case R.id.nav_selection_controls:
                return DummyFragment.newInstance();
            case R.id.nav_sliders:
                return DummyFragment.newInstance();
            case R.id.nav_snackbars_and_toasts:
                return DummyFragment.newInstance();
            case R.id.nav_steppers:
                return DummyFragment.newInstance();
            case R.id.nav_subheaders:
                return DummyFragment.newInstance();
            case R.id.nav_tabs:
                return TabsFragment.newInstance();
            case R.id.nav_text_fields:
                return DummyFragment.newInstance();
            case R.id.nav_toolbars:
                return DummyFragment.newInstance();
            case R.id.nav_tooltips:
                return DummyFragment.newInstance();
            default:
                return null;
        }
    }
}
