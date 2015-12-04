package fr.erictruong.android.lists;

import fr.erictruong.android.lists.item.MaterialListItem;

public interface Bindable<I> {

    /**
     * This method should be used to bind the ViewHolder to the list item. For instance, setting a text to a TextView.
     *
     * @param item   The item which has been mapped to the {@link MaterialListItem} model class
     *               or one its subclass.
     */
    void bind(I item);

    /**
     * This method should be used to unbind the ViewHolder from the list item. Use it to remove any listener applied to
     * one the views.
     */
    void unbind();
}
