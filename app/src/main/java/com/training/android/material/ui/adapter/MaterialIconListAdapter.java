package com.training.android.material.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.training.android.material.R;
import com.training.android.material.ui.listcontrol.IconListControl;
import com.training.android.material.ui.tile.SingleLineTile;

import java.util.List;

public class MaterialIconListAdapter extends RecyclerView.Adapter<MaterialIconListAdapter.ViewHolder> {

    private List<SingleLineTile> mRows;
    private boolean flagStartIndented;
    private boolean flagEndIndented;

    public MaterialIconListAdapter(List<SingleLineTile> rows) {
        mRows = rows;
    }

    public MaterialIconListAdapter(List<SingleLineTile> rows, boolean start, boolean end) {
        mRows = rows;
        flagStartIndented = start;
        flagEndIndented = end;
    }

    /**
     * Create new views (invoked by the layout manager). Set the view's size, margins, paddings and layout parameters.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.tile_list_single_line_material, parent, false);

        final ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.Callbacks() {
            @Override
            public void onActionClick(View view, int position) {
                System.out.println("onActionClick() position=" + position);
            }

            @Override
            public void onPrimaryActionClick(View view, int position) {
                System.out.println("onPrimaryActionClick() position=" + position);
            }

            @Override
            public void onSecondaryActionClick(View view, int position) {
                System.out.println("onSecondaryActionClick() position=" + position);
            }
        });

        if (flagStartIndented) {
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) viewHolder.textView.getLayoutParams();
            layoutParams.setMarginStart(context.getResources().getDimensionPixelSize(R.dimen.keyline_2_minus_16dp));
        }
        if (flagEndIndented) {
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) viewHolder.textView.getLayoutParams();
            layoutParams.setMarginEnd(context.getResources().getDimensionPixelSize(R.dimen.list_icon_size_plus_16dp_material));
        }

        return viewHolder;
    }

    /**
     * Replace the contents of a view (invoked by the layout manager). Get element from your dataset at this position and
     * replace the contents of the view with that element.
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        SingleLineTile row = mRows.get(position);
        viewHolder.textView.setText(row.getText());
        if (viewHolder.primaryView != null) {
            if (row.getPrimary() != null) {
                ((ImageView) viewHolder.primaryView).setImageDrawable(((IconListControl) row.getPrimary()).getDrawable());
            } else {
                ((ImageView) viewHolder.primaryView).setImageDrawable(null);
            }
        } else {
            if (row.getPrimary() != null && row.getPrimary().inflateStub(viewHolder.primaryStub)) {
                ((ImageView) viewHolder.primaryView).setImageDrawable(((IconListControl) row.getPrimary()).getDrawable());
            }
        }
        if (viewHolder.secondaryView != null) {
            if (row.getSecondary() != null) {
                ((ImageView) viewHolder.secondaryView).setImageDrawable(((IconListControl) row.getSecondary()).getDrawable());
            } else {
                ((ImageView) viewHolder.secondaryView).setImageDrawable(null);
            }
        } else {
            if (row.getSecondary() != null && row.getSecondary().inflateStub(viewHolder.secondaryStub)) {
                ((ImageView) viewHolder.secondaryView).setImageDrawable(((IconListControl) row.getSecondary()).getDrawable());
            }
        }
    }

    /**
     * Return the size of your dataset (invoked by the layout manager).
     */
    @Override
    public int getItemCount() {
        return mRows.size();
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public static interface Callbacks {
            public void onActionClick(View view, int position);

            public void onPrimaryActionClick(View view, int position);

            public void onSecondaryActionClick(View view, int position);
        }

        public Callbacks callbacks;

        public TextView textView;
        public ViewStub primaryStub;
        public ViewStub secondaryStub;
        public View primaryView;
        public View secondaryView;

        public ViewHolder(View view, Callbacks listener) {
            super(view);
            callbacks = listener;
            textView = (TextView) view.findViewById(R.id.text);
            primaryStub = (ViewStub) view.findViewById(R.id.primary_stub);
            primaryStub.setOnInflateListener(new ViewStub.OnInflateListener() {
                @Override
                public void onInflate(ViewStub stub, View inflated) {
                    primaryView = inflated;
                    primaryView.setOnClickListener(ViewHolder.this);
                }
            });
            secondaryStub = (ViewStub) view.findViewById(R.id.secondary_stub);
            secondaryStub.setOnInflateListener(new ViewStub.OnInflateListener() {
                @Override
                public void onInflate(ViewStub stub, View inflated) {
                    secondaryView = inflated;
                    secondaryView.setOnClickListener(ViewHolder.this);
                }
            });
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.equals(primaryView)) {
                callbacks.onPrimaryActionClick(view, getPosition());
            } else if (view.equals(secondaryView)) {
                callbacks.onSecondaryActionClick(view, getPosition());
            } else {
                callbacks.onActionClick(view, getPosition());
            }
        }
    }
}

