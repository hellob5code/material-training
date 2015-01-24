package com.training.android.material.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.training.android.material.ui.activity.AaaActivity;
import com.training.android.material.ui.adapter.MaterialCardAdapter;
import com.training.android.material.ui.card.Card;
import com.training.android.material.ui.card.HeaderCard;
import com.training.android.material.ui.card.HeadlineBodyCard;
import com.training.android.material.ui.card.HeadlineBodyThreeButtonCard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static com.training.android.material.ui.card.Card.TYPE_PRIMARY_HEADLINE_BODY_2;

public class BottomSheetsFragment extends CardFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerAdapter(new MaterialCardAdapter(populateDataset()));
    }

    private List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<Card>();
        dataset.add(new HeadlineBodyCard(0, TYPE_PRIMARY_HEADLINE_BODY_2, "Bottom sheets", "One way to present a set of actions to a user is with a bottom sheet, a sheet of paper that slides up from the bottom edge of the screen. Bottom sheets offer flexibility in the display of clear and simple actions that do not need explanation."));
        dataset.add(new HeaderCard(0, "Usage"));
        dataset.add(new HeadlineBodyCard(0, null, "Bottom sheets are especially suitable when three or more actions are displayed to the user and when the actions do not require a description. If there are two or fewer actions or detailed description is required, consider using a menu or dialog instead.\n\nBottom sheets can be list-style or grid-style. Grid layouts increase visual disambiguation.\n\nYou can use bottom sheets to show actions related to other apps or to allow entry points to other apps (via the app icon)."));
        dataset.add(new HeaderCard(0, "Content"));
        dataset.add(new HeadlineBodyThreeButtonCard(0, null, "In a standard list-style bottom sheet, each action should have a text description and a left-aligned icon. When necessary, use separators to logically group actions. Also use subheaders or titles to give context to the choices.\n\nA scrollable grid-style bottom sheet can contain icons for standard share actions.",
                "Example #1",
                "Example #2",
                "Example #3",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), AaaActivity.class));
                        return null;
                    }
                },
                null,
                null));
        dataset.add(new HeaderCard(0, "Behavior"));
        dataset.add(new HeadlineBodyCard(0, null, "When a bottom sheet is displayed, it should animate upwards from the bottom edge of the screen. The previous content dims to give the user context for where they just were and the modal nature of the choice. Tapping on the dimmed area dismisses the sheet, as does swiping down on the sheet.\n\nIf the sheet contains more actions that can fit in the initial display, the sheet is scrollable. Scrolling should also pull up the sheet container and eventually cover the entire screen.\n\nWhen the action sheet covers the entire screen, add a dismiss button to the header, on the left side of the title."));
        return dataset;
    }
}
