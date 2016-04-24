package fr.erictruong.material.training.ui.components.subheaders

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.android.core.util.ThemeUtils
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
import org.jetbrains.anko.support.v4.ctx
import java.util.*

class SubheadersFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val colorPrimary = ThemeUtils.obtainColorPrimary(ctx)

        val cards = ArrayList<MaterialCardItem>()
        cards.add(DisplayBodyItem(
                display = getString(R.string.subheaders), displayColor = colorPrimary,
                body = getString(R.string.subheaders_txt), bodyAppearance = R.style.TextAppearance_AppCompat_Body2))
//        cards.add(DisplayBodyItem.Builder()
//                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
//                .display(getString(R.string.subheaders))
//                .body(getString(R.string.subheaders_txt))
//                .build())
//        cards.add(HeadlineBodyItem.Builder()
//                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
//                .headline("List subheaders")
//                .button1("Sample") { ctx.startActivity<SampleListSubheaderActivity>() }
//                .build())

        adapter.swapData(cards)
    }
}
