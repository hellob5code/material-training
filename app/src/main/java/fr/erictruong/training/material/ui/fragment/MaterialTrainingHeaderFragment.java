package fr.erictruong.training.material.ui.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AspectRatioImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Picasso;
import fr.erictruong.training.material.R;

public abstract class MaterialTrainingHeaderFragment extends MaterialTrainingFragment {

    @InjectView(R.id.img) AspectRatioImageView img;
    @InjectView(R.id.recycler) RecyclerView recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_header, container, false);
        ButterKnife.inject(this, view);
        setUpHeader();
        setRecyclerView(recycler);
        return view;
    }

    private void setUpHeader() {
        TypedValue outValue = new TypedValue();
        getResources().getValue(R.dimen.ratio_16_9_inverse, outValue, true);
        float ratio = outValue.getFloat();
        img.setAspectRatio(ratio);
        img.setAspectRatioEnabled(true);
        Picasso.with(getActivity())
                .load(getHeaderDrawable())
                .fit()
                .into(img);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = parent.getChildLayoutPosition(view);
                if (position == 0) {
                    outRect.top = getResources().getDimensionPixelSize(R.dimen.action_bar_size_x3);
                }
            }
        });
        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int verticalScrollOffset = recycler.computeVerticalScrollOffset();
                img.setTranslationY(-verticalScrollOffset);
            }
        });
    }

    protected abstract int getHeaderDrawable();
}
