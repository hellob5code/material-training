package fr.erictruong.android.lists

interface Bindable<I> {

    fun bind(item: I)

    fun unbind()
}
