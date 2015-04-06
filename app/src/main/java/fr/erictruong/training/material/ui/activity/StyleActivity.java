package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.ColorCardFragment;
import fr.erictruong.training.material.ui.fragment.IconsCardFragment;
import fr.erictruong.training.material.ui.fragment.ImageryCardFragment;
import fr.erictruong.training.material.ui.fragment.TypographyCardFragment;

public class StyleActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = StyleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setUpContent(NAVDRAWER_CHILD_COLOR_ID);
        }
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_STYLE_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_style);
    }

    @Override
    protected Fragment getSelectedFragment(int navdrawerItemId) {
        switch (navdrawerItemId) {
            case NAVDRAWER_CHILD_COLOR_ID:
                return new ColorCardFragment();
            case NAVDRAWER_CHILD_ICONS_ID:
                return new IconsCardFragment();
            case NAVDRAWER_CHILD_IMAGERY_ID:
                return new ImageryCardFragment();
            case NAVDRAWER_CHILD_TYPOGRAPHY_ID:
                return new TypographyCardFragment();
            default:
                return super.getSelectedFragment(navdrawerItemId);
        }
    }
}
