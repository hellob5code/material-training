package fr.erictruong.training.material.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.activity.SystemIconsActivity;
import fr.erictruong.training.material.ui.adapter.MaterialCardAdapter;
import fr.erictruong.training.material.ui.card.Card;
import fr.erictruong.training.material.ui.card.HeadlineBodyCard;
import fr.erictruong.training.material.ui.card.HeadlineBodyThreeButtonCard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class IconsCardFragment extends CardFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerAdapter(new MaterialCardAdapter(getActivity(), populateDataset()));
    }

    private List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<Card>();
        dataset.add(new HeadlineBodyCard(0, Card.TYPE_PRIMARY_HEADLINE_BODY_2, getString(R.string.fragment_icons), null));
        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_icons_product_icons), null,
                "Example #1",
                null));
        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_icons_system_icons), null,
                "Example #1",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), SystemIconsActivity.class));
                        return null;
                    }
                }));
        return dataset;
    }
}
