package com.training.android.material.ui.tile;

public abstract class Tile {

    protected int id;

    protected Tile(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
