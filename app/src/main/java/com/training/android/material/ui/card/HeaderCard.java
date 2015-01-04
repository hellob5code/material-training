package com.training.android.material.ui.card;

public class HeaderCard extends Card {

    public static final int TYPE_HEADER = 1;

    private String text;

    public HeaderCard(int id, String text) {
        super(id, TYPE_HEADER);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
