package com.training.android.material.ui.activity;

import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.*;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.training.android.material.R;
import com.training.android.material.ui.listcontrol.IconListControl;
import com.training.android.material.ui.listcontrol.ListControl;
import com.training.android.material.ui.tile.Tile;
import com.training.android.material.ui.tile.SingleLineTile;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractExpandableNavDrawerActivity extends ActionBarActivity {

    private static final String TAG = AbstractExpandableNavDrawerActivity.class.getSimpleName();

    protected abstract DrawerLayout getDrawerLayout();

    protected abstract View getContentLayout();

    protected abstract boolean onNavDrawerItemSelected(Tile item);

    protected int getSelectedNavDrawerGroupId() {
        return NAVDRAWER_ITEM_INVALID;
    }

    /**
     * Returns the navigation drawer (opened) title that corresponds to this Activity. Subclasses of {@link AbstractExpandableNavDrawerActivity}
     * should override this to indicate the corresponding drawer item.
     */
    protected String getNavigationDrawerOpenedTitle() {
        return getString(android.R.string.untitled);
    }

    /**
     * Returns the navigation drawer (closed) title that corresponds to this Activity. Subclasses of {@link AbstractExpandableNavDrawerActivity}
     * should override this to indicate the corresponding drawer item.
     */
    protected String getNavigationDrawerClosedTitle() {
        return getString(android.R.string.untitled);
    }

    /** Delay to launch nav drawer item, to allow close animation to play */
    private static final int NAVDRAWER_LAUNCH_DELAY = 200;

    /** Fade in and fade out durations for the main content when switching between different Activities of the app through the Nav Drawer */
    protected static final int CONTENT_FADE_OUT_DURATION = 200;
    protected static final int CONTENT_FADE_IN_DURATION = 200;

    protected static final int NAVDRAWER_ITEM_INVALID = -1;
    protected static final int NAVDRAWER_DIVIDER = -2;
    protected static final int NAVDRAWER_SUBHEADER = -3;

    protected ActionBarDrawerToggle mDrawerToggle;
    private ArrayList<NavDrawerGroup> mNavDrawerItems = new ArrayList<NavDrawerGroup>();
    private int mSelectedNavDrawerItemId = NAVDRAWER_ITEM_INVALID;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setupNavigationDrawer();
        fadeInContent(NAVDRAWER_ITEM_INVALID); // Always fade
    }

    private void setupNavigationDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, getDrawerLayout(), R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                updateStatusBarOnDrawerSlide(0);
                invalidateOptionsMenu();
                getSupportActionBar().setTitle(getNavigationDrawerClosedTitle());
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                updateStatusBarOnDrawerSlide(1);
                invalidateOptionsMenu();
                getSupportActionBar().setTitle(getNavigationDrawerOpenedTitle());
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                updateStatusBarOnDrawerSlide(slideOffset);
            }
        };
        getDrawerLayout().setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        populateNavDrawer();
        createNavDrawerItems();
    }

    /**
     * Updates the status bar color according to the navigation drawer slide offset. Subclasses of {@link AbstractExpandableNavDrawerActivity}
     * should override this.
     */
    protected void updateStatusBarOnDrawerSlide(float slideOffset) {
    }

    /**
     * Populates the navigation drawer. Subclasses of {@link AbstractExpandableNavDrawerActivity} should override this.
     */
    protected void populateNavDrawer() {
        mNavDrawerItems.clear();
    }

    protected void createNavDrawerItems() {
        final ExpandableListView container = (ExpandableListView) findViewById(R.id.navdrawer_items);

        final NavDrawerExpandableListAdapter adapter = new NavDrawerExpandableListAdapter(mNavDrawerItems);
        container.setAdapter(adapter);
        container.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (id == NAVDRAWER_ITEM_INVALID || id == NAVDRAWER_DIVIDER || id == NAVDRAWER_SUBHEADER) {
                    return false;
                } else {
                    onNavDrawerItemClicked(adapter.getGroup(groupPosition));
                }
                if (container.isGroupExpanded(groupPosition)) {
                    container.collapseGroup(groupPosition);
                } else {
                    container.expandGroup(groupPosition, true);
                }
                return true;
            }
        });
        container.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                onNavDrawerItemClicked(adapter.getChild(groupPosition, childPosition));
                return true;
            }
        });

        // Expand the selected group
        int selectedGroupIndex = adapter.getGroupIndex(getSelectedNavDrawerGroupId());
        if (selectedGroupIndex != -1) {
            container.expandGroup(selectedGroupIndex);
        }
    }

    private void onNavDrawerItemClicked(final NavDrawerGroup group) {
        if (group.isItem()) {
            onNavDrawerItemSelected(group);
            getDrawerLayout().closeDrawer(Gravity.START);
        }
    }

    private void onNavDrawerItemClicked(final NavDrawerChild child) {
        // Perform action after a short delay to allow the close animation to play
        if (child.getId() != mSelectedNavDrawerItemId) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mSelectedNavDrawerItemId = child.getId();
                    if (onNavDrawerItemSelected(child)) {
                        fadeInContent(child.getId());
                    }
                }
            }, NAVDRAWER_LAUNCH_DELAY);
            fadeOutContent(child.getId());
        }
        getDrawerLayout().closeDrawer(Gravity.START);
    }

    private void fadeInContent(int itemId) {
        if (!skipFade(itemId)) {
            if (getContentLayout() != null) {
                getContentLayout().setAlpha(0);
                getContentLayout().animate().setInterpolator(new DecelerateInterpolator()).alpha(1).setDuration(CONTENT_FADE_IN_DURATION);
            } else {
                Log.e(TAG, "No content view to fade in, implement getContentLayout() to initialize it.");
            }
        }
    }

    private void fadeOutContent(int itemId) {
        if (!skipFade(itemId)) {
            if (getContentLayout() != null) {
                getContentLayout().setAlpha(1);
                getContentLayout().animate().setInterpolator(new AccelerateInterpolator()).alpha(0).setDuration(CONTENT_FADE_OUT_DURATION);
            } else {
                Log.e(TAG, "No content view to fade out, implement getContentLayout() to initialize it.");
            }
        }
    }

    /**
     * Subclasses of {@link AbstractExpandableNavDrawerActivity} should override this and return true to skip fading the content in and out.
     */
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

    private NavDrawerGroup addGroup(NavDrawerGroup group) {
        mNavDrawerItems.add(group);
        return group;
    }

    protected NavDrawerGroup addDivider() {
        return addGroup(new NavDrawerGroup(NAVDRAWER_DIVIDER, null, null, null));
    }

    protected NavDrawerGroup addSubheader(String text) {
        return addGroup(new NavDrawerGroup(NAVDRAWER_SUBHEADER, text, null, null));
    }

    protected NavDrawerGroup addGroup(int id, String text) {
        return addGroup(new NavDrawerGroup(id, text, null, null));
    }

    protected NavDrawerGroup addItem(int id, String text) {
        return addGroup(new NavDrawerItem(id, text, null, null));
    }

    protected NavDrawerGroup addItem(int id, String text, ListControl primary, ListControl secondary) {
        return addGroup(new NavDrawerItem(id, text, primary, secondary));
    }

    protected static class NavDrawerChild extends SingleLineTile {
        int parentId = NAVDRAWER_ITEM_INVALID;

        public NavDrawerChild(int id, String text) {
            super(id, text);
        }

        public int getParentId() {
            return parentId;
        }
    }

    protected static class NavDrawerGroup extends SingleLineTile {
        List<NavDrawerChild> children = new ArrayList<NavDrawerChild>();

        public NavDrawerGroup(int id, String text, ListControl primary, ListControl secondary) {
            super(id, text, primary, secondary);
        }

        public boolean isItem() {
            return false;
        }

        public List<NavDrawerChild> getChildren() {
            return children;
        }

        private NavDrawerGroup addChild(NavDrawerChild child) {
            child.parentId = id;
            children.add(child);
            return this;
        }

        protected NavDrawerGroup addChild(int id, String text) {
            return addChild(new NavDrawerChild(id, text));
        }
    }

    protected static class NavDrawerItem extends NavDrawerGroup {

        public NavDrawerItem(int id, String text, ListControl primary, ListControl secondary) {
            super(id, text, primary, secondary);
        }

        @Override
        public boolean isItem() {
            return true;
        }
    }

    private class NavDrawerExpandableListAdapter extends BaseExpandableListAdapter {

        private List<NavDrawerGroup> items;

        private NavDrawerExpandableListAdapter(List<NavDrawerGroup> items) {
            this.items = items;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return items.get(groupPosition).children.size();
        }

        @Override
        public NavDrawerChild getChild(int groupPosition, int childPosition) {
            NavDrawerGroup group = getGroup(groupPosition);
            if (group.children != null && !group.children.isEmpty()) {
                return group.children.get(childPosition);
            }
            return null;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            if (getChild(groupPosition, childPosition) != null) {
                return getChild(groupPosition, childPosition).getId();
            }
            return NAVDRAWER_ITEM_INVALID;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup container) {
            NavDrawerChild child = getChild(groupPosition, childPosition);

            // Select layout to inflate
            int layoutToInflate = R.layout.tile_navdrawer_child_material;

            // Perform inflation
            View view = getLayoutInflater().inflate(layoutToInflate, container, false);

            // Bind the content
            TextView textView = (TextView) view.findViewById(R.id.text);
            textView.setText(child.getText());

            return view;
        }

        @Override
        public int getGroupCount() {
            return items.size();
        }

        @Override
        public NavDrawerGroup getGroup(int groupPosition) {
            return items.get(groupPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return items.get(groupPosition).getId();
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup container) {
            final NavDrawerGroup group = getGroup(groupPosition);

            // Select layout to inflate
            int layoutToInflate;
            if (group.getId() == NAVDRAWER_DIVIDER) {
                layoutToInflate = R.layout.tile_list_divider_material;
            } else if (group.getId() == NAVDRAWER_SUBHEADER) {
                layoutToInflate = R.layout.tile_list_subheader_material;
            } else {
                layoutToInflate = R.layout.tile_navdrawer_single_line_material;
            }

            // Perform inflation
            View view = getLayoutInflater().inflate(layoutToInflate, container, false);

            // Bind the content
            if (group.getId() == NAVDRAWER_DIVIDER) {
                view.setBackgroundResource(R.color.navdrawer_background);
            } else if (group.getId() == NAVDRAWER_SUBHEADER) {
                view.setBackgroundResource(R.color.navdrawer_background);
                if (mNavDrawerItems.indexOf(group) == 0) {
                    view.findViewById(R.id.divider).setVisibility(View.GONE);
                }
                TextView textView = (TextView) view.findViewById(R.id.text);
                textView.setText(group.getText());
                textView.setTextColor(getResources().getColor(R.color.material_text_secondary));
            } else {
                TextView textView = (TextView) view.findViewById(R.id.text);
                textView.setText(group.getText());
                if (group.isItem()) {
                    textView.setTextColor(getResources().getColor(R.color.material_navdrawer_text));
                } else {
                    textView.setTextColor(getResources().getColor(android.R.color.black));
                    textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                }

                if (setupListControl(group.getPrimary(), (ViewStub) view.findViewById(R.id.primary_stub))) {
                    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    layoutParams.setMarginStart(getResources().getDimensionPixelSize(R.dimen.keyline_2_minus_16dp));
                }
                if (setupListControl(group.getSecondary(), (ViewStub) view.findViewById(R.id.secondary_stub))) {
                    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    layoutParams.setMarginEnd(getResources().getDimensionPixelSize(R.dimen.material_list_icon_size_plus_16dp));
                }
            }

            return view;
        }

        private boolean setupListControl(final ListControl control, ViewStub stub) {
            stub.setOnInflateListener(new ViewStub.OnInflateListener() {
                @Override
                public void onInflate(ViewStub stub, View inflated) {
                    if (IconListControl.class.isInstance(control)) {
                        ImageView imageView = (ImageView) inflated;
                        imageView.setImageDrawable(((IconListControl) control).getDrawable());
                        imageView.setColorFilter(getResources().getColor(R.color.material_navdrawer_icon), PorterDuff.Mode.SRC_IN);

                    }
                }
            });
            return control != null && control.inflateStub(stub);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        public int getGroupIndex(int selectedNavigationDrawerGroupId) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getId() == selectedNavigationDrawerGroupId) {
                    return i;
                }
            }
            return -1;
        }
    }
}
