package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.ColorFragment;
import fr.erictruong.training.material.ui.fragment.IconsFragment;
import fr.erictruong.training.material.ui.fragment.ImageryFragment;
import fr.erictruong.training.material.ui.fragment.TypographyFragment;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;
import fr.erictruong.training.material.ui.tile.NavigationDrawerGroup;
import fr.erictruong.training.material.ui.tile.Tile;

public class StyleActivity extends MaterialTrainingActivity {

    private static final String TAG = StyleActivity.class.getSimpleName();

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_STYLE_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_style);
    }

    @Override
    protected int getDefaultSelectedFragment() {
        return NAVDRAWER_CHILD_COLOR_ID;
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_COLOR_ID:
                return new ColorFragment();
            case NAVDRAWER_CHILD_ICONS_ID:
                return new IconsFragment();
            case NAVDRAWER_CHILD_IMAGERY_ID:
                return new ImageryFragment();
            case NAVDRAWER_CHILD_TYPOGRAPHY_ID:
                return new TypographyFragment();
            default:
                return super.getSelectedFragment(id);
        }
    }

    @Override
    protected NavigationDrawerChild getPreviousNavigationDrawerItem(NavigationDrawerExpandableListAdapter adapter, int id) {
        switch (id) {
            case NAVDRAWER_CHILD_COLOR_ID:
                return adapter.getGroupById(NAVDRAWER_GROUP_ANIMATION_ID).getLastChild();
            default:
                return super.getPreviousNavigationDrawerItem(adapter, id);
        }
    }

    @Override
    protected NavigationDrawerChild getNextNavigationDrawerItem(NavigationDrawerExpandableListAdapter adapter, int id) {
        switch (id) {
            case NAVDRAWER_CHILD_TYPOGRAPHY_ID:
                return adapter.getGroupById(NAVDRAWER_GROUP_LAYOUT_ID).getFirstChild();
            default:
                return super.getNextNavigationDrawerItem(adapter, id);
        }
    }
}
