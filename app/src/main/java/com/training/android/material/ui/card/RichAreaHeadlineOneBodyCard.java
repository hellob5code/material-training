package com.training.android.material.ui.card;

public class RichAreaHeadlineOneBodyCard extends HeadlineOneBodyCard {

    public static final int TYPE_RICH_AREA_HEADLINE_ONE_BODY = 5;

    protected int richAreaLayoutId;

    public RichAreaHeadlineOneBodyCard(int id, int viewType) {
        super(id, viewType);
    }

    public RichAreaHeadlineOneBodyCard(int id, int richAreaLayoutId, String headline, String body1) {
        super(id, TYPE_RICH_AREA_HEADLINE_ONE_BODY);
        this.richAreaLayoutId = richAreaLayoutId;
        this.headline = headline;
        this.body1 = body1;
    }

    protected RichAreaHeadlineOneBodyCard(int id, int viewType, int richAreaLayoutId, String headline, String body1) {
        super(id, viewType);
        this.richAreaLayoutId = richAreaLayoutId;
        this.headline = headline;
        this.body1 = body1;
    }

    public int getRichAreaLayoutId() {
        return richAreaLayoutId;
    }

    public String getHeadline() {
        return headline;
    }

    public String getBody1() {
        return body1;
    }
}

