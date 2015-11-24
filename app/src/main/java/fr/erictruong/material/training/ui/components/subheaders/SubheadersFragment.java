package fr.erictruong.material.training.ui.components.subheaders;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fr.erictruong.material.training.R;
import fr.erictruong.android.cards.DisplayBodyItem;
import fr.erictruong.android.cards.HeadlineBodyItem;
import fr.erictruong.android.cards.MaterialCardItem;
import fr.erictruong.material.training.ui.core.BaseCardFragment;

import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_DISPLAY1_PRIMARY_BODY2;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON;

public class SubheadersFragment extends BaseCardFragment {

    public static SubheadersFragment newInstance() {
        Bundle args = new Bundle();
        SubheadersFragment fragment = new SubheadersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<MaterialCardItem> cards = new ArrayList<>();
        cards.add(new DisplayBodyItem.Builder()
                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
                .display(getString(R.string.subheaders))
                .body(getString(R.string.subheaders_txt))
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("List subheaders")
                .button1("Example #1", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListSubheaderActivity.start(getContext());
                    }
                })
                .build());

        getAdapter().swapData(cards);
    }
}
