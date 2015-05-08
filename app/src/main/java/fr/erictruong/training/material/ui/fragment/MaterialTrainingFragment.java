package fr.erictruong.training.material.ui.fragment;

import android.app.Activity;
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

public abstract class MaterialTrainingFragment extends RecyclerFragment {

    private OnScrollListener scrollListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            scrollListener = (OnScrollListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity + " must implement DatePickerDialogFragment.OnDateSetListener");
        }
    }

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

                int actionBarSize = getResources().getDimensionPixelSize(R.dimen.action_bar_size);

                // Set top margin of first card
                if (position == 0) {
                    outRect.top += actionBarSize;
                }

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
                    outRect.bottom = actionBarSize + margin;
                }
            }
        });
        getRecyclerView().addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                scrollListener.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    protected abstract List<Card> populateDataset();

    public interface OnScrollListener {
        void onScrolled(RecyclerView recyclerView, int dx, int dy);
    }
}
