package fr.erictruong.material.training.ui.material_design.introduction

import android.os.Bundle
import android.view.View

import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.HeadlineBodyItem
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
import java.util.*

class IntroductionFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cards = ArrayList<MaterialCardItem>()
        // display1_primary body2
        cards.add(DisplayBodyItem(display = getString(R.string.introduction), body = getString(R.string.introduction_txt)))
        // headline_primary body1
        cards.add(HeadlineBodyItem(headline = getString(R.string.introduction_goals), body = getString(R.string.introduction_goals_txt)))

        adapter.swapData(cards)
    }
}
