package com.training.android.material.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ObservableScrollView;
import android.widget.SlidingTabLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;
import com.training.android.material.ui.adapter.LockedTabsSamplePagerAdapter;
import com.training.android.material.util.ApiUtils;
import com.training.android.material.util.ThemeUtils;

public class LockedFixedTabsActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener, LockedTabsSamplePagerAdapter.Callbacks {

    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.sliding_tabs) SlidingTabLayout slidingTabLayout;
    @InjectView(R.id.view_pager) ViewPager viewPager;

    private LockedTabsSamplePagerAdapter mAdapter;

    private ObservableScrollView mCurrentObservableScrollView;
    private View mCurrentPlaceholderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_locked);
        ButterKnife.inject(this);

        if (ApiUtils.isLollipop()) {
            int statusBarrSize = getResources().getDimensionPixelSize(R.dimen.status_bar_size);
            toolbar.getLayoutParams().height += statusBarrSize;
            toolbar.setPadding(0, statusBarrSize, 0, 0);
            View navdrawer = findViewById(R.id.navdrawer);
            navdrawer.setPadding(0, statusBarrSize, 0, 0);
        }
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View view) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        mAdapter = new LockedTabsSamplePagerAdapter(this, new String[]{ "No. ONE", "Item Two", "The Third" });
        mAdapter.setCallbacks(this);

        viewPager.setAdapter(mAdapter);

        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setCustomTabView(R.layout.tab_indicator_material, android.R.id.text1);
        slidingTabLayout.setSelectedIndicatorColors(ThemeUtils.obtainAccentColor(this));
        slidingTabLayout.setViewPager(viewPager);
        slidingTabLayout.setOnPageChangeListener(this);

        drawerLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mCurrentObservableScrollView = mAdapter.getScrollView(0);
                mCurrentPlaceholderView = mAdapter.getStickyPlaceholderView(0);
                onScrollChanged(mCurrentObservableScrollView.getScrollY());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tabs, menu);
        return true;
    }

    @Override
    public void onScrollChanged(int scrollY) {
        toolbar.setTranslationY(-scrollY);
        int diff = mCurrentPlaceholderView.getTop() - scrollY;
        slidingTabLayout.setTranslationY(diff > 0 ? diff : 0);
    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent() {

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
    }

    @Override
    public void onPageSelected(int i) {
        mCurrentObservableScrollView = mAdapter.getScrollView(i);
        mCurrentPlaceholderView = mAdapter.getStickyPlaceholderView(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {
    }
}