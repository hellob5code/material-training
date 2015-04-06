package fr.erictruong.training.material.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.tile.IconTextGridTile;
import fr.erictruong.training.material.ui.tile.SubheaderTile;
import fr.erictruong.training.material.ui.tile.Tile;

import java.util.List;

import static fr.erictruong.training.material.ui.tile.Tile.TYPE_SUBHEADER;
import static fr.erictruong.training.material.ui.tile.Tile.TYPE_GRID_ICON_TEXT;

public class IconsGridAdapter extends RecyclerView.Adapter {

    private List<Tile> dataset;

    public IconsGridAdapter(List<Tile> dataset) {
        this.dataset = dataset;
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
            case TYPE_GRID_ICON_TEXT: {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tile_grid_icon_text_material, parent, false);
                viewHolder = new IconTextGridTile.ViewHolder(v);
                break;
            }
        }

        ((Tile.TileHolder) viewHolder).createView(parent.getContext(), false, false);

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
