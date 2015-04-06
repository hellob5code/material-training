package fr.erictruong.training.material.ui.fragment;

import android.os.Bundle;
import android.view.View;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.adapter.MaterialCardAdapter;
import fr.erictruong.training.material.ui.card.Card;
import fr.erictruong.training.material.ui.card.HeadlineBodyCard;
import fr.erictruong.training.material.ui.card.HeadlineRichHorizontalRecyclerViewBodyCard;
import fr.erictruong.training.material.ui.card.HeadlineRichImageBodyCard;

import java.util.ArrayList;
import java.util.List;

import static fr.erictruong.training.material.ui.card.Card.TYPE_PRIMARY_HEADLINE_BODY_2;

public class EnvironmentCardFragment extends CardFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerAdapter(new MaterialCardAdapter(getActivity(), populateDataset()));
    }

    private List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<Card>();
        dataset.add(new HeadlineBodyCard(0, TYPE_PRIMARY_HEADLINE_BODY_2, getString(R.string.fragment_environment), null));
        dataset.add(new HeadlineRichImageBodyCard(0,
                R.drawable.whatismaterial_environment_3d,
                getString(R.string.fragment_environment_3d_world),
                getString(R.string.fragment_environment_3d_world_txt)));
        dataset.add(new HeadlineRichHorizontalRecyclerViewBodyCard(0,
                new int[]{R.drawable.whatismaterial_environment_shadow1, R.drawable.whatismaterial_environment_shadow2, R.drawable.whatismaterial_environment_shadow3},
                getString(R.string.fragment_environment_light_and_shadow),
                getString(R.string.fragment_environment_light_and_shadow_txt)));
        return dataset;
    }
}
