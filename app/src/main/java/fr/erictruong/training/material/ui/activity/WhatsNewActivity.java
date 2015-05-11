package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.DummyFragment;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;
import fr.erictruong.training.material.ui.tile.NavigationDrawerGroup;
import fr.erictruong.training.material.ui.tile.Tile;

public class WhatsNewActivity extends MaterialTrainingActivity {

    private static final String TAG = WhatsNewActivity.class.getSimpleName();

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_WHATS_NEW_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_whats_new);
    }

    @Override
    protected int getDefaultSelectedNavigationDrawerChildId() {
        return NAVDRAWER_CHILD_WHATS_NEW_ID;
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_WHATS_NEW_ID:
                return new DummyFragment();
            default:
                return super.getSelectedFragment(id);
        }
    }

    @Override
    protected NavigationDrawerChild getPreviousNavigationDrawerItem(NavigationDrawerExpandableListAdapter adapter, int id) {
        switch (id) {
            case NAVDRAWER_CHILD_WHATS_NEW_ID:
                return adapter.getGroupById(NAVDRAWER_GROUP_RESOURCES_ID).getLastChild();
            default:
                return super.getPreviousNavigationDrawerItem(adapter, id);
        }
    }

    @Override
    protected NavigationDrawerChild getNextNavigationDrawerItem(NavigationDrawerExpandableListAdapter adapter, int id) {
        // No next item
        return null;
    }
}
