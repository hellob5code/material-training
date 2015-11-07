package fr.erictruong.android.lists;

public class MaterialListItem {

    public static final long NO_ID = -1;

    public final long id;
    public final int viewType;

    public MaterialListItem(long id, int viewType) {
        this.id = id;
        this.viewType = viewType;
    }
}
