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
    protected int getDefaultSelectedNavigationDrawerChildId() {
        return NAVDRAWER_CHILD_ACCESSIBILITY_ID;
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_ACCESSIBILITY_ID:
                return new AccessibilityFragment();
            case NAVDRAWER_CHILD_BIDIRECTIONALITY_ID:
                return new BidirectionalityFragment();
            default:
                return super.getSelectedFragment(id);
        }
    }

    @Override
    protected NavigationDrawerChild getPreviousNavigationDrawerItem(NavigationDrawerExpandableListAdapter adapter, int id) {
        switch (id) {
            case NAVDRAWER_CHILD_ACCESSIBILITY_ID:
                return adapter.getGroupById(NAVDRAWER_GROUP_PATTERNS_ID).getLastChild();
            default:
                return super.getPreviousNavigationDrawerItem(adapter, id);
        }
    }

    @Override
    protected NavigationDrawerChild getNextNavigationDrawerItem(NavigationDrawerExpandableListAdapter adapter, int id) {
        switch (id) {
            case NAVDRAWER_CHILD_BIDIRECTIONALITY_ID:
                return adapter.getGroupById(NAVDRAWER_GROUP_RESOURCES_ID).getFirstChild();
            default:
                return super.getNextNavigationDrawerItem(adapter, id);
        }
    }
}
