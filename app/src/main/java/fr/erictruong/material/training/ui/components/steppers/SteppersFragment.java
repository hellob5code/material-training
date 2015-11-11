package fr.erictruong.material.training.ui.components.steppers;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.components.cards.DisplayBodyItem;
import fr.erictruong.material.training.ui.components.cards.HeadlineBodyItem;
import fr.erictruong.material.training.ui.components.cards.MaterialCardItem;
import fr.erictruong.material.training.ui.components.tabs.FixedTabBarActivity;
import fr.erictruong.material.training.ui.core.BaseCardFragment;

import static fr.erictruong.material.training.ui.components.cards.MaterialCardAdapter.VIEW_TYPE_DISPLAY1_PRIMARY_BODY2;
import static fr.erictruong.material.training.ui.components.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON;

public class SteppersFragment extends BaseCardFragment {

    public static SteppersFragment newInstance() {
        Bundle args = new Bundle();
        SteppersFragment fragment = new SteppersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<MaterialCardItem> cards = new ArrayList<>();
        cards.add(new DisplayBodyItem.Builder()
                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
                .display(getString(R.string.steppers))
                .body(getString(R.string.steppers_txt))
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON)
                .headline("Types of steps")
                .button1("Mobile step text", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MobileStepTextActivity.start(getContext());
                    }
                })
                .button2("Mobile step dots", null)
                .button3("Mobile step progress bar", null)
                .build());

        getAdapter().swapData(cards);
    }
}
