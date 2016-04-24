package fr.erictruong.material.training.ui.components.steppers

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.android.core.util.ThemeUtils
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
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
        //        cards.add(new DisplayBodyItem.Builder()
        //                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
        //                .display(getString(R.string.steppers))
        //                .body(getString(R.string.steppers_txt))
        //                .build());
        //        cards.add(new HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Mobile step")
        //                .button1("Text", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        MobileStepTextActivity.start(getContext());
        //                    }
        //                })
        //                .button2("Dots", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        MobileStepDotsActivity.start(getContext());
        //                    }
        //                })
        //                .button3("Progress bar", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        MobileStepProgressBarActivity.start(getContext());
        //                    }
        //                })
        //                .build());

        adapter.swapData(cards)
    }
}
