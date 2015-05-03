package fr.erictruong.training.material.ui.card;

public abstract class Card {

    public static final int TYPE_SUBHEADER                                     =  1;
    public static final int TYPE_DISPLAY_1_BODY_1                              =  2;
    public static final int TYPE_DISPLAY_1_BODY_2                              =  3;
    public static final int TYPE_HEADLINE_BODY_1                               =  4;
    public static final int TYPE_HEADLINE_BODY_2                               =  5;
    public static final int TYPE_HEADLINE_BODY_1_SIX_VERTICAL_BUTTON           =  6;
    public static final int TYPE_HEADLINE_BODY_1_THREE_BUTTON                  =  7;
    public static final int TYPE_PRIMARY_DISPLAY_1_BODY_1                      =  8;
    public static final int TYPE_PRIMARY_DISPLAY_1_BODY_2                      =  9;
    public static final int TYPE_PRIMARY_HEADLINE_BODY_1                       = 10;
    public static final int TYPE_PRIMARY_HEADLINE_BODY_2                       = 11;
    public static final int TYPE_ACCENT_HEADLINE_BODY_2                        = 12;
    public static final int TYPE_RICH_AREA_HEADLINE_BODY_1                     = 13;
    public static final int TYPE_RICH_IMAGE_HEADLINE_BODY_1                    = 14;
    public static final int TYPE_HEADLINE_RICH_HORIZONTAL_RECYCLER_VIEW_BODY_1 = 15;
    public static final int TYPE_HEADLINE_RICH_IMAGE_BODY_1                    = 16;

    protected long id;
    protected int viewType;

    public Card(long id, int viewType) {
        this.id = id;
        this.viewType = viewType;
    }

    public long getId() {
        return id;
    }

    public int getViewType() {
        return viewType;
    }

    public interface CardHolder {

        void bindView(Card card, int position);
    }
}