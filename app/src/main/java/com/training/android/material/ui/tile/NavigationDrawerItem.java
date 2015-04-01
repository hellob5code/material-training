package com.training.android.material.ui.tile;

import com.training.android.material.ui.listcontrol.ListControl;

public class NavigationDrawerItem extends NavigationDrawerGroup {

    public NavigationDrawerItem(int id, String text, ListControl primary, ListControl secondary) {
        super(id, text, primary, secondary);
    }

    @Override
    public boolean isItem() {
        return true;
    }
}
