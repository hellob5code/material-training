package fr.erictruong.material.training.ui.components.lists_controls

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.erictruong.material.training.R
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.nestedScrollView

class ListsControlsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ListsControlsFragmentUI().createView(AnkoContext.create(context, this))
    }
}

class ListsControlsFragmentUI : AnkoComponent<Fragment> {

    override fun createView(ui: AnkoContext<Fragment>) = with(ui) {
        nestedScrollView {
            verticalLayout {
                padding = dimen(R.dimen.padding_medium)
                bottomPadding += dimen(R.dimen.action_bar_size)
                textView("Checkbox")
                button("Sample") { onClick { ctx.startActivity<CheckboxIconListControlActivity>() } }
                button("Alt") { onClick { ctx.startActivity<AvatarCheckboxListControlActivity>() } }
                textView("Switch")
                button("Sample") { onClick { ctx.startActivity<IconSwitchListControlActivity>() } }
                textView("Reorder")
                button("Sample") { onClick { ctx.startActivity<AvatarReorderListControlActivity>() } }
                textView("Expand/collapse")
                button("Sample") { onClick { ctx.startActivity<IconExpandListControlActivity>() } }
                textView("Leave-behinds")
                button("Sample") { onClick { /*ctx.startActivity<FixedTabBarActivity>()*/ } }.enabled = false // TODO: Write and start LeaveBehindsListControlActivity.
            }
        }
    }
}
