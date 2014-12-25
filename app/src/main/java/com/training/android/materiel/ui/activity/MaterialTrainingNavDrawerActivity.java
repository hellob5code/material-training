package com.training.android.materiel.ui.activity;

import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.training.android.materiel.R;
import com.training.android.materiel.ui.listcontrol.IconListControl;
import com.training.android.materiel.ui.listcontrol.ListControl;

public abstract class MaterialTrainingNavDrawerActivity extends AbstractNavDrawerActivity {

    private static final String TAG = MaterialTrainingNavDrawerActivity.class.getSimpleName();

    protected static final int NAVDRAWER_ITEM_MAIN_ID = 0;

    @Override
    protected void populateNavigationDrawer() {
        super.populateNavigationDrawer();
        addItem(new MaterialTrainingNavDrawerItem(NAVDRAWER_ITEM_MAIN_ID, R.string.navdrawer_item_main, new IconListControl(R.drawable.ic_launcher), null));
        addItem(new MaterialTrainingNavDrawerItem(1, R.string.hello_world, new IconListControl(R.drawable.ic_launcher), null));
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
            navDrawerItemViews[i] = createNavigationDrawerItem((MaterialTrainingNavDrawerItem) item, drawerItemsListContainer);
            drawerItemsListContainer.addView(navDrawerItemViews[i]);
            i++;
        }
    }

    private View createNavigationDrawerItem(final MaterialTrainingNavDrawerItem item, ViewGroup container) {
        boolean isSelected = getSelectedNavigationDrawerItemId() == item.id;

        // Select layout to inflate
        int layoutToInflate;
        if (item.id == NAVDRAWER_ITEM_SEPARATOR) {
            layoutToInflate = R.layout.list_divider_material;
        } else {
            layoutToInflate = R.layout.list_item_single_line_material;
        }

        // Perform inflation
        View view = getLayoutInflater().inflate(layoutToInflate, container, false);
        if (item.id == NAVDRAWER_ITEM_SEPARATOR) {
            return view;
        }

        // Setup item content
        boolean startIndented = false;
        if (item.primary != null) {
            View primaryView = inflateStubIfViewNotNull(view, R.id.primary_stub, item.primary);
            startIndented = item.primary.setupView(this, primaryView);
        }
        boolean endIndented = false;
        if (item.secondary != null) {
            View secondaryView = inflateStubIfViewNotNull(view, R.id.secondary_stub, item.secondary);
            endIndented = item.secondary.setupView(this, secondaryView);
        }

        TextView titleView = (TextView) view.findViewById(R.id.text);
        titleView.setText(getString(item.textId));

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

    private void formatNavigationDrawerItem(View view, boolean startIndented, boolean endIndented, MaterialTrainingNavDrawerItem item, boolean selected) {
        if (item.id == NAVDRAWER_ITEM_SEPARATOR) {
            return;
        }

        // Configure its appearance according to whether or not it's selected
        if (IconListControl.class.isInstance(item.primary) && ((IconListControl) item.primary).getDrawableId() > 0) {
            ImageView iconView = (ImageView) view.findViewById(R.id.list_control_icon_material);
            iconView.setColorFilter(selected ?
                    getResources().getColor(R.color.navdrawer_text_color_selected) :
                    getResources().getColor(R.color.material_navdrawer_icon), PorterDuff.Mode.SRC_IN);
        }
        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setTextColor(selected ?
                getResources().getColor(R.color.navdrawer_text_color_selected) :
                getResources().getColor(R.color.material_navdrawer_text));

        if (startIndented) {
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            layoutParams.setMarginStart(getResources().getDimensionPixelSize(R.dimen.keyline_2_minus_16dp));
        }
        if (endIndented) {
            int controlWidth = getResources().getDimensionPixelSize(item.secondary.getLayoutSizeId());
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

    @Override
    protected boolean goToNavDrawerItem(NavDrawerItem item) {
        return false;
    }

    protected static class MaterialTrainingNavDrawerItem extends NavDrawerItem {
        ListControl primary, secondary;

        public MaterialTrainingNavDrawerItem(int id, int textId, ListControl primary, ListControl secondary) {
            super(id, textId);
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
