package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.AccessibilityCardFragment;
import fr.erictruong.training.material.ui.fragment.BidirectionalityCardFragment;

public class UsabilityActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = UsabilityActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setupContent(NAVDRAWER_CHILD_ACCESSIBILITY_ID);
        }
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_USABILITY_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_usability);
    }

    @Override
    protected Fragment getSelectedFragment(int navdrawerItemId) {
        switch (navdrawerItemId) {
            case NAVDRAWER_CHILD_ACCESSIBILITY_ID:
                return new AccessibilityCardFragment();
            case NAVDRAWER_CHILD_BIDIRECTIONALITY_ID:
                return new BidirectionalityCardFragment();
            default:
                return super.getSelectedFragment(navdrawerItemId);
        }
    }
}
