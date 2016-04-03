package fr.erictruong.material.training.ui.components.lists_controls

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import fr.erictruong.android.core.activity.RecyclerActivity
import fr.erictruong.android.lists.MaterialListAdapter
import fr.erictruong.android.lists.item.AvatarReorderItem
import fr.erictruong.android.lists.item.MaterialListItem
import fr.erictruong.material.training.model.DummyModel
import java.util.*

class AvatarReorderListControlActivity : RecyclerActivity() {

    val itemCount = 42
    val objectModel = DummyModel(0, "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = MaterialListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemTouchHelper = ItemTouchHelper(ReorderItemTouchHelperCallback(adapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)

        val items = ArrayList<MaterialListItem>(itemCount)
        for (i in 0..itemCount - 1) {
            val item = AvatarReorderItem(
                    id = i.toLong(),
                    avatarUrl = objectModel.avatarUrl,
                    text1 = objectModel.text1 + " #" + i,
                    action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() },
                    itemTouchHelper = itemTouchHelper)
            items.add(item)
        }
        adapter.swapData(items)
    }

    inner class ReorderItemTouchHelperCallback(private val adapter: MaterialListAdapter) : ItemTouchHelper.Callback() {

        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
            val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
            return ItemTouchHelper.Callback.makeMovementFlags(dragFlags, 0)
        }

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            if (viewHolder.itemViewType != target.itemViewType) {
                return false
            }

            // Notify the adapter of the move
            adapter.moveItem(viewHolder.adapterPosition, target.adapterPosition)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            // Not supported
        }

        override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
            // We only want the active item to change
            if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                // TODO: Change background appearance.
                // viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
            }
            super.onSelectedChanged(viewHolder, actionState)
        }

        override fun clearView(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder) {
            super.clearView(recyclerView, viewHolder)
            // TODO: Restore default background appearance.
            // viewHolder.itemView.setBackgroundColor(0);
        }

    }
}
