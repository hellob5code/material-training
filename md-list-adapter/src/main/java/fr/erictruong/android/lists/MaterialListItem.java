package fr.erictruong.android.lists;

public class MaterialListItem {

    public static final long NO_ID = -1;

    private long id;
    private int viewType;

    public MaterialListItem(long id, int viewType) {
        this.id = id;
        this.viewType = viewType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    @Override
    public String toString() {
        return "MaterialListItem{" +
                "id=" + id +
                ", viewType=" + viewType +
                '}';
    }
}
