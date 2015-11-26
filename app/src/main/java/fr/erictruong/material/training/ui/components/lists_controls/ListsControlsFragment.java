package fr.erictruong.material.training.ui.components.lists_controls;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fr.erictruong.android.cards.DisplayBodyItem;
import fr.erictruong.android.cards.HeadlineBodyItem;
import fr.erictruong.android.cards.MaterialCardItem;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.BaseCardFragment;

import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_DISPLAY1_PRIMARY_BODY2;
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_CHECKBOX;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_CHECKBOX_ICON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON_EXPAND;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON_SWITCH;

public class ListsControlsFragment extends BaseCardFragment {

    public static ListsControlsFragment newInstance() {
        Bundle args = new Bundle();
        ListsControlsFragment fragment = new ListsControlsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<MaterialCardItem> cards = new ArrayList<>();
        cards.add(new DisplayBodyItem.Builder()
                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
                .display(getString(R.string.lists_controls))
                .body(getString(R.string.lists_controls_txt))
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Checkbox")
                .button1("Sample", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListControlActivity.start(getContext(), VIEW_TYPE_ONE_LINE_CHECKBOX_ICON);
                    }
                })
                .button2("Alt", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListControlActivity.start(getContext(), VIEW_TYPE_ONE_LINE_AVATAR_CHECKBOX);
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Switch")
                .button1("Sample", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListControlActivity.start(getContext(), VIEW_TYPE_ONE_LINE_ICON_SWITCH);
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Reorder")
                .button1("Sample", null)
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Switch")
                .button1("Sample", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListControlActivity.start(getContext(), VIEW_TYPE_ONE_LINE_ICON_EXPAND);
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON)
                .headline("Leave-behinds")
                .button1("Sample", null)
                .build());

        getAdapter().swapData(cards);
    }
}
