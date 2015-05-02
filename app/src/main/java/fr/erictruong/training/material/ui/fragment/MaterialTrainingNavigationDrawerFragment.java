package fr.erictruong.training.material.ui.fragment;

import android.os.Bundle;
import android.view.View;
import fr.erictruong.training.material.ui.adapter.MaterialCardAdapter;
import fr.erictruong.training.material.ui.card.Card;

import java.util.List;

public abstract class MaterialTrainingNavigationDrawerFragment extends CardFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerAdapter(new MaterialCardAdapter(getActivity(), populateDataset()));
    }

    protected abstract List<Card> populateDataset();
}
