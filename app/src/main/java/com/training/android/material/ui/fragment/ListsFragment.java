package com.training.android.material.ui.fragment;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import com.training.android.material.ui.adapter.MaterialCardAdapter;
import com.training.android.material.ui.card.*;

import java.util.ArrayList;
import java.util.List;

import static com.training.android.material.ui.card.Card.TYPE_PRIMARY_HEADLINE_BODY_2;

public class ListsFragment extends CardFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerAdapter(new MaterialCardAdapter(getActivity(), populateDataset()));
    }

    private List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<Card>();
        dataset.add(new HeadlineBodyCard(0, TYPE_PRIMARY_HEADLINE_BODY_2, "Lists", "Lists present multiple line items in a vertical arrangement as a single continuous element."));
        dataset.add(new SubheaderCard(0, "Usage"));
        dataset.add(new HeadlineBodyCard(0, null, Html.fromHtml("A <b>list</b> consists of a single continuous column of tessellated sub-divisions of equal width called <b>rows</b> that function as containers for <b>tiles</b>.<br/><br/><b>Tiles</b> hold content, and can vary in height within a list.<br/><br/>Lists are best suited to presenting a <b>homogeneous data type or sets of data types</b>, such as images and text, optimized for <b>reading comprehension</b> with the goal of differentiating between like data types or qualities within a single data type.<br/><br/>If more than three lines of text need to be shown in list tiles, use cards instead.<br/><br/>If the primary distinguishing content consists of images, use a grid list.")));
        dataset.add(new SubheaderCard(0, "Content"));
        dataset.add(new HeadlineBodyCard(0, "Tile content", Html.fromHtml("List tiles present collections of related content in a consistent format, using hierarchy to enhance readability by prioritizing a consistent type or set of content. For example, in an email app, an inbox list emphasizes an avatar and text snippet over a time stamp. This helps users more easily find the most important information within the collection of content.<br/><br/>List tiles can contain up to three lines of text, and the amount of text can vary between tiles within the same list. To display more than three lines of text, use a card.<br/><br/>Bias the most distinguishing content in a tile towards the left of the tile. In tiles with mutli-line content, place the most distinguishing content in the first line.")));
        dataset.add(new HeadlineBodyCard(0, "Tile actions", Html.fromHtml("The majority of space on a list tile should be dedicated to the primary action.<br/><br/>Because actions are not distinguishing elements of list tiles, place supplemental actions on the right side of the tile.<br/><br/>Primary and supplemental actions, such as play, zoom in, delete, and select, are immediate and typically do not have a submenu of options (action overflow) within the list.<br/><br/>Actions can open a subsequent view, such as a card.<br/><br/><b>Primary actions:</b><br/>\u2022 Fill the entire tile, and therefore are not represented via icons, text, etc.<br/>\u2022 Are consistent throughout tiles in a specific list. For example, the primary action for all tiles in a single list of music would be to play a song, or in a list of emails, to open to read an email.<br/><b>Supplemental actions:</b><br/>\u2022 Are represented in tiles with icons, secondary text, etc.<br/>\u2022 Are functionally consistent throughout tiles in a specific list, for example, an icon that indicates whether someone is online.<br/>\u2022 Are placed in a consistent location within the tiles of a specific list.<br/><br/>Avoid creating visual noise by repeatedly using supplemental actions in tiles, for example, by displaying a share action in every tile. Toggles, such as stars or pins, are exceptions because they provide meaningful information by displaying state.")));
        dataset.add(new SubheaderCard(0, "Behavior"));
        dataset.add(new HeadlineBodyCard(0, "Scrolling", "Lists scroll only vertically."));
        dataset.add(new HeadlineBodyCard(0, "Gestures", "Per-tile swipe actions should be consistent within lists.\n\nWhere appropriate, tiles can be moved between a list and a drop target (for example, moving a file into a folder) and picked up and manually reordered within a list."));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Tile filtering and sorting", "List tiles can be programmatically sorted or filtered by date, file size, alphabetical order, or other parameters.",
                "Alphabetical sorting makes information easier to find.",
                null));
        dataset.add(new SubheaderCard(0, "Specs"));
        dataset.add(new HeadlineBodyCard(0, null, Html.fromHtml("In a <b>single-line list</b>, each tile contains a single line of text. The amount of text can vary between tiles within the same list.")));
        dataset.add(new HeadlineBodyCard(0, null, Html.fromHtml("In a <b>two-line list</b>, each tile contains a maximum of two lines of text. The amount of text can vary between tiles within the same list.")));
        dataset.add(new HeadlineBodyCard(0, null, Html.fromHtml("In a <b>three-line list</b>, each tile contains a maximum of three lines of text.<br/><br/>The amount of text can vary between tiles within the same list.")));
        dataset.add(new HeadlineBodySixVerticalButtonCard(0, "Single-line list", Html.fromHtml("<b>Text only</b><br/><br/>Font: Roboto Regular 16sp<br/>Tile height: 48dp<br/>Text padding, top: 16dp<br/>Text padding, bottom: 20dp<br/><br/>Bottom padding is measured from the baseline.<br/><br/>Add 8dp padding at the top and bottom of a list. One exception is at the top of a list with a subheader, because subheaders contain their own padding.<br/><br/><b>Icon with text</b><br/>Font: Roboto Regular 16sp<br/>Tile height: 56dp<br/>Icon padding, left: 16dp<br/>Text padding, left: 72dp<br/>Text padding, top: 16dp<br/>Text padding, bottom: 20dp<br/><br/>Bottom padding is measured from the baseline.<br/><br/>Add 8dp padding at the top and bottom of a list. One exception is at the top of a list with a subheader, because subheaders contain their own padding.<br/><br/><b>Avatar with text</b><br/><br/>Font: Roboto Regular 16sp<br/>Tile height: 56dp<br/>Left avatar padding: 16dp<br/>Text padding, left: 72dp<br/>Text padding, top: 20dp<br/>Text padding, bottom: 24dp<br/><br/>Bottom padding is measured from the baseline.<br/><br/>Add 8dp padding at the top and bottom of a list. One exception is at the top of a list with a subheader, because subheaders contain their own padding.<br/><br/><b>Avatar with text and icon</b><br/><br/>Font: Roboto Regular 16sp<br/>Tile height: 48dp<br/>Left avatar padding: 16dp<br/>Text padding, left: 72dp<br/>Text padding, top: 20dp<br/>Text padding, bottom: 24dp<br/><br/>Bottom padding is measured from the baseline.<br/><br/>Right icon padding: 16dp<br/><br/>Add 8dp padding at the top and bottom of a list. One exception is at the top of a list with a subheader, because subheaders contain their own padding."),
                "Text only",
                "Icon with text",
                "Avatar with text",
                "Avatar with text and icon",
                null,
                null,
                null,
                null));
        dataset.add(new HeadlineBodySixVerticalButtonCard(0, "Two-line list", Html.fromHtml("<b>Text only</b><br/><br/>Primary text font: Roboto Regular 16sp<br/>Secondary text font: Roboto Regular 14sp<br/>Tile height: 72dp<br/>Text padding, left: 16dp<br/>Text padding, top and bottom: 20dp<br/><br/>Bottom padding is measured from the baseline.<br/><br/>Add 8dp padding at the top and bottom of a list. One exception is at the top of a list with a subheader, because subheaders contain their own padding.<br/><br/><b>Icon with text</b><br/><br/>Primary text font: Roboto Regular 16sp<br/>Secondary text font: Roboto Regular 14sp<br/>Tile height: 72dp<br/>Left icon padding: 16dp<br/>Text padding, left: 72dp<br/>Text padding, top and bottom: 20dp<br/>Bottom padding is measured from the baseline.<br/><br/>Add 8dp padding at the top and bottom of a list. One exception is at the top of a list with a subheader, because subheaders contain their own padding.<br/><br/><b>Avatar with text</b><br/><br/>Primary text font: Roboto Regular 16sp<br/>Secondary text font: Roboto Regular 14sp<br/>Tile height: 72dp<br/>Left avatar padding: 16dp<br/>Text padding, left: 72dp<br/>Text padding, top and bottom: 20dp<br/><br/>Bottom padding is measured from the baseline.<br/><br/>Center-align icon with text area.<br/><br/>Add 8dp padding at the top and bottom of a list. One exception is at the top of a list with a subheader, because subheaders contain their own padding.<br/><br/><b>Avatar with text and icon</b><br/><br/>Primary text font: Roboto Regular 16sp<br/>Secondary text font: Roboto Regular 14sp<br/>Tile height: 72dp<br/>Left avatar padding: 16dp<br/>Text padding, left: 72dp<br/>Text padding, top and bottom: 20dp<br/><br/>Bottom padding is measured from the baseline.<br/><br/>Right icon padding: 16dp<br/><br/>Add 8dp padding at the top and bottom of a list. One exception is at the top of a list with a subheader, because subheaders contain their own padding."),
                "Text only",
                "Icon with text",
                "Avatar with text",
                "Avatar with text and icon",
                null,
                null,
                null,
                null));
        dataset.add(new HeadlineBodySixVerticalButtonCard(0, "Three-line list", Html.fromHtml("<b>Text only</b><br/><br/>Primary text font: Roboto Regular 16sp<br/><br/>Secondary text font: Roboto Regular 14sp<br/>Tile height: 88dp<br/>Text padding, left: 16dp<br/>Text padding, top: 16dp<br/>Text padding, bottom: 20dp<br/><br/>Bottom padding is measured from the baseline.<br/><br/>Add 8dp padding at the top and bottom of a list. One exception is at the top of a list with a subheader, because subheaders contain their own padding.<br/><br/><b>Icon with text</b><br/><br/>Primary text font: Roboto Regular 16sp<br/>Secondary text font: Roboto Regular 14sp<br/>Tile height: 88dp<br/>Left icon padding: 16dp<br/>Text left padding: 72dp<br/>Text padding, top: 16dp<br/>Text padding, bottom: 20dp<br/><br/>Bottom padding is measured from the baseline.<br/><br/>Top-align icon with primary text.<br/><br/>Add 8dp padding at the top and bottom of a list. One exception is at the top of a list with a subheader, because subheaders contain their own padding.<br/><br/><b>Avatar with text</b><br/><br/>Primary text font: Roboto Regular 16sp<br/>Secondary text font: Roboto Regular 14sp<br/>Tile height: 88dp<br/>Left avatar padding: 16dp<br/>Left text padding: 72dp<br/>Text padding, top: 16dp<br/>Text padding, bottom: 20dp<br/><br/>Bottom padding is measured from the baseline.<br/><br/>Top-align avatar with primary text.<br/><br/>Add 8dp padding at the top and bottom of a list. One exception is at the top of a list with a subheader, because subheaders contain their own padding.<br/><br/><b>Avatar with text and icon</b><br/><br/>Primary text font: Roboto Regular 16sp<br/>Secondary text font: Roboto Regular 14sp<br/>Tile height: 88dp<br/>Left avatar padding: 16dp<br/>Text left padding: 72dp<br/>Text padding, top: 16dp<br/>Text padding, bottom: 20dp<br/><br/>Bottom padding is measured from the baseline.<br/><br/>Right icon padding: 16dp<br/><br/>Top-align avatar and icon with primary text.<br/><br/>Add 8dp padding at the top and bottom of a list. One exception is at the top of a list with a subheader, because subheaders contain their own padding."),
                "Text only",
                "Icon with text",
                "Avatar with text",
                "Avatar with text and icon",
                null,
                null,
                null,
                null));
        return dataset;
    }
    /*extends Fragment {

    private static final String TAG = ListsFragment.class.getSimpleName();

    private List<Tile> myDataset =new ArrayList<Tile>();

    @InjectView(R.id.recycler) RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lists, container, false);
        ButterKnife.inject(this, view);

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // Use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        myDataset.add(new SubheaderTile(0, "Create"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 1", new IconListControl(getActivity(), R.drawable.device_ic_developer_mode), null));
        myDataset.add(new SingleLineListTile(1, "Single-line item 2", new IconListControl(getActivity(), R.drawable.device_ic_developer_mode), null));
        myDataset.add(new SingleLineListTile(1, "Single-line item 3", new IconListControl(getActivity(), R.drawable.device_ic_developer_mode), null));
        myDataset.add(new SingleLineListTile(1, "Single-line item 4"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 5"));
        myDataset.add(new SubheaderTile(0, "Aaa"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 6"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 7"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 8"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 9"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 10"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 11"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 12"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 13"));
        myDataset.add(new DividerListTile());
        myDataset.add(new SingleLineListTile(1, "Single-line item 14"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 15"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 16"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 17"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 18"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 19"));
        myDataset.add(new SingleLineListTile(1, "Single-line item 20"));

        // Specify an adapter
        mAdapter = new MaterialListAdapter(myDataset, true, true);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }*/
}
