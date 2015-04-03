package com.training.android.material.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import com.training.android.material.R;
import com.training.android.material.ui.fragment.ColorCardFragment;
import com.training.android.material.ui.fragment.IconsCardFragment;
import com.training.android.material.ui.fragment.ImageryCardFragment;
import com.training.android.material.ui.fragment.TypographyCardFragment;

public class StyleActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = StyleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setupContent(NAVDRAWER_CHILD_COLOR_ID);
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
