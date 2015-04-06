package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.AuthenticMotionCardFragment;
import fr.erictruong.training.material.ui.fragment.DelightfulDetailsCardFragment;
import fr.erictruong.training.material.ui.fragment.MeaningfulTransitionsCardFragment;
import fr.erictruong.training.material.ui.fragment.ResponsiveInteractionCardFragment;

public class AnimationActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = AnimationActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setUpContent(NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID);
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
