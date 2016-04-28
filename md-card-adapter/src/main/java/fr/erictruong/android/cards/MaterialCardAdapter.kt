package fr.erictruong.android.cards

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import fr.erictruong.android.cards.holder.*
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.android.cards.item.MaterialCardItem.Companion.decodeHolderType
import fr.erictruong.android.cards.item.MaterialCardItem.Companion.decodeViewType
import java.util.*

class MaterialCardAdapter : RecyclerView.Adapter<Holder>() {

    companion object {
        val NO_ID: Long = -1
        val MAGIC_NUMBER: Int = 100
    }

    private var dataset: MutableList<MaterialCardItem> = arrayListOf()

    fun getItem(position: Int): MaterialCardItem {
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
            DisplayBodyViewHolder.TYPE -> return DisplayBodyViewHolder(parent, originalType)
            HeadlineBodyViewHolder.TYPE -> return HeadlineBodyViewHolder(parent, originalType)
            HeadlineBodyThreeButtonViewHolder.TYPE -> return HeadlineBodyThreeButtonViewHolder(parent, originalType)
            HeadlineBodySixButtonViewHolder.TYPE -> return HeadlineBodySixButtonViewHolder(parent, originalType)
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

    fun swapData(items: MutableList<MaterialCardItem>) {
        this.dataset = items
        notifyDataSetChanged()
    }

    fun addItem(position: Int, item: MaterialCardItem) {
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

//    private var dataset = emptyList<MaterialCardItem>()
//
//    fun swapData(items: List<MaterialCardItem>) {
//        this.dataset = items
//        notifyDataSetChanged()
//    }
//
//    fun getItem(position: Int): MaterialCardItem {
//        return dataset[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return getItem(position).id
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return getItem(position).viewType
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        when (viewType) {
//            VIEW_TYPE_DISPLAY1_BODY1 -> return DisplayBodyViewHolder(inflater.inflate(R.layout.card_display1_body1, parent, false))
//            VIEW_TYPE_DISPLAY1_PRIMARY_BODY1 -> return DisplayBodyViewHolder(inflater.inflate(R.layout.card_display1_primary_body1, parent, false))
//            VIEW_TYPE_DISPLAY1_BODY2 -> return DisplayBodyViewHolder(inflater.inflate(R.layout.card_display1_body2, parent, false))
//            VIEW_TYPE_DISPLAY1_PRIMARY_BODY2 -> return DisplayBodyViewHolder(inflater.inflate(R.layout.card_display1_primary_body2, parent, false))
//            VIEW_TYPE_HEADLINE_BODY1 -> return HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_body1, parent, false))
//            VIEW_TYPE_HEADLINE_BODY1_THREE_BUTTON -> return HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_body1_three_button, parent, false))
//            VIEW_TYPE_HEADLINE_BODY1_SIX_BUTTON -> return HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_body1_six_button, parent, false))
//            VIEW_TYPE_HEADLINE_BODY2 -> return HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_body2, parent, false))
//            VIEW_TYPE_HEADLINE_PRIMARY_BODY1 -> return HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_primary_body1, parent, false))
//            VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON -> return HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_primary_body1_three_button, parent, false))
//            VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON -> return HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_primary_body1_six_button, parent, false))
//            VIEW_TYPE_HEADLINE_PRIMARY_BODY2 -> return HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_primary_body2, parent, false))
//            else -> throw IllegalArgumentException("Unknown view type: " + viewType)
//        }
//    }
//
//    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
//        (viewHolder as MaterialCardViewHolder<MaterialCardItem>).bind(getItem(position))
//    }
//
//    override fun getItemCount(): Int {
//        return dataset.size
//    }
//
//    companion object {
//
//        val VIEW_TYPE_DISPLAY1_BODY1 = 0
//        val VIEW_TYPE_DISPLAY1_PRIMARY_BODY1 = 1
//        val VIEW_TYPE_DISPLAY1_BODY2 = 2
//        val VIEW_TYPE_DISPLAY1_PRIMARY_BODY2 = 3
//        val VIEW_TYPE_HEADLINE_BODY1 = 4
//        val VIEW_TYPE_HEADLINE_BODY1_THREE_BUTTON = 5
//        val VIEW_TYPE_HEADLINE_BODY1_SIX_BUTTON = 6
//        val VIEW_TYPE_HEADLINE_BODY2 = 7
//        val VIEW_TYPE_HEADLINE_PRIMARY_BODY1 = 8
//        val VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON = 9
//        val VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON = 10
//        val VIEW_TYPE_HEADLINE_PRIMARY_BODY2 = 11
//
//        val VIEW_TYPE_IMAGE_BODY1 = 20
//        val VIEW_TYPE_AVATAR_TITLE_SUBTITLE_IMAGE_BODY1_THREE_BUTTON = 25
//        val VIEW_TYPE_AVATAR_TITLE_SUBTITLE_IMAGE_BODY1_SIX_BUTTON = 30
//        val VIEW_TYPE_IMAGE_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON_EXPAND = 35
//        val VIEW_TYPE_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON = 40
//        val VIEW_TYPE_IMAGE_THREE_ICON = 45
//        val VIEW_TYPE_IMAGE_THREE_ICON_VERTICAL = 50
//        val VIEW_TYPE_BACKGROUND_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON = 55
//        val VIEW_TYPE_IMAGE_HEADLINE_THREE_ICON = 60
//        val VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON = 65
//        val VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON_SMALL = 70
//        val VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON_LARGE = 75
//    }
}
