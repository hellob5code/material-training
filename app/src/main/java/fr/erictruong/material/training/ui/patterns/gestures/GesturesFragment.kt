package fr.erictruong.material.training.ui.patterns.gestures

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.MaterialCardItem
import fr.erictruong.material.training.ui.core.BaseCardFragment
import java.util.*

class GesturesFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cards = ArrayList<MaterialCardItem>()
        // TODO: Add cards and stuff.

        adapter.swapData(cards)
    }
}
