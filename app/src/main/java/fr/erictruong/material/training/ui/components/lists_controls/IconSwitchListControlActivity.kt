package fr.erictruong.material.training.ui.components.lists_controls

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import fr.erictruong.android.cards.Bindable
import fr.erictruong.android.core.activity.RecyclerActivity
import fr.erictruong.android.lists.holder.IconSwitchViewHolder
import fr.erictruong.android.lists.stub.*
import fr.erictruong.material.training.domain.DummyModel
import java.util.*

class IconSwitchListControlActivity : RecyclerActivity() {

    companion object {
        val KEY_ITEMS = "key_items"
    }

    var items = ArrayList<DummyModel>()
    val adapter = IconSwitchAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(this)
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
        outState?.putParcelableArrayList(KEY_ITEMS, items)
    }

    class IconSwitchAdapter() : RecyclerView.Adapter<ViewHolder>() {

        var dataset = mutableListOf<DummyModel>()

        fun swapData(items: List<DummyModel>) {
            dataset.addAll(items)
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int = dataset.size

        override fun getItemId(position: Int): Long = dataset[position].id

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? = ViewHolder(parent, viewType)

        override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(dataset[position])

        override fun onViewRecycled(holder: ViewHolder) = holder.unbind()
    }

    class ViewHolder : IconSwitchViewHolder, Bindable<DummyModel> {

        val actionStub: ActionStub
        val textStub: TextStub
        val iconStub: IconStub
        val switchStub: SwitchStub

        constructor(parent: ViewGroup, viewType: Int) : super(parent, viewType) {
            actionStub = ActionStub(itemView)
            textStub = TextStub(text1)
            iconStub = IconStub(icon)
            switchStub = SwitchStub(toggle)
        }

        override fun bind(item: DummyModel) {
            actionStub.bind { v -> Snackbar.make(v, "Action - id=${item.id}", Snackbar.LENGTH_SHORT).show() }
            switchStub.bind(item.isSelected) { buttonView, isChecked ->
                item.isSelected = isChecked
                Snackbar.make(buttonView, "Secondary action - id=${item.id}", Snackbar.LENGTH_SHORT).show()
            }
            // TODO: Bind holder to item.
        }

        override fun unbind() {
            actionStub.unbind()
            switchStub.unbind()
            // TODO: Unbind holder.
        }
    }
}
