package fr.erictruong.android.lists.item;

import android.support.v7.widget.helper.ItemTouchHelper;

import fr.erictruong.android.lists.OnActionListener;

public class ReorderableItem extends TextItem implements Reorderable {

    private ItemTouchHelper itemTouchHelper;

    private ReorderableItem(Builder builder) {
        super(builder.id, builder.viewType, builder.text1, builder.text2, builder.text3, builder.action);
        this.itemTouchHelper = builder.itemTouchHelper;
    }

    protected ReorderableItem(long id, int viewType, ItemTouchHelper itemTouchHelper, CharSequence text1, CharSequence text2, CharSequence text3, OnActionListener action) {
        super(id, viewType, text1, text2, text3, action);
        this.itemTouchHelper = itemTouchHelper;
    }

    @Override
    public ItemTouchHelper getItemTouchHelper() {
        return itemTouchHelper;
    }

    @Override
    public void setItemTouchHelper(ItemTouchHelper helper) {
        this.itemTouchHelper = helper;
    }

    @Override
    public String toString() {
        return "ReorderableItem{" +
                "id=" + getId() +
                ", viewType=" + getViewType() +
                '}';
    }

    public static final class Builder {

        private long id;
        private int viewType;
        private ItemTouchHelper itemTouchHelper;
        private CharSequence text1;
        private CharSequence text2;
        private CharSequence text3;
        private OnActionListener action;

        public Builder() {
            this.id = NO_ID;
//            this.viewType = MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder viewType(int viewType) {
            this.viewType = viewType;
            return this;
        }

        public Builder itemTouchHelper(ItemTouchHelper itemTouchHelper) {
            this.itemTouchHelper = itemTouchHelper;
            return this;
        }

        public Builder text1(CharSequence text1) {
            this.text1 = text1;
            return this;
        }

        public Builder text2(CharSequence text2) {
            this.text2 = text2;
            return this;
        }

        public Builder text3(CharSequence text3) {
            this.text3 = text3;
            return this;
        }

        public Builder action(OnActionListener action) {
            this.action = action;
            return this;
        }

        public ReorderableItem build() {
            return new ReorderableItem(this);
        }
    }
}
