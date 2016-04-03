package fr.erictruong.material.training.ui.components.subheaders

import android.os.Bundle
import android.view.View

import java.util.ArrayList

import fr.erictruong.android.cards.MaterialCardItem
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.HeadlineBodyItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment

import fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_DISPLAY1_PRIMARY_BODY2
import fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx

class SubheadersFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cards = ArrayList<MaterialCardItem>()
        cards.add(DisplayBodyItem.Builder()
                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
                .display(getString(R.string.subheaders))
                .body(getString(R.string.subheaders_txt))
                .build())
        cards.add(HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("List subheaders")
                .button1("Sample") { ctx.startActivity<SampleListSubheaderActivity>() }
                .build())

        adapter.swapData(cards)
    }
}
