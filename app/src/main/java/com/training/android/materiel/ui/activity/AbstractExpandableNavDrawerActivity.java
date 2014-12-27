package com.training.android.materiel.ui.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.util.TypedValue;
import android.view.*;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.training.android.materiel.R;
import com.training.android.materiel.ui.listcontrol.IconListControl;
import com.training.android.materiel.ui.listcontrol.ListControl;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractExpandableNavDrawerActivity extends Activity {

    private static final String TAG = AbstractExpandableNavDrawerActivity.class.getSimpleName();

    protected abstract DrawerLayout getDrawerLayout();

    protected abstract View getContentLayout();

    protected abstract boolean onNavDrawerItemSelected(NavDrawerItem item);

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
    private int mSelectedNavigationDrawerItemId = NAVDRAWER_ITEM_INVALID;

    protected int getSelectedNavigationDrawerItemId() {
        return NAVDRAWER_ITEM_INVALID;
    }

    protected int getSelectedNavigationDrawerGroupId() {
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

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setupNavigationDrawer();
    }

    private void setupNavigationDrawer() {
        if (getDrawerLayout() == null) {
            Log.e(TAG, "No DrawerLayout to setup, implement getDrawerLayout() to initialize it.");
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
     * Updates the status bar color according to the navigation drawer slide offset. Subclasses of {@link AbstractExpandableNavDrawerActivity}
     * should override this.
     */
    protected void updateStatusBarForNavDrawerSlide(float slideOffset) {
    }

    protected void createNavigationDrawerItems() {
        final ExpandableListView drawerItemsListContainer = (ExpandableListView) findViewById(R.id.navdrawer_items);
        if (drawerItemsListContainer == null) {
            Log.e(TAG, "No navigation drawer list container.");
            return;
        }

        final NavigationDrawerExpandableListAdapter adapter = new NavigationDrawerExpandableListAdapter(mNavDrawerItems);
        drawerItemsListContainer.setAdapter(adapter);

        // In order to show animations, we need to use a custom click handler for our ExpandableListView.
        drawerItemsListContainer.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // We call collapseGroupWithAnimation(int) and expandGroupWithAnimation(int) to animate group expansion/collapse.
                if (drawerItemsListContainer.isGroupExpanded(groupPosition)) {
                    drawerItemsListContainer.collapseGroup(groupPosition);
                } else {
                    drawerItemsListContainer.expandGroup(groupPosition, true);
                }
                if (id != NAVDRAWER_ITEM_INVALID && id != NAVDRAWER_DIVIDER && id != NAVDRAWER_SUBHEADER) {
                    onNavigationDrawerItemClicked(adapter.getGroup(groupPosition));
                }
                return true;
            }
        });

        drawerItemsListContainer.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                onNavigationDrawerItemClicked(adapter.getChild(groupPosition, childPosition));
                return true;
            }
        });

        int selectedGroupIndex = adapter.getGroupIndex(getSelectedNavigationDrawerGroupId());
        if (selectedGroupIndex != -1) {
            drawerItemsListContainer.expandGroup(selectedGroupIndex);
        }
    }

    /**
     * Populates the navigation drawer. Subclasses of {@link AbstractExpandableNavDrawerActivity} should override this.
     */
    protected void populateNavigationDrawer() {
        mNavDrawerItems.clear();
    }

    protected void onNavigationDrawerItemClicked(final NavDrawerItem item) {
        if (NavDrawerGroup.class.isInstance(item) && ((NavDrawerGroup)item).getChildren().size() > 0) {
            return;
        }

        // Simply close the drawer on reselect
        if (item.getId() == mSelectedNavigationDrawerItemId) {
            getDrawerLayout().closeDrawer(Gravity.START);
            return;
        }

        // Perform action after a short delay, to allow the close animation to play
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSelectedNavigationDrawerItemId = item.getId();
                onNavDrawerItemSelected(item);
                fadeInContent(item.getId());
            }
        }, NAVDRAWER_LAUNCH_DELAY);

        fadeOutContent(item.getId());

        getDrawerLayout().closeDrawer(Gravity.START);
    }

    private void fadeInContent(int itemId) {
        if (!skipFade(itemId)) {
            if (getContentLayout() != null) {
                Log.d(TAG, "Fading in content. [class=" + getClass().getSimpleName() + "]");
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
                Log.d(TAG, "Fading out content. [class=" + getClass().getSimpleName() + "]");
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

    public ArrayList<NavDrawerGroup> getNavDrawerItems() {
        return mNavDrawerItems;
    }

    protected void addDivider() {
        addItem(new NavDrawerGroup(NAVDRAWER_DIVIDER));
    }

    protected void addSubheader(int stringId) {
        addItem(new SingleLineNavDrawerGroup(NAVDRAWER_SUBHEADER, stringId));
    }

    private void addItem(NavDrawerGroup item) {
        mNavDrawerItems.add(item);
    }

    protected void addItem(int id, int stringId, ListControl primary, ListControl secondary) {
        addItem(new SingleLineControlNavDrawerGroup(id, stringId, primary, secondary));
    }

    protected void addItem(int id, int string1Id, int string2Id, ListControl primary, ListControl secondary) {
        addItem(new TwoLineControlNavDrawerGroup(id, string1Id, string2Id, primary, secondary));
    }

    protected void addItem(int id, int string1Id, int string2Id, int string3Id, ListControl primary, ListControl secondary) {
        addItem(new ThreeLineControlNavDrawerGroup(id, string1Id, string2Id, string3Id, primary, secondary));
    }

    private void addGroup(NavDrawerGroup item) {
        mNavDrawerItems.add(item);
    }

    protected void addGroup(int id, int stringId, NavDrawerItem... items) {
        addGroup(new SingleLineNavDrawerGroup(id, stringId, items));
    }

    protected NavDrawerItem addChild(int id, int stringId, ListControl primary, ListControl secondary) {
        return new SingleLineControlNavDrawerItem(id, stringId, primary, secondary);
    }

    protected NavDrawerItem addChild(int id, int string1Id, int string2Id, ListControl primary, ListControl secondary) {
        return new TwoLineControlNavDrawerItem(id, string1Id, string2Id, primary, secondary);
    }

    protected NavDrawerItem addChild(int id, int string1Id, int string2Id, int string3Id, ListControl primary, ListControl secondary) {
        return new ThreeLineControlNavDrawerItem(id, string1Id, string2Id, string3Id, primary, secondary);
    }

    protected static class NavDrawerItem {
        int id;
        int parentId = NAVDRAWER_ITEM_INVALID;

        public NavDrawerItem(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public int getParentId() {
            return parentId;
        }
    }

    protected static class SingleLineNavDrawerItem extends NavDrawerItem {
        int text1Id;

        public SingleLineNavDrawerItem(int id, int text1Id) {
            super(id);
            this.text1Id = text1Id;
        }

        public int getText1Id() {
            return text1Id;
        }
    }

    protected static class TwoLineNavDrawerItem extends SingleLineNavDrawerItem {
        int text2Id;

        public TwoLineNavDrawerItem(int id, int text1Id, int text2Id) {
            super(id, text1Id);
            this.text2Id = text2Id;
        }

        public int getText2Id() {
            return text2Id;
        }
    }

    protected static class ThreeLineNavDrawerItem extends TwoLineNavDrawerItem {
        int text3Id;

        public ThreeLineNavDrawerItem(int id, int text1Id, int text2Id, int text3Id) {
            super(id, text1Id, text2Id);
            this.text3Id = text3Id;
        }

        public int getText3Id() {
            return text3Id;
        }
    }

    protected static class SingleLineControlNavDrawerItem extends SingleLineNavDrawerItem {
        ListControl primary, secondary;

        public SingleLineControlNavDrawerItem(int id, int text1Id, ListControl primary, ListControl secondary) {
            super(id, text1Id);
            this.primary = primary;
            this.secondary = secondary;
        }

        public ListControl getPrimary() {
            return primary;
        }

        public ListControl getSecondary() {
            return secondary;
        }
    }

    protected static class TwoLineControlNavDrawerItem extends TwoLineNavDrawerItem {
        ListControl primary, secondary;

        public TwoLineControlNavDrawerItem(int id, int text1Id, int text2Id, ListControl primary, ListControl secondary) {
            super(id, text1Id, text2Id);
            this.primary = primary;
            this.secondary = secondary;
        }

        public ListControl getPrimary() {
            return primary;
        }

        public ListControl getSecondary() {
            return secondary;
        }
    }

    protected static class ThreeLineControlNavDrawerItem extends ThreeLineNavDrawerItem {
        ListControl primary, secondary;

        public ThreeLineControlNavDrawerItem(int id, int text1Id, int text2Id, int text3Id, ListControl primary, ListControl secondary) {
            super(id, text1Id, text2Id, text3Id);
            this.primary = primary;
            this.secondary = secondary;
        }

        public ListControl getPrimary() {
            return primary;
        }

        public ListControl getSecondary() {
            return secondary;
        }
    }

    protected static class NavDrawerGroup extends NavDrawerItem {
        List<NavDrawerItem> children = new ArrayList<NavDrawerItem>();

        public NavDrawerGroup(int id, NavDrawerItem... items) {
            super(id);
            for (NavDrawerItem item : items) {
                item.parentId = id;
                children.add(item);
            }
        }

        public List<NavDrawerItem> getChildren() {
            return children;
        }
    }

    protected static class SingleLineNavDrawerGroup extends NavDrawerGroup {
        int text1Id;

        public SingleLineNavDrawerGroup(int id, int text1Id, NavDrawerItem... items) {
            super(id, items);
            this.text1Id = text1Id;
        }

        public int getText1Id() {
            return text1Id;
        }
    }

    protected static class TwoLineNavDrawerGroup extends SingleLineNavDrawerGroup {
        int text2Id;

        public TwoLineNavDrawerGroup(int id, int text1Id, int text2Id, NavDrawerItem... items) {
            super(id, text1Id, items);
            this.text2Id = text2Id;
        }

        public int getText2Id() {
            return text2Id;
        }
    }

    protected static class ThreeLineNavDrawerGroup extends TwoLineNavDrawerGroup {
        int text3Id;

        public ThreeLineNavDrawerGroup(int id, int text1Id, int text2Id, int text3Id, NavDrawerItem... items) {
            super(id, text1Id, text2Id, items);
            this.text3Id = text3Id;
        }

        public int getText3Id() {
            return text3Id;
        }
    }

    protected static class SingleLineControlNavDrawerGroup extends SingleLineNavDrawerGroup {
        ListControl primary, secondary;

        public SingleLineControlNavDrawerGroup(int id, int text1Id, ListControl primary, ListControl secondary, NavDrawerItem... items) {
            super(id, text1Id, items);
            this.primary = primary;
            this.secondary = secondary;
        }

        public ListControl getPrimary() {
            return primary;
        }

        public ListControl getSecondary() {
            return secondary;
        }
    }

    protected static class TwoLineControlNavDrawerGroup extends TwoLineNavDrawerGroup {
        ListControl primary, secondary;

        public TwoLineControlNavDrawerGroup(int id, int text1Id, int text2Id, ListControl primary, ListControl secondary, NavDrawerItem... items) {
            super(id, text1Id, text2Id, items);
            this.primary = primary;
            this.secondary = secondary;
        }

        public ListControl getPrimary() {
            return primary;
        }

        public ListControl getSecondary() {
            return secondary;
        }
    }

    protected static class ThreeLineControlNavDrawerGroup extends ThreeLineNavDrawerGroup {
        ListControl primary, secondary;

        public ThreeLineControlNavDrawerGroup(int id, int text1Id, int text2Id, int text3Id, ListControl primary, ListControl secondary, NavDrawerItem... items) {
            super(id, text1Id, text2Id, text3Id, items);
            this.primary = primary;
            this.secondary = secondary;
        }

        public ListControl getPrimary() {
            return primary;
        }

        public ListControl getSecondary() {
            return secondary;
        }
    }

    private class NavigationDrawerExpandableListAdapter extends BaseExpandableListAdapter {

        private List<NavDrawerGroup> items;

        private NavigationDrawerExpandableListAdapter(List<NavDrawerGroup> items) {
            this.items = items;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return items.get(groupPosition).children.size();
        }

        @Override
        public NavDrawerItem getChild(int groupPosition, int childPosition) {
            NavDrawerGroup group = getGroup(groupPosition);
            if (group.children != null && !group.children.isEmpty()) {
                return group.children.get(childPosition);
            }
            return null;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            if (getChild(groupPosition, childPosition) != null) {
                return getChild(groupPosition, childPosition).id;
            }
            return NAVDRAWER_ITEM_INVALID;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup container) {
            NavDrawerItem item = getChild(groupPosition, childPosition);

            // Select layout to inflate
            int layoutToInflate = R.layout.navdrawer_child_single_line_material;

            // Perform inflation
            final View view = getLayoutInflater().inflate(layoutToInflate, container, false);

            if (SingleLineControlNavDrawerItem.class.isInstance(item)) {
                SingleLineControlNavDrawerItem controlItem = (SingleLineControlNavDrawerItem) item;

                TextView textView = (TextView) view.findViewById(R.id.text);
                textView.setText(getString(controlItem.text1Id));

//                if (controlItem.primary != null) {
//                    controlItem.primary.inflateStub(primaryView);
//                }
//                boolean endIndented = false;
//                if (controlItem.secondary != null) {
//                    endIndented = controlItem.secondary.inflateStub(secondaryView);
//                }

//                boolean isSelected = item.id == getSelectedNavigationDrawerItemId();
//                formatNavDrawerChild(view, controlItem, false, isSelected);

            } else if (SingleLineNavDrawerItem.class.isInstance(item)) {
                SingleLineNavDrawerItem textItem = (SingleLineNavDrawerItem) item;
                TextView textView = (TextView) view.findViewById(R.id.text);
                textView.setText(getString(textItem.text1Id));
                textView.setTextColor(getResources().getColor(R.color.material_text_secondary));
            }

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
            return items.get(groupPosition).id;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup container) {
            final NavDrawerGroup item = getGroup(groupPosition);

            // Select layout to inflate
            int layoutToInflate;
            if (item.id == NAVDRAWER_DIVIDER) {
                layoutToInflate = R.layout.list_divider_material;
            } else if (item.id == NAVDRAWER_SUBHEADER) {
                layoutToInflate = R.layout.list_subheader_material;
            } else {
                layoutToInflate = R.layout.navdrawer_child_single_line_material;
            }

            // Perform inflation
            View view = getLayoutInflater().inflate(layoutToInflate, container, false);

            // Setup item content
            if (SingleLineControlNavDrawerGroup.class.isInstance(item)) {
                SingleLineControlNavDrawerGroup controlItem = (SingleLineControlNavDrawerGroup) item;

                TextView textView = (TextView) view.findViewById(R.id.text);
                textView.setText(getString(controlItem.text1Id));

//                boolean startIndented = false;
//                if (controlItem.primary != null) {
//                    startIndented = controlItem.primary.inflateStub(primaryView);
//                }
//                boolean endIndented = false;
//                if (controlItem.secondary != null) {
//                    endIndented = controlItem.secondary.inflateStub(secondaryView);
//                }

//                boolean isSelected = item.id == getSelectedNavigationDrawerItemId();
//                formatNavDrawerGroup(view, controlItem, false, false, isSelected);

            } else if (SingleLineNavDrawerGroup.class.isInstance(item)) {
                SingleLineNavDrawerGroup textItem = (SingleLineNavDrawerGroup) item;
                TextView textView = (TextView) view.findViewById(R.id.text);
                textView.setText(getString(textItem.text1Id));

                if (item.id == NAVDRAWER_SUBHEADER) {
                    view.setBackgroundResource(R.color.navdrawer_background);
                    if (getNavDrawerItems().indexOf(textItem) == 0) {
                        view.findViewById(R.id.divider).setVisibility(View.GONE);
                    }
                    textView.setTextColor(getResources().getColor(R.color.material_text_secondary));
                } else {
                    textView.setTextColor(getResources().getColor(android.R.color.black));
                    textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                }
            } else {
                view.setBackgroundResource(R.color.navdrawer_background);
            }

            return view;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        private void formatNavDrawerChild(View view, SingleLineControlNavDrawerItem controlItem, boolean endIndented, boolean selected) {
            formatNavDrawerItem(view, controlItem, true, endIndented, selected);
        }

        private void formatNavDrawerItem(View view, SingleLineControlNavDrawerItem controlItem, boolean startIndented, boolean endIndented, boolean selected) {
//            // Get selected color
//            int selectedColor;
//            TypedValue tv = new TypedValue();
//            if (getTheme().resolveAttribute(android.R.attr.colorPrimary, tv, true) && tv.resourceId > 0) {
//                selectedColor = getResources().getColor(tv.resourceId);
//            } else {
//                selectedColor = getResources().getColor(R.color.material_navdrawer_selected);
//            }
//
//            // Configure its appearance according to whether or not it's selected
//            TextView textView = (TextView) view.findViewById(R.id.text);
//            textView.setTextColor(selected ? selectedColor : getResources().getColor(R.color.material_text_secondary));
//            if (IconListControl.class.isInstance(controlItem.primary) && ((IconListControl) controlItem.primary).getDrawable() != null) {
//                ImageView iconView = (ImageView) view.findViewById(R.id.list_control_icon_material);
//                iconView.setColorFilter(selected ? selectedColor : getResources().getColor(R.color.material_navdrawer_icon), PorterDuff.Mode.SRC_IN);
//            }
//
//            if (startIndented) {
//                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
//                layoutParams.setMarginStart(getResources().getDimensionPixelSize(R.dimen.keyline_2_minus_16dp));
//            }
//            if (endIndented) {
//                int controlWidth = getResources().getDimensionPixelSize(controlItem.secondary.getLayoutSizeId());
//                int marginSmall = getResources().getDimensionPixelSize(R.dimen.margin_small);
//                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
//                layoutParams.setMarginEnd(controlWidth + marginSmall);
//            }
//
//            int minHeight = getResources().getDimensionPixelSize(R.dimen.material_avatar_list_item_min_size);
//            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//            // TODO: Implement AvatarListControl.
////        if (minHeight > layoutParams.height && (AvatarListControl.class.isInstance(item.primary) || AvatarListControl.class.isInstance(item.secondary))) {
////            layoutParams.height = minHeight;
////        }
        }

        private void formatNavDrawerGroup(View view, SingleLineControlNavDrawerGroup controlItem, boolean startIndented, boolean endIndented, boolean selected) {
            formatNavDrawerItem(view, controlItem, startIndented, endIndented, selected);
        }

        private void formatNavDrawerItem(View view, SingleLineControlNavDrawerGroup controlItem, boolean startIndented, boolean endIndented, boolean selected) {
//            // Get selected color
//            int selectedColor;
//            TypedValue tv = new TypedValue();
//            if (getTheme().resolveAttribute(android.R.attr.colorPrimary, tv, true) && tv.resourceId > 0) {
//                selectedColor = getResources().getColor(tv.resourceId);
//            } else {
//                selectedColor = getResources().getColor(R.color.material_navdrawer_selected);
//            }
//
//            // Configure its appearance according to whether or not it's selected
//            TextView textView = (TextView) view.findViewById(R.id.text);
//            textView.setTextColor(selected ? selectedColor : getResources().getColor(R.color.material_navdrawer_text));
//            if (IconListControl.class.isInstance(controlItem.primary) && ((IconListControl) controlItem.primary).getDrawable() != null) {
//                ImageView iconView = (ImageView) view.findViewById(R.id.list_control_icon_material);
//                iconView.setColorFilter(selected ? selectedColor : getResources().getColor(R.color.material_navdrawer_icon), PorterDuff.Mode.SRC_IN);
//            }
//
//            if (startIndented) {
//                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
//                layoutParams.setMarginStart(getResources().getDimensionPixelSize(R.dimen.keyline_2_minus_16dp));
//            }
//            if (endIndented) {
//                int controlWidth = getResources().getDimensionPixelSize(controlItem.secondary.getLayoutSizeId());
//                int marginSmall = getResources().getDimensionPixelSize(R.dimen.margin_small);
//                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
//                layoutParams.setMarginEnd(controlWidth + marginSmall);
//            }
//
//            int minHeight = getResources().getDimensionPixelSize(R.dimen.material_avatar_list_item_min_size);
//            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//            // TODO: Implement AvatarListControl.
////        if (minHeight > layoutParams.height && (AvatarListControl.class.isInstance(item.primary) || AvatarListControl.class.isInstance(item.secondary))) {
////            layoutParams.height = minHeight;
////        }
        }

        public int getGroupIndex(int selectedNavigationDrawerGroupId) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).id == selectedNavigationDrawerGroupId) {
                    return i;
                }
            }
            return -1;
        }
    }
}
