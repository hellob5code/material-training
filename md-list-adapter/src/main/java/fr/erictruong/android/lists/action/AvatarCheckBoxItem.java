package fr.erictruong.android.lists.action;

import fr.erictruong.android.lists.MaterialListAdapter;
import fr.erictruong.android.lists.OnActionListener;
import fr.erictruong.android.lists.OnCheckActionListener;

public class AvatarCheckBoxItem extends CheckBoxItem {

    public final String avatarUrl;

    private AvatarCheckBoxItem(Builder builder) {
        super(builder.id, builder.viewType, builder.isChecked, builder.text1, builder.text2, builder.text3, builder.action, builder.actionSecondary);
        this.avatarUrl = builder.avatarUrl;
    }

    protected AvatarCheckBoxItem(long id, int viewType, String avatarUrl, boolean isChecked, CharSequence text1, CharSequence text2, CharSequence text3, OnActionListener action, OnCheckActionListener actionSecondary) {
        super(id, viewType, isChecked, text1, text2, text3, action, actionSecondary);
        this.avatarUrl = avatarUrl;
    }

    public static final class Builder {

        private long id;
        private int viewType;
        private String avatarUrl;
        private boolean isChecked;
        private CharSequence text1;
        private CharSequence text2;
        private CharSequence text3;
        private OnActionListener action;
        private OnCheckActionListener actionSecondary;

        public Builder() {
            this.id = NO_ID;
            this.viewType = MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_CHECKBOX;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder viewType(int viewType) {
            this.viewType = viewType;
            return this;
        }

        public Builder avatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
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

        public AvatarCheckBoxItem build() {
            return new AvatarCheckBoxItem(this);
        }
    }
}
