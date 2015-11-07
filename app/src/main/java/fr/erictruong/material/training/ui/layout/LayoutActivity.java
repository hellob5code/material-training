package fr.erictruong.material.training.ui.layout;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.BaseDrawerActivity;
import fr.erictruong.material.training.ui.core.DummyFragment;

public class LayoutActivity extends BaseDrawerActivity {

    /**
     * Start an {@link LayoutActivity} with extras.
     *
     * @param context The Android context.
     * @param id      (Extra) The navigation menu item ID of the desired content.
     */
    public static void start(Context context, int id) {
        Intent starter = new Intent(context, LayoutActivity.class);
        starter.putExtra(EXTRA_NAV_ID, id);
        context.startActivity(starter);
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case R.id.nav_principles:
                return DummyFragment.newInstance();
            case R.id.nav_units_and_measurements:
                return DummyFragment.newInstance();
            case R.id.nav_metrics_and_keylines:
                return DummyFragment.newInstance();
            case R.id.nav_structure:
                return DummyFragment.newInstance();
            case R.id.nav_adaptive_ui:
                return DummyFragment.newInstance();
            default:
                return null;
        }
    }
}
