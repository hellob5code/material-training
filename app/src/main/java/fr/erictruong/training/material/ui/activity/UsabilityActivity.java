package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.AccessibilityFragment;
import fr.erictruong.training.material.ui.fragment.BidirectionalityFragment;

public class UsabilityActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = UsabilityActivity.class.getSimpleName();

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_USABILITY_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_usability);
    }

    @Override
    protected int getDefaultSelectedFragment() {
        return NAVDRAWER_CHILD_ACCESSIBILITY_ID;
    }

    @Override
    protected Fragment getSelectedFragment(int navdrawerItemId) {
        switch (navdrawerItemId) {
            case NAVDRAWER_CHILD_ACCESSIBILITY_ID:
                return new AccessibilityFragment();
            case NAVDRAWER_CHILD_BIDIRECTIONALITY_ID:
                return new BidirectionalityFragment();
            default:
                return null;
        }
    }
}
