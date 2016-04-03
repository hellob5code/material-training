package fr.erictruong.material.training.ui.components.lists

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import java.util.ArrayList

import fr.erictruong.android.core.activity.RecyclerActivity
import fr.erictruong.android.lists.MaterialListAdapter
import fr.erictruong.android.lists.OnActionListener
import fr.erictruong.android.lists.item.AvatarIconItem
import fr.erictruong.android.lists.item.AvatarItem
import fr.erictruong.android.lists.item.IconItem
import fr.erictruong.android.lists.item.MaterialListItem
import fr.erictruong.android.lists.item.TextItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.model.DummyModel

import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_ICON
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_AVATAR
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_AVATAR_ICON
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_ICON
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_AVATAR
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_AVATAR_ICON
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_ICON

class SampleListActivity : RecyclerActivity() {

    companion object {
        val LIST_VIEW_TYPE = "extra_list_view_type"
        private val ITEM_COUNT = 42
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = recyclerView

        val adapter = MaterialListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val viewType = intent.getIntExtra(LIST_VIEW_TYPE, -1)

        val items = ArrayList<MaterialListItem>(ITEM_COUNT)
        for (i in 0..ITEM_COUNT - 1) {
            val dummyModel = DummyModel(i.toLong(), "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text")
            val item = mapItem(viewType, dummyModel)
            items.add(item)
        }
        adapter.swapData(items)
    }

    private fun mapItem(viewType: Int, model: DummyModel): MaterialListItem {
        when (viewType) {
            VIEW_TYPE_ONE_LINE -> return mapOneLineItem(viewType, model)
            VIEW_TYPE_ONE_LINE_ICON -> return mapOneLineIconItem(viewType, model)
            VIEW_TYPE_ONE_LINE_AVATAR -> return mapOneLineAvatarItem(viewType, model)
            VIEW_TYPE_ONE_LINE_AVATAR_ICON -> return mapOneLineAvatarIconItem(viewType, model)
            VIEW_TYPE_TWO_LINE -> return mapTwoLineItem(viewType, model)
            VIEW_TYPE_TWO_LINE_ICON -> return mapTwoLineIconItem(viewType, model)
            VIEW_TYPE_TWO_LINE_AVATAR -> return mapTwoLineAvatarItem(viewType, model)
            VIEW_TYPE_TWO_LINE_AVATAR_ICON -> return mapTwoLineAvatarIconItem(viewType, model)
            VIEW_TYPE_THREE_LINE -> return mapThreeLineItem(viewType, model)
            VIEW_TYPE_THREE_LINE_ICON -> return mapThreeLineIconItem(viewType, model)
            VIEW_TYPE_THREE_LINE_AVATAR -> return mapThreeLineAvatarItem(viewType, model)
            VIEW_TYPE_THREE_LINE_AVATAR_ICON -> return mapThreeLineAvatarIconItem(viewType, model)
            else -> throw IllegalArgumentException("Unknown view type: " + viewType)
        }
    }

    private fun mapOneLineItem(viewType: Int, model: DummyModel): MaterialListItem {
        return TextItem.Builder()
                .id(model.id)
                .text1("Single-line item")
                .action { v, item -> Snackbar.make(recyclerView, "Action #" + item.id, Snackbar.LENGTH_SHORT).show() }
                .build()
    }

    private fun mapOneLineIconItem(viewType: Int, model: DummyModel): MaterialListItem {
        return IconItem.Builder()
                .id(model.id)
                .icon(R.drawable.gray)
                .text1("Single-line item")
                .action { v, item -> Snackbar.make(recyclerView, "Action #" + item.id, Snackbar.LENGTH_SHORT).show() }
                .build()
    }

    private fun mapOneLineAvatarItem(viewType: Int, model: DummyModel): MaterialListItem {
        return AvatarItem.Builder()
                .id(model.id)
                .avatarUrl(model.avatarUrl)
                .text1("Single-line item")
                .action { v, item -> Snackbar.make(recyclerView, "Action #" + item.id, Snackbar.LENGTH_SHORT).show() }
                .build()
    }

