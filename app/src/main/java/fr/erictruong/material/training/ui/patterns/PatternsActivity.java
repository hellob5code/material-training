package fr.erictruong.material.training.ui.patterns;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.BaseDrawerActivity;
import fr.erictruong.material.training.ui.core.fragment.DummyFragment;

public class PatternsActivity extends BaseDrawerActivity {

    /**
     * Start an {@link PatternsActivity} with extras.
     *
     * @param context The Android context.
     * @param id      (Extra) The navigation menu item ID of the desired content.
     */
    public static void start(Context context, int id) {
        Intent starter = new Intent(context, PatternsActivity.class);
        starter.putExtra(EXTRA_NAV_ID, id);
        context.startActivity(starter);
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case R.id.nav_app_structure:
                return DummyFragment.newInstance();
            case R.id.nav_data_formats:
                return DummyFragment.newInstance();
            case R.id.nav_empty_states:
                return DummyFragment.newInstance();
            case R.id.nav_errors:
                return DummyFragment.newInstance();
            case R.id.nav_gestures:
                return DummyFragment.newInstance();
            case R.id.nav_fingerprint:
                return DummyFragment.newInstance();
            case R.id.nav_launch_screens:
                return DummyFragment.newInstance();
            case R.id.nav_loading_images:
                return DummyFragment.newInstance();
            case R.id.nav_navigation:
                return DummyFragment.newInstance();
            case R.id.nav_navigation_drawer:
                return DummyFragment.newInstance();
            case R.id.nav_navigational_transitions:
                return DummyFragment.newInstance();
            case R.id.nav_notifications:
                return DummyFragment.newInstance();
            case R.id.nav_scrolling_techniques:
                return DummyFragment.newInstance();
            case R.id.nav_search:
                return DummyFragment.newInstance();
            case R.id.nav_selection:
                return DummyFragment.newInstance();
            case R.id.nav_settings:
                return DummyFragment.newInstance();
            case R.id.nav_swipe_to_refresh:
                return DummyFragment.newInstance();
            default:
                return null;
        }
    }
}
