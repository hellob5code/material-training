package com.training.android.material.ui.tile;

import android.content.Context;

public abstract class Tile {

    public static final int TYPE_SUBHEADER = 1;
    public static final int TYPE_LIST_SINGLE_LINE = 2;
    public static final int TYPE_LIST_TWO_LINE = 3;
    public static final int TYPE_LIST_THREE_LINE = 4;

    protected int id;
    protected int viewType;

    protected Tile(int id, int viewType) {
        this.id = id;
        this.viewType = viewType;
    }

    public int getId() {
        return id;
    }

    public int getViewType() {
        return viewType;
    }

    public interface TileHolder {

        public void createView(Context context, boolean startIndented, boolean endIndented);

        public void bindView(Tile tile, int position);
    }
}
