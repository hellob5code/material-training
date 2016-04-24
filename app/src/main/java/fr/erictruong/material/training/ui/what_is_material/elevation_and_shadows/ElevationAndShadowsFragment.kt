package fr.erictruong.material.training.ui.what_is_material.elevation_and_shadows

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
import java.util.*

class ElevationAndShadowsFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cards = ArrayList<MaterialCardItem>()
        // display1_primary body2
        cards.add(DisplayBodyItem(display = getString(R.string.objects_elevation_and_shadows), body = getString(R.string.objects_elevation_and_shadows_txt)))
        // TODO: Add cards and stuff.

        adapter.swapData(cards)
    }
}
