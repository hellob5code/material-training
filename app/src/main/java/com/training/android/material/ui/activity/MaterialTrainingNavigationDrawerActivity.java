package com.training.android.material.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.BuildConfig;
import com.training.android.material.R;
import com.training.android.material.ui.listcontrol.IconListControl;
import com.training.android.material.ui.tile.Tile;
import com.training.android.material.util.ApiUtils;
import com.training.android.material.util.ViewUtils;

// TODO: If the list of content in the navigation drawer is very long, the two options can be pinned to the bottom of the navigation drawer on a surface with a higher elevation. This surface is present only while at the top of the list; any other scroll position will immediately result in dismissing the surface and placing the options at the end of the list, in-line with the rest of the list content. The navigation drawer retains its scroll position when closed and reopened.
public abstract class MaterialTrainingNavigationDrawerActivity extends AbstractExpandableNavigationDrawerActivity {

    private static final String TAG = MaterialTrainingNavigationDrawerActivity.class.getSimpleName();

    protected static final int NAVDRAWER_GROUP_MATERIAL_DESIGN_ID =             0;
    protected static final int NAVDRAWER_CHILD_INTRODUCTION_ID =                1;
    protected static final int NAVDRAWER_GROUP_WHAT_IS_MATERIAL_ID =          100;
    protected static final int NAVDRAWER_CHILD_ENVIRONMENT_ID =               101;
    protected static final int NAVDRAWER_CHILD_MATERIAL_PROPERTIES_ID =       102;
    protected static final int NAVDRAWER_CHILD_OBJECTS_IN_3D_SPACE_ID =       103;
    protected static final int NAVDRAWER_GROUP_ANIMATION_ID =                 200;
    protected static final int NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID =          201;
    protected static final int NAVDRAWER_CHILD_RESPONSIVE_INTERACTION_ID =    202;
    protected static final int NAVDRAWER_CHILD_MEANINGFUL_TRANSITIONS_ID =    203;
    protected static final int NAVDRAWER_CHILD_DELIGHTFUL_DETAILS_ID =        204;
    protected static final int NAVDRAWER_GROUP_STYLE_ID =                     300;
    protected static final int NAVDRAWER_CHILD_COLOR_ID =                     301;
    protected static final int NAVDRAWER_CHILD_ICONS_ID =                     302;
    protected static final int NAVDRAWER_CHILD_IMAGERY_ID =                   303;
    protected static final int NAVDRAWER_CHILD_TYPOGRAPHY_ID =                304;
    protected static final int NAVDRAWER_GROUP_LAYOUT_ID =                    400;
    protected static final int NAVDRAWER_CHILD_PRINCIPLES_ID =                401;
    protected static final int NAVDRAWER_CHILD_METRICS_AND_KEYLINES_ID =      402;
    protected static final int NAVDRAWER_CHILD_STRUCTURE_ID =                 403;
    protected static final int NAVDRAWER_GROUP_COMPONENTS_ID =                500;
    protected static final int NAVDRAWER_CHILD_BOTTOM_SHEETS_ID =             501;
    protected static final int NAVDRAWER_CHILD_BUTTONS_ID =                   502;
    protected static final int NAVDRAWER_CHILD_CARDS_ID =                     503;
    protected static final int NAVDRAWER_CHILD_CHIPS_ID =                     504;
    protected static final int NAVDRAWER_CHILD_DIALOGS_ID =                   505;
    protected static final int NAVDRAWER_CHILD_DIVIDERS_ID =                  506;
    protected static final int NAVDRAWER_CHILD_GRIDS_ID =                     507;
    protected static final int NAVDRAWER_CHILD_LISTS_ID =                     508;
    protected static final int NAVDRAWER_CHILD_LIST_CONTROLS_ID =             509;
    protected static final int NAVDRAWER_CHILD_MENUS_ID =                     510;
    protected static final int NAVDRAWER_CHILD_PICKERS_ID =                   511;
    protected static final int NAVDRAWER_CHILD_PROGRESS_AND_ACTIVITY_ID =     512;
    protected static final int NAVDRAWER_CHILD_SLIDERS_ID =                   513;
    protected static final int NAVDRAWER_CHILD_SNACKBARS_AND_TOASTS_ID =      514;
    protected static final int NAVDRAWER_CHILD_SUBHEADERS_ID =                515;
    protected static final int NAVDRAWER_CHILD_SWITCHES_ID =                  516;
    protected static final int NAVDRAWER_CHILD_TABS_ID =                      517;
    protected static final int NAVDRAWER_CHILD_TEXT_FIELDS_ID =               518;
    protected static final int NAVDRAWER_CHILD_TOOLTIPS_ID =                  519;
    protected static final int NAVDRAWER_GROUP_PATTERNS_ID =                  600;
    protected static final int NAVDRAWER_CHILD_DATA_FORMATS_ID =              601;
    protected static final int NAVDRAWER_CHILD_ERRORS_ID =                    602;
    protected static final int NAVDRAWER_CHILD_GESTURES_ID =                  603;
    protected static final int NAVDRAWER_CHILD_LOADING_IMAGES_ID =            604;
    protected static final int NAVDRAWER_CHILD_NAVIGATION_DRAWER_ID =         605;
    protected static final int NAVDRAWER_CHILD_NAVIGATIONAL_TRANSITIONS_ID =  606;
    protected static final int NAVDRAWER_CHILD_SCROLLING_TECHNIQUES_ID =      607;
    protected static final int NAVDRAWER_CHILD_SEARCH_ID =                    608;
    protected static final int NAVDRAWER_CHILD_SELECTION_ID =                 609;
    protected static final int NAVDRAWER_CHILD_SETTINGS_ID =                  610;
    protected static final int NAVDRAWER_CHILD_SWIPE_TO_REFRESH_ID =          611;
    protected static final int NAVDRAWER_GROUP_USABILITY_ID =                 700;
    protected static final int NAVDRAWER_CHILD_ACCESSIBILITY_ID =             701;
    protected static final int NAVDRAWER_CHILD_BIDIRECTIONALITY_ID =          702;
    protected static final int NAVDRAWER_GROUP_RESOURCES_ID =                 800;
    protected static final int NAVDRAWER_CHILD_COLOR_PALETTES_ID =            801;
    protected static final int NAVDRAWER_CHILD_LAYOUT_TEMPLATES_ID =          802;
    protected static final int NAVDRAWER_CHILD_ROBOTO_AND_NOTO_FONTS_ID =     803;
    protected static final int NAVDRAWER_CHILD_STICKER_SHEETS_AND_ICONS_ID =  804;
    protected static final int NAVDRAWER_GROUP_WHATS_NEW_ID =                 900;
    protected static final int NAVDRAWER_CHILD_WHATS_NEW_ID =                 901;
    protected static final int NAVDRAWER_ITEM_SETTINGS_ID =                  1000;
    protected static final int NAVDRAWER_ITEM_DEV_MODE_ID =                  1001;

    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @InjectView(R.id.content) View content;
    @InjectView(R.id.navdrawer_items) ExpandableListView navdrawerItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navdrawer);
        ButterKnife.inject(this);

        if (ApiUtils.isLollipop()) {
            int statusBarSize = getResources().getDimensionPixelSize(R.dimen.status_bar_size);
            toolbar.getLayoutParams().height += statusBarSize;
            toolbar.setPadding(0, statusBarSize, 0, 0);
            navdrawerItems.setPadding(0, navdrawerItems.getPaddingTop() + statusBarSize, 0, 0);
        }
        ViewUtils.setMaxWidth(navdrawerItems, getResources().getDimensionPixelSize(R.dimen.navdrawer_max_width_material));
        setSupportActionBar(toolbar);

        overridePendingTransition(R.anim.short_fade_in, R.anim.short_fade_out);
    }

    @Override
    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    @Override
    public View getContentLayout() {
        return content;
    }

    @Override
    protected ExpandableListView getDrawerItemsLayout() {
        return navdrawerItems;
    }

    @Override
    protected String getNavigationDrawerOpenedTitle() {
        return getString(R.string.app_name);
    }

    @Override
    protected void populateNavigationDrawer() {
        super.populateNavigationDrawer();
        addGroup(NAVDRAWER_GROUP_MATERIAL_DESIGN_ID, getString(R.string.navdrawer_group_material_design))
                .addChild(NAVDRAWER_CHILD_INTRODUCTION_ID, getString(R.string.navdrawer_child_introduction));
        addGroup(NAVDRAWER_GROUP_WHAT_IS_MATERIAL_ID, getString(R.string.navdrawer_group_what_is_material))
                .addChild(NAVDRAWER_CHILD_ENVIRONMENT_ID, getString(R.string.navdrawer_child_environment))
                .addChild(NAVDRAWER_CHILD_MATERIAL_PROPERTIES_ID, getString(R.string.navdrawer_child_material_properties))
                .addChild(NAVDRAWER_CHILD_OBJECTS_IN_3D_SPACE_ID, getString(R.string.navdrawer_child_objects_in_3d_space));
        addGroup(NAVDRAWER_GROUP_ANIMATION_ID, getString(R.string.navdrawer_group_animation))
                .addChild(NAVDRAWER_CHILD_AUTHENTIC_MOTION_ID, getString(R.string.navdrawer_child_authentic_motion))
                .addChild(NAVDRAWER_CHILD_RESPONSIVE_INTERACTION_ID, getString(R.string.navdrawer_child_responsive_interaction))
                .addChild(NAVDRAWER_CHILD_MEANINGFUL_TRANSITIONS_ID, getString(R.string.navdrawer_child_meaningful_transitions))
                .addChild(NAVDRAWER_CHILD_DELIGHTFUL_DETAILS_ID, getString(R.string.navdrawer_child_delightful_details));
        addGroup(NAVDRAWER_GROUP_STYLE_ID, getString(R.string.navdrawer_group_style))
                .addChild(NAVDRAWER_CHILD_COLOR_ID, getString(R.string.navdrawer_child_color))
                .addChild(NAVDRAWER_CHILD_ICONS_ID, getString(R.string.navdrawer_child_icons))
                .addChild(NAVDRAWER_CHILD_IMAGERY_ID, getString(R.string.navdrawer_child_imagery))
                .addChild(NAVDRAWER_CHILD_TYPOGRAPHY_ID, getString(R.string.navdrawer_child_typography));
        addGroup(NAVDRAWER_GROUP_LAYOUT_ID, getString(R.string.navdrawer_group_layout))
                .addChild(NAVDRAWER_CHILD_PRINCIPLES_ID, getString(R.string.navdrawer_child_principles))
                .addChild(NAVDRAWER_CHILD_METRICS_AND_KEYLINES_ID, getString(R.string.navdrawer_child_metrics_and_keylines))
                .addChild(NAVDRAWER_CHILD_STRUCTURE_ID, getString(R.string.navdrawer_child_structure));
        addGroup(NAVDRAWER_GROUP_COMPONENTS_ID, getString(R.string.navdrawer_group_components))
                .addChild(NAVDRAWER_CHILD_BOTTOM_SHEETS_ID, getString(R.string.navdrawer_child_bottom_sheets))
                .addChild(NAVDRAWER_CHILD_BUTTONS_ID, getString(R.string.navdrawer_child_buttons))
                .addChild(NAVDRAWER_CHILD_CARDS_ID, getString(R.string.navdrawer_child_cards))
                .addChild(NAVDRAWER_CHILD_CHIPS_ID, getString(R.string.navdrawer_child_chips))
                .addChild(NAVDRAWER_CHILD_DIALOGS_ID, getString(R.string.navdrawer_child_dialogs))
                .addChild(NAVDRAWER_CHILD_DIVIDERS_ID, getString(R.string.navdrawer_child_dividers))
                .addChild(NAVDRAWER_CHILD_GRIDS_ID, getString(R.string.navdrawer_child_grids))
                .addChild(NAVDRAWER_CHILD_LISTS_ID, getString(R.string.navdrawer_child_lists))
                .addChild(NAVDRAWER_CHILD_LIST_CONTROLS_ID, getString(R.string.navdrawer_child_list_controls))
                .addChild(NAVDRAWER_CHILD_MENUS_ID, getString(R.string.navdrawer_child_menus))
                .addChild(NAVDRAWER_CHILD_PICKERS_ID, getString(R.string.navdrawer_child_pickers))
                .addChild(NAVDRAWER_CHILD_PROGRESS_AND_ACTIVITY_ID, getString(R.string.navdrawer_child_progress_and_activity))
                .addChild(NAVDRAWER_CHILD_SLIDERS_ID, getString(R.string.navdrawer_child_sliders))
                .addChild(NAVDRAWER_CHILD_SNACKBARS_AND_TOASTS_ID, getString(R.string.navdrawer_child_snackbars_and_toasts))
                .addChild(NAVDRAWER_CHILD_SUBHEADERS_ID, getString(R.string.navdrawer_child_subheaders))
                .addChild(NAVDRAWER_CHILD_SWITCHES_ID, getString(R.string.navdrawer_child_switches))
                .addChild(NAVDRAWER_CHILD_TABS_ID, getString(R.string.navdrawer_child_tabs))
                .addChild(NAVDRAWER_CHILD_TEXT_FIELDS_ID, getString(R.string.navdrawer_child_text_fields))
                .addChild(NAVDRAWER_CHILD_TOOLTIPS_ID, getString(R.string.navdrawer_child_tooltips));
        addGroup(NAVDRAWER_GROUP_PATTERNS_ID, getString(R.string.navdrawer_group_patterns))
                .addChild(NAVDRAWER_CHILD_DATA_FORMATS_ID, getString(R.string.navdrawer_child_data_formats))
                .addChild(NAVDRAWER_CHILD_ERRORS_ID, getString(R.string.navdrawer_child_errors))
                .addChild(NAVDRAWER_CHILD_GESTURES_ID, getString(R.string.navdrawer_child_gestures))
                .addChild(NAVDRAWER_CHILD_LOADING_IMAGES_ID, getString(R.string.navdrawer_child_loading_images))
                .addChild(NAVDRAWER_CHILD_NAVIGATION_DRAWER_ID, getString(R.string.navdrawer_child_navigation_drawer))
                .addChild(NAVDRAWER_CHILD_NAVIGATIONAL_TRANSITIONS_ID, getString(R.string.navdrawer_child_navigational_transitions))
                .addChild(NAVDRAWER_CHILD_SCROLLING_TECHNIQUES_ID, getString(R.string.navdrawer_child_scrolling_techniques))
                .addChild(NAVDRAWER_CHILD_SEARCH_ID, getString(R.string.navdrawer_child_search))
                .addChild(NAVDRAWER_CHILD_SELECTION_ID, getString(R.string.navdrawer_child_selection))
                .addChild(NAVDRAWER_CHILD_SETTINGS_ID, getString(R.string.navdrawer_child_settings))
                .addChild(NAVDRAWER_CHILD_SWIPE_TO_REFRESH_ID, getString(R.string.navdrawer_child_swipe_to_refresh));
        addGroup(NAVDRAWER_GROUP_USABILITY_ID, getString(R.string.navdrawer_group_usability))
                .addChild(NAVDRAWER_CHILD_ACCESSIBILITY_ID, getString(R.string.navdrawer_child_accessibility))
                .addChild(NAVDRAWER_CHILD_BIDIRECTIONALITY_ID, getString(R.string.navdrawer_child_bidirectionality));
        addGroup(NAVDRAWER_GROUP_RESOURCES_ID, getString(R.string.navdrawer_group_resources))
                .addChild(NAVDRAWER_CHILD_COLOR_PALETTES_ID, getString(R.string.navdrawer_child_color_palettes))
                .addChild(NAVDRAWER_CHILD_LAYOUT_TEMPLATES_ID, getString(R.string.navdrawer_child_layout_templates))
                .addChild(NAVDRAWER_CHILD_ROBOTO_AND_NOTO_FONTS_ID, getString(R.string.navdrawer_child_roboto_and_noto_fonts))
                .addChild(NAVDRAWER_CHILD_STICKER_SHEETS_AND_ICONS_ID, getString(R.string.navdrawer_child_sticker_sheets_and_icons));
        addGroup(NAVDRAWER_GROUP_WHATS_NEW_ID, getString(R.string.navdrawer_group_whats_new))
                .addChild(NAVDRAWER_CHILD_WHATS_NEW_ID, getString(R.string.navdrawer_child_whats_new));
        addDivider();
        addItem(NAVDRAWER_ITEM_SETTINGS_ID, getString(R.string.navdrawer_item_settings), new IconListControl(this, R.drawable.ic_action_settings), null);
        if (BuildConfig.DEBUG) {
            addItem(NAVDRAWER_ITEM_DEV_MODE_ID, getString(R.string.navdrawer_item_developer_mode), new IconListControl(this, R.drawable.ic_device_developer_mode), null);
        }
    }

    @Override
    protected boolean goToNavigationDrawerItem(Tile item) {
        int id = item.getId();
        // Clic on item
        switch (id) {
            case NAVDRAWER_ITEM_SETTINGS_ID:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case NAVDRAWER_ITEM_DEV_MODE_ID:
                startActivity(new Intent(this, DeveloperModeActivity.class));
                return true;
            default:
                // Clic on a child of another group
                int parentId = ((NavigationDrawerChild) item).getParentId();
                switch (parentId) {
                    case NAVDRAWER_GROUP_MATERIAL_DESIGN_ID:
                        startActivity(new Intent(this, MaterialDesignActivity.class).putExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, id));
                        break;
                    case NAVDRAWER_GROUP_WHAT_IS_MATERIAL_ID:
                        startActivity(new Intent(this, WhatIsMaterialActivity.class).putExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, id));
                        break;
                    case NAVDRAWER_GROUP_ANIMATION_ID:
                        startActivity(new Intent(this, AnimationActivity.class).putExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, id));
                        break;
                    case NAVDRAWER_GROUP_STYLE_ID:
                        startActivity(new Intent(this, StyleActivity.class).putExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, id));
                        break;
                    case NAVDRAWER_GROUP_LAYOUT_ID:
                        startActivity(new Intent(this, LayoutActivity.class).putExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, id));
                        break;
                    case NAVDRAWER_GROUP_COMPONENTS_ID:
                        startActivity(new Intent(this, ComponentsActivity.class).putExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, id));
                        break;
                    case NAVDRAWER_GROUP_PATTERNS_ID:
                        startActivity(new Intent(this, PatternsActivity.class).putExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, id));
                        break;
                    case NAVDRAWER_GROUP_USABILITY_ID:
                        startActivity(new Intent(this, UsabilityActivity.class).putExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, id));
                        break;
                    case NAVDRAWER_GROUP_RESOURCES_ID:
                        startActivity(new Intent(this, ResourcesActivity.class).putExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, id));
                        break;
                    case NAVDRAWER_GROUP_WHATS_NEW_ID:
                        startActivity(new Intent(this, WhatsNewActivity.class).putExtra(EXTRA_SELECTED_NAVIGATION_DRAWER_CHILD_ID, id));
                        break;
                }
                finish();
                return false;
        }
    }
}