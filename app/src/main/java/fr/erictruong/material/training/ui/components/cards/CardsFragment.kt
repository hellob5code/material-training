package fr.erictruong.material.training.ui.components.cards

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.erictruong.material.training.R
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.nestedScrollView

class CardsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return CardsFragmentUI().createView(AnkoContext.create(context, this))
    }
}

class CardsFragmentUI : AnkoComponent<Fragment> {

    override fun createView(ui: AnkoContext<Fragment>) = with(ui) {
        nestedScrollView {
            verticalLayout {
                padding = dimen(R.dimen.padding_medium)
                bottomPadding += dimen(R.dimen.action_bar_size)
                clipToPadding = false
                button("Media area - Text") { onClick { ctx.startActivity<MediaBody1CardActivity>() } }
                button("Avatar, Title, and Subtitle area - Media area - Text - Actions") { onClick { ctx.startActivity<AvatarSubheaderMediaBody1ActionsActivity>("extra_card_view_type" to 0) } }
                button("Avatar, Title, and Subtitle area - Media area - Actions") { onClick { ctx.startActivity<AvatarSubheaderMediaBody1ActionsActivity>("extra_card_view_type" to 1) } }
                button("Media area - Primary text - Subtext - Actions - Expanded text") { onClick { ctx.startActivity<MediaHeadlineSubtextActionsExpandBody1Activity>() } }
                button("Primary text - Subtext - Text - Actions") { onClick { ctx.startActivity<HeadlineSubtextBody1ActionsActivity>() } }
                button("Media area - Actions #1") { onClick { ctx.startActivity<MediaActionsActivity>("extra_card_view_type" to 0) } }
                button("Media area - Actions #2") { onClick { ctx.startActivity<MediaActionsActivity>("extra_card_view_type" to 1) } }
                button("Media area - Primary text - Actions") { onClick { ctx.startActivity<MediaHeadlineActionsActivity>() } }
                button("Media area - Primary text - Subtext - Actions #1") { onClick { ctx.startActivity<MediaHeadlineSubtextActionsActivity>("extra_card_view_type" to 0) } }
                button("Media area - Primary text - Subtext - Actions #2") { onClick { ctx.startActivity<MediaHeadlineSubtextActionsActivity>("extra_card_view_type" to 1) } }
                button("Media area - Primary text - Subtext - Actions #3") { onClick { ctx.startActivity<MediaHeadlineSubtextActionsActivity>("extra_card_view_type" to 2) } }
                button("Media area - Primary text - Subtext - Actions #4") { onClick { ctx.startActivity<MediaHeadlineSubtextActionsActivity>("extra_card_view_type" to 3) } }
            }
        }
    }
}
