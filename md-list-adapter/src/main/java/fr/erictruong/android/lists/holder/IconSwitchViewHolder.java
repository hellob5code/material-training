package fr.erictruong.android.lists.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import fr.erictruong.android.lists.MaterialListTileViewHolder;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.item.IconSwitchItem;

public class IconSwitchViewHolder extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<IconSwitchItem> {

    private SwitchViewHolder switchHolder;

    @NonNull
    private ImageView icon;

    public IconSwitchViewHolder(View itemView) {
        super(itemView);
        switchHolder = new SwitchViewHolder(itemView);
        icon = (ImageView) itemView.findViewById(R.id.icon);
    }

    @Override
    public void bind(final IconSwitchItem item) {
        switchHolder.bind(item);
        icon.setImageResource(item.getIcon());
    }

    @Override
    public void unbind() {
        switchHolder.unbind();
    }
}
