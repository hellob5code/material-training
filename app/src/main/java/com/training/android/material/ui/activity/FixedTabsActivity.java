package com.training.android.material.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SlidingTabLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;
import com.training.android.material.ui.adapter.TabsSamplePagerAdapter;
import com.training.android.material.util.ApiUtils;
import com.training.android.material.util.ThemeUtils;
import com.training.android.material.util.ViewUtils;

public class FixedTabsActivity extends ActionBarActivity {

    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.navdrawer_items) ExpandableListView navdrawerItems;
    @InjectView(R.id.sliding_tabs) SlidingTabLayout slidingTabLayout;
    @InjectView(R.id.view_pager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        ButterKnife.inject(this);

        if (ApiUtils.isLollipop()) {
            int statusBarSize = getResources().getDimensionPixelSize(R.dimen.status_bar_size);
            toolbar.getLayoutParams().height += statusBarSize;
            toolbar.setPadding(0, statusBarSize, 0, 0);
            navdrawerItems.setPadding(0, navdrawerItems.getPaddingTop() + statusBarSize, 0, 0);
        }
        ViewUtils.setMaxWidth(navdrawerItems, getResources().getDimensionPixelSize(R.dimen.navdrawer_max_width_material));
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

        viewPager.setAdapter(new TabsSamplePagerAdapter(this, new String[]{ "No. ONE", "Item Two", "The Third" }));

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setCustomTabView(R.layout.tab_indicator_material, android.R.id.text1);
        slidingTabLayout.setSelectedIndicatorColors(ThemeUtils.obtainColorAccent(this));
        slidingTabLayout.setViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tabs, menu);
        return true;
    }
}