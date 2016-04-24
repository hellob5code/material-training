package fr.erictruong.material.training.ui.components.steppers

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
import java.util.*

class SteppersFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cards = ArrayList<MaterialCardItem>()
        // display1_primary body2
        cards.add(DisplayBodyItem(display = getString(R.string.steppers), body = getString(R.string.steppers_txt)))
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
