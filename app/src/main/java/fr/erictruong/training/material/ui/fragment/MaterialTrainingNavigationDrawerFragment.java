package fr.erictruong.training.material.ui.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.adapter.MaterialCardAdapter;
import fr.erictruong.training.material.ui.card.Card;
import fr.erictruong.training.material.util.ApiUtils;

import java.util.List;

import static fr.erictruong.training.material.ui.card.Card.TYPE_SUBHEADER;

public abstract class MaterialTrainingNavigationDrawerFragment extends RecyclerFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerAdapter(new MaterialCardAdapter(getActivity(), populateDataset()));
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = parent.getChildLayoutPosition(view);
                int viewType = parent.getAdapter().getItemViewType(position);

                int margin;
                if (ApiUtils.isLollipop()) {
                    margin = getResources().getDimensionPixelSize(R.dimen.margin_small);
                } else {
                    margin = getResources().getDimensionPixelSize(R.dimen.margin_xxsmall);
                }

                outRect.set(margin * 2, margin, margin * 2, 0);

                if (viewType == TYPE_SUBHEADER) {
                    // Remove top margin for subheader card
                    outRect.top = 0;
                }
                if (position > 1) {
                    int previousViewType = parent.getAdapter().getItemViewType(position - 1);
                    if (previousViewType == TYPE_SUBHEADER) {
                        // Remove top margin for card preceded by a subheader card
                        outRect.top = 0;
                    }
                }

                // Set bottom margin of last card
                if (position == parent.getAdapter().getItemCount() - 1) {
                    outRect.bottom = margin;
                }
            }
        });
    }

    protected abstract List<Card> populateDataset();
}
