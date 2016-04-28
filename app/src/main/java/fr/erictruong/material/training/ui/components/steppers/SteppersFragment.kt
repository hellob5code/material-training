package fr.erictruong.material.training.ui.components.steppers

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.HeadlineBodyThreeButtonItem
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.android.core.util.ThemeUtils
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import java.util.*

class SteppersFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val colorPrimary = ThemeUtils.obtainColorPrimary(ctx)

        val cards = ArrayList<MaterialCardItem>()
        cards.add(DisplayBodyItem(
                display = getString(R.string.steppers), displayColor = colorPrimary,
                body = getString(R.string.steppers_txt), bodyAppearance = R.style.TextAppearance_AppCompat_Body2))
        cards.add(HeadlineBodyThreeButtonItem(
                headline = "Mobile step", headlineColor = colorPrimary,
                button1 = "Text", button1Action = { ctx.startActivity<MobileStepTextActivity>() },
                button2 = "Dots", button2Action = { ctx.startActivity<MobileStepDotsActivity>() },
                button3 = "Progress bar", button3Action = { ctx.startActivity<MobileStepProgressBarActivity>() }))

        adapter.swapData(cards)
    }
}
