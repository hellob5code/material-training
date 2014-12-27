package com.training.android.materiel.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.materiel.R;
import com.training.android.materiel.ui.adapter.MaterialIconListAdapter;
import com.training.android.materiel.ui.listcontrol.AvatarListControl;
import com.training.android.materiel.ui.listcontrol.IconListControl;
import com.training.android.materiel.ui.row.SingleLineListRow;

import java.util.ArrayList;
import java.util.List;

public class ListsFragment extends Fragment {

    private static final String TAG = ListsFragment.class.getSimpleName();

    private List<SingleLineListRow> myDataset =new ArrayList<SingleLineListRow>();

    @InjectView(R.id.recycler_view) RecyclerView mRecyclerView;

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

        myDataset.add(new SingleLineListRow(1, "Single-line item 1", new IconListControl(getActivity(), R.drawable.device_ic_developer_mode), null));
        myDataset.add(new SingleLineListRow(1, "Single-line item 2", new IconListControl(getActivity(), R.drawable.device_ic_developer_mode), null));
        myDataset.add(new SingleLineListRow(1, "Single-line item 3", new IconListControl(getActivity(), R.drawable.device_ic_developer_mode), null));
        myDataset.add(new SingleLineListRow(1, "Single-line item 4"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 5"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 6"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 7"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 8"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 9"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 10"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 11"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 12"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 13"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 14"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 15"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 16"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 17"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 18"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 19"));
        myDataset.add(new SingleLineListRow(1, "Single-line item 20"));

        // Specify an adapter
        mAdapter = new MaterialIconListAdapter(myDataset, true, true);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
