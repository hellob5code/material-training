package fr.erictruong.training.material.ui.fragment;

import android.os.Bundle;
import android.view.View;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.adapter.MaterialCardAdapter;
import fr.erictruong.training.material.ui.card.Card;
import fr.erictruong.training.material.ui.card.HeadlineBodyCard;

import java.util.ArrayList;
import java.util.List;

public class TooltipsCardFragment extends CardFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerAdapter(new MaterialCardAdapter(getActivity(), populateDataset()));
    }

    private List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<Card>();
        dataset.add(new HeadlineBodyCard(0, Card.TYPE_PRIMARY_HEADLINE_BODY_2, getString(R.string.fragment_tooltips), getString(R.string.fragment_tooltips_txt)));
        return dataset;
    }
}
