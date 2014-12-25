package com.training.android.materiel.ui.activity;

import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.training.android.materiel.BuildConfig;
import com.training.android.materiel.R;
import com.training.android.materiel.ui.listcontrol.IconListControl;
import com.training.android.materiel.ui.listcontrol.ListControl;

public abstract class MaterialTrainingNavDrawerActivity extends AbstractNavDrawerActivity {

    private static final String TAG = MaterialTrainingNavDrawerActivity.class.getSimpleName();

    protected static final int NAVDRAWER_ITEM_MAIN_ID = 0;
    protected static final int NAVDRAWER_ITEM_SETTINGS_ID = 1000;
    protected static final int NAVDRAWER_ITEM_DEV_MODE_ID = 1001;

    @Override
    protected void populateNavigationDrawer() {
        super.populateNavigationDrawer();
        addItem(NAVDRAWER_ITEM_MAIN_ID, R.string.navdrawer_item_main, new IconListControl(R.drawable.action_ic_bookmark), null);
        addItem(1, R.string.hello_world, new IconListControl(R.drawable.action_ic_bookmark_outline), null);
        addDivider();
        addItem(NAVDRAWER_ITEM_SETTINGS_ID, R.string.navdrawer_item_settings, new IconListControl(R.drawable.action_ic_settings), null);
        if (BuildConfig.DEBUG) {
            addItem(NAVDRAWER_ITEM_DEV_MODE_ID, R.string.navdrawer_item_developer_mode, new IconListControl(R.drawable.device_ic_developer_mode), null);
        }
    }

    @Override
    protected void createNavigationDrawerItems() {
        ViewGroup drawerItemsListContainer = (ViewGroup) findViewById(R.id.navdrawer_items);
        if (drawerItemsListContainer == null) {
            return;
        }

        View[] navDrawerItemViews = new View[mNavDrawerItems.size()];
        drawerItemsListContainer.removeAllViews();
        int i = 0;
        for (NavDrawerItem item : mNavDrawerItems) {
            navDrawerItemViews[i] = createNavigationDrawerItem(item, drawerItemsListContainer);
            drawerItemsListContainer.addView(navDrawerItemViews[i]);
            i++;
        }
    }

    private View createNavigationDrawerItem(final NavDrawerItem item, ViewGroup container) {
        boolean isSelected = getSelectedNavigationDrawerItemId() == item.id;

        // Select layout to inflate
        int layoutToInflate;
        if (item.id == NAVDRAWER_ITEM_DIVIDER) {
            layoutToInflate = R.layout.list_divider_material;
        } else {
            layoutToInflate = R.layout.list_item_single_line_material;
        }

        // Perform inflation
        View view = getLayoutInflater().inflate(layoutToInflate, container, false);
        if (item.id == NAVDRAWER_ITEM_DIVIDER) {
            return view;
        }

        SingleLineNavDrawerItem singleLineItem = (SingleLineNavDrawerItem) item;

        // Setup item content
        boolean startIndented = false;
        if (singleLineItem.primary != null) {
            View primaryView = inflateStubIfViewNotNull(view, R.id.primary_stub, singleLineItem.primary);
            startIndented = singleLineItem.primary.setupView(this, primaryView);
        }
        boolean endIndented = false;
        if (singleLineItem.secondary != null) {
            View secondaryView = inflateStubIfViewNotNull(view, R.id.secondary_stub, singleLineItem.secondary);
            endIndented = singleLineItem.secondary.setupView(this, secondaryView);
        }

        TextView titleView = (TextView) view.findViewById(R.id.text);
        titleView.setText(getString(singleLineItem.textId));

        // Format item content
        formatNavigationDrawerItem(view, startIndented, endIndented, item, isSelected);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNavigationDrawerItemClicked(item);
            }
        });

        return view;
    }

    private View inflateStubIfViewNotNull(View view, int viewStubId, ListControl control) {
        ViewStub viewStub = (ViewStub) view.findViewById(viewStubId);
        if (viewStub != null) {
            ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
            layoutParams.width = getResources().getDimensionPixelSize(control.getLayoutSizeId());
            layoutParams.height = getResources().getDimensionPixelSize(control.getLayoutSizeId());
            viewStub.setInflatedId(control.getInflatedId());
            viewStub.setLayoutResource(control.getLayoutId());
            return viewStub.inflate();
        }
        return null;
    }

    private void formatNavigationDrawerItem(View view, boolean startIndented, boolean endIndented, NavDrawerItem item, boolean selected) {
        // TODO: The touch ripple also becomes a highlight, to further indicate selection.
        if (item.id == NAVDRAWER_ITEM_DIVIDER) {
            return;
        }

        SingleLineNavDrawerItem singleLineItem = (SingleLineNavDrawerItem) item;

        // Configure its appearance according to whether or not it's selected
        if (IconListControl.class.isInstance(singleLineItem.primary) && ((IconListControl) singleLineItem.primary).getDrawableId() > 0) {
            ImageView iconView = (ImageView) view.findViewById(R.id.list_control_icon_material);
            iconView.setColorFilter(selected ? getSelectedColor() : getResources().getColor(R.color.material_navdrawer_icon), PorterDuff.Mode.SRC_IN);
        }
        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setTextColor(selected ? getSelectedColor() : getResources().getColor(R.color.material_navdrawer_text));

        if (startIndented) {
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            layoutParams.setMarginStart(getResources().getDimensionPixelSize(R.dimen.keyline_2_minus_16dp));
        }
        if (endIndented) {
            int controlWidth = getResources().getDimensionPixelSize(singleLineItem.secondary.getLayoutSizeId());
            int marginSmall = getResources().getDimensionPixelSize(R.dimen.margin_small);
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            layoutParams.setMarginEnd(controlWidth + marginSmall);
        }

        int minHeight = getResources().getDimensionPixelSize(R.dimen.material_avatar_list_item_min_size);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        // TODO: Implement AvatarListControl.
//        if (minHeight > layoutParams.height && (AvatarListControl.class.isInstance(item.primary) || AvatarListControl.class.isInstance(item.secondary))) {
//            layoutParams.height = minHeight;
//        }
    }

    private int getSelectedColor() {
        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.colorPrimary, tv, true) && tv.resourceId > 0) {
            return getResources().getColor(tv.resourceId);
        } else {
            return getResources().getColor(R.color.material_navdrawer_selected);
        }
    }

    @Override
    protected boolean goToNavDrawerItem(NavDrawerItem item) {
        return false;
    }

    private void addDivider() {
        addItem(new NavDrawerItem(NAVDRAWER_ITEM_DIVIDER));
    }

    private void addItem(int id, int title, ListControl primary, ListControl secondary) {
        addItem(new SingleLineNavDrawerItem(id, title, primary, secondary));
    }

    protected static class SingleLineNavDrawerItem extends NavDrawerItem {
        int textId;
        ListControl primary, secondary;

        public SingleLineNavDrawerItem(int id, int textId, ListControl primary, ListControl secondary) {
            super(id);
            this.textId = textId;
            this.primary = primary;
            this.secondary = secondary;
        }

        public int getTextId() {
            return textId;
        }

        public ListControl getPrimary() {
            return primary;
        }

        public ListControl getSecondary() {
            return secondary;
        }
    }
}
