package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.IntroductionFragment;

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
    protected Fragment getSelectedFragment(int navdrawerItemId) {
        switch (navdrawerItemId) {
            case NAVDRAWER_CHILD_INTRODUCTION_ID:
                return new IntroductionFragment();
            default:
                return null;
        }
    }
}
