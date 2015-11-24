package fr.erictruong.android.cards;

public class DisplayBodyItem extends MaterialCardItem {

    public final CharSequence display;
    public final CharSequence body;

    private DisplayBodyItem(Builder builder) {
        super(builder.id, builder.viewType);
        this.display = builder.display;
        this.body = builder.body;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static final class Builder {

        private long id;
        private int viewType;
        private CharSequence display;
        private CharSequence body;

        public Builder() {
            this.id = NO_ID;
            this.viewType = MaterialCardAdapter.VIEW_TYPE_DISPLAY1_BODY1;
        }

        private Builder(DisplayBodyItem item) {
            this.id = item.id;
            this.viewType = item.viewType;
            this.display = item.display;
            this.body = item.body;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder viewType(int viewType) {
            this.viewType = viewType;
            return this;
        }

        public Builder display(CharSequence display) {
            this.display = display;
            return this;
        }

        public Builder body(CharSequence body) {
            this.body = body;
            return this;
        }

        public DisplayBodyItem build() {
            return new DisplayBodyItem(this);
        }
    }
}
