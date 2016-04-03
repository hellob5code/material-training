package fr.erictruong.material.training.ui.components.lists_controls

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import fr.erictruong.android.core.activity.RecyclerActivity
import fr.erictruong.android.lists.MaterialListAdapter
import fr.erictruong.android.lists.holder.AvatarCheckBoxViewHolder
import fr.erictruong.android.lists.item.AvatarCheckBoxItem
import fr.erictruong.android.lists.item.MaterialListItem
import fr.erictruong.material.training.data.DummyModel
import java.util.*

class AvatarCheckboxListControlActivity : RecyclerActivity() {

    val itemCount = 42
    val objectModel = DummyModel(0, "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = MaterialListAdapter<AvatarCheckBoxViewHolder>()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = ArrayList<MaterialListItem>(itemCount)
        for (i in 0..itemCount - 1) {
            val item = AvatarCheckBoxItem(
                    id = i.toLong(),
                    avatarUrl = objectModel.avatarUrl,
                    text1 = objectModel.text1,
                    action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() },
                    checkAction = { v, item -> Snackbar.make(recyclerView, "Secondary action - " + item, Snackbar.LENGTH_SHORT).show() })
            items.add(item)
        }
        adapter.swapData(items)
    }
}
