package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.DummyFragment;

public class ResourcesActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = ResourcesActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setUpContent(NAVDRAWER_CHILD_COLOR_PALETTES_ID);
        }
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_RESOURCES_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_resources);
    }

    @Override
    protected Fragment getSelectedFragment(int navdrawerItemId) {
        switch (navdrawerItemId) {
            case NAVDRAWER_CHILD_COLOR_PALETTES_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_LAYOUT_TEMPLATES_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_ROBOTO_AND_NOTO_FONTS_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_STICKER_SHEETS_AND_ICONS_ID:
                return new DummyFragment();
            default:
                return super.getSelectedFragment(navdrawerItemId);
        }
    }
}
