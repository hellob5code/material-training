package fr.erictruong.android.lists.state;

import fr.erictruong.android.lists.MaterialListAdapter.TextViewType;
import fr.erictruong.android.lists.MaterialListItem;
import fr.erictruong.android.lists.OnActionListener;

import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE;

public class TextItem extends MaterialListItem {

    public final CharSequence text1;
    public final CharSequence text2;
    public final CharSequence text3;
    public final OnActionListener action;

    private TextItem(Builder builder) {
        super(builder.id, builder.viewType);
        this.text1 = builder.text1;
        this.text2 = builder.text2;
        this.text3 = builder.text3;
        this.action = builder.action;
    }

    protected TextItem(long id, int viewType, CharSequence text1, CharSequence text2, CharSequence text3, OnActionListener action) {
        super(id, viewType);
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.action = action;
    }

    public static final class Builder {

        private long id;
        private int viewType;
        private CharSequence text1;
        private CharSequence text2;
        private CharSequence text3;
        private OnActionListener action;

        public Builder() {
            this.id = NO_ID;
            this.viewType = VIEW_TYPE_ONE_LINE;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder viewType(@TextViewType int viewType) {
            this.viewType = viewType;
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

        public TextItem build() {
            return new TextItem(this);
        }
    }
}
