package com.training.android.materiel.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.training.android.materiel.R;

public class SingleLineListAdapter extends RecyclerView.Adapter<SingleLineListAdapter.ViewHolder> {

    private String[] mDataset;

    public SingleLineListAdapter(String[] dataset) {
        mDataset = dataset;
    }

    /**
     * Create new views (invoked by the layout manager). Set the view's size, margins, paddings and layout parameters.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single_line_material, parent, false);

        return new ViewHolder(view, new ViewHolder.Callbacks() {
            @Override
            public void onPrimaryActionClick(View v) {
            }

            @Override
            public void onSupplementalPrimaryActionClick(View v) {
            }

            @Override
            public void onSupplementalSecondaryActionClick(View v) {
            }
        });
    }

    /**
     * Replace the contents of a view (invoked by the layout manager). Get element from your dataset at this position and
     * replace the contents of the view with that element.
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.text1.setText(mDataset[position]);
    }

    /**
     * Return the size of your dataset (invoked by the layout manager).
     */
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public static interface Callbacks {
            public void onPrimaryActionClick(View v);

            public void onSupplementalPrimaryActionClick(View v);

            public void onSupplementalSecondaryActionClick(View v);
        }

        public Callbacks mListener;

        public TextView text1;

        public ViewHolder(View v, Callbacks listener) {
            super(v);
            mListener = listener;
            text1 = (TextView) v.findViewById(R.id.text);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onPrimaryActionClick(v);
        }
    }
}

