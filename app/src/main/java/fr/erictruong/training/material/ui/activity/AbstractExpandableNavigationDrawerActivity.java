package fr.erictruong.training.material.ui.activity;

import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.*;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.*;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.listcontrol.IconListControl;
import fr.erictruong.training.material.ui.listcontrol.ListControl;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;
import fr.erictruong.training.material.util.LogUtils;
import fr.erictruong.training.material.util.ThemeUtils;
import fr.erictruong.training.material.ui.tile.NavigationDrawerGroup;
import fr.erictruong.training.material.ui.tile.NavigationDrawerItem;
import fr.erictruong.training.material.ui.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractExpandableNavigationDrawerActivity extends ActionBarActivity {

    private static final String TAG = AbstractExpandableNavigationDrawerActivity.class.getSimpleName();

    protected static final String EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID = "extra_selected_navigation_drawer_child_id";
    protected static final String KEY_SELECTED_NAVIGATION_DRAWER_CHILD_ID = "key_selected_navigation_drawer_child_id";

    /** Delay to launch nav drawer item, to allow close animation to play */
    private static final int NAVIGATION_DRAWER_LAUNCH_DELAY = 200;

    /** Fade in and fade out durations for the main content when switching between different Activities of the app through the Nav Drawer */
    protected static final int CONTENT_FADE_OUT_DURATION = 200;
    protected static final int CONTENT_FADE_IN_DURATION = 200;

    protected static final int NAVDRAWER_ITEM_INVALID = -1;
    protected static final int NAVDRAWER_DIVIDER = -2;
    protected static final int NAVDRAWER_SUBHEADER = -3;

    private ActionBarDrawerToggle drawerToggle;
    private ArrayList<NavigationDrawerGroup> navigationDrawerItems = new ArrayList<NavigationDrawerGroup>();
    private int selectedNavigationDrawerItemId = NAVDRAWER_ITEM_INVALID;

    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_ITEM_INVALID;
    }

    /**
     * Returns the navigation drawer (opened) title that corresponds to this Activity. Subclasses of {@link AbstractExpandableNavigationDrawerActivity}
     * should override this to indicate the corresponding drawer item.
     */
    protected String getNavigationDrawerOpenedTitle() {
        return getString(android.R.string.untitled);
    }

    /**
     * Returns the navigation drawer (closed) title that corresponds to this Activity. Subclasses of {@link AbstractExpandableNavigationDrawerActivity}
     * should override this to indicate the corresponding drawer item.
     */
    protected String getNavigationDrawerClosedTitle() {
        return getString(android.R.string.untitled);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SELECTED_NAVIGATION_DRAWER_CHILD_ID, selectedNavigationDrawerItemId);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        selectedNavigationDrawerItemId = savedInstanceState.getInt(KEY_SELECTED_NAVIGATION_DRAWER_CHILD_ID, NAVDRAWER_ITEM_INVALID);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            selectedNavigationDrawerItemId = getIntent().getIntExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, NAVDRAWER_ITEM_INVALID);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setUpActionBar();
        setUpNavigationDrawer();
        fadeInContent(NAVDRAWER_ITEM_INVALID); // Always fade in
    }

    private void setUpActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getDrawerLayout().isDrawerOpen(Gravity.START)) {
            getSupportActionBar().setTitle(getNavigationDrawerOpenedTitle());
        } else {
            getSupportActionBar().setTitle(getNavigationDrawerClosedTitle());
        }
    }

    private void setUpNavigationDrawer() {
        drawerToggle = new ActionBarDrawerToggle(this, getDrawerLayout(), R.string.content_descr_drawer_open, R.string.content_descr_drawer_close) {
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
        getDrawerLayout().setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        populateNavigationDrawer();
        createNavigationDrawerItems();
    }

    /**
     * Updates the status bar color according to the navigation drawer slide offset. Subclasses of {@link AbstractExpandableNavigationDrawerActivity}
     * should override this.
     */
    protected void updateStatusBarOnDrawerSlide(float slideOffset) {
    }

    /**
     * Populates the navigation drawer. Subclasses of {@link AbstractExpandableNavigationDrawerActivity} should override this.
     */
    protected void populateNavigationDrawer() {
        navigationDrawerItems.clear();
    }

    protected void createNavigationDrawerItems() {
        final NavigationDrawerExpandableListAdapter adapter = new NavigationDrawerExpandableListAdapter(navigationDrawerItems);
        getNavigationDrawer().setAdapter(adapter);
        getNavigationDrawer().setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (id == NAVDRAWER_ITEM_INVALID || id == NAVDRAWER_DIVIDER || id == NAVDRAWER_SUBHEADER) {
                    return false;
                } else {
                    onNavigationDrawerItemClicked(adapter.getGroup(groupPosition));
                }

                if (getNavigationDrawer().isGroupExpanded(groupPosition)) {
                    getNavigationDrawer().collapseGroup(groupPosition);
                } else {
                    getNavigationDrawer().expandGroup(groupPosition, true);
                }
                return true;
            }
        });
        getNavigationDrawer().setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                onNavigationDrawerItemClicked(adapter.getChild(groupPosition, childPosition));
                return true;
            }
        });

        // Expand the selected group
        int selectedGroupIndex = adapter.getGroupIndex(getSelectedNavigationDrawerGroupId());
        if (selectedGroupIndex != -1) {
            getNavigationDrawer().expandGroup(selectedGroupIndex);
        }
    }

    private void onNavigationDrawerItemClicked(final NavigationDrawerGroup group) {
        if (group.isItem()) {
            goToNavigationDrawerItem(group);
            getDrawerLayout().closeDrawer(Gravity.START);
        }
    }

    private void onNavigationDrawerItemClicked(final NavigationDrawerChild child) {
        // Perform action after a short delay to allow the close animation to play
        if (child.getId() != selectedNavigationDrawerItemId) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    selectedNavigationDrawerItemId = child.getId();
                    if (goToNavigationDrawerItem(child)) {
                        fadeInContent(child.getId());
                        getNavigationDrawer().invalidateViews();
                    }
                }
            }, NAVIGATION_DRAWER_LAUNCH_DELAY);
            fadeOutContent(child.getId());
        }
        getDrawerLayout().closeDrawer(Gravity.START);
    }

    private void fadeInContent(int itemId) {
        if (!skipFade(itemId)) {
            if (getContent() != null) {
                getContent().setAlpha(0);
                getContent().animate().setInterpolator(new DecelerateInterpolator()).alpha(1).setDuration(CONTENT_FADE_IN_DURATION);
            } else {
                LogUtils.e(getClass(), "No content view to fade in, implement getContent() to initialize it.");
            }
        }
    }

    private void fadeOutContent(int itemId) {
        if (!skipFade(itemId)) {
            if (getContent() != null) {
                getContent().setAlpha(1);
                getContent().animate().setInterpolator(new AccelerateInterpolator()).alpha(0).setDuration(CONTENT_FADE_OUT_DURATION);
            } else {
                LogUtils.e(getClass(), "No content view to fade out, implement getContent() to initialize it.");
            }
        }
    }

    /**
     * Subclasses of {@link AbstractExpandableNavigationDrawerActivity} should override this and return true to skip fading the content in and out.
     */
    protected boolean skipFade(int itemId) {
        return false;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public void openDrawer() {
        getDrawerLayout().openDrawer(Gravity.START);
    }

    public void closeDrawer() {
        getDrawerLayout().closeDrawer(Gravity.START);
    }

    private NavigationDrawerGroup addGroup(NavigationDrawerGroup group) {
        navigationDrawerItems.add(group);
        return group;
    }

    protected NavigationDrawerGroup addDivider() {
        return addGroup(new NavigationDrawerGroup(NAVDRAWER_DIVIDER, null, null, null));
    }

    protected NavigationDrawerGroup addSubheader(String text) {
        return addGroup(new NavigationDrawerGroup(NAVDRAWER_SUBHEADER, text, null, null));
    }

    protected NavigationDrawerGroup addGroup(int id, String text) {
        return addGroup(new NavigationDrawerGroup(id, text, null, null));
    }

    protected NavigationDrawerGroup addItem(int id, String text) {
        return addGroup(new NavigationDrawerItem(id, text, null, null));
    }

    protected NavigationDrawerGroup addItem(int id, String text, ListControl primary, ListControl secondary) {
        return addGroup(new NavigationDrawerItem(id, text, primary, secondary));
    }

    private class NavigationDrawerExpandableListAdapter extends BaseExpandableListAdapter {

        private List<NavigationDrawerGroup> items;

        private NavigationDrawerExpandableListAdapter(List<NavigationDrawerGroup> items) {
            this.items = items;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return items.get(groupPosition).getChildren().size();
        }

        @Override
        public NavigationDrawerChild getChild(int groupPosition, int childPosition) {
            NavigationDrawerGroup group = getGroup(groupPosition);
            if (group.getChildren() != null && !group.getChildren().isEmpty()) {
                return group.getChildren().get(childPosition);
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
            NavigationDrawerChild child = getChild(groupPosition, childPosition);

            // Select layout to inflate
            int layoutToInflate = R.layout.tile_navdrawer_child_material;

            // Perform inflation
            View view = getLayoutInflater().inflate(layoutToInflate, container, false);

            // Bind the content
            TextView textView = (TextView) view.findViewById(R.id.tv_text);
            textView.setText(child.getText());
            if (selectedNavigationDrawerItemId == getChildId(groupPosition, childPosition)) {
                textView.setTextColor(ThemeUtils.obtainColorPrimary(AbstractExpandableNavigationDrawerActivity.this));
            }

            return view;
        }

        @Override
        public int getGroupCount() {
            return items.size();
        }

        @Override
        public NavigationDrawerGroup getGroup(int groupPosition) {
            return items.get(groupPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return getGroup(groupPosition).getId();
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup container) {
            final NavigationDrawerGroup group = getGroup(groupPosition);

            // Select layout to inflate
            int layoutToInflate;
            if (group.getId() == NAVDRAWER_DIVIDER) {
                layoutToInflate = R.layout.tile_list_divider_material;
            } else if (group.getId() == NAVDRAWER_SUBHEADER) {
                layoutToInflate = R.layout.tile_subheader_material;
            } else {
                layoutToInflate = R.layout.tile_navdrawer_single_line_material;
            }

            // Perform inflation
            View view = getLayoutInflater().inflate(layoutToInflate, container, false);

            // Bind the content
            if (group.getId() == NAVDRAWER_DIVIDER) {
                view.setBackgroundResource(android.R.color.white);
            } else if (group.getId() == NAVDRAWER_SUBHEADER) {
                view.setBackgroundResource(android.R.color.white);
                if (navigationDrawerItems.indexOf(group) == 0) {
                    view.findViewById(R.id.divider).setVisibility(View.GONE);
                }
                TextView textView = (TextView) view.findViewById(R.id.tv_text);
                textView.setText(group.getText());
                textView.setTextColor(getResources().getColor(R.color.material_text_secondary));
            } else {
                TextView textView = (TextView) view.findViewById(R.id.tv_text);
                textView.setText(group.getText());
                if (group.isItem()) {
                    textView.setTextColor(getResources().getColor(R.color.material_navdrawer_text));
                } else {
                    textView.setTextColor(getResources().getColor(android.R.color.black));
                    textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                }

                if (setUpListControl(group.getPrimary(), (ViewStub) view.findViewById(R.id.stub_primary))) {
                    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    layoutParams.setMarginStart(getResources().getDimensionPixelSize(R.dimen.keyline_2_minus_16dp));
                }
                if (setUpListControl(group.getSecondary(), (ViewStub) view.findViewById(R.id.stub_secondary))) {
                    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    layoutParams.setMarginEnd(getResources().getDimensionPixelSize(R.dimen.list_icon_size_plus_16dp_material));
                }
            }

            return view;
        }

        private boolean setUpListControl(final ListControl control, ViewStub stub) {
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

    protected abstract DrawerLayout getDrawerLayout();

    protected abstract View getContent();

    protected abstract ExpandableListView getNavigationDrawer();

    protected abstract boolean goToNavigationDrawerItem(Tile item);
}
