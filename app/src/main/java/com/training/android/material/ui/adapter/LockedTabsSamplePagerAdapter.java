package com.training.android.material.ui.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ObservableScrollView;
import com.training.android.material.R;

public class LockedTabsSamplePagerAdapter extends PagerAdapter {

    private static final String TAG = LockedTabsSamplePagerAdapter.class.getSimpleName();

    public static interface Callbacks {

        public void onScrollChanged(int scrollY);

        public void onDownMotionEvent();

        public void onUpOrCancelMotionEvent();
    }

    private Callbacks mCallbacks;

    private Activity mActivity;
    private String[] mDataset;

    private ObservableScrollView[] mObservableScrollViews;
    private View[] mStickyPlaceholderViews;

    public LockedTabsSamplePagerAdapter(Activity activity, String[] dataset) {
        mActivity = activity;
        mDataset = dataset;
        mObservableScrollViews = new ObservableScrollView[dataset.length];
        mStickyPlaceholderViews = new View[dataset.length];
    }

    @Override
    public int getCount() {
        return mDataset.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDataset[position];
    }

    public ObservableScrollView getScrollView(int position) {
        return mObservableScrollViews[position];
    }

    public View getStickyPlaceholderView(int position) {
        return mStickyPlaceholderViews[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = mActivity.getLayoutInflater().inflate(R.layout.dummy_content_alt, container, false);

        ObservableScrollView scrollView = (ObservableScrollView) view.findViewById(R.id.scroll_view);
        scrollView.setCallbacks(new ObservableScrollView.Callbacks() {
            @Override
            public void onScrollChanged(int scrollY) {
                mCallbacks.onScrollChanged(scrollY);
            }

            @Override
            public void onDownMotionEvent() {
            }

            @Override
            public void onUpOrCancelMotionEvent() {
            }
        });
        mObservableScrollViews[position] = scrollView;
        mStickyPlaceholderViews[position] = view.findViewById(R.id.placeholder_sticky);

        // TODO: Setup layout content here.

        container.addView(view);
        Log.d(TAG, "instantiateItem() [position: " + position + "]");

        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        Log.d(TAG, "destroyItem() [position: " + position + "]");
    }

    public void setCallbacks(Callbacks listener) {
        mCallbacks = listener;
    }
}
