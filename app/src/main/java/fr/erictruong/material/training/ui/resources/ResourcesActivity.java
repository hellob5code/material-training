package fr.erictruong.material.training.ui.resources;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.BaseDrawerActivity;
import fr.erictruong.material.training.ui.core.DummyFragment;

public class ResourcesActivity extends BaseDrawerActivity {

    /**
     * Start an {@link ResourcesActivity} with extras.
     *
     * @param context The Android context.
     * @param id      (Extra) The navigation menu item ID of the desired content.
     */
    public static void start(Context context, int id) {
        Intent starter = new Intent(context, ResourcesActivity.class);
        starter.putExtra(EXTRA_NAV_ID, id);
        context.startActivity(starter);
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case R.id.nav_color_palettes:
                return DummyFragment.newInstance();
            case R.id.nav_devices:
                return DummyFragment.newInstance();
            case R.id.nav_layout_templates:
                return DummyFragment.newInstance();
            case R.id.nav_roboto_and_noto_fonts:
                return DummyFragment.newInstance();
            case R.id.nav_sticker_sheets_and_icons:
                return DummyFragment.newInstance();
            default:
                return null;
        }
    }
}
