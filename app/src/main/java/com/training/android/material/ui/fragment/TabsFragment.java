package com.training.android.material.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;
import com.training.android.material.ui.activity.*;
import com.training.android.material.ui.adapter.MaterialCardAdapter;
import com.training.android.material.ui.card.*;
import com.training.android.material.util.ApiUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static com.training.android.material.ui.card.HeaderCard.TYPE_HEADER;
import static com.training.android.material.ui.card.HeadlineOneBodyThreeButtonCard.TYPE_HEADLINE_ONE_BODY_THREE_BUTTON;

public class TabsFragment extends Fragment {

    @InjectView(R.id.recycler_view) RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        ButterKnife.inject(this, view);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                if (parent.getChildPosition(view) < 1)
                    return;
                if (ApiUtils.isLollipop()) {
                    outRect.top = getResources().getDimensionPixelSize(R.dimen.margin_small);
                } else {
                    outRect.top = getResources().getDimensionPixelSize(R.dimen.margin_xsmall);
                }
            }
        });

        List<Card> dataset = populateDataset();

        mAdapter = new MaterialCardAdapter(dataset);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    private List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<Card>();
        dataset.add(new HeaderCard(Card.TYPE_NONE, "Usage"));
        dataset.add(new HeadlineOneBodyCard(Card.TYPE_NONE, null, "A tab provides the affordance for displaying grouped content. A tab label succinctly describes the tab’s associated grouping of content."));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "Mobile tabs", null,
                "Example #1",
                null));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "When to use", "Use tabs to organize content at a high level, for example, presenting different sections of a newspaper. Don’t use tabs for carousels or pagination of content. Those use cases involve viewing content, not navigating between groups of content.\n\nFor more detail about using tabs for navigating top-level views, see “Top-level view strategies” in Layout > Structure > UI Regions and Guidance.",
                "Example #1",
                null));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "Tab characteristics", "Tabs are presented as a single row.\n\nTabs should not be nested. Content in a tab should not consist of another set of tabbed content.\n\nA set of tabs contains at minimum a pair of tabs and no more than six tabs.\n\nTabs control the display of content in a consistent location.\n\nThe tab corresponding to the visible content is highlighted.\n\nTabs are grouped together and the group of tabs is in turn connected with their content.\n\nKeeping tabs adjacent to their content helps maintain the relationship between the two, as too great a separation can introduce ambiguity.",
                "Example #1",
                "Example #2",
                null,
                null));
        dataset.add(new HeaderCard(Card.TYPE_NONE, "Content"));
        dataset.add(new HeadlineOneBodyCard(Card.TYPE_NONE, null, "Content presented in tabs can vary widely, even between tabs. For example, different years within a tabbed portfolio or different types of settings.\n\nAll content within a set of tabs should be related under a larger organizing principle (for example, Settings or Directions), with each tab’s content mutually exclusive of the others'.\n\nTab labels should provide meaningful distinctions that logically organize associated content.\n\nTab labels may be icons or text and must not be truncated.\n\nAvoid the need for cross-tab comparison of content; significant cross-tab comparison may indicate the content would benefit from a different organization or presentation."));
        dataset.add(new HeaderCard(Card.TYPE_NONE, "Types of tabs"));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "Fixed tabs", "Fixed tabs display all tabs concurrently and are best used with content that benefits from quick pivots between tabs, such as switching transportation methods for directions in Google Maps.\n\nThe maximum number of tabs is limited by the view’s width. Fixed tabs have equal width, based on the widest tab label. To navigate between fixed tabs, touch the tab or swipe the content area left or right.",
                "Example #1",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), FixedTabsActivity.class));
                        return null;
                    }
                }));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "Scrollable tabs", "Scrollable tabs display a subset of tabs at any given moment, and can contain longer tab labels and a larger number of tabs. They are best used for browsing contexts in touch interfaces when users don’t need to directly compare the tab labels.\n\nTo navigate between scrollable tabs, touch the tab, swipe the tabs left or right, or swipe the content area left or right.",
                "Example #1",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), ScrollableTabsActivity.class));
                        return null;
                    }
                }));
        return dataset;
    }
}
