package fr.erictruong.material.training.ui.components.lists

import android.os.Bundle
import android.view.View

import java.util.ArrayList

import fr.erictruong.android.cards.MaterialCardItem
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.HeadlineBodyItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
import org.jetbrains.anko.startActivity

import fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_DISPLAY1_PRIMARY_BODY2
import fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_ICON
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_AVATAR
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_AVATAR_ICON
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_ICON
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_AVATAR
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_AVATAR_ICON
import fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_ICON
import fr.erictruong.material.training.ui.components.lists.SampleListActivity.Companion.LIST_VIEW_TYPE
import org.jetbrains.anko.support.v4.ctx

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
                .button1("Single-line") { ctx.startActivity<SampleListActivity>(LIST_VIEW_TYPE to VIEW_TYPE_ONE_LINE) }
                .button2("Two-line") { ctx.startActivity<SampleListActivity>(LIST_VIEW_TYPE to VIEW_TYPE_TWO_LINE) }
                .button3("Three-line") { ctx.startActivity<SampleListActivity>(LIST_VIEW_TYPE to VIEW_TYPE_THREE_LINE) }
                .build())
        cards.add(HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Icon with text")
                .button1("Single-line") { ctx.startActivity<SampleListActivity>(LIST_VIEW_TYPE to VIEW_TYPE_ONE_LINE_ICON) }
                .button2("Two-line") { ctx.startActivity<SampleListActivity>(LIST_VIEW_TYPE to VIEW_TYPE_TWO_LINE_ICON) }
                .button3("Three-line") { ctx.startActivity<SampleListActivity>(LIST_VIEW_TYPE to VIEW_TYPE_THREE_LINE_ICON) }
                .build())
        cards.add(HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Avatar with text")
                .button1("Single-line") { ctx.startActivity<SampleListActivity>(LIST_VIEW_TYPE to VIEW_TYPE_ONE_LINE_AVATAR) }
                .button2("Two-line") { ctx.startActivity<SampleListActivity>(LIST_VIEW_TYPE to VIEW_TYPE_TWO_LINE_AVATAR) }
                .button3("Three-line") { ctx.startActivity<SampleListActivity>(LIST_VIEW_TYPE to VIEW_TYPE_THREE_LINE_AVATAR) }
                .build())
        cards.add(HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Avatar with text and icon")
                .button1("Single-line") { ctx.startActivity<SampleListActivity>(LIST_VIEW_TYPE to VIEW_TYPE_ONE_LINE_AVATAR_ICON) }
                .button2("Two-line") { ctx.startActivity<SampleListActivity>(LIST_VIEW_TYPE to VIEW_TYPE_TWO_LINE_AVATAR_ICON) }
                .button3("Three-line") { ctx.startActivity<SampleListActivity>(LIST_VIEW_TYPE to VIEW_TYPE_THREE_LINE_AVATAR_ICON) }
                .build())

        adapter.swapData(cards)
    }
}
