package fr.erictruong.material.training.ui.components.tabs

import android.os.Bundle
import android.view.View

import java.util.ArrayList

import fr.erictruong.android.cards.MaterialCardItem
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.HeadlineBodyItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment

import fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_DISPLAY1_PRIMARY_BODY2
import fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.startActivity

class TabsFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cards = ArrayList<MaterialCardItem>()
        cards.add(DisplayBodyItem.Builder()
                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
                .display(getString(R.string.tabs))
                .body(getString(R.string.tabs_txt))
                .build())
        cards.add(HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON)
                .headline("Fixed tabs")
                .button1("Default app bar and fixed tab bar") { ctx.startActivity<FixedTabBarActivity>() }
                .button2("Extended app bar and fixed tab bar") { ctx.startActivity<ExtendedAppBarTabBarActivity>() }
                .button3("Fixed tab bar pinned to top with scrolled content") { ctx.startActivity<PinnedTabBarActivity>() }
                .button4("Inset search, app bar, and fixed tab bar", null) // TODO: Write and start InsetSearchTabBarActivity.
                .button5("Text color is the same as the tab indicator") { ctx.startActivity<ColoredTabBarActivity>() }
                .build())
        cards.add(HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON)
                .headline("Scrollable tabs")
                .button1("Default app bar and scrollable tab bar") { ctx.startActivity<ScrollableTabBarActivity>() }
                .build())
        cards.add(HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON)
                .headline("Tabs with icons")
                .button1("Default app bar and fixed tab bar with icons") { ctx.startActivity<FixedTabBarIconsActivity>() }
                .button2("Icon color is the same as the tab indicator") { ctx.startActivity<ColoredTabBarIconsActivity>() }
                .build())

        adapter.swapData(cards)
    }
}