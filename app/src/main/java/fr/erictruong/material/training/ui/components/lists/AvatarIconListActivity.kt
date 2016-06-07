package fr.erictruong.material.training.ui.components.lists

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import fr.erictruong.android.cards.Bindable
import fr.erictruong.android.core.activity.RecyclerActivity
import fr.erictruong.android.lists.holder.AvatarIconViewHolder
import fr.erictruong.android.lists.stub.ActionStub
import fr.erictruong.android.lists.stub.AvatarStub
import fr.erictruong.android.lists.stub.IconStub
import fr.erictruong.android.lists.stub.TextStub

class AvatarIconListActivity : RecyclerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AvatarIconAdapter(intent.getIntExtra("extra_list_view_type", 0))
    }

    class AvatarIconAdapter(val viewType: Int = 0) : RecyclerView.Adapter<ViewHolder>() {

        override fun getItemCount(): Int = 24

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getItemViewType(position: Int): Int = viewType

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? = ViewHolder(parent, viewType)

        override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)
    }

    class ViewHolder : AvatarIconViewHolder, Bindable<Int> {

        val actionStub: ActionStub
        val textStub: TextStub
        val avatarStub: AvatarStub
        val iconStub: IconStub

        constructor(parent: ViewGroup, viewType: Int) : super(parent, viewType) {
            actionStub = ActionStub(itemView)
            textStub = TextStub(text1, text2, text3)
            avatarStub = AvatarStub(avatar)
            iconStub = IconStub(icon)
        }

        override fun bind(item: Int) {
            actionStub.bind { v -> Snackbar.make(v, "Action - id=$item", Snackbar.LENGTH_SHORT).show() }
            // TODO: Bind holder to item.
        }

        override fun unbind() {
            actionStub.unbind()
            // TODO: Unbind holder.
        }
    }
}
