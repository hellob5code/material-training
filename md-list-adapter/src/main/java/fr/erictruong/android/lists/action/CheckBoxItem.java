package fr.erictruong.android.lists.action;

import fr.erictruong.android.lists.MaterialListAdapter;
import fr.erictruong.android.lists.OnActionListener;
import fr.erictruong.android.lists.OnCheckActionListener;
import fr.erictruong.android.lists.state.TextItem;

public class CheckBoxItem extends TextItem {

    public final boolean isChecked;
    public final OnCheckActionListener checkAction;

    private CheckBoxItem(Builder builder) {
        super(builder.id, builder.viewType, builder.text1, builder.text2, builder.text3, builder.action);
        this.isChecked = builder.isChecked;
        this.checkAction = builder.checkAction;
    }

    protected CheckBoxItem(long id, int viewType, boolean isChecked, CharSequence text1, CharSequence text2, CharSequence text3, OnActionListener action, OnCheckActionListener checkAction) {
        super(id, viewType, text1, text2, text3, action);
        this.isChecked = isChecked;
        this.checkAction = checkAction;
    }

    public static final class Builder {

        private long id;
        private int viewType;
        private boolean isChecked;
        private CharSequence text1;
        private CharSequence text2;
        private CharSequence text3;
        private OnActionListener action;
        private OnCheckActionListener checkAction;

        public Builder() {
            this.id = NO_ID;
            this.viewType = MaterialListAdapter.VIEW_TYPE_ONE_LINE_CHECKBOX;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder viewType(int viewType) {
            this.viewType = viewType;
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

        public Builder checkAction(OnCheckActionListener checkAction) {
            this.checkAction = checkAction;
            return this;
        }

        public CheckBoxItem build() {
            return new CheckBoxItem(this);
        }
    }
}
