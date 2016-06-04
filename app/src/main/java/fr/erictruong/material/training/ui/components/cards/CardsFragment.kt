package fr.erictruong.material.training.ui.components.cards

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
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

                textView("Media area - Supporting text")
                include<CardView>(R.layout.card_media_body1)
                textView("Avatar, Title, and Subtitle area - Media area - Supporting text - Actions")
                include<CardView>(R.layout.card_avatar_subheader_media_body1_actions)
                textView("Avatar, Title, and Subtitle area - Media area - Actions")
                include<CardView>(R.layout.card_avatar_subheader_media_body1_vertical_actions)
                textView("Media area - Primary text - Subtext - Actions - Expanded supporting text")
                include<CardView>(R.layout.card_media_headline_subtext_actions_expanded_body1)
                textView("Primary text - Subtext - Supporting text - Actions")
                include<CardView>(R.layout.card_headline_subtext_body1_actions)
                textView("Media area - Actions #1")
                include<CardView>(R.layout.card_media_actions_alt1)
                textView("Media area - Actions #2")
                include<CardView>(R.layout.card_media_actions_alt2)
                textView("Media area - Primary text - Actions")
                linearLayout {
                    clipToPadding = false

                    include<CardView>(R.layout.card_media_headline_actions).lparams {
                        width = 0
                        weight = 1f
                    }
                    space {}.lparams(width = dip(8), height = dip(8))
                    include<CardView>(R.layout.card_media_headline_actions).lparams {
                        width = 0
                        weight = 1f
                    }
                }
                textView("Media area - Primary text - Subtext - Actions #1")
                include<CardView>(R.layout.card_media_headline_subtext_actions_alt1)
                textView("Media area - Primary text - Subtext - Actions #2")
                include<CardView>(R.layout.card_media_headline_subtext_actions_alt2)
                textView("Media area - Primary text - Subtext - Actions #3")
                include<CardView>(R.layout.card_media_headline_subtext_actions_alt3)
                textView("Media area - Primary text - Subtext - Actions #4")
                include<CardView>(R.layout.card_media_headline_subtext_actions_alt4)
//                button("Media area - Supporting text") { onClick { /*ctx.startActivity<SampleCardActivity>()*/ } }.enabled = false
//                button("Avatar, Title, and Subtitle area - Media area - Supporting text - Actions") { onClick { /*ctx.startActivity<SampleCardActivity>()*/ } }.enabled = false
//                button("Avatar, Title, and Subtitle area - Media area - Actions") { onClick { /*ctx.startActivity<SampleCardActivity>()*/ } }.enabled = false
//                button("Media area - Primary text - Subtext - Actions - Expanded supporting text") { onClick { /*ctx.startActivity<SampleCardActivity>()*/ } }.enabled = false
//                button("Primary text - Subtext - Supporting text - Actions") { onClick { /*ctx.startActivity<SampleCardActivity>()*/ } }.enabled = false
//                button("Media area - Actions #1") { onClick { /*ctx.startActivity<SampleCardActivity>()*/ } }.enabled = false
//                button("Media area - Actions #2") { onClick { /*ctx.startActivity<SampleCardActivity>()*/ } }.enabled = false
//                button("Media area - Primary text - Subtext - Actions") { onClick { /*ctx.startActivity<SampleCardActivity>()*/ } }.enabled = false
//                button("Media area - Primary text - Actions") { onClick { /*ctx.startActivity<SampleCardActivity>()*/ } }.enabled = false
//                button("Media area - Primary text - Subtext - Actions #1") { onClick { /*ctx.startActivity<SampleCardActivity>()*/ } }.enabled = false
//                button("Media area - Primary text - Subtext - Actions #2") { onClick { /*ctx.startActivity<SampleCardActivity>()*/ } }.enabled = false
//                button("Media area - Primary text - Subtext - Actions #3") { onClick { /*ctx.startActivity<SampleCardActivity>()*/ } }.enabled = false
            }
        }
    }
}
