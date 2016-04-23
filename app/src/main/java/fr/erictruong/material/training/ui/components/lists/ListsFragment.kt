package fr.erictruong.material.training.ui.components.lists

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_DISPLAY1_PRIMARY_BODY2
import fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON
import fr.erictruong.android.cards.MaterialCardItem
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.HeadlineBodyItem
import fr.erictruong.android.lists.holder.Holder
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import java.util.*

class ListsFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cards = ArrayList<MaterialCardItem>()
        cards.add(DisplayBodyItem.Builder()
                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
                .display(getString(R.string.lists))
                .body(getString(R.string.lists_txt))
                .build())
        cards.add(HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Text only")
                .button1("Single-line") { ctx.startActivity<TextListActivity>(TextListActivity.LIST_VIEW_TYPE to Holder.ONE_LINE) }
                .button2("Two-line") { ctx.startActivity<TextListActivity>(TextListActivity.LIST_VIEW_TYPE to Holder.TWO_LINE) }
                .button3("Three-line") { ctx.startActivity<TextListActivity>(TextListActivity.LIST_VIEW_TYPE to Holder.THREE_LINE) }
                .build())
        cards.add(HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Icon with text")
                .button1("Single-line") { ctx.startActivity<IconListActivity>(IconListActivity.LIST_VIEW_TYPE to Holder.ONE_LINE) }
                .button2("Two-line") { ctx.startActivity<IconListActivity>(IconListActivity.LIST_VIEW_TYPE to Holder.TWO_LINE) }
                .button3("Three-line") { ctx.startActivity<IconListActivity>(IconListActivity.LIST_VIEW_TYPE to Holder.THREE_LINE) }
                .build())
        cards.add(HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Avatar with text")
                .button1("Single-line") { ctx.startActivity<AvatarListActivity>(AvatarListActivity.LIST_VIEW_TYPE to Holder.ONE_LINE) }
                .button2("Two-line") { ctx.startActivity<AvatarListActivity>(AvatarListActivity.LIST_VIEW_TYPE to Holder.TWO_LINE) }
                .button3("Three-line") { ctx.startActivity<AvatarListActivity>(AvatarListActivity.LIST_VIEW_TYPE to Holder.THREE_LINE) }
                .build())
        cards.add(HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Avatar with text and icon")
                .button1("Single-line") { ctx.startActivity<AvatarIconListActivity>(AvatarIconListActivity.LIST_VIEW_TYPE to Holder.ONE_LINE) }
                .button2("Two-line") { ctx.startActivity<AvatarIconListActivity>(AvatarIconListActivity.LIST_VIEW_TYPE to Holder.TWO_LINE) }
                .button3("Three-line") { ctx.startActivity<AvatarIconListActivity>(AvatarIconListActivity.LIST_VIEW_TYPE to Holder.THREE_LINE) }
                .build())

        adapter.swapData(cards)
    }
}
