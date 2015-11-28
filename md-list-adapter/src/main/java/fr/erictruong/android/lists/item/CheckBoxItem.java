package fr.erictruong.android.lists.item;

import fr.erictruong.android.lists.MaterialListAdapter;
import fr.erictruong.android.lists.OnActionListener;

public class CheckBoxItem extends TextItem {

    private boolean isChecked;
    private OnActionListener checkAction;

    private CheckBoxItem(Builder builder) {
        super(builder.id, builder.viewType, builder.text1, builder.text2, builder.text3, builder.action);
        this.isChecked = builder.isChecked;
        this.checkAction = builder.checkAction;
    }

    protected CheckBoxItem(long id, int viewType, boolean isChecked, CharSequence text1, CharSequence text2, CharSequence text3, OnActionListener action, OnActionListener checkAction) {
        super(id, viewType, text1, text2, text3, action);
        this.isChecked = isChecked;
        this.checkAction = checkAction;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public OnActionListener getCheckAction() {
        return checkAction;
    }

    public void setCheckAction(OnActionListener checkAction) {
        this.checkAction = checkAction;
    }

    @Override
    public String toString() {
        return "CheckBoxItem{" +
                "id=" + getId() +
                ", viewType=" + getViewType() +
                '}';
    }

    public static final class Builder {

        private long id;
        private int viewType;
        private boolean isChecked;
        private CharSequence text1;
        private CharSequence text2;
        private CharSequence text3;
        private OnActionListener action;
        private OnActionListener checkAction;

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

        public Builder checkAction(OnActionListener checkAction) {
            this.checkAction = checkAction;
            return this;
        }

        public CheckBoxItem build() {
            return new CheckBoxItem(this);
        }
    }
}
