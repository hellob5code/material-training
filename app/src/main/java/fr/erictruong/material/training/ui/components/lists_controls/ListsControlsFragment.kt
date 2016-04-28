package fr.erictruong.material.training.ui.components.lists_controls

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

class ListsControlsFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val colorPrimary = ThemeUtils.obtainColorPrimary(ctx)

        val cards = ArrayList<MaterialCardItem>()
        cards.add(DisplayBodyItem(
                display = getString(R.string.lists_controls), displayColor = colorPrimary,
                body = getString(R.string.lists_controls_txt), bodyAppearance = R.style.TextAppearance_AppCompat_Body2))
        cards.add(HeadlineBodyThreeButtonItem(
                headline = "Checkbox", headlineColor = colorPrimary,
                button1 = "Sample", button1Action = { ctx.startActivity<CheckboxIconListControlActivity>() },
                button2 = "Alt", button2Action = { ctx.startActivity<AvatarCheckboxListControlActivity>() }))
        cards.add(HeadlineBodyThreeButtonItem(
                headline = "Switch", headlineColor = colorPrimary,
                button1 = "Sample", button1Action = { ctx.startActivity<IconSwitchListControlActivity>() }))
        cards.add(HeadlineBodyThreeButtonItem(
                headline = "Reorder", headlineColor = colorPrimary,
                button1 = "Sample", button1Action = { ctx.startActivity<AvatarReorderListControlActivity>() }))
        cards.add(HeadlineBodyThreeButtonItem(
                headline = "Expand/collapse", headlineColor = colorPrimary,
                button1 = "Sample", button1Action = { ctx.startActivity<IconExpandListControlActivity>() }))
        cards.add(HeadlineBodyThreeButtonItem(
                headline = "Leave-behinds", headlineColor = colorPrimary,
                button1 = "Sample", button1Action = null)) // TODO: Write and start LeaveBehindsListControlActivity.

        adapter.swapData(cards)
    }
}
