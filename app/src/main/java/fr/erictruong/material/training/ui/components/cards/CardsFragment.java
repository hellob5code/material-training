package fr.erictruong.android.cards;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fr.erictruong.android.cards.DisplayBodyItem;
import fr.erictruong.android.cards.HeadlineBodyItem;
import fr.erictruong.android.cards.MaterialCardItem;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.BaseCardFragment;

import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_DISPLAY1_PRIMARY_BODY2;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON;

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
                .body("Card with action area, rich media and supporting text")
                .button1("Example", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .body("Card with action areas 1 and 2, optional header, rich media, supporting text, and supplemental actions")
                .button1("Example", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .body("Card with action areas 1, 2, 3 and 4, optional header, rich media, and supplemental actions")
                .button1("Example", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .body("Card with action areas 1 and 2, optional header, supporting text and supplemental actions")
                .button1("Example", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .body("Media area; Supporting text")
                .button1("Example", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .body("Avatar, Title, and Subtitle area; Media area; Supporting text; Actions")
                .button1("Example", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .body("Avatar, Title, and Subtitle area; Media area; Actions")
                .button1("Example", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .body("Media area; Primary text; Subtext; Actions")
                .button1("Example", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .body("Media area; Primary text; Subtext; Actions; Expanded supporting text")
                .button1("Example", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .body("Primary text; Subtext; Supporting text; Actions")
                .button1("Example", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .body("Media area; Actions")
                .button1("Example", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .body("Media area; Primary text; Subtext; Actions")
                .button1("Example", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .body("Media area; Primary text; Actions")
                .button1("Example", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .body("Media area; Primary text; Subtext; Actions")
                .button1("Example #1", null)
                .button2("Example #2", null)
                .button3("Example #3", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .body("Media area; Actions")
                .button1("Example", null)
                .build());

        getAdapter().swapData(cards);
    }
}
