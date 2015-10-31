package fr.erictruong.material.training.ui.components.tabs;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.adapter.SimpleFragmentPagerAdapter;
import fr.erictruong.material.training.ui.core.fragment.DummyFragment;

public class FixedTabBarIconsActivity extends AppCompatActivity {

    @Bind(R.id.fixed_tab_bar_toolbar) Toolbar toolbar;
    @Bind(R.id.fixed_tab_bar_tabs) TabLayout tabs;
    @Bind(R.id.fixed_tab_bar_view_pager) ViewPager viewPager;

    public static void start(Context context) {
        Intent starter = new Intent(context, FixedTabBarIconsActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed_tab_bar);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(toolbar, "Navigation icon", Snackbar.LENGTH_SHORT).show();
            }
        });

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment("Recents", DummyFragment.newInstance());
        adapter.addFragment("Favorites", DummyFragment.newInstance());
        adapter.addFragment("Nearby", DummyFragment.newInstance());

        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);

        ColorStateList tabTextColors = tabs.getTabTextColors();
        tabs.getTabAt(0).setIcon(getStateListDrawable(tabTextColors, R.drawable.ic_phone_white_24dp));
        tabs.getTabAt(1).setIcon(getStateListDrawable(tabTextColors, R.drawable.ic_favorite_white_24dp));
        tabs.getTabAt(2).setIcon(getStateListDrawable(tabTextColors, R.drawable.ic_person_pin_white_24dp));
    }

    private Drawable getStateListDrawable(ColorStateList colorStateList, @DrawableRes int drawableResId) {
        Drawable drawable = ContextCompat.getDrawable(this, drawableResId);
        DrawableCompat.setTintList(drawable, colorStateList);
        return drawable;
    }
}
