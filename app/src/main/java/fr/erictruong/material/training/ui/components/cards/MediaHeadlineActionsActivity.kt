package fr.erictruong.material.training.ui.components.cards

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import fr.erictruong.android.cards.Bindable
import fr.erictruong.android.cards.decorator.GridSpacingItemDecoration
import fr.erictruong.android.cards.holder.MediaHeadlineActionsViewHolder
import fr.erictruong.android.core.activity.RecyclerActivity
import fr.erictruong.material.training.R
import org.jetbrains.anko.dimen

class MediaHeadlineActionsActivity : RecyclerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val spanCount = 2
        recyclerView.layoutManager = GridLayoutManager(this, spanCount)
        recyclerView.addItemDecoration(GridSpacingItemDecoration(spanCount, dimen(R.dimen.margin_small), true))
        recyclerView.adapter = Adapter()
    }

    class Adapter() : RecyclerView.Adapter<ViewHolder>() {

        override fun getItemCount(): Int = 24

        override fun getItemId(position: Int): Long = position.toLong()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
            return ViewHolder(parent, viewType)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(position)
        }
    }

    class ViewHolder(parent: ViewGroup, viewType: Int) : MediaHeadlineActionsViewHolder(parent, viewType), Bindable<Int> {

        override fun bind(item: Int) {
            action1.setOnClickListener { v -> Snackbar.make(v, "Action 1 - id=$item", Snackbar.LENGTH_SHORT).show() }
            action2.setOnClickListener { v -> Snackbar.make(v, "Action 2 - id=$item", Snackbar.LENGTH_SHORT).show() }
            action3.setOnClickListener { v -> Snackbar.make(v, "Action 3 - id=$item", Snackbar.LENGTH_SHORT).show() }
            // TODO: Bind holder to item.
        }

        override fun unbind() {
            // TODO: Unbind holder.
        }
    }
}
