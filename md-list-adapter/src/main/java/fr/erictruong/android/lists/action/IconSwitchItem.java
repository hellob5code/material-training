package fr.erictruong.android.lists.action;

import android.support.annotation.DrawableRes;

import fr.erictruong.android.lists.MaterialListAdapter;
import fr.erictruong.android.lists.OnActionListener;
import fr.erictruong.android.lists.OnCheckActionListener;

public class IconSwitchItem extends SwitchItem {

    public final int icon;

    private IconSwitchItem(Builder builder) {
        super(builder.id, builder.viewType, builder.isChecked, builder.text1, builder.text2, builder.text3, builder.action, builder.actionSecondary);
        this.icon = builder.icon;
    }

    protected IconSwitchItem(long id, int viewType, int icon, boolean isChecked, CharSequence text1, CharSequence text2, CharSequence text3, OnActionListener action, OnCheckActionListener actionSecondary) {
        super(id, viewType, isChecked, text1, text2, text3, action, actionSecondary);
        this.icon = icon;
    }

    public static final class Builder {

        private long id;
        private int viewType;
        private int icon;
        private boolean isChecked;
        private CharSequence text1;
        private CharSequence text2;
        private CharSequence text3;
        private OnActionListener action;
        private OnCheckActionListener actionSecondary;

        public Builder() {
            this.id = NO_ID;
            this.viewType = MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON_SWITCH;
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

        public Builder isChecked(boolean isChecked) {
            this.isChecked = isChecked;
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

        public Builder actionSecondary(OnCheckActionListener actionSecondary) {
            this.actionSecondary = actionSecondary;
            return this;
        }

        public IconSwitchItem build() {
            return new IconSwitchItem(this);
        }
    }
}
