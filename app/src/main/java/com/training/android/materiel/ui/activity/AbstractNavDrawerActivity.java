package com.training.android.materiel.ui.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import com.training.android.materiel.R;

import java.util.ArrayList;

public abstract class AbstractNavDrawerActivity extends Activity {

    private static final String TAG = AbstractNavDrawerActivity.class.getSimpleName();

    protected abstract DrawerLayout getDrawerLayout();

    protected abstract View getContentLayout();

    protected abstract void createNavigationDrawerItems();

    protected abstract boolean goToNavDrawerItem(NavDrawerItem item);

    // Delay to launch nav drawer item, to allow close animation to play
    private static final int NAVDRAWER_LAUNCH_DELAY = 200;

    // Fade in and fade out durations for the main content when switching between
    // different Activities of the app through the Nav Drawer
    protected static final int CONTENT_FADE_OUT_DURATION = 100;
    protected static final int CONTENT_FADE_IN_DURATION = 100;

    protected static final int NAVDRAWER_ITEM_INVALID = -1;
    protected static final int NAVDRAWER_ITEM_SEPARATOR = -2;

    /**
     * Ordered list of items added to the navigation drawer
     */
    protected ArrayList<NavDrawerItem> mNavDrawerItems = new ArrayList<NavDrawerItem>();

    protected ActionBarDrawerToggle mDrawerToggle;

    /**
     * Returns the navigation drawer item that corresponds to this Activity. Subclasses of {@link AbstractNavDrawerActivity}
     * should override this to indicate the corresponding drawer item.
     * Returns NAVDRAWER_ITEM_INVALID by default to mean that this Activity should not have a Navigation Drawer.
     */
    protected int getSelectedNavigationDrawerItemId() {
        return NAVDRAWER_ITEM_INVALID;
    }

    /**
     * Returns the navigation drawer (opened) title that corresponds to this Activity. Subclasses of {@link AbstractNavDrawerActivity}
     * should override this to indicate the corresponding drawer item.
     */
    protected String getNavigationDrawerOpenedTitle() {
        return getString(android.R.string.untitled);
    }

    /**
     * Returns the navigation drawer (closed) title that corresponds to this Activity. Subclasses of {@link AbstractNavDrawerActivity}
     * should override this to indicate the corresponding drawer item.
     */
    protected String getNavigationDrawerClosedTitle() {
        return getString(android.R.string.untitled);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setupNavigationDrawer();
        fadeInContent();
    }

    protected void setupNavigationDrawer() {
        if (getDrawerLayout() == null) {
            Log.w(TAG, "setupNavigationDrawer() - No DrawerLayout to setup, use setDrawerLayout() to initialize it.");
            return;
        }

        mDrawerToggle = new ActionBarDrawerToggle(this, getDrawerLayout(), R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                updateStatusBarForNavDrawerSlide(0f);
                getActionBar().setTitle(getNavigationDrawerClosedTitle());
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                updateStatusBarForNavDrawerSlide(1f);
                getActionBar().setTitle(getNavigationDrawerOpenedTitle());
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                updateStatusBarForNavDrawerSlide(slideOffset);
            }
        };

        getDrawerLayout().setDrawerListener(mDrawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle.syncState();

        populateNavigationDrawer();
        createNavigationDrawerItems();
    }

    /**
     * Updates the status bar color according to the navigation drawer slide offset. Subclasses of {@link AbstractNavDrawerActivity}
     * should override this.
     */
    protected void updateStatusBarForNavDrawerSlide(float slideOffset) {
    }

    private void fadeInContent() {
        if (getContentLayout() != null) {
            Log.d(TAG, "fadeInContent() - [class=" + getClass().getSimpleName() + "]");
            getContentLayout().setAlpha(0);
            getContentLayout().animate().alpha(1).setDuration(CONTENT_FADE_IN_DURATION);
        } else {
            Log.w(TAG, "fadeInContent() - No content view to fade in, use setContentLayout() to initialize it.");
        }
    }

    private void fadeOutContent() {
        if (getContentLayout() != null) {
            Log.d(TAG, "fadeOutContent() - [class=" + getClass().getSimpleName() + "]");
            getContentLayout().animate().alpha(0).setDuration(CONTENT_FADE_OUT_DURATION);
        } else {
            Log.w(TAG, "fadeOutContent() - No content view to fade out, use setContentLayout() to initialize it.");
        }
    }

    protected void populateNavigationDrawer() {
        mNavDrawerItems.clear();
    }

    protected void onNavigationDrawerItemClicked(final NavDrawerItem item) {
        if (item.id == getSelectedNavigationDrawerItemId()) {
            getDrawerLayout().closeDrawer(Gravity.START);
            return;
        }

        // Launch the target Activity after a short delay, to allow the close animation to play
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goToNavDrawerItem(item);
            }
        }, NAVDRAWER_LAUNCH_DELAY);

        if (!skipFade(item.id)) {
            fadeOutContent();
        }

        getDrawerLayout().closeDrawer(Gravity.START);
    }

    protected boolean skipFade(int itemId) {
        return false;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public void openDrawer() {
        getDrawerLayout().openDrawer(Gravity.START);
    }

    public void closeDrawer() {
        getDrawerLayout().closeDrawer(Gravity.START);
    }

    protected void addItem(NavDrawerItem item) {
        mNavDrawerItems.add(item);
    }

    protected static class NavDrawerItem {
        int id;
        int textId;

        public NavDrawerItem(int id, int textId) {
            this.id = id;
            this.textId = textId;
        }

        public int getId() {
            return id;
        }

        public int getTextId() {
            return textId;
        }
    }
}
