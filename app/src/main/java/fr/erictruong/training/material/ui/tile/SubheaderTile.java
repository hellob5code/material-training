package fr.erictruong.training.material.ui.tile;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import fr.erictruong.training.material.R;

public class SubheaderTile extends Tile {

    private String subhead;

    public SubheaderTile(int id, String subhead) {
        super(id, TYPE_SUBHEADER);
        this.subhead = subhead;
    }

    public String getSubhead() {
        return subhead;
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements TileHolder {

        @InjectView(R.id.divider) View divider;
        @InjectView(R.id.tv_subhead) TextView tvSubhead;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }

        @Override
        public void createView(Context context, boolean startIndented, boolean endIndented) {

        }

        @Override
        public void bindView(Tile tile, int position) {
            if (position == 0) {
                divider.setVisibility(View.GONE);
            } else {
                divider.setVisibility(View.VISIBLE);
            }

            SubheaderTile c = (SubheaderTile) tile;
            bindView(c.getSubhead());
        }

        protected void bindView(String text) {
            tvSubhead.setText(text);
        }
    }
}
