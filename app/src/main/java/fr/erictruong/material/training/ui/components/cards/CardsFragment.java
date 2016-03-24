package fr.erictruong.material.training.ui.components.cards;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fr.erictruong.android.cards.MaterialCardItem;
import fr.erictruong.android.cards.item.DisplayBodyItem;
import fr.erictruong.android.cards.item.HeadlineBodyItem;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.BaseCardFragment;

import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_AVATAR_TITLE_SUBTITLE_IMAGE_BODY1_SIX_BUTTON;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_AVATAR_TITLE_SUBTITLE_IMAGE_BODY1_THREE_BUTTON;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_BACKGROUND_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_DISPLAY1_PRIMARY_BODY2;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON_LARGE;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON_SMALL;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_IMAGE_BODY1;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_IMAGE_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON_EXPAND;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_IMAGE_HEADLINE_THREE_ICON;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_IMAGE_THREE_ICON;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_IMAGE_THREE_ICON_VERTICAL;

public class CardsFragment extends BaseCardFragment {

    public static CardsFragment newInstance() {
        Bundle args = new Bundle();
        CardsFragment fragment = new CardsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<MaterialCardItem> cards = new ArrayList<>();
        cards.add(new DisplayBodyItem.Builder()
                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
                .display(getString(R.string.cards))
                .body(getString(R.string.cards_txt))
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Media area - Supporting text")
                .button1("Sample", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleCardActivity.start(getContext(), VIEW_TYPE_IMAGE_BODY1);
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Avatar, Title, and Subtitle area - Media area - Supporting text - Actions")
                .button1("Sample", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleCardActivity.start(getContext(), VIEW_TYPE_AVATAR_TITLE_SUBTITLE_IMAGE_BODY1_THREE_BUTTON);
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Avatar, Title, and Subtitle area - Media area - Actions")
                .button1("Sample", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleCardActivity.start(getContext(), VIEW_TYPE_AVATAR_TITLE_SUBTITLE_IMAGE_BODY1_SIX_BUTTON);
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Media area - Primary text - Subtext - Actions - Expanded supporting text")
                .button1("Sample", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleCardActivity.start(getContext(), VIEW_TYPE_IMAGE_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON_EXPAND);
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Primary text - Subtext - Supporting text - Actions")
                .button1("Sample", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleCardActivity.start(getContext(), VIEW_TYPE_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON   );
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Media area - Actions")
                .button1("Sample", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleCardActivity.start(getContext(), VIEW_TYPE_IMAGE_THREE_ICON);
                    }
                })
                .button2("Alt", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleCardActivity.start(getContext(), VIEW_TYPE_IMAGE_THREE_ICON_VERTICAL);
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Media area - Primary text - Subtext - Actions")
                .button1("Sample", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleCardActivity.start(getContext(), VIEW_TYPE_BACKGROUND_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON);
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Media area - Primary text - Actions")
                .button1("Sample", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleCardActivity.start(getContext(), VIEW_TYPE_IMAGE_HEADLINE_THREE_ICON);
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Media area - Primary text - Subtext - Actions")
                .button1("Sample", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleCardActivity.start(getContext(), VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON_SMALL);
                    }
                })
                .button2("Alt #2", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleCardActivity.start(getContext(), VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON);
                    }
                })
                .button3("Alt #3", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleCardActivity.start(getContext(), VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON_LARGE);
                    }
                })
                .build());

        getAdapter().swapData(cards);
    }
}
