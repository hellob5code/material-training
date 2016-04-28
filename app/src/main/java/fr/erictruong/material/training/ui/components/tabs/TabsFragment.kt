package fr.erictruong.material.training.ui.components.tabs

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.HeadlineBodySixButtonItem
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.android.core.util.ThemeUtils
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import java.util.*

class TabsFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val colorPrimary = ThemeUtils.obtainColorPrimary(ctx)

        val cards = ArrayList<MaterialCardItem>()
        cards.add(DisplayBodyItem(
                display = getString(R.string.tabs), displayColor = colorPrimary,
                body = getString(R.string.tabs_txt), bodyAppearance = R.style.TextAppearance_AppCompat_Body2))
        cards.add(HeadlineBodySixButtonItem(
                headline = "Fixed tabs", headlineColor = colorPrimary,
                button1 = "Default app bar and fixed tab bar", button1Action = { ctx.startActivity<FixedTabBarActivity>() },
                button2 = "Extended app bar and fixed tab bar", button2Action = { ctx.startActivity<ExtendedAppBarTabBarActivity>() },
                button3 = "Fixed tab bar pinned to top with scrolled content", button3Action = { ctx.startActivity<PinnedTabBarActivity>() },
                button4 = "Inset search, app bar, and fixed tab bar", // TODO: Write and start InsetSearchTabBarActivity.
                button5 = "Text color is the same as the tab indicator", button5Action = { ctx.startActivity<ColoredTabBarActivity>() }))
        cards.add(HeadlineBodySixButtonItem(
                headline = "Scrollable tabs", headlineColor = colorPrimary,
                button1 = "Default app bar and scrollable tab bar", button1Action = { ctx.startActivity<ScrollableTabBarActivity>() }))
        cards.add(HeadlineBodySixButtonItem(
                headline = "Tabs with icons", headlineColor = colorPrimary,
                button1 = "Default app bar and fixed tab bar with icons", button1Action = { ctx.startActivity<FixedTabBarIconsActivity>() },
                button2 = "Icon color is the same as the tab indicator", button2Action = { ctx.startActivity<ColoredTabBarIconsActivity>() }))

        adapter.swapData(cards)
    }
}
