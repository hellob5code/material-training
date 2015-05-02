package fr.erictruong.training.material.ui.fragment;

import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.card.Card;
import fr.erictruong.training.material.ui.card.HeadlineBodyCard;

import java.util.ArrayList;
import java.util.List;

public class TabsFragment extends MaterialTrainingNavigationDrawerFragment {

    @Override
    protected List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<>();
        dataset.add(new HeadlineBodyCard(0, Card.TYPE_PRIMARY_HEADLINE_BODY_2, getString(R.string.fragment_tabs), getString(R.string.fragment_tabs_txt)));
        return dataset;
    }
}
