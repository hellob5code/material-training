package fr.erictruong.material.training.ui.usability;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.BaseDrawerActivity;
import fr.erictruong.material.training.ui.core.fragment.DummyFragment;

public class UsabilityActivity extends BaseDrawerActivity {

    /**
     * Start an {@link UsabilityActivity} with extras.
     *
     * @param context The Android context.
     * @param id      (Extra) The navigation menu item ID of the desired content.
     */
    public static void start(Context context, int id) {
        Intent starter = new Intent(context, UsabilityActivity.class);
        starter.putExtra(EXTRA_NAV_ID, id);
        context.startActivity(starter);
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case R.id.nav_accessibility:
                return DummyFragment.newInstance();
            case R.id.nav_bidirectionality:
                return DummyFragment.newInstance();
            default:
                return null;
        }
    }
}
