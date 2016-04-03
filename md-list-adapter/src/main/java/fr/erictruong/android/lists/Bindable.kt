package fr.erictruong.android.lists

interface Bindable<I> {

    /**
     * This method should be used to bind the ViewHolder to the list item. For instance, setting a text to a TextView.
     *
     * @param item   The item which has been mapped to the [MaterialListItem] model class
     *               or one its subclass.
     */
    fun bind(item: I)

    /**
     * This method should be used to unbind the ViewHolder from the list item. Use it to remove any listener applied to
     * one the views.
     */
    fun unbind()
}
