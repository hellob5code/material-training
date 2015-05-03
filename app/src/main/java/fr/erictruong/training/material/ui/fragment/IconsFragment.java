package fr.erictruong.training.material.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.activity.SystemIconsActivity;
import fr.erictruong.training.material.ui.adapter.MaterialCardAdapter;
import fr.erictruong.training.material.ui.card.Card;
import fr.erictruong.training.material.ui.card.DisplayBodyCard;
import fr.erictruong.training.material.ui.card.HeadlineBodyCard;
import fr.erictruong.training.material.ui.card.HeadlineBodyThreeButtonCard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static android.support.v7.widget.RecyclerView.NO_ID;
import static fr.erictruong.training.material.ui.card.Card.TYPE_PRIMARY_DISPLAY_1_BODY_2;

public class IconsFragment extends MaterialTrainingNavigationDrawerFragment {

    @Override
    protected List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<>();
        dataset.add(new DisplayBodyCard(NO_ID, TYPE_PRIMARY_DISPLAY_1_BODY_2, getString(R.string.fragment_icons), null));
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
