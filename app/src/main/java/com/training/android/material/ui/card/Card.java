package com.training.android.material.ui.card;

public class Card {

    public static final int TYPE_NONE = 0;

    protected int id;
    protected int viewType;

    protected Card(int id, int viewType) {
        this.id = id;
        this.viewType = viewType;
    }

    public int getId() {
        return id;
    }

    public int getViewType() {
        return viewType;
    }
}