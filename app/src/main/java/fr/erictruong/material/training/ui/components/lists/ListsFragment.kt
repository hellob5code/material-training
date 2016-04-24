package fr.erictruong.material.training.ui.components.lists

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.HeadlineBodyItem
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.android.core.util.ThemeUtils
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
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
        cards.add(
                HeadlineBodyItem(
                        headline = "Text only"/*,
                        button1 = ("Single-line") { ctx.startActivity<TextListActivity>("extra_list_view_type" to ONE_LINE) },
                        button2 = ("Two-line") { ctx.startActivity<TextListActivity>("extra_list_view_type" to TWO_LINE) },
                        button3 = ("Three-line") { ctx.startActivity<TextListActivity>("extra_list_view_type" to THREE_LINE) }*/
                )
        )
//        cards.add(HeadlineBodyItem(
//                headline = ("Icon with text"),
//                button1 = ("Single-line") { ctx.startActivity<IconListActivity>("extra_list_view_type" to ONE_LINE) },
//                button2 = ("Two-line") { ctx.startActivity<IconListActivity>("extra_list_view_type" to TWO_LINE) },
//                button3 = ("Three-line") { ctx.startActivity<IconListActivity>("extra_list_view_type" to THREE_LINE) })
//        )
//        cards.add(HeadlineBodyItem(
//                headline = ("Avatar with text"),
//                button1 = ("Single-line") { ctx.startActivity<AvatarListActivity>("extra_list_view_type" to ONE_LINE) },
//                button2 = ("Two-line") { ctx.startActivity<AvatarListActivity>("extra_list_view_type" to TWO_LINE) },
//                button3 = ("Three-line") { ctx.startActivity<AvatarListActivity>("extra_list_view_type" to THREE_LINE) })
//        )
//        cards.add(HeadlineBodyItem(
//                headline = ("Avatar with text and icon"),
//                button1 = ("Single-line") { ctx.startActivity<AvatarIconListActivity>("extra_list_view_type" to ONE_LINE) },
//                button2 = ("Two-line") { ctx.startActivity<AvatarIconListActivity>("extra_list_view_type" to TWO_LINE) },
//                button3 = ("Three-line") { ctx.startActivity<AvatarIconListActivity>("extra_list_view_type" to THREE_LINE) })
//        )
        //        cards.add(DisplayBodyItem.Builder()
        //                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
        //                .display(getString(R.string.lists))
        //                .body(getString(R.string.lists_txt))
        //                .build())
        //        cards.add(HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Text only")
        //                .button1("Single-line") { ctx.startActivity<TextListActivity>("extra_list_view_type" to ONE_LINE) }
        //                .button2("Two-line") { ctx.startActivity<TextListActivity>("extra_list_view_type" to TWO_LINE) }
        //                .button3("Three-line") { ctx.startActivity<TextListActivity>("extra_list_view_type" to THREE_LINE) }
        //                .build())
        //        cards.add(HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Icon with text")
        //                .button1("Single-line") { ctx.startActivity<IconListActivity>("extra_list_view_type" to ONE_LINE) }
        //                .button2("Two-line") { ctx.startActivity<IconListActivity>("extra_list_view_type" to TWO_LINE) }
        //                .button3("Three-line") { ctx.startActivity<IconListActivity>("extra_list_view_type" to THREE_LINE) }
        //                .build())
        //        cards.add(HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Avatar with text")
        //                .button1("Single-line") { ctx.startActivity<AvatarListActivity>("extra_list_view_type" to ONE_LINE) }
        //                .button2("Two-line") { ctx.startActivity<AvatarListActivity>("extra_list_view_type" to TWO_LINE) }
        //                .button3("Three-line") { ctx.startActivity<AvatarListActivity>("extra_list_view_type" to THREE_LINE) }
        //                .build())
        //        cards.add(HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Avatar with text and icon")
        //                .button1("Single-line") { ctx.startActivity<AvatarIconListActivity>("extra_list_view_type" to ONE_LINE) }
        //                .button2("Two-line") { ctx.startActivity<AvatarIconListActivity>("extra_list_view_type" to TWO_LINE) }
        //                .button3("Three-line") { ctx.startActivity<AvatarIconListActivity>("extra_list_view_type" to THREE_LINE) }
        //                .build())

        adapter.swapData(cards)
    }
}
