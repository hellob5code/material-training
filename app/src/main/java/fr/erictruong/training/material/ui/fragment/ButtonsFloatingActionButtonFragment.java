package fr.erictruong.training.material.ui.fragment;

import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.card.Card;
import fr.erictruong.training.material.ui.card.DisplayBodyCard;
import fr.erictruong.training.material.ui.card.HeadlineBodyCard;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.NO_ID;
import static fr.erictruong.training.material.ui.card.Card.TYPE_PRIMARY_DISPLAY_1_BODY_2;
import static fr.erictruong.training.material.ui.card.Card.TYPE_PRIMARY_HEADLINE_BODY_1;

public class ButtonsFloatingActionButtonFragment extends MaterialTrainingFragment {

    @Override
    protected List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<>();
        dataset.add(new DisplayBodyCard(NO_ID, TYPE_PRIMARY_DISPLAY_1_BODY_2, getString(R.string.fragment_buttons_floating_action_button), null));
        dataset.add(new HeadlineBodyCard(NO_ID, TYPE_PRIMARY_HEADLINE_BODY_1, getString(R.string.fragment_buttons_floating_action_button_floating_action_button), null));
        dataset.add(new HeadlineBodyCard(NO_ID, TYPE_PRIMARY_HEADLINE_BODY_1, getString(R.string.fragment_buttons_floating_action_button_behavior), null));
        dataset.add(new HeadlineBodyCard(NO_ID, TYPE_PRIMARY_HEADLINE_BODY_1, getString(R.string.fragment_buttons_floating_action_button_transitions), null));
        dataset.add(new HeadlineBodyCard(NO_ID, TYPE_PRIMARY_HEADLINE_BODY_1, getString(R.string.fragment_buttons_floating_action_button_large_screens), null));
        return dataset;
    }
}
