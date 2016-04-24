package fr.erictruong.material.training.ui.components.snackbars_and_toasts

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
import java.util.*

class SnackbarsAndToastsFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cards = ArrayList<MaterialCardItem>()
        // display1_primary body2
        cards.add(DisplayBodyItem(display = getString(R.string.snackbars_and_toasts), body = getString(R.string.snackbars_and_toasts_txt)))
        // TODO: Add cards and stuff.

        adapter.swapData(cards)
    }
}
