package fr.erictruong.android.lists.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import fr.erictruong.android.lists.MaterialListTileViewHolder;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.item.IconItem;


public class IconViewHolder extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<IconItem> {

    private TextViewHolder textHolder;

    @NonNull
    private ImageView icon;

    public IconViewHolder(View itemView) {
        super(itemView);
        textHolder = new TextViewHolder(itemView);
        icon = (ImageView) itemView.findViewById(R.id.icon);
    }

    @Override
    public void bind(IconItem item) {
        textHolder.bind(item);
        icon.setImageResource(item.getIcon());
    }

    @Override
    public void unbind() {
        textHolder.unbind();
    }
}
