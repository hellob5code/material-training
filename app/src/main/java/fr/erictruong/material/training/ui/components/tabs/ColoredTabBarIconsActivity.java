package fr.erictruong.material.training.ui.components.tabs;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.adapter.SimpleFragmentPagerAdapter;
import fr.erictruong.material.training.ui.core.fragment.DummyFragment;
import fr.erictruong.material.training.util.ThemeUtils;

public class ColoredTabBarIconsActivity extends AppCompatActivity {

    @Bind(R.id.colored_tab_bar_toolbar) Toolbar toolbar;
    @Bind(R.id.colored_tab_bar_tabs) TabLayout tabs;
    @Bind(R.id.colored_tab_bar_view_pager) ViewPager viewPager;

    @BindColor(R.color.material_text_secondary) int colorMaterialTextSecondary;

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
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp_alpha54);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(toolbar, "Navigation!", Snackbar.LENGTH_SHORT).show();
            }
        });

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(DummyFragment.newInstance());
        adapter.addFragment(DummyFragment.newInstance());
        adapter.addFragment(DummyFragment.newInstance());

        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);

        tabs.setTabTextColors(colorMaterialTextSecondary, ThemeUtils.obtainColorAccent(this));

        Drawable drawable = ThemeUtils.getPrimaryTintedDrawable(this, R.drawable.ic_phone_black_24dp_alpha54);

        tabs.getTabAt(0).setIcon(drawable);
        tabs.getTabAt(1).setIcon(R.drawable.ic_favorite_black_24dp_alpha54);
        tabs.getTabAt(2).setIcon(R.drawable.ic_person_pin_black_24dp_alpha54);
    }
}
