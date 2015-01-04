package com.training.android.material.ui.tile;

import com.training.android.material.ui.listcontrol.ListControl;

public class SingleLineTile extends Tile {

    private String text;
    private ListControl primary, secondary;

    public SingleLineTile(int id, String text) {
        super(id);
        this.text = text;
    }

    public SingleLineTile(int id, String text, ListControl primary, ListControl secondary) {
        super(id);
        this.text = text;
        this.primary = primary;
        this.secondary = secondary;
    }

    public String getText() {
        return text;
    }

    public ListControl getPrimary() {
        return primary;
    }

    public ListControl getSecondary() {
        return secondary;
    }
}
