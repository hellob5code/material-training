package com.training.android.material.ui.tile;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;

public class IconTextGridTile extends Tile {

    private Drawable icon;
    private String text;

    public IconTextGridTile(int id, Drawable icon) {
        this(id, icon, null);
    }

    public IconTextGridTile(int id, Drawable icon, String text) {
        this(id, TYPE_GRID_ICON_TEXT, icon, text);
    }

    protected IconTextGridTile(int id, int viewType, Drawable icon, String text) {
        super(id, viewType);
        this.icon = icon;
        this.text = text;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getText() {
        return text;
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements TileHolder {

        @InjectView(R.id.img_icon) ImageView imgIcon;
        @InjectView(R.id.tv_text) TextView tvText;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }

        @Override
        public void createView(Context context, boolean startIndented, boolean endIndented) {
            // Do nothing
        }

        @Override
        public void bindView(Tile tile, int position) {
            IconTextGridTile t = (IconTextGridTile) tile;
            bindView(t.getIcon(), t.getText());
        }

        protected void bindView(Drawable icon, String text) {
            imgIcon.setImageDrawable(icon);
            tvText.setText(text);
        }
    }
}
