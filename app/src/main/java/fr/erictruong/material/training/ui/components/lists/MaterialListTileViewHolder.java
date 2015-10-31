package fr.erictruong.material.training.ui.components.lists;

public interface MaterialListTileViewHolder<I extends MaterialListItem, T> {

    void bind(I item, T object);
}
