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
import com.training.android.materiel.ui.adapter.SingleLineListAdapter;

public class ListsFragment extends Fragment {

    private static final String TAG = ListsFragment.class.getSimpleName();

    private String[] myDataset = new String[]{
            "I am single line item 1",
            "I am single line item 2",
            "I am single line item 3",
            "I am single line item 4",
            "I am single line item 5",
            "I am single line item 6",
            "I am single line item 7",
            "I am single line item 8",
            "I am single line item 9",
            "I am single line item 10",
            "I am single line item 11",
            "I am single line item 12",
            "I am single line item 13",
            "I am single line item 14",
            "I am single line item 15",
            "I am single line item 16",
            "I am single line item 17",
            "I am single line item 18",
            "I am single line item 19",
            "I am single line item 20",
    };

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

        // Specify an adapter (see also next example)
        mAdapter = new SingleLineListAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
