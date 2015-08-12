package fr.erictruong.material.training.ui.components.lists;

import android.support.annotation.DrawableRes;

import fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.AvatarIconViewType;

import static fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_ICON;

public class AvatarIconItem extends IconItem {

    public final String avatarUrl;

    private AvatarIconItem(Builder builder) {
        super(builder.id, builder.viewType, builder.icon, builder.text1, builder.text2, builder.text3, builder.action);
        this.avatarUrl = builder.avatarUrl;
    }

    protected AvatarIconItem(long id, int viewType, String avatarUrl, int icon, CharSequence text1, CharSequence text2, CharSequence text3, OnActionListener action) {
        super(id, viewType, icon, text1, text2, text3, action);
        this.avatarUrl = avatarUrl;
    }

    public static final class Builder {

        private long id;
        private int viewType;
        private String avatarUrl;
        private int icon;
        private CharSequence text1;
        private CharSequence text2;
        private CharSequence text3;
        private OnActionListener action;

        public Builder() {
            this.id = NO_ID;
            this.viewType = VIEW_TYPE_ONE_LINE_AVATAR_ICON;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder viewType(@AvatarIconViewType int viewType) {
            this.viewType = viewType;
            return this;
        }

        public Builder avatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
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

        public Builder action(OnActionListener<AvatarIconItem> action) {
            this.action = action;
            return this;
        }

        public AvatarIconItem build() {
            return new AvatarIconItem(this);
        }
    }
}
