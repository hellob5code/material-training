package com.training.android.material.ui.card;

public class HeadlineOneBodyCard extends Card {

    public static final int TYPE_HEADLINE_ONE_BODY = 3;

    protected String headline, body1;

    public HeadlineOneBodyCard(int id, int viewType) {
        super(id, viewType);
    }

    public HeadlineOneBodyCard(int id, String headline, String body1) {
        super(id, TYPE_HEADLINE_ONE_BODY);
        this.headline = headline;
        this.body1 = body1;
    }

    protected HeadlineOneBodyCard(int id, int viewType, String headline, String body1) {
        super(id, viewType);
        this.headline = headline;
        this.body1 = body1;
    }

    public String getHeadline() {
        return headline;
    }

    public String getBody1() {
        return body1;
    }
}

