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

public class TypographyFragment extends MaterialTrainingFragment {

    @Override
    protected List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<>();
        dataset.add(new DisplayBodyCard(NO_ID, TYPE_PRIMARY_DISPLAY_1_BODY_2, getString(R.string.fragment_typography), getString(R.string.fragment_typography_txt)));
        dataset.add(new HeadlineBodyCard(NO_ID, TYPE_PRIMARY_HEADLINE_BODY_1, getString(R.string.fragment_typography_language_categorization), null));
        dataset.add(new HeadlineBodyCard(NO_ID, TYPE_PRIMARY_HEADLINE_BODY_1, getString(R.string.fragment_typography_typeface), null));
        dataset.add(new HeadlineBodyCard(NO_ID, TYPE_PRIMARY_HEADLINE_BODY_1, getString(R.string.fragment_typography_styles), null));
        dataset.add(new HeadlineBodyCard(NO_ID, TYPE_PRIMARY_HEADLINE_BODY_1, getString(R.string.fragment_typography_line_height), null));
        dataset.add(new HeadlineBodyCard(NO_ID, TYPE_PRIMARY_HEADLINE_BODY_1, getString(R.string.fragment_typography_other_typographic_guidelines), null));
        dataset.add(new HeadlineBodyCard(NO_ID, TYPE_PRIMARY_HEADLINE_BODY_1, getString(R.string.fragment_typography_language_categories_reference), null));
        return dataset;
    }
}
