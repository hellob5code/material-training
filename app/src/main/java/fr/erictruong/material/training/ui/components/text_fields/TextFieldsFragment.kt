package fr.erictruong.material.training.ui.components.text_fields

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.MaterialCardItem
import fr.erictruong.material.training.ui.core.BaseCardFragment
import java.util.*

class TextFieldsFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cards = ArrayList<MaterialCardItem>()
        // TODO: Add cards and stuff.

        adapter.swapData(cards)
    }
}
