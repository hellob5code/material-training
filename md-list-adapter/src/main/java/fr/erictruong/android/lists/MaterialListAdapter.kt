package fr.erictruong.android.lists

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import fr.erictruong.android.lists.holder.Holder
import fr.erictruong.android.lists.item.MaterialListItem
import java.util.*
import kotlin.reflect.KClass

class MaterialListAdapter<H : Holder>(val clazz: KClass<H>) : RecyclerView.Adapter<H>() {

    companion object {
        inline operator fun <reified H : Holder> invoke() = MaterialListAdapter(H::class)
    }

    private var dataset: MutableList<MaterialListItem> = arrayListOf()

    fun getItem(position: Int): MaterialListItem {
        return dataset[position]
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).id
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): H {
        return clazz.constructors.first().call(parent, viewType)
    }

    override fun onBindViewHolder(holder: H, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onViewRecycled(holder: H?) {
        holder?.unbind()
    }

    fun swapData(items: MutableList<MaterialListItem>) {
        this.dataset = items
        notifyDataSetChanged()
    }

    fun addItem(position: Int, item: MaterialListItem) {
        dataset.add(position, item)
        notifyItemInserted(position)
    }

    fun removeItem(position: Int) {
        dataset.removeAt(position)
        notifyItemRemoved(position)
    }

    fun moveItem(fromPosition: Int, toPosition: Int): Boolean {
        Collections.swap(dataset, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
        return true
    }
}