    private fun mapOneLineAvatarIconItem(viewType: Int, model: DummyModel): MaterialListItem {
        return AvatarIconItem.Builder()
                .id(model.id)
                .avatarUrl(model.avatarUrl)
                .icon(R.drawable.gray).text1("Single-line item")
                .action { v, item -> Snackbar.make(recyclerView, "Action #" + item.id, Snackbar.LENGTH_SHORT).show() }
                .build()
    }

    private fun mapTwoLineItem(viewType: Int, model: DummyModel): MaterialListItem {
        return TextItem.Builder()
                .id(model.id)
                .viewType(viewType)
                .text1("Two-line item")
                .text2(model.text2)
                .action { v, item -> Snackbar.make(recyclerView, "Action #" + item.id, Snackbar.LENGTH_SHORT).show() }
                .build()
    }

    private fun mapTwoLineIconItem(viewType: Int, model: DummyModel): MaterialListItem {
        return IconItem.Builder()
                .id(model.id)
                .viewType(viewType)
                .icon(R.drawable.gray).text1("Two-line item")
                .text2(model.text2)
                .action { v, item -> Snackbar.make(recyclerView, "Action #" + item.id, Snackbar.LENGTH_SHORT).show() }
                .build()
    }

    private fun mapTwoLineAvatarItem(viewType: Int, model: DummyModel): MaterialListItem {
        return AvatarItem.Builder()
                .id(model.id)
                .viewType(viewType)
                .avatarUrl(model.avatarUrl)
                .text1("Two-line item")
                .text2(model.text2)
                .action { v, item -> Snackbar.make(recyclerView, "Action #" + item.id, Snackbar.LENGTH_SHORT).show() }
                .build()
    }

    private fun mapTwoLineAvatarIconItem(viewType: Int, model: DummyModel): MaterialListItem {
        return AvatarIconItem.Builder()
                .id(model.id)
                .viewType(viewType)
                .avatarUrl(model.avatarUrl)
                .icon(R.drawable.gray)
                .text1("Two-line item")
                .text2(model.text2)
                .action { v, item -> Snackbar.make(recyclerView, "Action #" + item.id, Snackbar.LENGTH_SHORT).show() }
                .build()
    }

    private fun mapThreeLineItem(viewType: Int, model: DummyModel): MaterialListItem {
        return TextItem.Builder()
                .id(model.id)
                .viewType(viewType)
                .text1("Three-line item")
                .text2(model.text2)
                .text3(model.text3)
                .action { v, item -> Snackbar.make(recyclerView, "Action #" + item.id, Snackbar.LENGTH_SHORT).show() }
                .build()
    }

    private fun mapThreeLineIconItem(viewType: Int, model: DummyModel): MaterialListItem {
        return IconItem.Builder()
                .id(model.id)
                .viewType(viewType)
                .icon(R.drawable.gray)
                .text1("Three-line item")
                .text2(model.text2)
                .text3(model.text3)
                .action { v, item -> Snackbar.make(recyclerView, "Action #" + item.id, Snackbar.LENGTH_SHORT).show() }
                .build()
    }

    private fun mapThreeLineAvatarItem(viewType: Int, model: DummyModel): MaterialListItem {
        return AvatarItem.Builder()
                .id(model.id)
                .viewType(viewType)
                .avatarUrl(model.avatarUrl)
                .text1("Three-line item")
                .text2(model.text2)
                .text3(model.text3)
                .action { v, item -> Snackbar.make(recyclerView, "Action #" + item.id, Snackbar.LENGTH_SHORT).show() }
                .build()
    }

    private fun mapThreeLineAvatarIconItem(viewType: Int, model: DummyModel): MaterialListItem {
        return AvatarIconItem.Builder()
                .id(model.id)
                .viewType(viewType)
                .avatarUrl(model.avatarUrl)
                .icon(R.drawable.gray)
                .text1("Three-line item")
                .text2(model.text2)
                .text3(model.text3)
                .action { v, item -> Snackbar.make(recyclerView, "Action #" + item.id, Snackbar.LENGTH_SHORT).show() }
                .build()
    }
}
