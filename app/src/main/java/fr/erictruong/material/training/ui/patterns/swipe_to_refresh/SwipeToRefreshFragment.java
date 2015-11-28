package fr.erictruong.material.training.ui.patterns.swipe_to_refresh;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fr.erictruong.material.training.R;
import fr.erictruong.android.cards.item.DisplayBodyItem;
import fr.erictruong.android.cards.item.HeadlineBodyItem;
import fr.erictruong.android.cards.MaterialCardItem;
import fr.erictruong.material.training.ui.core.BaseCardFragment;

import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_DISPLAY1_PRIMARY_BODY2;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON;

public class SwipeToRefreshFragment extends BaseCardFragment {

    public static SwipeToRefreshFragment newInstance() {
        Bundle args = new Bundle();
        SwipeToRefreshFragment fragment = new SwipeToRefreshFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
     public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<MaterialCardItem> cards = new ArrayList<>();
        cards.add(new DisplayBodyItem.Builder()
                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
                .display(getString(R.string.swipe_to_refresh))
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON)
                .headline(getString(R.string.swipe_to_refresh_swipe_to_refresh))
                .button1("Sample", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleSwipeToRefreshActivity.start(getContext());
                    }
                })
                .build());

        getAdapter().swapData(cards);
    }
}
