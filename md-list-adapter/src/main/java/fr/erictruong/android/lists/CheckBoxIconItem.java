package fr.erictruong.android.lists;

import android.support.annotation.DrawableRes;

public class CheckBoxIconItem extends IconItem {

    public final boolean isChecked;
    public final OnCheckActionListener actionPrimary;

    private CheckBoxIconItem(Builder builder) {
        super(builder.id, builder.viewType, builder.icon, builder.text1, builder.text2, builder.text3, builder.action);
        this.isChecked = builder.isChecked;
        this.actionPrimary = builder.actionPrimary;
    }

    protected CheckBoxIconItem(long id, int viewType, boolean isChecked, int icon, CharSequence text1, CharSequence text2, CharSequence text3, OnActionListener action, OnCheckActionListener actionPrimary) {
        super(id, viewType, icon, text1, text2, text3, action);
        this.isChecked = isChecked;
        this.actionPrimary = actionPrimary;
    }

    public static final class Builder {

        private long id;
        private int viewType;
        private boolean isChecked;
        private int icon;
        private CharSequence text1;
        private CharSequence text2;
        private CharSequence text3;
        private OnActionListener action;
        private OnCheckActionListener actionPrimary;

        public Builder() {
            this.id = NO_ID;
            this.viewType = MaterialListAdapter.VIEW_TYPE_ONE_LINE_CHECKBOX_ICON;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder viewType(@MaterialListAdapter.AvatarIconViewType int viewType) {
            this.viewType = viewType;
            return this;
        }

        public Builder isChecked(boolean isChecked) {
            this.isChecked = isChecked;
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

        public Builder actionPrimary(OnCheckActionListener actionPrimary) {
            this.actionPrimary = actionPrimary;
            return this;
        }

        public CheckBoxIconItem build() {
            return new CheckBoxIconItem(this);
        }
    }
}
