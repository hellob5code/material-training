package com.training.android.material.ui.card;

public abstract class Card {

    public static final int TYPE_HEADER = 1;
    public static final int TYPE_HEADLINE_BODY_1 = 2;
    public static final int TYPE_HEADLINE_BODY_1_SIX_VERTICAL_BUTTON = 3;
    public static final int TYPE_HEADLINE_BODY_1_THREE_BUTTON = 4;
    public static final int TYPE_PRIMARY_HEADLINE_BODY_2 = 5;
    public static final int TYPE_ACCENT_HEADLINE_BODY_2 = 6;
    public static final int TYPE_RICH_AREA_HEADLINE_BODY_1 = 7;

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