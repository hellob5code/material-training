package fr.erictruong.material.training.ui.core;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.animation.AnimationActivity;
import fr.erictruong.material.training.ui.components.ComponentsActivity;
import fr.erictruong.material.training.ui.layout.LayoutActivity;
import fr.erictruong.material.training.ui.material_design.MaterialDesignActivity;
import fr.erictruong.material.training.ui.patterns.PatternsActivity;
import fr.erictruong.material.training.ui.resources.ResourcesActivity;
import fr.erictruong.material.training.ui.style.StyleActivity;
import fr.erictruong.material.training.ui.usability.UsabilityActivity;
import fr.erictruong.material.training.ui.what_is_material.WhatIsMaterialActivity;
import fr.erictruong.material.training.ui.whats_new.WhatsNewActivity;

public abstract class BaseDrawerActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String EXTRA_NAV_ID = "extra_nav_id";

    @Bind(R.id.drawer_layout)
    protected DrawerLayout drawerLayout;
    @Bind(R.id.drawer_navigation)
    protected NavigationView navigation;
    @Bind(R.id.drawer_toolbar)
    protected Toolbar toolbar;
    @Bind(R.id.drawer_content)
    protected ViewGroup content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_drawer);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.access_navigation_drawer_open, R.string.access_navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigation.setNavigationItemSelectedListener(this);

        // Initialze content
        int selectedNavId = getIntent().getIntExtra(EXTRA_NAV_ID, -1);
        navigation.getMenu().performIdentifierAction(selectedNavId, 0);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        String title = item.getTitle().toString();

        Fragment fragment = getSelectedFragment(id);
        if (fragment != null) {
            replaceFragment(fragment, title);
            getIntent().putExtra(EXTRA_NAV_ID, id);
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        switch (id) {
            default:
                int groupId = item.getGroupId();
                switch (groupId) {
                    case R.id.group_material_design:
                        MaterialDesignActivity.start(this, id);
                        break;
                    case R.id.group_what_is_material:
                        WhatIsMaterialActivity.start(this, id);
                        break;
                    case R.id.group_animation:
                        AnimationActivity.start(this, id);
                        break;
                    case R.id.group_style:
                        StyleActivity.start(this, id);
                        break;
                    case R.id.group_layout:
                        LayoutActivity.start(this, id);
                        break;
                    case R.id.group_components:
                        ComponentsActivity.start(this, id);
                        break;
                    case R.id.group_patterns:
                        PatternsActivity.start(this, id);
                        break;
                    case R.id.group_usability:
                        UsabilityActivity.start(this, id);
                        break;
                    case R.id.group_resources:
                        ResourcesActivity.start(this, id);
                        break;
                    case R.id.group_whats_new:
                        WhatsNewActivity.start(this, id);
                        break;
                    default:
                        throw new IllegalStateException("Unknown navigation group: " + groupId);
                }
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Replace an existing fragment that was added to the drawer content container.
     *
     * @param fragment The new fragment to place in the container.
     * @param tag      The tag name for the fragment.
     */
    protected void replaceFragment(Fragment fragment, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.drawer_content, fragment, tag).commit();
    }

    /**
     * Return an fragment instance given the navigation menu item ID of the desired content.
     *
     * @param id The navigation menu item ID of the desired content.
     * @return A {@code Fragment} instance or {@code null} if the menu item ID was unresolved.
     */
    protected abstract Fragment getSelectedFragment(int id);
}
