package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.*;

public class PatternsActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = PatternsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setupContent(NAVDRAWER_CHILD_DATA_FORMATS_ID);
        }
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_PATTERNS_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_patterns);
    }

    @Override
    protected Fragment getSelectedFragment(int navdrawerItemId) {
        switch (navdrawerItemId) {
            case NAVDRAWER_CHILD_DATA_FORMATS_ID:
                return new DataFormatsCardFragment();
            case NAVDRAWER_CHILD_ERRORS_ID:
                return new ErrorsCardFragment();
            case NAVDRAWER_CHILD_GESTURES_ID:
                return new GesturesCardFragment();
            case NAVDRAWER_CHILD_LOADING_IMAGES_ID:
                return new LoadingImagesCardFragment();
            case NAVDRAWER_CHILD_NAVIGATION_DRAWER_ID:
                return new NavigationDrawerCardFragment();
            case NAVDRAWER_CHILD_NAVIGATIONAL_TRANSITIONS_ID:
                return new NavigationalTransitionsCardFragment();
            case NAVDRAWER_CHILD_SCROLLING_TECHNIQUES_ID:
                return new ScrollingTechniquesCardFragment();
            case NAVDRAWER_CHILD_SEARCH_ID:
                return new SearchCardFragment();
            case NAVDRAWER_CHILD_SELECTION_ID:
                return new SelectionCardFragment();
            case NAVDRAWER_CHILD_SETTINGS_ID:
                return new SettingsCardFragment();
            case NAVDRAWER_CHILD_SWIPE_TO_REFRESH_ID:
                return new SwipeToRefreshCardFragment();
            default:
                return super.getSelectedFragment(navdrawerItemId);
        }
    }
}
