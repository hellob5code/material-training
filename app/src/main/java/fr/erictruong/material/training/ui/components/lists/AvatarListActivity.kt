package fr.erictruong.material.training.ui.components.lists

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import fr.erictruong.android.core.activity.RecyclerActivity
import fr.erictruong.android.lists.MaterialListAdapter
import fr.erictruong.android.lists.holder.AvatarViewHolder
import fr.erictruong.android.lists.holder.Holder
import fr.erictruong.android.lists.item.AvatarItem
import fr.erictruong.android.lists.item.MaterialListItem
import fr.erictruong.material.training.model.DummyModel
import java.util.*

class AvatarListActivity : RecyclerActivity() {

    companion object {
        val LIST_VIEW_TYPE = "extra_list_view_type"
    }

    val itemCount = 42

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = MaterialListAdapter<AvatarViewHolder>()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val viewType = intent.getIntExtra(LIST_VIEW_TYPE, -1)

        val items = ArrayList<MaterialListItem>(itemCount)
        for (i in 0..itemCount - 1) {
            val objectModel = DummyModel(i.toLong(), "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text")
            val item = mapItem(viewType, objectModel)
            items.add(item)
        }
        adapter.swapData(items)
    }

    /**
     * Map an object model into a list item holder.
     */
    private fun mapItem(viewType: Int, model: DummyModel): MaterialListItem {
        when (viewType) {
            Holder.ONE_LINE -> return mapOneLineItem(model)
            Holder.TWO_LINE -> return mapTwoLineItem(model)
            Holder.THREE_LINE -> return mapThreeLineItem(model)
            else -> throw IllegalArgumentException("Unknown view type: " + viewType)
        }
    }

    private fun mapOneLineItem(model: DummyModel): MaterialListItem = AvatarItem(
            id = model.id,
            avatarUrl = model.avatarUrl,
            text1 = "Single-line item",
            action = { v, item -> Snackbar.make(recyclerView, "Action #" + item, Snackbar.LENGTH_SHORT).show() })

    private fun mapTwoLineItem(model: DummyModel): MaterialListItem =  AvatarItem(
            id = model.id,
            viewType = Holder.TWO_LINE,
            avatarUrl = model.avatarUrl,
            text1 = "Two-line item",
            text2 = model.text2,
            action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })

    private fun mapThreeLineItem(model: DummyModel): MaterialListItem =  AvatarItem(
            id = model.id,
            viewType = Holder.THREE_LINE,
            avatarUrl = model.avatarUrl,
            text1 = "Three-line item",
            text2 = model.text2,
            text3 = model.text3,
            action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })
}
