package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.DummyFragment;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;
import fr.erictruong.training.material.ui.tile.NavigationDrawerGroup;
import fr.erictruong.training.material.ui.tile.Tile;

public class ResourcesActivity extends MaterialTrainingActivity {

    private static final String TAG = ResourcesActivity.class.getSimpleName();

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_RESOURCES_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_resources);
    }

    @Override
    protected int getDefaultSelectedFragment() {
        return NAVDRAWER_CHILD_COLOR_PALETTES_ID;
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_COLOR_PALETTES_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_LAYOUT_TEMPLATES_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_ROBOTO_AND_NOTO_FONTS_ID:
                return new DummyFragment();
            case NAVDRAWER_CHILD_STICKER_SHEETS_AND_ICONS_ID:
                return new DummyFragment();
            default:
                return null;
        }
    }

    @Override
    protected NavigationDrawerChild getPreviousNavigationDrawerItem(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_COLOR_PALETTES_ID:
                return new NavigationDrawerChild(NAVDRAWER_GROUP_USABILITY_ID, NAVDRAWER_CHILD_BIDIRECTIONALITY_ID, null);
            case NAVDRAWER_CHILD_LAYOUT_TEMPLATES_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_COLOR_PALETTES_ID, null);
            case NAVDRAWER_CHILD_ROBOTO_AND_NOTO_FONTS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_LAYOUT_TEMPLATES_ID, null);
            case NAVDRAWER_CHILD_STICKER_SHEETS_AND_ICONS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_ROBOTO_AND_NOTO_FONTS_ID, null);
            default:
                return null;
        }
    }

    @Override
    protected NavigationDrawerChild getNextNavigationDrawerItem(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_COLOR_PALETTES_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_LAYOUT_TEMPLATES_ID, null);
            case NAVDRAWER_CHILD_LAYOUT_TEMPLATES_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_ROBOTO_AND_NOTO_FONTS_ID, null);
            case NAVDRAWER_CHILD_ROBOTO_AND_NOTO_FONTS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_STICKER_SHEETS_AND_ICONS_ID, null);
            case NAVDRAWER_CHILD_STICKER_SHEETS_AND_ICONS_ID:
                return new NavigationDrawerChild(NAVDRAWER_GROUP_WHATS_NEW_ID, NAVDRAWER_CHILD_WHATS_NEW_ID, null);
            default:
                return null;
        }
    }
}
