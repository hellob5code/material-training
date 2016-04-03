package fr.erictruong.material.training.ui.patterns.swipe_to_refresh

import android.os.Bundle
import android.view.View

import java.util.ArrayList
import org.jetbrains.anko.startActivity

import fr.erictruong.android.cards.MaterialCardItem
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.HeadlineBodyItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment

import fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_DISPLAY1_PRIMARY_BODY2
import fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON
import org.jetbrains.anko.support.v4.ctx

class SwipeToRefreshFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cards = ArrayList<MaterialCardItem>()
        cards.add(DisplayBodyItem.Builder()
                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
                .display(getString(R.string.swipe_to_refresh))
                .build())
        cards.add(HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON)
                .headline(getString(R.string.swipe_to_refresh_swipe_to_refresh))
                .button1("Sample") {
                    ctx.startActivity<SampleSwipeToRefreshActivity>()
                }
                .build())

        adapter.swapData(cards)
    }
}
