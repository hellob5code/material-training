package fr.erictruong.material.training.ui.components.lists_controls

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.android.core.util.ThemeUtils
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
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
        //        cards.add(DisplayBodyItem.Builder()
        //                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
        //                .display(getString(R.string.lists_controls))
        //                .body(getString(R.string.lists_controls_txt))
        //                .build())
        //        cards.add(HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Checkbox")
        //                .button1("Sample") { ctx.startActivity<CheckboxIconListControlActivity>() }
        //                .button2("Alt") { ctx.startActivity<AvatarCheckboxListControlActivity>() }
        //                .build())
        //        cards.add(HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Switch")
        //                .button1("Sample") { ctx.startActivity<IconSwitchListControlActivity>() }
        //                .build())
        //        cards.add(HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Reorder")
        //                .button1("Sample") { ctx.startActivity<AvatarReorderListControlActivity>() }
        //                .build())
        //        cards.add(HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Expand/collapse")
        //                .button1("Sample") { ctx.startActivity<IconExpandListControlActivity>() }
        //                .build())
        //        cards.add(HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Leave-behinds")
        //                .button1("Sample", null) // TODO: Write and start LeaveBehindsListControlActivity.
        //                .build())

        adapter.swapData(cards)
    }
}
