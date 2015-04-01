package com.training.android.material.ui.activity;

import android.os.Bundle;
import com.training.android.material.persistence.preference.AppPrefs;
import com.training.android.material.ui.tile.NavigationDrawerChild;

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
