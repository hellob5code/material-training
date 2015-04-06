package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.DummyFragment;

public class WhatsNewActivity extends MaterialTrainingNavigationDrawerActivity {

    private static final String TAG = WhatsNewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setUpContent(NAVDRAWER_CHILD_WHATS_NEW_ID);
        }
    }

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_WHATS_NEW_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_whats_new);
    }

    @Override
    protected Fragment getSelectedFragment(int navdrawerItemId) {
        switch (navdrawerItemId) {
            case NAVDRAWER_CHILD_WHATS_NEW_ID:
                return new DummyFragment();
            default:
                return super.getSelectedFragment(navdrawerItemId);
        }
    }
}
