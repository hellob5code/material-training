package com.training.android.material.ui.row;

import com.training.android.material.ui.listcontrol.ListControl;

public class SingleLineListRow extends ListRow {

    private String text;
    private ListControl primary, secondary;

    public SingleLineListRow(int id, String text) {
        super(id);
        this.text = text;
    }

    public SingleLineListRow(int id, String text, ListControl primary, ListControl secondary) {
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
