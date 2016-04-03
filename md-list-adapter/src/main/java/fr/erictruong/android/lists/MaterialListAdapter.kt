package fr.erictruong.android.lists

import android.support.annotation.IntDef
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import java.util.Collections

import fr.erictruong.android.lists.holder.AvatarCheckBoxViewHolder
import fr.erictruong.android.lists.holder.AvatarIconViewHolder
import fr.erictruong.android.lists.holder.AvatarReorderViewHolder
import fr.erictruong.android.lists.holder.AvatarViewHolder
import fr.erictruong.android.lists.holder.CheckBoxIconViewHolder
import fr.erictruong.android.lists.holder.CheckBoxViewHolder
import fr.erictruong.android.lists.holder.ExpandViewHolder
import fr.erictruong.android.lists.holder.IconExpandViewHolder
import fr.erictruong.android.lists.holder.IconSwitchViewHolder
import fr.erictruong.android.lists.holder.IconViewHolder
import fr.erictruong.android.lists.holder.TextViewHolder
import fr.erictruong.android.lists.item.MaterialListItem

class MaterialListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE_LINE = 0
        const val VIEW_TYPE_TWO_LINE = 1
        const val VIEW_TYPE_THREE_LINE = 2

        const val VIEW_TYPE_ONE_LINE_ICON = 3
        const val VIEW_TYPE_TWO_LINE_ICON = 4
        const val VIEW_TYPE_THREE_LINE_ICON = 5

        const val VIEW_TYPE_ONE_LINE_AVATAR = 6
        const val VIEW_TYPE_TWO_LINE_AVATAR = 7
        const val VIEW_TYPE_THREE_LINE_AVATAR = 8

        const val VIEW_TYPE_ONE_LINE_AVATAR_ICON = 9
        const val VIEW_TYPE_TWO_LINE_AVATAR_ICON = 10
        const val VIEW_TYPE_THREE_LINE_AVATAR_ICON = 11

        const val VIEW_TYPE_ONE_LINE_CHECKBOX = 12

        const val VIEW_TYPE_ONE_LINE_SWITCH = 21

        const val VIEW_TYPE_ONE_LINE_EXPAND = 31

        const val VIEW_TYPE_ONE_LINE_CHECKBOX_ICON = 230

        const val VIEW_TYPE_ONE_LINE_AVATAR_CHECKBOX = 245

        const val VIEW_TYPE_ONE_LINE_ICON_SWITCH = 251

        const val VIEW_TYPE_ONE_LINE_AVATAR_REORDER = 269

        const val VIEW_TYPE_ONE_LINE_ICON_EXPAND = 300
    }

    @IntDef(VIEW_TYPE_ONE_LINE.toLong(), VIEW_TYPE_TWO_LINE.toLong(), VIEW_TYPE_THREE_LINE.toLong())
    @Retention(AnnotationRetention.SOURCE)
    annotation class TextViewType

    @IntDef(VIEW_TYPE_ONE_LINE_ICON.toLong(), VIEW_TYPE_TWO_LINE_ICON.toLong(), VIEW_TYPE_THREE_LINE_ICON.toLong())
    @Retention(AnnotationRetention.SOURCE)
    annotation class IconViewType

    @IntDef(VIEW_TYPE_ONE_LINE_AVATAR.toLong(), VIEW_TYPE_TWO_LINE_AVATAR.toLong(), VIEW_TYPE_THREE_LINE_AVATAR.toLong())
    @Retention(AnnotationRetention.SOURCE)
    annotation class AvatarViewType

    @IntDef(VIEW_TYPE_ONE_LINE_AVATAR_ICON.toLong(), VIEW_TYPE_TWO_LINE_AVATAR_ICON.toLong(), VIEW_TYPE_THREE_LINE_AVATAR_ICON.toLong())
    @Retention(AnnotationRetention.SOURCE)
    annotation class AvatarIconViewType

    private var dataset: MutableList<MaterialListItem> = arrayListOf()

    fun swapData(items: MutableList<MaterialListItem>) {
        this.dataset = items
        notifyDataSetChanged()
    }

    fun getItem(position: Int): MaterialListItem {
        return dataset[position]
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).id
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        when (viewType) {
            VIEW_TYPE_ONE_LINE -> return TextViewHolder(inflater.inflate(R.layout.list_tile_one_line, parent, false))
            VIEW_TYPE_TWO_LINE -> return TextViewHolder(inflater.inflate(R.layout.list_tile_two_line, parent, false))
            VIEW_TYPE_THREE_LINE -> return TextViewHolder(inflater.inflate(R.layout.list_tile_three_line, parent, false))

            VIEW_TYPE_ONE_LINE_ICON -> return IconViewHolder(inflater.inflate(R.layout.list_tile_one_line_icon, parent, false))
            VIEW_TYPE_TWO_LINE_ICON -> return IconViewHolder(inflater.inflate(R.layout.list_tile_two_line_icon, parent, false))
            VIEW_TYPE_THREE_LINE_ICON -> return IconViewHolder(inflater.inflate(R.layout.list_tile_three_line_icon, parent, false))

            VIEW_TYPE_ONE_LINE_AVATAR -> return AvatarViewHolder(inflater.inflate(R.layout.list_tile_one_line_avatar, parent, false))
            VIEW_TYPE_TWO_LINE_AVATAR -> return AvatarViewHolder(inflater.inflate(R.layout.list_tile_two_line_avatar, parent, false))
            VIEW_TYPE_THREE_LINE_AVATAR -> return AvatarViewHolder(inflater.inflate(R.layout.list_tile_three_line_avatar, parent, false))

            VIEW_TYPE_ONE_LINE_AVATAR_ICON -> return AvatarIconViewHolder(inflater.inflate(R.layout.list_tile_one_line_avatar_icon, parent, false))
            VIEW_TYPE_TWO_LINE_AVATAR_ICON -> return AvatarIconViewHolder(inflater.inflate(R.layout.list_tile_two_line_avatar_icon, parent, false))
            VIEW_TYPE_THREE_LINE_AVATAR_ICON -> return AvatarIconViewHolder(inflater.inflate(R.layout.list_tile_three_line_avatar_icon, parent, false))

            VIEW_TYPE_ONE_LINE_CHECKBOX -> return CheckBoxViewHolder(inflater.inflate(R.layout.list_tile_one_line_checkbox_end, parent, false))

            VIEW_TYPE_ONE_LINE_EXPAND -> return ExpandViewHolder(inflater.inflate(R.layout.list_tile_one_line_checkbox_end, parent, false))

            VIEW_TYPE_ONE_LINE_CHECKBOX_ICON -> return CheckBoxIconViewHolder(inflater.inflate(R.layout.list_tile_one_line_checkbox_icon, parent, false))

            VIEW_TYPE_ONE_LINE_AVATAR_CHECKBOX -> return AvatarCheckBoxViewHolder(inflater.inflate(R.layout.list_tile_one_line_avatar_checkbox, parent, false))

            VIEW_TYPE_ONE_LINE_ICON_SWITCH -> return IconSwitchViewHolder(inflater.inflate(R.layout.list_tile_one_line_icon_switch, parent, false))

            VIEW_TYPE_ONE_LINE_AVATAR_REORDER -> return AvatarReorderViewHolder(inflater.inflate(R.layout.list_tile_one_line_avatar_icon, parent, false))

            VIEW_TYPE_ONE_LINE_ICON_EXPAND -> return IconExpandViewHolder(inflater.inflate(R.layout.list_tile_one_line_icon_expand, parent, false))

            else -> throw IllegalArgumentException("Unknown view type: " + viewType)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Bindable<Any>).bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder?) {
        (holder as Bindable<Any>).unbind()
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
