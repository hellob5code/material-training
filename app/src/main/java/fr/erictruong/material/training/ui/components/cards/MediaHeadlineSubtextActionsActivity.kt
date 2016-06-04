package fr.erictruong.material.training.ui.components.cards

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import fr.erictruong.android.cards.Bindable
import fr.erictruong.android.cards.decorator.ListSpacingItemDecoration
import fr.erictruong.android.cards.holder.AvatarSubheaderMediaBody1ActionsViewHolder
import fr.erictruong.android.cards.holder.MediaHeadlineSubtextActionsViewHolder
import fr.erictruong.android.core.activity.RecyclerActivity
import fr.erictruong.material.training.R
import org.jetbrains.anko.dimen
import org.jetbrains.anko.find

class MediaHeadlineSubtextActionsActivity : RecyclerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(ListSpacingItemDecoration(dimen(R.dimen.margin_small)))

        val viewType = intent.getIntExtra("extra_card_view_type", -1)
        recyclerView.adapter = Adapter(viewType)
    }

    class Adapter(val viewType: Int = 0) : RecyclerView.Adapter<ViewHolder>() {

        override fun getItemCount(): Int = 24

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getItemViewType(position: Int): Int = viewType

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
            return ViewHolder(parent, viewType)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(position)
        }
    }

    class ViewHolder(parent: ViewGroup, viewType: Int) : MediaHeadlineSubtextActionsViewHolder(parent, viewType), Bindable<Int> {

        override fun bind(item: Int) {
            action1.setOnClickListener { v -> Snackbar.make(v, "Action 1 - id=$item", Snackbar.LENGTH_SHORT).show() }
            action2.setOnClickListener { v -> Snackbar.make(v, "Action 2 - id=$item", Snackbar.LENGTH_SHORT).show() }
            // TODO: Bind holder to item.
        }

        override fun unbind() {
            // TODO: Unbind holder.
        }
    }
}
