package com.training.android.material.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.training.android.material.R;
import com.training.android.material.ui.activity.ContactsActivity;
import com.training.android.material.ui.activity.MyFilesActivity;
import com.training.android.material.ui.adapter.MaterialCardAdapter;
import com.training.android.material.ui.card.Card;
import com.training.android.material.ui.card.HeadlineBodyCard;
import com.training.android.material.ui.card.HeadlineBodyThreeButtonCard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static com.training.android.material.ui.card.Card.TYPE_PRIMARY_HEADLINE_BODY_2;

public class BottomSheetsCardFragment extends CardFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerAdapter(new MaterialCardAdapter(getActivity(), populateDataset()));
    }

    private List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<Card>();
        dataset.add(new HeadlineBodyCard(0, TYPE_PRIMARY_HEADLINE_BODY_2, getString(R.string.fragment_bottom_sheets), getString(R.string.fragment_bottom_sheets_txt)));
        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_bottom_sheets_list_style), null,
                "Example #1",
                "#2",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), ContactsActivity.class));
                        return null;
                    }
                },
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), MyFilesActivity.class));
                        return null;
                    }
                }));
        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_bottom_sheets_grid_style), null, "Example #1", null));
        return dataset;
    }
}
