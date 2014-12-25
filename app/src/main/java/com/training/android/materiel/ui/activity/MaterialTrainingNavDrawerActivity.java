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

// TODO: If the list of content in the navigation drawer is very long, the two options can be pinned to the bottom of the navigation drawer on a surface with a higher elevation. This surface is present only while at the top of the list; any other scroll position will immediately result in dismissing the surface and placing the options at the end of the list, in-line with the rest of the list content. The navigation drawer retains its scroll position when closed and reopened.
public abstract class MaterialTrainingNavDrawerActivity extends AbstractNavDrawerActivity {

    private static final String TAG = MaterialTrainingNavDrawerActivity.class.getSimpleName();

    protected static final int NAVDRAWER_ITEM_MAIN_ID = 0;
    protected static final int NAVDRAWER_ITEM_SETTINGS_ID = 1000;
    protected static final int NAVDRAWER_ITEM_DEV_MODE_ID = 1001;

    @Override
    protected void populateNavigationDrawer() {
        super.populateNavigationDrawer();
        addSubheader(R.string.hello_world);
        addItem(NAVDRAWER_ITEM_MAIN_ID, R.string.navdrawer_item_main, new IconListControl(R.drawable.action_ic_bookmark), null);
        addSubheader(R.string.app_name);
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

        View[] navDrawerItemViews = new View[getNavDrawerItems().size()];
        drawerItemsListContainer.removeAllViews();
        int i = 0;
        for (NavDrawerItem item : getNavDrawerItems()) {
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
        } else if (item.id == NAVDRAWER_SUBHEADER) {
            layoutToInflate = R.layout.list_subheader_material;
        } else {
            layoutToInflate = R.layout.list_item_single_line_material;
        }

        // Perform inflation
        View view = getLayoutInflater().inflate(layoutToInflate, container, false);

        if (item.id == NAVDRAWER_ITEM_DIVIDER) {
            return view;
        } else {
            SingleLineNavDrawerItem textItem = (SingleLineNavDrawerItem) item;
            TextView titleView = (TextView) view.findViewById(R.id.text);
            titleView.setText(getString(textItem.stringId));

            if (item.id == NAVDRAWER_SUBHEADER) {
                formatNavigationDrawerItem(view, false, false, item, isSelected);

            } else {
                SingleLineControlNavDrawerItem controlItem = (SingleLineControlNavDrawerItem) item;
                boolean startIndented = false;
                if (controlItem.primary != null) {
                    View primaryView = inflateStubIfViewNotNull(view, R.id.primary_stub, controlItem.primary);
                    startIndented = controlItem.primary.setupView(this, primaryView);
                }
                boolean endIndented = false;
                if (controlItem.secondary != null) {
                    View secondaryView = inflateStubIfViewNotNull(view, R.id.secondary_stub, controlItem.secondary);
                    endIndented = controlItem.secondary.setupView(this, secondaryView);
                }

                formatNavigationDrawerItem(view, startIndented, endIndented, item, isSelected);

                // Enable click
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onNavigationDrawerItemClicked(item);
                    }
                });
            }
        }

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
            // Do nothing
        } else if (item.id == NAVDRAWER_SUBHEADER) {
            if (getNavDrawerItems().indexOf(item) == 0) {
                view.findViewById(R.id.divider).setVisibility(View.GONE);
            }

            TextView textView = (TextView) view.findViewById(R.id.text);
            textView.setTextColor(getResources().getColor(R.color.material_text_secondary));

        } else {
            SingleLineControlNavDrawerItem controlItem = (SingleLineControlNavDrawerItem) item;

            // Configure its appearance according to whether or not it's selected
            TextView textView = (TextView) view.findViewById(R.id.text);
            textView.setTextColor(selected ? getSelectedColor() : getResources().getColor(R.color.material_navdrawer_text));
            if (IconListControl.class.isInstance(controlItem.primary) && ((IconListControl) controlItem.primary).getDrawableId() > 0) {
                ImageView iconView = (ImageView) view.findViewById(R.id.list_control_icon_material);
                iconView.setColorFilter(selected ? getSelectedColor() : getResources().getColor(R.color.material_navdrawer_icon), PorterDuff.Mode.SRC_IN);
            }

            if (startIndented) {
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                layoutParams.setMarginStart(getResources().getDimensionPixelSize(R.dimen.keyline_2_minus_16dp));
            }
            if (endIndented) {
                int controlWidth = getResources().getDimensionPixelSize(controlItem.secondary.getLayoutSizeId());
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

    private void addSubheader(int stringId) {
        addItem(new SingleLineNavDrawerItem(NAVDRAWER_SUBHEADER, stringId));
    }

    private void addItem(int id, int stringId, ListControl primary, ListControl secondary) {
        addItem(new SingleLineControlNavDrawerItem(id, stringId, primary, secondary));
    }

    protected static class SingleLineNavDrawerItem extends NavDrawerItem {
        int stringId;

        public SingleLineNavDrawerItem(int id, int stringId) {
            super(id);
            this.stringId = stringId;
        }

        public int getStringId() {
            return stringId;
        }
    }

    protected static class SingleLineControlNavDrawerItem extends SingleLineNavDrawerItem {
        ListControl primary, secondary;

        public SingleLineControlNavDrawerItem(int id, int stringId, ListControl primary, ListControl secondary) {
            super(id, stringId);
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
}
