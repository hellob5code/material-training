package fr.erictruong.training.material.ui.tile;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DividerListTile extends Tile {

    public DividerListTile() {
        super(TYPE_NONE, TYPE_LIST_DIVIDER);
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements TileHolder {

        public ViewHolder(View v) {
            super(v);
        }

        @Override
        public void createView(Context context, boolean startIndented, boolean endIndented) {
        }

        @Override
        public void bindView(Tile tile, int position) {
        }
    }
}
