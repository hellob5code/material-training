package fr.erictruong.android.lists.action;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import fr.erictruong.android.lists.MaterialListTileViewHolder;
import fr.erictruong.android.lists.R;

public class IconSwitchViewHolder<T> extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<IconSwitchItem, T> {

    private SwitchViewHolder<T> switchHolder;

    @NonNull
    private ImageView icon;

    public IconSwitchViewHolder(View itemView) {
        super(itemView);
        switchHolder = new SwitchViewHolder<>(itemView);
        icon = (ImageView) itemView.findViewById(R.id.icon);
    }

    @Override
    public void bind(final IconSwitchItem item, final T object) {
        switchHolder.bind(item, object);
        icon.setImageResource(item.icon);
    }

    @Override
    public void unbind() {
        switchHolder.unbind();
    }
}
