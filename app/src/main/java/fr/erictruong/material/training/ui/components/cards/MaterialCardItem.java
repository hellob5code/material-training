package fr.erictruong.material.training.ui.components.cards;

public class MaterialCardItem {

    public static final long NO_ID = -1;

    public final long id;
    public final int viewType;

    public MaterialCardItem(long id, int viewType) {
        this.id = id;
        this.viewType = viewType;
    }
}
