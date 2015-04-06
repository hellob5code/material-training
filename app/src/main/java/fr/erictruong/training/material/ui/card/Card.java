package fr.erictruong.training.material.ui.card;

public abstract class Card {

    public static final int TYPE_SUBHEADER = 1;
    public static final int TYPE_HEADLINE_BODY_1 = 2;
    public static final int TYPE_HEADLINE_BODY_1_SIX_VERTICAL_BUTTON = 3;
    public static final int TYPE_HEADLINE_BODY_1_THREE_BUTTON = 4;
    public static final int TYPE_PRIMARY_HEADLINE_BODY_2 = 5;
    public static final int TYPE_ACCENT_HEADLINE_BODY_2 = 6;
    public static final int TYPE_RICH_AREA_HEADLINE_BODY_1 = 7;
    public static final int TYPE_RICH_IMAGE_HEADLINE_BODY_1 = 8;
    public static final int TYPE_HEADLINE_RICH_HORIZONTAL_RECYCLER_VIEW_BODY_1 = 9;
    public static final int TYPE_HEADLINE_RICH_IMAGE_BODY_1 = 10;

    protected int id;
    protected int viewType;

    public Card(int id, int viewType) {
        this.id = id;
        this.viewType = viewType;
    }

    public int getId() {
        return id;
    }

    public int getViewType() {
        return viewType;
    }

    public interface CardHolder {

        void bindView(Card card, int position);
    }
}