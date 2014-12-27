package com.training.android.materiel.ui.row;

public abstract class ListRow {

    protected int id;

    protected ListRow(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
