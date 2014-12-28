package com.training.android.materiel.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Toolbar;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.materiel.BuildConfig;
import com.training.android.materiel.R;
import com.training.android.materiel.ui.listcontrol.IconListControl;
import com.training.android.materiel.ui.row.ListRow;

// TODO: If the list of content in the navigation drawer is very long, the two options can be pinned to the bottom of the navigation drawer on a surface with a higher elevation. This surface is present only while at the top of the list; any other scroll position will immediately result in dismissing the surface and placing the options at the end of the list, in-line with the rest of the list content. The navigation drawer retains its scroll position when closed and reopened.
public abstract class MaterialTrainingNavDrawerActivity extends AbstractExpandableNavDrawerActivity {

    private static final String TAG = MaterialTrainingNavDrawerActivity.class.getSimpleName();

    protected static final String EXTRA_SELECTED_CHILD_ID = "selected_child_id";

    protected static final int NAVDRAWER_GROUP_COMPONENTS = 400;
    protected static final int NAVDRAWER_CHILD_BOTTOM_SHEETS_ID = 401;
    protected static final int NAVDRAWER_CHILD_BUTTONS_ID = 402;
    protected static final int NAVDRAWER_CHILD_LISTS_ID = 408;
    protected static final int NAVDRAWER_GROUP_PATTERNS = 500;
    protected static final int NAVDRAWER_CHILD_DATA_FORMATS_ID = 501;
    protected static final int NAVDRAWER_CHILD_ERRORS_ID = 502;
    protected static final int NAVDRAWER_ITEM_SETTINGS_ID = 1000;
    protected static final int NAVDRAWER_ITEM_DEV_MODE_ID = 1001;

    @InjectView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navdrawer);
        ButterKnife.inject(this);
        setActionBar(toolbar);
        overridePendingTransition(R.anim.short_fade_in, R.anim.short_fade_out);
    }

    @Override
    public DrawerLayout getDrawerLayout() {
        return (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    @Override
    public View getContentLayout() {
        return findViewById(R.id.content);
    }

    @Override
    protected String getNavigationDrawerOpenedTitle() {
        return getString(R.string.app_name);
    }

    @Override
    protected void populateNavDrawer() {
        super.populateNavDrawer();
        addGroup(NAVDRAWER_GROUP_COMPONENTS, getString(R.string.navdrawer_group_components))
                .addChild(NAVDRAWER_CHILD_BOTTOM_SHEETS_ID, getString(R.string.navdrawer_child_bottom_sheets))
                .addChild(NAVDRAWER_CHILD_LISTS_ID, getString(R.string.navdrawer_child_lists))
                .addChild(NAVDRAWER_CHILD_BUTTONS_ID, getString(R.string.navdrawer_child_buttons));
        addGroup(NAVDRAWER_GROUP_PATTERNS, getString(R.string.navdrawer_group_patterns))
                .addChild(NAVDRAWER_CHILD_DATA_FORMATS_ID, getString(R.string.navdrawer_child_data_formats))
                .addChild(NAVDRAWER_CHILD_ERRORS_ID, getString(R.string.navdrawer_child_errors));
        addDivider();
        addItem(NAVDRAWER_ITEM_SETTINGS_ID, getString(R.string.navdrawer_item_settings), new IconListControl(this, R.drawable.action_ic_settings), null);
        if (BuildConfig.DEBUG) {
            addItem(NAVDRAWER_ITEM_DEV_MODE_ID, getString(R.string.navdrawer_item_developer_mode), new IconListControl(this, R.drawable.device_ic_developer_mode), null);
        }
    }

    @Override
    protected boolean onNavDrawerItemSelected(ListRow item) {
        int id = item.getId();
        if (id == NAVDRAWER_ITEM_SETTINGS_ID) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        } else if (id == NAVDRAWER_ITEM_DEV_MODE_ID) {
            startActivity(new Intent(this, DeveloperModeActivity.class));
            return true;
        } else {
            int parentId = ((NavDrawerChild) item).getParentId();
            if (parentId == NAVDRAWER_GROUP_COMPONENTS) {
                startActivity(new Intent(this, ComponentsActivity.class).putExtra(EXTRA_SELECTED_CHILD_ID, id));
            } else if (parentId == NAVDRAWER_GROUP_PATTERNS) {
                startActivity(new Intent(this, PatternsActivity.class).putExtra(EXTRA_SELECTED_CHILD_ID, id));
            }
            finish();
        }
        return false;
    }
}
