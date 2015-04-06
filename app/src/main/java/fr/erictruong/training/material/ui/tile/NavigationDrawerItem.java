package fr.erictruong.training.material.ui.tile;

import fr.erictruong.training.material.ui.listcontrol.ListControl;

public class NavigationDrawerItem extends NavigationDrawerGroup {

    public NavigationDrawerItem(int id, String text, ListControl primary, ListControl secondary) {
        super(id, text, primary, secondary);
    }

    @Override
    public boolean isItem() {
        return true;
    }
}
