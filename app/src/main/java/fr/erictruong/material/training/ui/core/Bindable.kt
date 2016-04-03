package fr.erictruong.material.training.ui.core

interface Bindable<I> {

    fun bind(item: I)

    fun unbind()
}
