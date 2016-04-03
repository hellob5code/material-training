package fr.erictruong.material.training.ui.components.toolbars

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.erictruong.material.training.R
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.nestedScrollView

class ToolbarsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ToolbarsFragmentUI().createView(AnkoContext.create(context, this))
    }
}

class ToolbarsFragmentUI : AnkoComponent<Fragment> {

    override fun createView(ui: AnkoContext<Fragment>) = with(ui) {
        nestedScrollView {
            verticalLayout {
                padding = dimen(R.dimen.padding_medium)
                bottomPadding += dimen(R.dimen.action_bar_size)
                textView("Labels")
                button("Toolbar above another sheet") { onClick { /*ctx.startActivity<ToolbarAboveActivity>()*/ } }.enabled = false
                button("Toolbar on another sheet") { onClick { /*ctx.startActivity<ToolbarSameLevelActivity>()*/ } }.enabled = false
                button("Second sheet covers the toolbar") { onClick { /*ctx.startActivity<ToolbarBelowActivity>()*/ } }.enabled = false
            }
        }
    }
}
