package com.training.android.material.ui.fragment;

import android.os.Bundle;
import android.view.View;
import com.training.android.material.R;
import com.training.android.material.ui.adapter.MaterialCardAdapter;
import com.training.android.material.ui.card.Card;
import com.training.android.material.ui.card.HeadlineBodyCard;
import com.training.android.material.ui.card.RichImageHeadlineBodyCard;

import java.util.ArrayList;
import java.util.List;

public class IntroductionCardFragment extends CardFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerAdapter(new MaterialCardAdapter(getActivity(), populateDataset()));
    }

    private List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<Card>();
        dataset.add(new RichImageHeadlineBodyCard(0, R.drawable.materialdesign_introduction, getString(R.string.fragment_introduction), getString(R.string.fragment_introduction_txt)));
        dataset.add(new HeadlineBodyCard(0, getString(R.string.fragment_introduction_goals), getString(R.string.fragment_introduction_goals_txt)));
        dataset.add(new HeadlineBodyCard(0, getString(R.string.fragment_introduction_principles), getText(R.string.fragment_introduction_principles_txt)));
        return dataset;
    }
}
