package fr.erictruong.material.training.ui.components.tabs

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.erictruong.material.training.R
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.nestedScrollView

class TabsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return TabsFragmentUI().createView(AnkoContext.create(context, this))
    }
}

class TabsFragmentUI : AnkoComponent<Fragment> {

    override fun createView(ui: AnkoContext<Fragment>) = with(ui) {
        nestedScrollView {
            verticalLayout {
                padding = dimen(R.dimen.padding_medium)
                bottomPadding += dimen(R.dimen.action_bar_size)
                textView("Fixed tabs")
                button("Default app bar and fixed tab bar") { onClick { ctx.startActivity<FixedTabBarActivity>() } }
                button("Extended app bar and fixed tab bar") { onClick { ctx.startActivity<ExtendedAppBarTabBarActivity>() } }
                button("Fixed tab bar pinned to top with scrolled content") { onClick { ctx.startActivity<PinnedTabBarActivity>() } }
                button("Inset search, app bar, and fixed tab bar") { onClick { /*ctx.startActivity<FixedTabBarActivity>()*/ } }.enabled = false
                button("Text color is the same as the tab indicator") { onClick { ctx.startActivity<ColoredTabBarActivity>() } }
                textView("Scrollable tabs")
                button("Default app bar and scrollable tab bar") { onClick { ctx.startActivity<ScrollableTabBarActivity>() } }
                textView("Tabs with icons")
                button("Default app bar and fixed tab bar with icons") { onClick { ctx.startActivity<FixedTabBarIconsActivity>() } }
                button("Icon color is the same as the tab indicator") { onClick { ctx.startActivity<ColoredTabBarIconsActivity>() } }
            }
        }
    }
}
