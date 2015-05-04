package fr.erictruong.training.material.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import fr.erictruong.training.material.R;

public class RecyclerFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        return view;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public RecyclerView.Adapter getRecyclerAdapter() {
        return adapter;
    }

    public void setRecyclerAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
        recyclerView.setAdapter(this.adapter);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        recyclerView.setLayoutManager(this.layoutManager);
    }
}
