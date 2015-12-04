package fr.erictruong.android.lists.item;

import fr.erictruong.android.lists.MaterialListAdapter.TextViewType;
import fr.erictruong.android.lists.OnActionListener;

import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE;

public class TextItem extends MaterialListItem implements Textable {

    private CharSequence text1;
    private CharSequence text2;
    private CharSequence text3;

    private TextItem(Builder builder) {
        super(builder.id, builder.viewType, builder.action);
        this.text1 = builder.text1;
        this.text2 = builder.text2;
        this.text3 = builder.text3;
    }

    protected TextItem(long id, int viewType, CharSequence text1, CharSequence text2, CharSequence text3, OnActionListener action) {
        super(id, viewType, action);
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
    }

    @Override
    public CharSequence getText1() {
        return text1;
    }

    @Override
    public void setText1(CharSequence text1) {
        this.text1 = text1;
    }

    @Override
    public CharSequence getText2() {
        return text2;
    }

    @Override
    public void setText2(CharSequence text2) {
        this.text2 = text2;
    }

    @Override
    public CharSequence getText3() {
        return text3;
    }

    @Override
    public void setText3(CharSequence text3) {
        this.text3 = text3;
    }

    @Override
    public String toString() {
        return "TextItem{" +
                "id=" + getId() +
                ", viewType=" + getViewType() +
                '}';
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
