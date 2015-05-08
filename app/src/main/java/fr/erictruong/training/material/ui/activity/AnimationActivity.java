package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.AuthenticMotionFragment;
import fr.erictruong.training.material.ui.fragment.DelightfulDetailsFragment;
import fr.erictruong.training.material.ui.fragment.MeaningfulTransitionsFragment;
import fr.erictruong.training.material.ui.fragment.ResponsiveInteractionFragment;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;
import fr.erictruong.training.material.ui.tile.NavigationDrawerGroup;
import fr.erictruong.training.material.ui.tile.Tile;

public class AnimationActivity extends MaterialTrainingActivity {

    private static final String TAG = AnimationActivity.class.getSimpleName();

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_ANIMATION_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_animation);
    }

    @Override
    protected int getDefaultSelectedFragment() {
        return NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID;
    }

    @Override
    protected Fragment getSelectedFragment(int navdrawerItemId) {
        switch (navdrawerItemId) {
            case NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID:
                return new AuthenticMotionFragment();
            case NAVDRAWER_CHILD_RESPONSIVE_INTERACTION_ID:
                return new ResponsiveInteractionFragment();
            case NAVDRAWER_CHILD_MEANINGFUL_TRANSITIONS_ID:
                return new MeaningfulTransitionsFragment();
            case NAVDRAWER_CHILD_DELIGHTFUL_DETAILS_ID:
                return new DelightfulDetailsFragment();
            default:
                return null;
        }
    }

    @Override
    protected NavigationDrawerChild getPreviousNavigationDrawerItem() {
        switch (getSelectedNavigationDrawerItemId()) {
            case NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID:
                return new NavigationDrawerChild(NAVDRAWER_GROUP_WHAT_IS_MATERIAL_ID, NAVDRAWER_CHILD_OBJECTS_IN_3D_SPACE_ID, null);
            case NAVDRAWER_CHILD_RESPONSIVE_INTERACTION_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID, null);
            case NAVDRAWER_CHILD_MEANINGFUL_TRANSITIONS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_RESPONSIVE_INTERACTION_ID, null);
            case NAVDRAWER_CHILD_DELIGHTFUL_DETAILS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_MEANINGFUL_TRANSITIONS_ID, null);
            default:
                return null;
        }
    }

    @Override
    protected NavigationDrawerChild getNextNavigationDrawerItem() {
        switch (getSelectedNavigationDrawerItemId()) {
            case NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_RESPONSIVE_INTERACTION_ID, null);
            case NAVDRAWER_CHILD_RESPONSIVE_INTERACTION_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_MEANINGFUL_TRANSITIONS_ID, null);
            case NAVDRAWER_CHILD_MEANINGFUL_TRANSITIONS_ID:
                return new NavigationDrawerChild(getSelectedNavigationDrawerGroupId(), NAVDRAWER_CHILD_DELIGHTFUL_DETAILS_ID, null);
            case NAVDRAWER_CHILD_DELIGHTFUL_DETAILS_ID:
                return new NavigationDrawerChild(NAVDRAWER_GROUP_STYLE_ID, NAVDRAWER_CHILD_COLOR_ID, null);
            default:
                return null;
        }
    }
}
