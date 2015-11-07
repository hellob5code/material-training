package fr.erictruong.android.lists;

import android.support.annotation.DrawableRes;

public class IconItem extends TextItem {

    public final int icon;

    private IconItem(Builder builder) {
        super(builder.id, builder.viewType, builder.text1, builder.text2, builder.text3, builder.action);
        this.icon = builder.icon;
    }

    protected IconItem(long id, int viewType, int icon, CharSequence text1, CharSequence text2, CharSequence text3, OnActionListener action) {
        super(id, viewType, text1, text2, text3, action);
        this.icon = icon;
    }

    public static final class Builder {

        private long id;
        private int viewType;
        private int icon;
        private CharSequence text1;
        private CharSequence text2;
        private CharSequence text3;
        private OnActionListener action;

        public Builder() {
            this.id = NO_ID;
            this.viewType = MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder viewType(@MaterialListAdapter.IconViewType int viewType) {
            this.viewType = viewType;
            return this;
        }

        public Builder icon(@DrawableRes int icon) {
            this.icon = icon;
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

        public IconItem build() {
            return new IconItem(this);
        }
    }
}
