package fr.erictruong.material.training.ui.material_design;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.BaseDrawerActivity;
import fr.erictruong.material.training.ui.material_design.introduction.IntroductionFragment;

public class MaterialDesignActivity extends BaseDrawerActivity {

    /**
     * Start an {@link MaterialDesignActivity} with extras.
     *
     * @param context The Android context.
     * @param id      (Extra) The navigation menu item ID of the desired content.
     */
    public static void start(Context context, int id) {
        Intent starter = new Intent(context, MaterialDesignActivity.class);
        starter.putExtra(EXTRA_NAV_ID, id);
        context.startActivity(starter);
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case R.id.nav_introduction:
                return IntroductionFragment.newInstance();
            default:
                return null;
        }
    }
}
