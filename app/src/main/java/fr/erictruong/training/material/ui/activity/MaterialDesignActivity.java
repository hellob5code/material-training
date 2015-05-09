package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.IntroductionFragment;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;
import fr.erictruong.training.material.ui.tile.NavigationDrawerGroup;
import fr.erictruong.training.material.ui.tile.Tile;

public class MaterialDesignActivity extends MaterialTrainingActivity {

    private static final String TAG = MaterialDesignActivity.class.getSimpleName();

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_MATERIAL_DESIGN_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_material_design);
    }

    @Override
    protected int getDefaultSelectedFragment() {
        return NAVDRAWER_CHILD_INTRODUCTION_ID;
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_INTRODUCTION_ID:
                return new IntroductionFragment();
            default:
                return null;
        }
    }

    @Override
    protected NavigationDrawerChild getPreviousNavigationDrawerItem(int id) {
        // Do nothing
        return null;
    }

    @Override
    protected NavigationDrawerChild getNextNavigationDrawerItem(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_INTRODUCTION_ID:
                return new NavigationDrawerChild(NAVDRAWER_GROUP_WHAT_IS_MATERIAL_ID, NAVDRAWER_CHILD_ENVIRONMENT_ID, null);
            default:
                return null;
        }
    }
}
