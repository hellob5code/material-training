package fr.erictruong.android.lists

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import fr.erictruong.android.lists.holder.*
import fr.erictruong.android.lists.item.MaterialListItem
import fr.erictruong.android.lists.item.MaterialListItem.Companion.decodeHolderType
import fr.erictruong.android.lists.item.MaterialListItem.Companion.decodeViewType
import java.util.*

/**
 * item => holder => layout => view
 */
class MaterialListAdapter : RecyclerView.Adapter<Holder>() {

    private var dataset: MutableList<MaterialListItem> = arrayListOf()

    fun getItem(position: Int): MaterialListItem {
        return dataset[position]
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).id
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return item.encodeViewType(item.viewType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val holderType = decodeHolderType(viewType)
        val originalType = decodeViewType(viewType)
        when (holderType) {
            TextViewHolder.TYPE -> return TextViewHolder(parent, originalType)
            IconViewHolder.TYPE -> return IconViewHolder(parent, originalType)
            AvatarViewHolder.TYPE -> return AvatarViewHolder(parent, originalType)
            CheckBoxViewHolder.TYPE -> return CheckBoxViewHolder(parent, originalType)
            AvatarIconViewHolder.TYPE -> return AvatarIconViewHolder(parent, originalType)
            CheckBoxIconViewHolder.TYPE -> return CheckBoxIconViewHolder(parent, originalType)
            AvatarCheckBoxViewHolder.TYPE -> return AvatarCheckBoxViewHolder(parent, originalType)
            IconSwitchViewHolder.TYPE -> return IconSwitchViewHolder(parent, originalType)
            AvatarReorderViewHolder.TYPE -> return AvatarReorderViewHolder(parent, originalType)
            IconExpandViewHolder.TYPE -> return IconExpandViewHolder(parent, originalType)
            else -> throw IllegalArgumentException("Unknown view type: " + viewType)
        }
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onViewRecycled(holder: Holder?) {
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
