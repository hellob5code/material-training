package fr.erictruong.material.training.ui.core;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import fr.erictruong.android.core.fragment.RecyclerFragment;
import fr.erictruong.android.core.util.BuildVersion;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.components.cards.MaterialCardAdapter;

public abstract class BaseCardFragment extends RecyclerFragment {

    private MaterialCardAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MaterialCardAdapter();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getRecyclerView();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int margin;
                if (BuildVersion.isLollipop()) {
                    margin = getResources().getDimensionPixelSize(R.dimen.margin_small);
                    outRect.set(0, margin, 0, 0);
                } else {
                    margin = getResources().getDimensionPixelSize(R.dimen.margin_xxsmall);
                    outRect.set(-margin, margin, -margin, 0);
                }

                int position = parent.getChildAdapterPosition(view);

                if (position == 0) {
                    outRect.top = 0;
                }
            }
        });
    }

    public MaterialCardAdapter getAdapter() {
        return adapter;
    }
}
