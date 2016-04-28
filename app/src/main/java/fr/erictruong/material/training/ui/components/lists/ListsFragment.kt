package fr.erictruong.material.training.ui.components.lists

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.HeadlineBodyThreeButtonItem
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.android.core.util.ThemeUtils
import fr.erictruong.android.lists.holder.Holder.Companion.ONE_LINE
import fr.erictruong.android.lists.holder.Holder.Companion.THREE_LINE
import fr.erictruong.android.lists.holder.Holder.Companion.TWO_LINE
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import java.util.*

class ListsFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val colorPrimary = ThemeUtils.obtainColorPrimary(ctx)

        val cards = ArrayList<MaterialCardItem>()
        cards.add(DisplayBodyItem(
                display = getString(R.string.lists), displayColor = colorPrimary,
                body = getString(R.string.lists_txt), bodyAppearance = R.style.TextAppearance_AppCompat_Body2))
        cards.add(HeadlineBodyThreeButtonItem(
                headline = "Text only", headlineColor = colorPrimary,
                button1 = "Single-line", button1Action = {
            println("AAA AA ")
            ctx.startActivity<TextListActivity>("extra_list_view_type" to ONE_LINE)
            println("AAA BB ")
        },
                button2 = "Two-line", button2Action = { ctx.startActivity<TextListActivity>("extra_list_view_type" to TWO_LINE) },
                button3 = "Three-line", button3Action = { ctx.startActivity<TextListActivity>("extra_list_view_type" to THREE_LINE) }))
        cards.add(HeadlineBodyThreeButtonItem(
                headline = ("Icon with text"), headlineColor = colorPrimary,
                button1 = "Single-line", button1Action = { ctx.startActivity<IconListActivity>("extra_list_view_type" to ONE_LINE) },
                button2 = "Two-line", button2Action = { ctx.startActivity<IconListActivity>("extra_list_view_type" to TWO_LINE) },
                button3 = "Three-line", button3Action = { ctx.startActivity<IconListActivity>("extra_list_view_type" to THREE_LINE) }))
        cards.add(HeadlineBodyThreeButtonItem(
                headline = ("Avatar with text"), headlineColor = colorPrimary,
                button1 = "Single-line", button1Action = { ctx.startActivity<AvatarListActivity>("extra_list_view_type" to ONE_LINE) },
                button2 = "Two-line", button2Action = { ctx.startActivity<AvatarListActivity>("extra_list_view_type" to TWO_LINE) },
                button3 = "Three-line", button3Action = { ctx.startActivity<AvatarListActivity>("extra_list_view_type" to THREE_LINE) }))
        cards.add(HeadlineBodyThreeButtonItem(
                headline = ("Avatar with text and icon"), headlineColor = colorPrimary,
                button1 = "Single-line", button1Action = { ctx.startActivity<AvatarIconListActivity>("extra_list_view_type" to ONE_LINE) },
                button2 = "Two-line", button2Action = { ctx.startActivity<AvatarIconListActivity>("extra_list_view_type" to TWO_LINE) },
                button3 = "Three-line", button3Action = { ctx.startActivity<AvatarIconListActivity>("extra_list_view_type" to THREE_LINE) }))

        adapter.swapData(cards)
    }
}
