package fr.erictruong.training.material.ui.activity;

import android.os.Bundle;
import fr.erictruong.training.material.persistence.preference.AppPrefs;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;

/**
 * Launcher Activity used to forward to the default screen or the last visited screen.
 */
public class MainActivity extends MaterialTrainingNavigationDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startLastVisitedActivity();
    }

    private void startLastVisitedActivity() {
        NavigationDrawerChild item = new NavigationDrawerChild(AppPrefs.getLastVisitedGroupId(this), AppPrefs.getLastVisitedChildId(this), null);
        goToNavigationDrawerItem(item);
    }
}
