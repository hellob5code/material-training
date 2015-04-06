package fr.erictruong.training.material.ui.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import fr.erictruong.training.material.R;

public class TabsSamplePagerAdapter extends PagerAdapter {

    private static final String TAG = TabsSamplePagerAdapter.class.getSimpleName();

    private Activity mActivity;
    private String[] mDataset;

    public TabsSamplePagerAdapter(Activity activity, String[] dataset) {
        mActivity = activity;
        mDataset = dataset;
    }

    @Override
    public int getCount() {
        return mDataset.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDataset[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mActivity.getLayoutInflater().inflate(R.layout.dummy_content, container, false);

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
}
