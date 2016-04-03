package fr.erictruong.material.training.ui.components.lists

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import fr.erictruong.android.core.activity.RecyclerActivity
import fr.erictruong.android.lists.MaterialListAdapter
import fr.erictruong.android.lists.item.AvatarIconItem
import fr.erictruong.android.lists.item.AvatarItem
import fr.erictruong.android.lists.item.IconItem
import fr.erictruong.android.lists.item.MaterialListItem
import fr.erictruong.android.lists.item.TextItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.model.DummyModel
import java.util.*

class SampleListActivity : RecyclerActivity() {

    companion object {
        val LIST_VIEW_TYPE = "extra_list_view_type"
    }

    val itemCount = 42

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = recyclerView

        val adapter = MaterialListAdapter()
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
            MaterialListAdapter.VIEW_TYPE_ONE_LINE -> return mapOneLineItem(viewType, model)
            MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON -> return mapOneLineIconItem(viewType, model)
            MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR -> return mapOneLineAvatarItem(viewType, model)
            MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_ICON -> return mapOneLineAvatarIconItem(viewType, model)

            MaterialListAdapter.VIEW_TYPE_TWO_LINE -> return mapTwoLineItem(viewType, model)
            MaterialListAdapter.VIEW_TYPE_TWO_LINE_ICON -> return mapTwoLineIconItem(viewType, model)
            MaterialListAdapter.VIEW_TYPE_TWO_LINE_AVATAR -> return mapTwoLineAvatarItem(viewType, model)
            MaterialListAdapter.VIEW_TYPE_TWO_LINE_AVATAR_ICON -> return mapTwoLineAvatarIconItem(viewType, model)

            MaterialListAdapter.VIEW_TYPE_THREE_LINE -> return mapThreeLineItem(viewType, model)
            MaterialListAdapter.VIEW_TYPE_THREE_LINE_ICON -> return mapThreeLineIconItem(viewType, model)
            MaterialListAdapter.VIEW_TYPE_THREE_LINE_AVATAR -> return mapThreeLineAvatarItem(viewType, model)
            MaterialListAdapter.VIEW_TYPE_THREE_LINE_AVATAR_ICON -> return mapThreeLineAvatarIconItem(viewType, model)

            else -> throw IllegalArgumentException("Unknown view type: " + viewType)
        }
    }

    private fun mapOneLineItem(viewType: Int, model: DummyModel): MaterialListItem = TextItem(
            id = model.id,
            text1 = "Single-line item",
            action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })

    private fun mapOneLineIconItem(viewType: Int, model: DummyModel): MaterialListItem = IconItem(
            id = model.id,
            icon = R.drawable.gray,
            text1 = "Single-line item",
            action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })

    private fun mapOneLineAvatarItem(viewType: Int, model: DummyModel): MaterialListItem = AvatarItem(
            id = model.id,
            avatarUrl = model.avatarUrl,
            text1 = "Single-line item",
            action = { v, item -> Snackbar.make(recyclerView, "Action #" + item, Snackbar.LENGTH_SHORT).show() })

    private fun mapOneLineAvatarIconItem(viewType: Int, model: DummyModel): MaterialListItem = AvatarIconItem(
            id = model.id,
            avatarUrl = model.avatarUrl,
            icon = R.drawable.gray,
            text1 = "Single-line item",
            action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })

    private fun mapTwoLineItem(viewType: Int, model: DummyModel): MaterialListItem = TextItem(
            id = model.id,
            viewType = viewType,
            text1 = "Two-line item",
            text2 = model.text2,
            action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })

    private fun mapTwoLineIconItem(viewType: Int, model: DummyModel): MaterialListItem = IconItem(
            id = model.id,
            viewType = viewType,
            icon = R.drawable.gray,
            text1 = "Two-line item",
            text2 = model.text2,
            action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })

    private fun mapTwoLineAvatarItem(viewType: Int, model: DummyModel): MaterialListItem = AvatarItem(
            id = model.id,
            viewType = viewType,
            avatarUrl = model.avatarUrl,
            text1 = "Two-line item",
            text2 = model.text2,
            action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })

    private fun mapTwoLineAvatarIconItem(viewType: Int, model: DummyModel): MaterialListItem = AvatarIconItem(
            id = model.id,
            viewType = viewType,
            avatarUrl = model.avatarUrl,
            icon = R.drawable.gray,
            text1 = "Two-line item",
            text2 = model.text2,
            action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })

    private fun mapThreeLineItem(viewType: Int, model: DummyModel): MaterialListItem = TextItem(
            id = model.id,
            viewType = viewType,
            text1 = "Three-line item",
            text2 = model.text2,
            text3 = model.text3,
            action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })

    private fun mapThreeLineIconItem(viewType: Int, model: DummyModel): MaterialListItem = IconItem(
            id = model.id,
            viewType = viewType,
            icon = R.drawable.gray,
            text1 = "Three-line item",
            text2 = model.text2,
            text3 = model.text3,
            action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })

    private fun mapThreeLineAvatarItem(viewType: Int, model: DummyModel): MaterialListItem = AvatarItem(
            id = model.id,
            viewType = viewType,
            avatarUrl = model.avatarUrl,
            text1 = "Three-line item",
            text2 = model.text2,
            text3 = model.text3,
            action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })

    private fun mapThreeLineAvatarIconItem(viewType: Int, model: DummyModel): MaterialListItem = AvatarIconItem(
            id = model.id,
            viewType = viewType,
            avatarUrl = model.avatarUrl,
            icon = R.drawable.gray,
            text1 = "Three-line item",
            text2 = model.text2,
            text3 = model.text3,
            action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })
}
