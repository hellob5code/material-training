package fr.erictruong.training.material.ui.fragment;

import android.os.Bundle;
import android.view.View;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.adapter.MaterialCardAdapter;
import fr.erictruong.training.material.ui.card.Card;
import fr.erictruong.training.material.ui.card.HeadlineRichHorizontalRecyclerViewBodyCard;
import fr.erictruong.training.material.ui.card.RichImageHeadlineBodyCard;

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
        dataset.add(new HeadlineRichHorizontalRecyclerViewBodyCard(0,
                new int[]{R.drawable.materialdesign_goals_language, R.drawable.materialdesign_goals_system},
                getString(R.string.fragment_introduction_goals),
                getString(R.string.fragment_introduction_goals_txt)));
        dataset.add(new HeadlineRichHorizontalRecyclerViewBodyCard(0,
                new int[]{R.drawable.materialdesign_principles_metaphor, R.drawable.materialdesign_principles_bold, R.drawable.materialdesign_principles_motion},
                getString(R.string.fragment_introduction_principles),
                getText(R.string.fragment_introduction_principles_txt)));
        return dataset;
    }
}
