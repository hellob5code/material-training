package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.*;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;
import fr.erictruong.training.material.ui.tile.NavigationDrawerGroup;
import fr.erictruong.training.material.ui.tile.Tile;

public class PatternsActivity extends MaterialTrainingActivity {

    private static final String TAG = PatternsActivity.class.getSimpleName();

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_PATTERNS_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_patterns);
    }

    @Override
    protected int getDefaultSelectedFragment() {
        return NAVDRAWER_CHILD_DATA_FORMATS_ID;
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_APP_STRUCTURE_ID:
                return new AppStructureFragment();
            case NAVDRAWER_CHILD_DATA_FORMATS_ID:
                return new DataFormatsFragment();
            case NAVDRAWER_CHILD_ERRORS_ID:
                return new ErrorsFragment();
            case NAVDRAWER_CHILD_GESTURES_ID:
                return new GesturesFragment();
            case NAVDRAWER_CHILD_LOADING_IMAGES_ID:
                return new LoadingImagesFragment();
            case NAVDRAWER_CHILD_NAVIGATION_DRAWER_ID:
                return new NavigationDrawerFragment();
            case NAVDRAWER_CHILD_NAVIGATIONAL_TRANSITIONS_ID:
                return new NavigationalTransitionsFragment();
            case NAVDRAWER_CHILD_SCROLLING_TECHNIQUES_ID:
                return new ScrollingTechniquesFragment();
            case NAVDRAWER_CHILD_SEARCH_ID:
                return new SearchFragment();
            case NAVDRAWER_CHILD_SELECTION_ID:
                return new SelectionFragment();
            case NAVDRAWER_CHILD_SETTINGS_ID:
                return new SettingsFragment();
            case NAVDRAWER_CHILD_SWIPE_TO_REFRESH_ID:
                return new SwipeToRefreshFragment();
            default:
                return null;
        }
    }

    @Override
    protected NavigationDrawerChild getPreviousNavigationDrawerItem(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_APP_STRUCTURE_ID:
                return new NavigationDrawerChild(NAVDRAWER_GROUP_COMPONENTS_ID, NAVDRAWER_CHILD_TOOLTIPS_ID, null);
            case NAVDRAWER_CHILD_DATA_FORMATS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_APP_STRUCTURE_ID, null);
            case NAVDRAWER_CHILD_ERRORS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_DATA_FORMATS_ID, null);
            case NAVDRAWER_CHILD_GESTURES_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_ERRORS_ID, null);
            case NAVDRAWER_CHILD_LOADING_IMAGES_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_GESTURES_ID, null);
            case NAVDRAWER_CHILD_NAVIGATION_DRAWER_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_LOADING_IMAGES_ID, null);
            case NAVDRAWER_CHILD_NAVIGATIONAL_TRANSITIONS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_NAVIGATION_DRAWER_ID, null);
            case NAVDRAWER_CHILD_SCROLLING_TECHNIQUES_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_NAVIGATIONAL_TRANSITIONS_ID, null);
            case NAVDRAWER_CHILD_SEARCH_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SCROLLING_TECHNIQUES_ID, null);
            case NAVDRAWER_CHILD_SELECTION_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SEARCH_ID, null);
            case NAVDRAWER_CHILD_SETTINGS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SELECTION_ID, null);
            case NAVDRAWER_CHILD_SWIPE_TO_REFRESH_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SETTINGS_ID, null);
            default:
                return null;
        }
    }

    @Override
    protected NavigationDrawerChild getNextNavigationDrawerItem(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_APP_STRUCTURE_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_DATA_FORMATS_ID, null);
            case NAVDRAWER_CHILD_DATA_FORMATS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_ERRORS_ID, null);
            case NAVDRAWER_CHILD_ERRORS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_GESTURES_ID, null);
            case NAVDRAWER_CHILD_GESTURES_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_LOADING_IMAGES_ID, null);
            case NAVDRAWER_CHILD_LOADING_IMAGES_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_NAVIGATION_DRAWER_ID, null);
            case NAVDRAWER_CHILD_NAVIGATION_DRAWER_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_NAVIGATIONAL_TRANSITIONS_ID, null);
            case NAVDRAWER_CHILD_NAVIGATIONAL_TRANSITIONS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SCROLLING_TECHNIQUES_ID, null);
            case NAVDRAWER_CHILD_SCROLLING_TECHNIQUES_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SEARCH_ID, null);
            case NAVDRAWER_CHILD_SEARCH_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SELECTION_ID, null);
            case NAVDRAWER_CHILD_SELECTION_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SETTINGS_ID, null);
            case NAVDRAWER_CHILD_SETTINGS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_SWIPE_TO_REFRESH_ID, null);
            case NAVDRAWER_CHILD_SWIPE_TO_REFRESH_ID:
                return new NavigationDrawerChild(NAVDRAWER_GROUP_USABILITY_ID, NAVDRAWER_CHILD_ACCESSIBILITY_ID, null);
            default:
                return null;
        }
    }
}
