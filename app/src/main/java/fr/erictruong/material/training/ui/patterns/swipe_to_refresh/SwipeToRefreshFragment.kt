package fr.erictruong.material.training.ui.patterns.swipe_to_refresh

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
import java.util.*

class SwipeToRefreshFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cards = ArrayList<MaterialCardItem>()
        // display1_primary body2
        cards.add(DisplayBodyItem(display = getString(R.string.swipe_to_refresh)))
//        cards.add(DisplayBodyItem.Builder()
//                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
//                .display(getString(R.string.swipe_to_refresh))
//                .build())
//        cards.add(HeadlineBodyItem.Builder()
//                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON)
//                .headline(getString(R.string.swipe_to_refresh_swipe_to_refresh))
//                .button1("Sample") {
//                    ctx.startActivity<SampleSwipeToRefreshActivity>()
//                }
//                .build())

        adapter.swapData(cards)
    }
}
