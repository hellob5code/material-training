package fr.erictruong.training.material.ui.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.util.ApiUtils;

import static fr.erictruong.training.material.ui.card.Card.TYPE_SUBHEADER;

public class CardFragment extends RecyclerFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                if (parent.getChildLayoutPosition(view) < 1) {
                    outRect.set(0, 0, 0, 0);
                    return;
                }
                if (parent.getAdapter().getItemViewType(parent.getChildLayoutPosition(view)) == TYPE_SUBHEADER
                        || parent.getAdapter().getItemViewType(parent.getChildLayoutPosition(view) - 1) == TYPE_SUBHEADER) {
                    outRect.set(0, 0, 0, 0);
                    return;
                }

                if (ApiUtils.isLollipop()) {
                    outRect.top = getResources().getDimensionPixelSize(R.dimen.margin_small);
                } else {
                    outRect.top = getResources().getDimensionPixelSize(R.dimen.margin_xxsmall);
                }
            }
        });
    }
}
