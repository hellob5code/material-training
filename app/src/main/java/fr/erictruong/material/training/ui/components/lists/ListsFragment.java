package fr.erictruong.material.training.ui.components.lists;

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
import static fr.erictruong.android.cards.MaterialCardAdapter.VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_ICON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_AVATAR;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_AVATAR_ICON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_ICON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_AVATAR;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_AVATAR_ICON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_ICON;

public class ListsFragment extends BaseCardFragment {

    public static ListsFragment newInstance() {
        Bundle args = new Bundle();
        ListsFragment fragment = new ListsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<MaterialCardItem> cards = new ArrayList<>();
        cards.add(new DisplayBodyItem.Builder()
                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
                .display(getString(R.string.lists))
                .body(getString(R.string.lists_txt))
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON)
                .headline("Single-line list")
                .button1("Text only", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListActivity.start(getContext(), VIEW_TYPE_ONE_LINE);
                    }
                })
                .button2("Icon with text", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListActivity.start(getContext(), VIEW_TYPE_ONE_LINE_ICON);
                    }
                })
                .button3("Avatar with text", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListActivity.start(getContext(), VIEW_TYPE_ONE_LINE_AVATAR);
                    }
                })
                .button4("Avatar with text and icon", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListActivity.start(getContext(), VIEW_TYPE_ONE_LINE_AVATAR_ICON);
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON)
                .headline("Two-line list")
                .button1("Text only", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListActivity.start(getContext(), VIEW_TYPE_TWO_LINE);
                    }
                })
                .button2("Icon with text", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListActivity.start(getContext(), VIEW_TYPE_TWO_LINE_ICON);
                    }
                })
                .button3("Avatar with text", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListActivity.start(getContext(), VIEW_TYPE_TWO_LINE_AVATAR);
                    }
                })
                .button4("Avatar with text and icon", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListActivity.start(getContext(), VIEW_TYPE_TWO_LINE_AVATAR_ICON);
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON)
                .headline("Three-line list")
                .button1("Text only", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListActivity.start(getContext(), VIEW_TYPE_THREE_LINE);
                    }
                })
                .button2("Icon with text", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListActivity.start(getContext(), VIEW_TYPE_THREE_LINE_ICON);
                    }
                })
                .button3("Avatar with text", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListActivity.start(getContext(), VIEW_TYPE_THREE_LINE_AVATAR);
                    }
                })
                .button4("Avatar with text and icon", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SampleListActivity.start(getContext(), VIEW_TYPE_THREE_LINE_AVATAR_ICON);
                    }
                })
                .build());

        getAdapter().swapData(cards);
    }
}
