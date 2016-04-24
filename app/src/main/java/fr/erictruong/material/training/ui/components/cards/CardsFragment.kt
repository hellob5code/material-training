package fr.erictruong.material.training.ui.components.cards

import android.os.Bundle
import android.view.View
import fr.erictruong.android.cards.item.DisplayBodyItem
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseCardFragment
import java.util.*

class CardsFragment : BaseCardFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cards = ArrayList<MaterialCardItem>()
        // display1_primary body2
        cards.add(DisplayBodyItem(display = getString(R.string.cards), body = getString(R.string.cards_txt)))
        // TODO: Add cards and stuff.

        //        cards.add(new DisplayBodyItem.Builder()
        //                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
        //                .display(getString(R.string.cards))
        //                .body(getString(R.string.cards_txt))
        //                .build());
        //        cards.add(new HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Media area - Supporting text")
        //                .button1("Sample", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        SampleCardActivity.start(getContext(), VIEW_TYPE_IMAGE_BODY1);
        //                    }
        //                })
        //                .build());
        //        cards.add(new HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Avatar, Title, and Subtitle area - Media area - Supporting text - Actions")
        //                .button1("Sample", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        SampleCardActivity.start(getContext(), VIEW_TYPE_AVATAR_TITLE_SUBTITLE_IMAGE_BODY1_THREE_BUTTON);
        //                    }
        //                })
        //                .build());
        //        cards.add(new HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Avatar, Title, and Subtitle area - Media area - Actions")
        //                .button1("Sample", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        SampleCardActivity.start(getContext(), VIEW_TYPE_AVATAR_TITLE_SUBTITLE_IMAGE_BODY1_SIX_BUTTON);
        //                    }
        //                })
        //                .build());
        //        cards.add(new HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Media area - Primary text - Subtext - Actions - Expanded supporting text")
        //                .button1("Sample", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        SampleCardActivity.start(getContext(), VIEW_TYPE_IMAGE_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON_EXPAND);
        //                    }
        //                })
        //                .build());
        //        cards.add(new HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Primary text - Subtext - Supporting text - Actions")
        //                .button1("Sample", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        SampleCardActivity.start(getContext(), VIEW_TYPE_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON   );
        //                    }
        //                })
        //                .build());
        //        cards.add(new HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Media area - Actions")
        //                .button1("Sample", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        SampleCardActivity.start(getContext(), VIEW_TYPE_IMAGE_THREE_ICON);
        //                    }
        //                })
        //                .button2("Alt", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        SampleCardActivity.start(getContext(), VIEW_TYPE_IMAGE_THREE_ICON_VERTICAL);
        //                    }
        //                })
        //                .build());
        //        cards.add(new HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Media area - Primary text - Subtext - Actions")
        //                .button1("Sample", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        SampleCardActivity.start(getContext(), VIEW_TYPE_BACKGROUND_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON);
        //                    }
        //                })
        //                .build());
        //        cards.add(new HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Media area - Primary text - Actions")
        //                .button1("Sample", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        SampleCardActivity.start(getContext(), VIEW_TYPE_IMAGE_HEADLINE_THREE_ICON);
        //                    }
        //                })
        //                .build());
        //        cards.add(new HeadlineBodyItem.Builder()
        //                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
        //                .headline("Media area - Primary text - Subtext - Actions")
        //                .button1("Sample", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        SampleCardActivity.start(getContext(), VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON_SMALL);
        //                    }
        //                })
        //                .button2("Alt #2", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        SampleCardActivity.start(getContext(), VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON);
        //                    }
        //                })
        //                .button3("Alt #3", new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        SampleCardActivity.start(getContext(), VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON_LARGE);
        //                    }
        //                })
        //                .build());

        adapter.swapData(cards)
    }
}
