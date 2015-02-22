package com.training.android.material.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.training.android.material.ui.activity.AccentFixedTabsActivity;
import com.training.android.material.ui.activity.FixedTabsActivity;
import com.training.android.material.ui.activity.LockedFixedTabsActivity;
import com.training.android.material.ui.activity.ScrollableTabsActivity;
import com.training.android.material.ui.adapter.MaterialCardAdapter;
import com.training.android.material.ui.card.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class TabsRecyclerFragment extends CardFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerAdapter(new MaterialCardAdapter(getActivity(), populateDataset()));
    }

    private List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<Card>();
        dataset.add(new SubheaderCard(0, "Usage"));
        dataset.add(new HeadlineBodyCard(0, null, "A tab provides the affordance for displaying grouped content. A tab label succinctly describes the tab’s associated grouping of content."));
        dataset.add(new HeadlineBodySixVerticalButtonCard(0, "Mobile tabs", null,
                "Extended app bar and tab bar",
                "Inset search, app bar, and tab bar",
                "Default app bar and tab bar",
                "Default app bar and scrollable tab bar",
                "Text color same as tab indicator",
                "Tab bar locked on scroll",
                null,
                null,
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), FixedTabsActivity.class));
                        return null;
                    }
                },
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), ScrollableTabsActivity.class));
                        return null;
                    }
                },
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), AccentFixedTabsActivity.class));
                        return null;
                    }
                },
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), LockedFixedTabsActivity.class));
                        return null;
                    }
                }));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "When to use", "Use tabs to organize content at a high level, for example, presenting different sections of a newspaper. Don’t use tabs for carousels or pagination of content. Those use cases involve viewing content, not navigating between groups of content.\n\nFor more detail about using tabs for navigating top-level views, see “Top-level view strategies” in Layout > Structure > UI Regions and Guidance.",
                "Example #1",
                null));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Tab characteristics", "Tabs are presented as a single row.\n\nTabs should not be nested. Content in a tab should not consist of another set of tabbed content.\n\nA set of tabs contains at minimum a pair of tabs and no more than six tabs.\n\nTabs control the display of content in a consistent location.\n\nThe tab corresponding to the visible content is highlighted.\n\nTabs are grouped together and the group of tabs is in turn connected with their content.\n\nKeeping tabs adjacent to their content helps maintain the relationship between the two, as too great a separation can introduce ambiguity.",
                "Example #1",
                "Example #2",
                null,
                null));
        dataset.add(new SubheaderCard(0, "Content"));
        dataset.add(new HeadlineBodyCard(0, null, "Content presented in tabs can vary widely, even between tabs. For example, different years within a tabbed portfolio or different types of settings.\n\nAll content within a set of tabs should be related under a larger organizing principle (for example, Settings or Directions), with each tab’s content mutually exclusive of the others'.\n\nTab labels should provide meaningful distinctions that logically organize associated content.\n\nTab labels may be icons or text and must not be truncated.\n\nAvoid the need for cross-tab comparison of content; significant cross-tab comparison may indicate the content would benefit from a different organization or presentation."));
        dataset.add(new SubheaderCard(0, "Types of tabs"));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Fixed tabs", "Fixed tabs display all tabs concurrently and are best used with content that benefits from quick pivots between tabs, such as switching transportation methods for directions in Google Maps.\n\nThe maximum number of tabs is limited by the view’s width. Fixed tabs have equal width, based on the widest tab label. To navigate between fixed tabs, touch the tab or swipe the content area left or right.",
                "Example #1",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), FixedTabsActivity.class));
                        return null;
                    }
                }));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Scrollable tabs", "Scrollable tabs display a subset of tabs at any given moment, and can contain longer tab labels and a larger number of tabs. They are best used for browsing contexts in touch interfaces when users don’t need to directly compare the tab labels.\n\nTo navigate between scrollable tabs, touch the tab, swipe the tabs left or right, or swipe the content area left or right.",
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
