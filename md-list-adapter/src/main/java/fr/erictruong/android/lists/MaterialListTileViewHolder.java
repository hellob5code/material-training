package fr.erictruong.android.lists;

public interface MaterialListTileViewHolder<I extends MaterialListItem, T> {

    /**
     * This method should be used to bind the ViewHolder to the list item. For instance, setting a text to a TextView.
     *
     * @param item   The item which has been mapped to the {@link MaterialListItem} model class
     *               or one its subclass.
     * @param object The original item within the adapter's data set.
     */
    void bind(I item, T object);

    /**
     * This method should be used to unbind the ViewHolder from the list item. Use it to remove any listener applied to
     * one the views.
     */
    void unbind();
}
