package fr.erictruong.android.lists.state;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import fr.erictruong.android.lists.MaterialListTileViewHolder;
import fr.erictruong.android.lists.R;


public class IconViewHolder<T> extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<IconItem, T> {

    private TextViewHolder<T> textHolder;

    @NonNull
    private ImageView icon;

    public IconViewHolder(View itemView) {
        super(itemView);
        textHolder = new TextViewHolder<>(itemView);
        icon = (ImageView) itemView.findViewById(R.id.icon);
    }

    @Override
    public void bind(IconItem item, T object) {
        textHolder.bind(item, object);
        icon.setImageResource(item.icon);
    }

    @Override
    public void unbind() {
        textHolder.unbind();
    }
}
