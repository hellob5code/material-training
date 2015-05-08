package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.AccessibilityFragment;
import fr.erictruong.training.material.ui.fragment.BidirectionalityFragment;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;
import fr.erictruong.training.material.ui.tile.NavigationDrawerGroup;
import fr.erictruong.training.material.ui.tile.Tile;

public class UsabilityActivity extends MaterialTrainingActivity {

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

    @Override
    protected NavigationDrawerChild getPreviousNavigationDrawerItem() {
        switch (getSelectedNavigationDrawerItemId()) {
            case NAVDRAWER_CHILD_ACCESSIBILITY_ID:
                return new NavigationDrawerChild(NAVDRAWER_GROUP_PATTERNS_ID, NAVDRAWER_CHILD_SWIPE_TO_REFRESH_ID, null);
            case NAVDRAWER_CHILD_BIDIRECTIONALITY_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_ACCESSIBILITY_ID, null);
            default:
                return null;
        }
    }

    @Override
    protected NavigationDrawerChild getNextNavigationDrawerItem() {
        switch (getSelectedNavigationDrawerItemId()) {
            case NAVDRAWER_CHILD_ACCESSIBILITY_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_BIDIRECTIONALITY_ID, null);
            case NAVDRAWER_CHILD_BIDIRECTIONALITY_ID:
                return new NavigationDrawerChild(NAVDRAWER_GROUP_RESOURCES_ID, NAVDRAWER_CHILD_COLOR_PALETTES_ID, null);
            default:
                return null;
        }
    }
}
