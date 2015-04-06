package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.MetricsAndKeylinesCardFragment;
import fr.erictruong.training.material.ui.fragment.PrinciplesCardFragment;
import fr.erictruong.training.material.ui.fragment.StructureCardFragment;

public class LayoutActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = LayoutActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setUpContent(NAVDRAWER_CHILD_PRINCIPLES_ID);
        }
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_LAYOUT_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_layout);
    }

    @Override
    protected Fragment getSelectedFragment(int navdrawerItemId) {
        switch (navdrawerItemId) {
            case NAVDRAWER_CHILD_PRINCIPLES_ID:
                return new PrinciplesCardFragment();
            case NAVDRAWER_CHILD_METRICS_AND_KEYLINES_ID:
                return new MetricsAndKeylinesCardFragment();
            case NAVDRAWER_CHILD_STRUCTURE_ID:
                return new StructureCardFragment();
            default:
                return super.getSelectedFragment(navdrawerItemId);
        }
    }
}
