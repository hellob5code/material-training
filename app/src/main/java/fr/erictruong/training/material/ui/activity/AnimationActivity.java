package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.AuthenticMotionFragment;
import fr.erictruong.training.material.ui.fragment.DelightfulDetailsFragment;
import fr.erictruong.training.material.ui.fragment.MeaningfulTransitionsFragment;
import fr.erictruong.training.material.ui.fragment.ResponsiveInteractionFragment;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;

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
    protected int getDefaultSelectedNavigationDrawerChildId() {
        return NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID;
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID:
                return new AuthenticMotionFragment();
            case NAVDRAWER_CHILD_RESPONSIVE_INTERACTION_ID:
                return new ResponsiveInteractionFragment();
            case NAVDRAWER_CHILD_MEANINGFUL_TRANSITIONS_ID:
                return new MeaningfulTransitionsFragment();
            case NAVDRAWER_CHILD_DELIGHTFUL_DETAILS_ID:
                return new DelightfulDetailsFragment();
            default:
                return super.getSelectedFragment(id);
        }
    }

    @Override
    protected NavigationDrawerChild getPreviousNavigationDrawerItem(NavigationDrawerExpandableListAdapter adapter, int id) {
        switch (id) {
            case NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID:
                return adapter.getGroupById(NAVDRAWER_GROUP_WHAT_IS_MATERIAL_ID).getLastChild();
            default:
                return super.getPreviousNavigationDrawerItem(adapter, id);
        }
    }

    @Override
    protected NavigationDrawerChild getNextNavigationDrawerItem(NavigationDrawerExpandableListAdapter adapter, int id) {
        switch (id) {
            case NAVDRAWER_CHILD_DELIGHTFUL_DETAILS_ID:
                return adapter.getGroupById(NAVDRAWER_GROUP_STYLE_ID).getFirstChild();
            default:
                return super.getNextNavigationDrawerItem(adapter, id);
        }
    }
}
