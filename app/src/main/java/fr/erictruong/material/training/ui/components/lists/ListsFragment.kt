package fr.erictruong.material.training.ui.components.lists

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.erictruong.material.training.R
import fr.erictruong.android.lists.holder.MaterialListHolder.Companion.ONE_LINE
import fr.erictruong.android.lists.holder.MaterialListHolder.Companion.THREE_LINE
import fr.erictruong.android.lists.holder.MaterialListHolder.Companion.TWO_LINE
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.nestedScrollView

class ListsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ListsFragmentUI().createView(AnkoContext.create(context, this))
    }
}

class ListsFragmentUI : AnkoComponent<Fragment> {

    override fun createView(ui: AnkoContext<Fragment>) = with(ui) {
        nestedScrollView {
            verticalLayout {
                padding = dimen(R.dimen.padding_medium)
                bottomPadding += dimen(R.dimen.action_bar_size)
                textView("Text only")
                button("Single-line") { onClick { ctx.startActivity<TextListActivity>("extra_list_view_type" to ONE_LINE) } }
                button("Two-line") { onClick { ctx.startActivity<TextListActivity>("extra_list_view_type" to TWO_LINE) } }
                button("Three-line") { onClick { ctx.startActivity<TextListActivity>("extra_list_view_type" to THREE_LINE) } }
                textView("Icon with text")
                button("Single-line") { onClick { ctx.startActivity<IconListActivity>("extra_list_view_type" to ONE_LINE) } }
                button("Two-line") { onClick { ctx.startActivity<IconListActivity>("extra_list_view_type" to TWO_LINE) } }
                button("Three-line") { onClick { ctx.startActivity<IconListActivity>("extra_list_view_type" to THREE_LINE) } }
                textView("Avatar with text")
                button("Single-line") { onClick { ctx.startActivity<AvatarListActivity>("extra_list_view_type" to ONE_LINE) } }
                button("Two-line") { onClick { ctx.startActivity<AvatarListActivity>("extra_list_view_type" to TWO_LINE) } }
                button("Three-line") { onClick { ctx.startActivity<AvatarListActivity>("extra_list_view_type" to THREE_LINE) } }
                textView("Avatar with text and icon")
                button("Single-line") { onClick { ctx.startActivity<AvatarIconListActivity>("extra_list_view_type" to ONE_LINE) } }
                button("Two-line") { onClick { ctx.startActivity<AvatarIconListActivity>("extra_list_view_type" to TWO_LINE) } }
                button("Three-line") { onClick { ctx.startActivity<AvatarIconListActivity>("extra_list_view_type" to THREE_LINE) } }
            }
        }
    }
}
