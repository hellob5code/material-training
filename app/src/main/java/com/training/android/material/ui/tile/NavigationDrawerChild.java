package com.training.android.material.ui.tile;

public class NavigationDrawerChild extends SingleLineListTile {

    int parentId = -1;

    public NavigationDrawerChild(int id, String text) {
        super(id, text);
    }

    public NavigationDrawerChild(int parentId, int id, String text) {
        super(id, text);
        this.parentId = parentId;
    }

    public int getParentId() {
        return parentId;
    }
}
