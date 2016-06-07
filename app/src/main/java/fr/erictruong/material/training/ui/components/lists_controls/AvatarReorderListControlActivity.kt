package fr.erictruong.material.training.ui.components.lists_controls

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.ViewGroup
import fr.erictruong.android.cards.Bindable
import fr.erictruong.android.core.activity.RecyclerActivity
import fr.erictruong.android.lists.holder.AvatarReorderViewHolder
import fr.erictruong.android.lists.stub.ActionStub
import fr.erictruong.android.lists.stub.AvatarStub
import fr.erictruong.android.lists.stub.ReorderStub
import fr.erictruong.android.lists.stub.TextStub
import fr.erictruong.material.training.domain.DummyModel
import java.util.*

class AvatarReorderListControlActivity : RecyclerActivity() {

    companion object {
        val KEY_ITEMS = "key_items"
    }

    var items = ArrayList<DummyModel>()
    val adapter = AvatarReorderAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.itemTouchHelper.attachToRecyclerView(recyclerView)
        recyclerView.adapter = adapter

        if (savedInstanceState == null) {
            (0..24).forEach { i -> items.add(DummyModel(i.toLong())) }
            adapter.swapData(items)
        } else {
            items = savedInstanceState.getParcelableArrayList<DummyModel>(KEY_ITEMS)
            adapter.swapData(items)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelableArrayList(KEY_ITEMS, adapter.dataset)
    }

    class AvatarReorderAdapter() : RecyclerView.Adapter<ViewHolder>() {

        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {

            override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
                val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
                return ItemTouchHelper.Callback.makeMovementFlags(dragFlags, 0)
            }

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                if (viewHolder.itemViewType != target.itemViewType) {
                    return false
                }

                // Notify the adapter of the move
                moveItem(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                // Not supported
            }

            override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
                // We only want the active item to change
                if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                    // TODO: Change background appearance.
//                     viewHolder?.itemView?.setBackgroundResource(R.color.primary_dark);
//                    viewHolder?.itemView?.setBackgroundColor(Color.RED)
//                    viewHolder?.itemView?.elevation = 100f
                }
                super.onSelectedChanged(viewHolder, actionState)
            }

            override fun clearView(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?) {
                super.clearView(recyclerView, viewHolder)
                // TODO: Restore default background appearance.
//                 viewHolder?.itemView?.setBackgroundResource(0);
//                viewHolder?.itemView?.elevation = 0f
            }
        })

        var dataset = ArrayList<DummyModel>()

        fun swapData(items: List<DummyModel>) {
            dataset.addAll(items)
            notifyDataSetChanged()
        }

        fun moveItem(fromPosition: Int, toPosition: Int) {
            Collections.swap(dataset, fromPosition, toPosition)
            notifyItemMoved(fromPosition, toPosition)
        }

        override fun getItemCount(): Int = dataset.size

        override fun getItemId(position: Int): Long = dataset[position].id

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? = ViewHolder(parent, viewType, itemTouchHelper)

        override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(dataset[position])

        override fun onViewRecycled(holder: ViewHolder) = holder.unbind()
    }

    class ViewHolder : AvatarReorderViewHolder, Bindable<DummyModel> {

        val actionStub: ActionStub
        val textStub: TextStub
        val avatarStub: AvatarStub
        val reorderStub: ReorderStub

        constructor(parent: ViewGroup, viewType: Int, itemTouchHelper: ItemTouchHelper) : super(parent, viewType) {
            actionStub = ActionStub(itemView)
            textStub = TextStub(text1)
            avatarStub = AvatarStub(avatar)
            itemView.setBackgroundColor(Color.WHITE)
            reorderStub = ReorderStub(icon, itemTouchHelper)
        }

        override fun bind(item: DummyModel) {
            actionStub.bind { v -> Snackbar.make(v, "Action - id=${item.id}", Snackbar.LENGTH_SHORT).show() }
            textStub.bind("${text1.text} #${item.id}")
            reorderStub.bind(this)
            // TODO: Bind holder to item.
        }

        override fun unbind() {
            // TODO: Unbind holder.
        }
    }
}
