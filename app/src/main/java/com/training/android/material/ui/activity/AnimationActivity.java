package com.training.android.material.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import com.training.android.material.R;
import com.training.android.material.ui.fragment.AuthenticMotionCardFragment;
import com.training.android.material.ui.fragment.DelightfulDetailsCardFragment;
import com.training.android.material.ui.fragment.MeaningfulTransitionsCardFragment;
import com.training.android.material.ui.fragment.ResponsiveInteractionCardFragment;

public class AnimationActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = AnimationActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setupContent(NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID);
        }
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_ANIMATION_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_animation);
    }

    @Override
    protected Fragment getSelectedFragment(int navdrawerItemId) {
        switch (navdrawerItemId) {
            case NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID:
                return new AuthenticMotionCardFragment();
            case NAVDRAWER_CHILD_RESPONSIVE_INTERACTION_ID:
                return new ResponsiveInteractionCardFragment();
            case NAVDRAWER_CHILD_MEANINGFUL_TRANSITIONS_ID:
                return new MeaningfulTransitionsCardFragment();
            case NAVDRAWER_CHILD_DELIGHTFUL_DETAILS_ID:
                return new DelightfulDetailsCardFragment();
            default:
                return super.getSelectedFragment(navdrawerItemId);
        }
    }
}
