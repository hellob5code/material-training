package fr.erictruong.material.training.ui.components.tabs;

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

public class TabsFragment extends BaseCardFragment {

    public static TabsFragment newInstance() {
        Bundle args = new Bundle();
        TabsFragment fragment = new TabsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<MaterialCardItem> cards = new ArrayList<>();
        cards.add(new DisplayBodyItem.Builder()
                .viewType(VIEW_TYPE_DISPLAY1_PRIMARY_BODY2)
                .display(getString(R.string.tabs))
                .body(getString(R.string.tabs_txt))
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON)
                .headline("Fixed tabs")
                .button1("Default app bar and fixed tab bar", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FixedTabBarActivity.start(getContext());
                    }
                })
                .button2("Extended app bar and fixed tab bar", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ExtendedAppBarTabBarActivity.start(getContext());
                    }
                })
                .button3("Fixed tab bar pinned to top with scrolled content", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         PinnedTabBarActivity.start(getContext());
                    }
                })
                .button4("Inset search, app bar, and fixed tab bar", null)
                .button5("Text color is the same as the tab indicator", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         ColoredTabBarActivity.start(getContext());
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON)
                .headline("Scrollable tabs")
                .button1("Default app bar and scrollable tab bar", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         ScrollableTabBarActivity.start(getContext());
                    }
                })
                .build());
        cards.add(new HeadlineBodyItem.Builder()
                .viewType(VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON)
                .headline("Tabs with icons")
                .button1("Default app bar and fixed tab bar with icons", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         FixedTabBarIconsActivity.start(getContext());
                    }
                })
                .button2("Icon color is the same as the tab indicator", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         ColoredTabBarIconsActivity.start(getContext());
                    }
                })
                .build());

        getAdapter().swapData(cards);
    }
}
