package fr.erictruong.material.training.ui.components.lists_controls

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
import fr.erictruong.android.lists.OnCheckActionListener
import fr.erictruong.android.lists.item.IconSwitchItem
import fr.erictruong.android.lists.item.MaterialListItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.model.DummyModel

class IconSwitchListControlActivity : RecyclerActivity() {

    var itemCount = 42
    var objectModel = DummyModel(0, "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = recyclerView

        val adapter = MaterialListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = ArrayList<MaterialListItem>(itemCount)
        for (i in 0..itemCount - 1) {
            val item = IconSwitchItem.Builder()
                    .id(i.toLong())
                    .icon(R.drawable.gray)
                    .text1(objectModel.text1)
                    .action { v, item -> Snackbar.make(getRecyclerView(), "Action #" + item.id, Snackbar.LENGTH_SHORT).show() }
                    .actionSecondary { v, item -> Snackbar.make(getRecyclerView(), "Secondary action #" + item.id, Snackbar.LENGTH_SHORT).show() }
                    .build()
            items.add(item)
        }
        adapter.swapData(items)
    }
}
