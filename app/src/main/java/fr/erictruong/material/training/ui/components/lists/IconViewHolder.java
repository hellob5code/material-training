package fr.erictruong.material.training.ui.components.lists;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import fr.erictruong.material.training.R;

public class IconViewHolder extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<IconItem> {

    private TextViewHolder viewHolder;

    @NonNull
    private ImageView icon;

    public IconViewHolder(View view) {
        super(view);
        viewHolder = new TextViewHolder(view);
        icon = (ImageView) view.findViewById(R.id.icon);
    }

    @Override
    public void bind(IconItem item) {
        viewHolder.bind(item);
        icon.setImageResource(item.icon);
    }
}
