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

public class SettingsFragment extends MaterialTrainingFragment {

    @Override
    protected List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<>();
        dataset.add(new DisplayBodyCard(NO_ID, TYPE_PRIMARY_DISPLAY_1_BODY_2, getString(R.string.fragment_settings), getString(R.string.fragment_settings_txt)));
        dataset.add(new HeadlineBodyCard(NO_ID, TYPE_PRIMARY_HEADLINE_BODY_1, getString(R.string.fragment_settings_flow_and_structure), null));
        dataset.add(new HeadlineBodyCard(NO_ID, TYPE_PRIMARY_HEADLINE_BODY_1, getString(R.string.fragment_settings_writing_guidelines), null));
        return dataset;
    }
}
