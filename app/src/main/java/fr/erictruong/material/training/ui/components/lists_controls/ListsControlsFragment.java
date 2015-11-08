package fr.erictruong.material.training.ui.components.lists_controls;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.components.cards.DisplayBodyItem;
import fr.erictruong.material.training.ui.components.cards.HeadlineBodyItem;
import fr.erictruong.material.training.ui.components.cards.MaterialCardItem;
import fr.erictruong.material.training.ui.core.BaseCardFragment;

import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_CHECKBOX;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_EXPAND;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON_EXPAND;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON_SWITCH;
import static fr.erictruong.material.training.ui.components.cards.MaterialCardAdapter.VIEW_TYPE_DISPLAY1_PRIMARY_BODY2;
import static fr.erictruong.material.training.ui.components.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_CHECKBOX_ICON;

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
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON)
                .headline(getString(R.string.lists_controls_types_of_list_controls))
                .button1("Checkbox", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListControlActivity.start(getContext(), VIEW_TYPE_ONE_LINE_CHECKBOX_ICON);
                    }
                })
                .button2("Checkbox (alt)", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListControlActivity.start(getContext(), VIEW_TYPE_ONE_LINE_AVATAR_CHECKBOX);
                    }
                })
                .button3("Switch", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListControlActivity.start(getContext(), VIEW_TYPE_ONE_LINE_ICON_SWITCH);
                    }
                })
                .button4("Reorder", null)
                .button5("Expand/collapse", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListControlActivity.start(getContext(), VIEW_TYPE_ONE_LINE_ICON_EXPAND);
                    }
                })
                .button6("Leave-behinds", null)
                .build());

        getAdapter().swapData(cards);
    }
}
