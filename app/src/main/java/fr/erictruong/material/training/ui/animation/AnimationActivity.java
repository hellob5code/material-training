package fr.erictruong.material.training.ui.animation;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.BaseDrawerActivity;
import fr.erictruong.material.training.ui.core.fragment.DummyFragment;

public class AnimationActivity extends BaseDrawerActivity {

    /**
     * Start an {@link AnimationActivity} with extras.
     *
     * @param context The Android context.
     * @param id      (Extra) The navigation menu item ID of the desired content.
     */
    public static void start(Context context, int id) {
        Intent starter = new Intent(context, AnimationActivity.class);
        starter.putExtra(EXTRA_NAV_ID, id);
        context.startActivity(starter);
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case R.id.nav_authentic_motion:
                return DummyFragment.newInstance();
            case R.id.nav_responsive_interaction:
                return DummyFragment.newInstance();
            case R.id.nav_meaningful_transitions:
                return DummyFragment.newInstance();
            case R.id.nav_delightful_details:
                return DummyFragment.newInstance();
            default:
                return null;
        }
    }
}
