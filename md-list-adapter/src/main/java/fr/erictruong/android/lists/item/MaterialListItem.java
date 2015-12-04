package fr.erictruong.android.lists.item;

import fr.erictruong.android.lists.OnActionListener;

public class MaterialListItem {

    public static final long NO_ID = -1;

    private long id;
    private int viewType;
    private OnActionListener action;

    public MaterialListItem(long id, int viewType, OnActionListener action) {
        this.id = id;
        this.viewType = viewType;
        this.action = action;
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

    public OnActionListener getAction() {
        return action;
    }

    public void setAction(OnActionListener action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "MaterialListItem{" +
                "id=" + id +
                ", viewType=" + viewType +
                '}';
    }
}
