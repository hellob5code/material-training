package fr.erictruong.training.material.ui.tile;

import fr.erictruong.training.material.ui.listcontrol.ListControl;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerGroup extends SingleLineListTile {

    List<NavigationDrawerChild> children = new ArrayList<>();

    public NavigationDrawerGroup(int id, String text, ListControl primary, ListControl secondary) {
        super(id, text, primary, secondary);
    }

    public boolean isItem() {
        return false;
    }

    public List<NavigationDrawerChild> getChildren() {
        return children;
    }

    private NavigationDrawerGroup addChild(NavigationDrawerChild child) {
        child.parentId = id;
        children.add(child);
        return this;
    }

    public NavigationDrawerGroup addChild(int id, String text) {
        return addChild(new NavigationDrawerChild(id, text));
    }
}
