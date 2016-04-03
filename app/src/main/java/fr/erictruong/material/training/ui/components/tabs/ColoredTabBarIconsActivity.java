package fr.erictruong.material.training.ui.components.tabs;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.StateSet;
import android.view.Menu;
import android.view.MenuInflater;

import butterknife.Bind;
import butterknife.ButterKnife;
import fr.erictruong.android.core.adapter.SimpleFragmentPagerAdapter;
import fr.erictruong.android.core.util.ThemeUtils;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.DummyFragment;

public class ColoredTabBarIconsActivity extends AppCompatActivity {

    @Bind(R.id.colored_tab_bar_drawer_layout) DrawerLayout drawerLayout;
    @Bind(R.id.colored_tab_bar_toolbar) Toolbar toolbar;
    @Bind(R.id.colored_tab_bar_tabs) TabLayout tabs;
    @Bind(R.id.colored_tab_bar_view_pager) ViewPager viewPager;

    public static void start(Context context) {
        Intent starter = new Intent(context, ColoredTabBarIconsActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colored_tab_bar);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.access_navigation_drawer_open, R.string.access_navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DummyFragment());
        adapter.addFragment(new DummyFragment());
        adapter.addFragment(new DummyFragment());

        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);

        tabs.getTabAt(0).setIcon(getStateListDrawable(R.drawable.ic_phone_black_24dp_alpha54));
        tabs.getTabAt(1).setIcon(getStateListDrawable(R.drawable.ic_favorite_black_24dp_alpha54));
        tabs.getTabAt(2).setIcon(getStateListDrawable(R.drawable.ic_person_pin_black_24dp_alpha54));
    }

    private StateListDrawable getStateListDrawable(@DrawableRes int drawableResId) {
        Drawable accentDrawable = ThemeUtils.getAccentTintedDrawable(this, drawableResId);
        Drawable defaultDrawable = ContextCompat.getDrawable(this, drawableResId);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, accentDrawable);
        stateListDrawable.addState(StateSet.WILD_CARD, defaultDrawable);
        return stateListDrawable;
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
        inflater.inflate(R.menu.search_dark, menu);
        inflater.inflate(R.menu.settings, menu);
        return true;
    }
}
