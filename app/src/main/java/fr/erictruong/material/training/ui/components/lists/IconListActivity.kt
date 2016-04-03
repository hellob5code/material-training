package fr.erictruong.material.training.ui.components.lists

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import fr.erictruong.android.core.activity.RecyclerActivity
import fr.erictruong.android.lists.MaterialListAdapter
import fr.erictruong.android.lists.holder.IconViewHolder
import fr.erictruong.android.lists.holder.MaterialListHolder.Companion.ONE_LINE
import fr.erictruong.android.lists.holder.MaterialListHolder.Companion.THREE_LINE
import fr.erictruong.android.lists.holder.MaterialListHolder.Companion.TWO_LINE
import fr.erictruong.android.lists.item.IconItem
import fr.erictruong.android.lists.item.MaterialListItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.data.DummyModel
import java.util.*

class IconListActivity : RecyclerActivity() {

    val itemCount = 42

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = MaterialListAdapter<IconViewHolder>()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val viewType = intent.getIntExtra("extra_list_view_type", -1)

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
            ONE_LINE -> return IconItem(
                    id = model.id,
                    icon = R.drawable.gray,
                    text1 = "Single-line item",
                    action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })
            TWO_LINE -> return IconItem(
                    id = model.id,
                    viewType = TWO_LINE,
                    icon = R.drawable.gray,
                    text1 = "Two-line item",
                    text2 = model.text2,
                    action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })
            THREE_LINE -> return IconItem(
                    id = model.id,
                    viewType = THREE_LINE,
                    icon = R.drawable.gray,
                    text1 = "Three-line item",
                    text2 = model.text2,
                    text3 = model.text3,
                    action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })
            else -> throw IllegalArgumentException("Unknown view type: " + viewType)
        }
    }
}
