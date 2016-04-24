package fr.erictruong.material.training.ui.what_is_material.material_properties

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.android.core.util.ThemeUtils
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
import org.jetbrains.anko.support.v4.ctx
import java.util.*

class MaterialPropertiesFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val colorPrimary = ThemeUtils.obtainColorPrimary(ctx)

        val cards = ArrayList<MaterialCardItem>()
        cards.add(DisplayBodyItem(
                display = getString(R.string.material_properties), displayColor = colorPrimary,
                body = getString(R.string.material_properties_txt), bodyAppearance = R.style.TextAppearance_AppCompat_Body2))
        // TODO: Add cards and stuff.

        adapter.swapData(cards)
    }
}
