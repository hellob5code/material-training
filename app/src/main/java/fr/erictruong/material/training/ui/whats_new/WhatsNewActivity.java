package fr.erictruong.material.training.ui.whats_new;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.BaseDrawerActivity;
import fr.erictruong.material.training.ui.core.DummyFragment;

public class WhatsNewActivity extends BaseDrawerActivity {

    /**
     * Start an {@link WhatsNewActivity} with extras.
     *
     * @param context The Android context.
     * @param id      (Extra) The navigation menu item ID of the desired content.
     */
    public static void start(Context context, int id) {
        Intent starter = new Intent(context, WhatsNewActivity.class);
        starter.putExtra(EXTRA_NAV_ID, id);
        context.startActivity(starter);
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case R.id.group_whats_new:
                return DummyFragment.newInstance();
            default:
                Log.d("WhatsNewActivity", "Unknown ID: " + id);
                return null;
        }
    }
}
