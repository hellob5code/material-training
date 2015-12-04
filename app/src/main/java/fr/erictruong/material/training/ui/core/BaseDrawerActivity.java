package fr.erictruong.material.training.ui.core;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import butterknife.Bind;
import butterknife.BindInt;
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

    @BindInt(android.R.integer.config_shortAnimTime) int shortAnimTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_drawer);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.access_navigation_drawer_open, R.string.access_navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigation.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            // Initialze content
            int selectedNavId = getIntent().getIntExtra(EXTRA_NAV_ID, -1);
            navigation.setCheckedItem(selectedNavId);
            Fragment fragment = getSelectedFragment(selectedNavId);
            if (fragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.drawer_content, fragment)
                        .commit();
                fadeInContent();
            }
        }
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
    public boolean onNavigationItemSelected(final MenuItem item) {
        final int id = item.getItemId();
        String title = item.getTitle().toString();

        navigation.setCheckedItem(id);
        Fragment fragment = getSelectedFragment(id);
        if (fragment != null) {
            replaceFragment(fragment, title);
            getIntent().putExtra(EXTRA_NAV_ID, id);
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        switch (id) {
            default:
                // Perform action after a short delay to allow the close animation to play
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startGroup(item, id);
                        finish();
                    }
                }, shortAnimTime);
                fadeOutContent();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void startGroup(MenuItem item, int id) {
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

    /**
     * Return an fragment instance given the navigation menu item ID of the desired content.
     *
     * @param id The navigation menu item ID of the desired content.
     * @return A {@code Fragment} instance or {@code null} if the menu item ID was unresolved.
     */
    @Nullable
    protected abstract Fragment getSelectedFragment(int id);

    /**
     * Replace an existing fragment that was added to the drawer content container. Play
     * fragment transition animation sequentially.
     *
     * @param fragment The new fragment to place in the container.
     * @param tag      The tag name for the fragment.
     */
    protected void replaceFragment(final Fragment fragment, final String tag) {
        // Fade in an out sequentially
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.drawer_content, fragment, tag)
                        .commit();
                fadeInContent();
            }
        }, shortAnimTime);
        fadeOutContent();
    }

    private void fadeInContent() {
        content.clearAnimation();
        content.animate().setInterpolator(new DecelerateInterpolator()).alpha(1).setDuration(shortAnimTime);
    }

    private void fadeOutContent() {
        content.clearAnimation();
        content.animate().setInterpolator(new AccelerateInterpolator()).alpha(0).setDuration(shortAnimTime);
    }
}
