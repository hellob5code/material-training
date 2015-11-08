package fr.erictruong.android.lists.action;

import fr.erictruong.android.lists.MaterialListAdapter;
import fr.erictruong.android.lists.OnActionListener;
import fr.erictruong.android.lists.OnCheckActionListener;

public class ExpandItem extends CheckBoxItem {

    private ExpandItem(Builder builder) {
        super(builder.id, builder.viewType, builder.isExpanded, builder.text1, builder.text2, builder.text3, builder.action, builder.checkAction);
    }

    protected ExpandItem(long id, int viewType, boolean isChecked, CharSequence text1, CharSequence text2, CharSequence text3, OnActionListener action, OnCheckActionListener checkAction) {
        super(id, viewType, isChecked, text1, text2, text3, action, checkAction);
    }

    public static final class Builder {

        private long id;
        private int viewType;
        private boolean isExpanded;
        private CharSequence text1;
        private CharSequence text2;
        private CharSequence text3;
        private OnActionListener action;
        private OnCheckActionListener checkAction;

        public Builder() {
            this.id = NO_ID;
            this.viewType = MaterialListAdapter.VIEW_TYPE_ONE_LINE_EXPAND;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder viewType(int viewType) {
            this.viewType = viewType;
            return this;
        }

        public Builder isExpanded(boolean isExpanded) {
            this.isExpanded = isExpanded;
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

        public ExpandItem build() {
            return new ExpandItem(this);
        }
    }
}
