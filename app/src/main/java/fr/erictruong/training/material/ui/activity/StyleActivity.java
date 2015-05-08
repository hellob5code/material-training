package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.ColorFragment;
import fr.erictruong.training.material.ui.fragment.IconsFragment;
import fr.erictruong.training.material.ui.fragment.ImageryFragment;
import fr.erictruong.training.material.ui.fragment.TypographyFragment;

public class StyleActivity extends MaterialTrainingActivity {

    private static final String TAG = StyleActivity.class.getSimpleName();

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_STYLE_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_style);
    }

    @Override
    protected int getDefaultSelectedFragment() {
        return NAVDRAWER_CHILD_COLOR_ID;
    }

    @Override
    protected Fragment getSelectedFragment(int navdrawerItemId) {
        switch (navdrawerItemId) {
            case NAVDRAWER_CHILD_COLOR_ID:
                return new ColorFragment();
            case NAVDRAWER_CHILD_ICONS_ID:
                return new IconsFragment();
            case NAVDRAWER_CHILD_IMAGERY_ID:
                return new ImageryFragment();
            case NAVDRAWER_CHILD_TYPOGRAPHY_ID:
                return new TypographyFragment();
            default:
                return null;
        }
    }
}
