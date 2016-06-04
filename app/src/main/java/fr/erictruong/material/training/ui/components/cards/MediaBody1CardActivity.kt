package fr.erictruong.material.training.ui.components.cards

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import fr.erictruong.android.cards.Bindable
import fr.erictruong.android.cards.decorator.ListSpacingItemDecoration
import fr.erictruong.android.cards.holder.MediaBody1ViewHolder
import fr.erictruong.android.core.activity.RecyclerActivity
import fr.erictruong.material.training.R
import org.jetbrains.anko.dimen

class MediaBody1CardActivity : RecyclerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(ListSpacingItemDecoration(dimen(R.dimen.margin_small)))
        recyclerView.adapter = Adapter()
    }

    class Adapter : RecyclerView.Adapter<ViewHolder>() {

        override fun getItemCount(): Int = 24

        override fun getItemId(position: Int): Long = position.toLong()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
            return ViewHolder(parent, viewType)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(position)
        }
    }

    class ViewHolder(parent: ViewGroup, viewType: Int) : MediaBody1ViewHolder(parent, viewType), Bindable<Int> {

        override fun bind(item: Int) {
            // TODO: Bind holder to item.
        }

        override fun unbind() {
            // TODO: Unbind holder.
        }
    }
}

