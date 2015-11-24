package fr.erictruong.android.cards;

import android.view.View;

public class HeadlineBodyItem extends MaterialCardItem {

    public final CharSequence headline;
    public final CharSequence body;
    public final CharSequence button1;
    public final CharSequence button2;
    public final CharSequence button3;
    public final CharSequence button4;
    public final CharSequence button5;
    public final CharSequence button6;
    public final View.OnClickListener action1;
    public final View.OnClickListener action2;
    public final View.OnClickListener action3;
    public final View.OnClickListener action4;
    public final View.OnClickListener action5;
    public final View.OnClickListener action6;

    private HeadlineBodyItem(Builder builder) {
        super(builder.id, builder.viewType);
        this.headline = builder.headline;
        this.body = builder.body;
        this.button1 = builder.button1;
        this.button2 = builder.button2;
        this.button3 = builder.button3;
        this.button4 = builder.button4;
        this.button5 = builder.button5;
        this.button6 = builder.button6;
        this.action1 = builder.action1;
        this.action2 = builder.action2;
        this.action3 = builder.action3;
        this.action4 = builder.action4;
        this.action5 = builder.action5;
        this.action6 = builder.action6;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static final class Builder {

        private long id;
        private int viewType;
        private CharSequence headline;
        private CharSequence body;
        private CharSequence button1;
        private CharSequence button2;
        private CharSequence button3;
        private CharSequence button4;
        private CharSequence button5;
        private CharSequence button6;
        private View.OnClickListener action1;
        private View.OnClickListener action2;
        private View.OnClickListener action3;
        private View.OnClickListener action4;
        private View.OnClickListener action5;
        private View.OnClickListener action6;

        public Builder() {
            this.id = -1;
            this.viewType = MaterialCardAdapter.VIEW_TYPE_HEADLINE_BODY1;
        }

        private Builder(HeadlineBodyItem item) {
            this.id = item.id;
            this.viewType = item.viewType;
            this.headline = item.headline;
            this.body = item.body;
            this.button1 = item.button1;
            this.button2 = item.button2;
            this.button3 = item.button3;
            this.button4 = item.button4;
            this.button5 = item.button5;
            this.button6 = item.button6;
            this.action1 = item.action1;
            this.action2 = item.action2;
            this.action3 = item.action3;
            this.action4 = item.action4;
            this.action5 = item.action5;
            this.action6 = item.action6;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder viewType(int viewType) {
            this.viewType = viewType;
            return this;
        }

        public Builder headline(CharSequence headline) {
            this.headline = headline;
            return this;
        }

        public Builder body(CharSequence body) {
            this.body = body;
            return this;
        }

        public Builder button1(CharSequence text, View.OnClickListener action) {
            this.button1 = text;
            this.action1 = action;
            return this;
        }

        public Builder button2(CharSequence text, View.OnClickListener action) {
            this.button2 = text;
            this.action2 = action;
            return this;
        }

        public Builder button3(CharSequence text, View.OnClickListener action) {
            this.button3 = text;
            this.action3 = action;
            return this;
        }

        public Builder button4(CharSequence text, View.OnClickListener action) {
            this.button4 = text;
            this.action4 = action;
            return this;
        }

        public Builder button5(CharSequence text, View.OnClickListener action) {
            this.button5 = text;
            this.action5 = action;
            return this;
        }

        public Builder button6(CharSequence text, View.OnClickListener action) {
            this.button6 = text;
            this.action6 = action;
            return this;
        }

        public HeadlineBodyItem build() {
            return new HeadlineBodyItem(this);
        }
    }
}
