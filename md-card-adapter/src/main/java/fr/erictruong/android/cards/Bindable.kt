package fr.erictruong.android.cards

interface Bindable<I> {

    fun bind(item: I)

    fun unbind()
}
