package com.training.android.material.ui.row;

public abstract class ListRow {

    protected int id;

    protected ListRow(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
