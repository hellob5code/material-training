package fr.erictruong.training.material.ui.tile;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.listcontrol.IconListControl;
import fr.erictruong.training.material.ui.listcontrol.ListControl;

public class SingleLineListTile extends Tile {

    private String text;
    private ListControl primary, secondary;

    public SingleLineListTile(int id, String text) {
        this(id, text, null, null);
    }

    public SingleLineListTile(int id, String text, ListControl primary, ListControl secondary) {
        this(id, TYPE_LIST_SINGLE_LINE, text, primary, secondary);
    }

    protected SingleLineListTile(int id, int viewType, String text, ListControl primary, ListControl secondary) {
        super(id, viewType);
        this.text = text;
        this.primary = primary;
        this.secondary = secondary;
    }

    public String getText() {
        return text;
    }

    public ListControl getPrimary() {
        return primary;
    }

    public ListControl getSecondary() {
        return secondary;
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements TileHolder, View.OnClickListener {

        public static interface Callbacks {
            public void onActionClick(View view, int position);

            public void onPrimaryActionClick(View view, int position);

            public void onSecondaryActionClick(View view, int position);
        }

        @InjectView(R.id.tv_text) TextView tvText1;
        @InjectView(R.id.stub_primary) ViewStub stubPrimary;
        @InjectView(R.id.stub_secondary) ViewStub stubSecondary;

        public View inflatedPrimary;
        public View inflatedSecondary;

        public Callbacks callbacks;

        public ViewHolder(View v) {//, Callbacks listener) {
            super(v);
            ButterKnife.inject(this, v);
            stubPrimary.setOnInflateListener(new ViewStub.OnInflateListener() {
                @Override
                public void onInflate(ViewStub stub, View inflated) {
                    inflatedPrimary = inflated;
                    inflatedPrimary.setOnClickListener(ViewHolder.this);
                }
            });
            stubSecondary.setOnInflateListener(new ViewStub.OnInflateListener() {
                @Override
                public void onInflate(ViewStub stub, View inflated) {
                    inflatedSecondary = inflated;
                    inflatedSecondary.setOnClickListener(ViewHolder.this);
                }
            });
//            callbacks = listener;
            v.setOnClickListener(this);
        }

        @Override
        public void createView(Context context, boolean startIndented, boolean endIndented) {
            if (startIndented) {
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) tvText1.getLayoutParams();
                layoutParams.setMarginStart(context.getResources().getDimensionPixelSize(R.dimen.keyline_2_minus_16dp));
            }
            if (endIndented) {
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) tvText1.getLayoutParams();
                layoutParams.setMarginEnd(context.getResources().getDimensionPixelSize(R.dimen.list_icon_size_plus_16dp_material));
            }
        }

        @Override
        public void bindView(Tile tile, int position) {
            SingleLineListTile t = (SingleLineListTile) tile;
            bindView(t.getText(), t.getPrimary(), t.getSecondary());
        }

        protected void bindView(String text, ListControl primary, ListControl secondary) {
            tvText1.setText(text);
            if (inflatedPrimary != null) {
                if (primary != null) {
                    ((ImageView) inflatedPrimary).setImageDrawable(((IconListControl) primary).getDrawable());
                } else {
                    ((ImageView) inflatedPrimary).setImageDrawable(null);
                }
            } else {
                if (primary != null && primary.inflateStub(stubPrimary)) {
                    ((ImageView) inflatedPrimary).setImageDrawable(((IconListControl) primary).getDrawable());
                }
            }
            if (inflatedSecondary != null) {
                if (secondary != null) {
                    ((ImageView) inflatedSecondary).setImageDrawable(((IconListControl) secondary).getDrawable());
                } else {
                    ((ImageView) inflatedSecondary).setImageDrawable(null);
                }
            } else {
                if (secondary != null && secondary.inflateStub(stubSecondary)) {
                    ((ImageView) inflatedSecondary).setImageDrawable(((IconListControl) secondary).getDrawable());
                }
            }
        }

        @Override
        public void onClick(View view) {
            if (callbacks != null) {
                if (view.equals(inflatedPrimary)) {
                    callbacks.onPrimaryActionClick(view, getPosition());
                } else if (view.equals(inflatedSecondary)) {
                    callbacks.onSecondaryActionClick(view, getPosition());
                } else {
                    callbacks.onActionClick(view, getPosition());
                }
            }
        }
    }
}
