package fr.erictruong.material.training.ui.components.lists_controls

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import fr.erictruong.android.core.activity.RecyclerActivity
import fr.erictruong.android.lists.MaterialListAdapter
import fr.erictruong.android.lists.item.CheckBoxIconItem
import fr.erictruong.android.lists.item.MaterialListItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.model.DummyModel
import java.util.*

class CheckboxIconListControlActivity : RecyclerActivity() {

    val itemCount = 42
    val objectModel = DummyModel(0, "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = MaterialListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = ArrayList<MaterialListItem>(itemCount)
        for (i in 0..itemCount - 1) {
            val item = CheckBoxIconItem(
                    id = i.toLong(),
                    icon = R.drawable.ic_message_24dp_alpha54,
                    text1 = objectModel.text1,
                    action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() },
                    checkAction = { v, item -> Snackbar.make(recyclerView, "Primary action - " + item, Snackbar.LENGTH_SHORT).show() })
            items.add(item)
        }
        adapter.swapData(items)
    }
}
