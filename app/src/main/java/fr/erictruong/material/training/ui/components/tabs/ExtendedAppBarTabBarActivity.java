package fr.erictruong.material.training.ui.components.tabs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import butterknife.Bind;
import butterknife.ButterKnife;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.adapter.SimpleFragmentPagerAdapter;
import fr.erictruong.material.training.ui.core.fragment.DummyFragment;

public class ExtendedAppBarTabBarActivity extends AppCompatActivity {

    @Bind(R.id.extended_app_bar_tab_bar_drawer_layout) DrawerLayout drawerLayout;
    @Bind(R.id.extended_app_bar_tab_bar_collapsing_toolbar) CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.extended_app_bar_tab_bar_toolbar) Toolbar toolbar;
    @Bind(R.id.extended_app_bar_tab_bar_tabs) TabLayout tabs;
    @Bind(R.id.extended_app_bar_tab_bar_view_pager) ViewPager viewPager;

    public static void start(Context context) {
        Intent starter = new Intent(context, ExtendedAppBarTabBarActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extended_app_bar_tab_bar);
        ButterKnife.bind(this);

        collapsingToolbar.setTitle(getTitle());

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.access_navigation_drawer_open, R.string.access_navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment("Item one", DummyFragment.newInstance());
        adapter.addFragment("Item two", DummyFragment.newInstance());
        adapter.addFragment("Item three", DummyFragment.newInstance());

        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_light, menu);
        inflater.inflate(R.menu.settings, menu);
        return true;
    }
}
