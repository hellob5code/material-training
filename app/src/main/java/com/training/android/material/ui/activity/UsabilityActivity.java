package com.training.android.material.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import com.training.android.material.R;
import com.training.android.material.ui.fragment.AccessibilityCardFragment;
import com.training.android.material.ui.fragment.BidirectionalityCardFragment;

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
