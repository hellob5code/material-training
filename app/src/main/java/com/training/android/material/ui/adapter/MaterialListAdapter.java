package com.training.android.material.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.training.android.material.R;
import com.training.android.material.ui.tile.DividerListTile;
import com.training.android.material.ui.tile.SingleLineListTile;
import com.training.android.material.ui.tile.SubheaderTile;
import com.training.android.material.ui.tile.Tile;

import java.util.List;

import static com.training.android.material.ui.tile.Tile.TYPE_LIST_DIVIDER;
import static com.training.android.material.ui.tile.Tile.TYPE_LIST_SINGLE_LINE;
import static com.training.android.material.ui.tile.Tile.TYPE_SUBHEADER;

public class MaterialListAdapter extends RecyclerView.Adapter {

    private List<Tile> dataset;
    private boolean flagStartIndented;
    private boolean flagEndIndented;

    public MaterialListAdapter(List<Tile> rows) {
        dataset = rows;
        flagStartIndented = false;
        flagEndIndented = false;
    }

    public MaterialListAdapter(List<Tile> rows, boolean start, boolean end) {
        dataset = rows;
        flagStartIndented = start;
        flagEndIndented = end;
    }

    @Override
    public int getItemViewType(int position) {
        return dataset.get(position).getViewType();
    }

    /**
     * Create new views (invoked by the layout manager). Set the view's size, margins, paddings and layout parameters.
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case TYPE_SUBHEADER: {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tile_subheader_material, parent, false);
                viewHolder = new SubheaderTile.ViewHolder(v);
                break;
            }
            case TYPE_LIST_DIVIDER: {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tile_list_divider_material, parent, false);
                viewHolder = new DividerListTile.ViewHolder(v);
                break;
            }
            case TYPE_LIST_SINGLE_LINE: {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tile_list_single_line_material, parent, false);
                viewHolder = new SingleLineListTile.ViewHolder(v);
                break;
            }
        }

//        View view = LayoutInflater.from(context).inflate(R.layout.tile_list_single_line_material, parent, false);
//
//        final ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.Callbacks() {
//            @Override
//            public void onActionClick(View view, int position) {
//                System.out.println("onActionClick() position=" + position);
//            }
//
//            @Override
//            public void onPrimaryActionClick(View view, int position) {
//                System.out.println("onPrimaryActionClick() position=" + position);
//            }
//
//            @Override
//            public void onSecondaryActionClick(View view, int position) {
//                System.out.println("onSecondaryActionClick() position=" + position);
//            }
//        });

        ((Tile.TileHolder) viewHolder).createView(parent.getContext(), flagStartIndented, flagEndIndented);

        return viewHolder;
    }

    /**
     * Replace the contents of a view (invoked by the layout manager). Get element from your dataset at this position
     * and replace the contents of the view with that element.
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        Tile tile = dataset.get(position);
        ((Tile.TileHolder) viewHolder).bindView(tile, position);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}

