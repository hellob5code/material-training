package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import fr.erictruong.training.material.persistence.preference.AppPrefs;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;

/**
 * Launcher Activity used to forward to the default screen or the last visited screen.
 */
public class MainActivity extends MaterialTrainingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startLastVisitedActivity();
    }

    private void startLastVisitedActivity() {
        onNavigationDrawerItemClicked(new NavigationDrawerChild(AppPrefs.getLastVisitedGroupId(this), AppPrefs.getLastVisitedChildId(this), null));
    }

    @Override
    protected int getDefaultSelectedFragment() {
        return NAVDRAWER_NO_ID;
    }

    @Override
    protected Fragment getSelectedFragment(int navdrawerItemId) {
        return null;
    }

    @Override
    protected NavigationDrawerChild getPreviousNavigationDrawerItem() {
        // Do nothing
        return null;
    }

    @Override
    protected NavigationDrawerChild getNextNavigationDrawerItem() {
        // Do nothing
        return null;
    }
}
