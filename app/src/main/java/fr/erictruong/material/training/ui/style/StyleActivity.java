package fr.erictruong.material.training.ui.style;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.BaseDrawerActivity;
import fr.erictruong.material.training.ui.core.DummyFragment;

public class StyleActivity extends BaseDrawerActivity {

    /**
     * Start an {@link StyleActivity} with extras.
     *
     * @param context The Android context.
     * @param id      (Extra) The navigation menu item ID of the desired content.
     */
    public static void start(Context context, int id) {
        Intent starter = new Intent(context, StyleActivity.class);
        starter.putExtra(EXTRA_NAV_ID, id);
        context.startActivity(starter);
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case R.id.nav_color:
                return DummyFragment.newInstance();
            case R.id.nav_icons:
                return DummyFragment.newInstance();
            case R.id.nav_imagery:
                return DummyFragment.newInstance();
            case R.id.nav_typography:
                return DummyFragment.newInstance();
            case R.id.nav_writing:
                return DummyFragment.newInstance();
            default:
                Log.d("StyleActivity", "Unknown ID: " + id);
                return null;
        }
    }
}
