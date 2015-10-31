package fr.erictruong.material.training.ui.components.tabs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.adapter.SimpleFragmentPagerAdapter;
import fr.erictruong.material.training.ui.core.fragment.DummyFragment;

public class ExtendedAppBarTabBarActivity extends AppCompatActivity {

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
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(toolbar, "Navigation icon", Snackbar.LENGTH_SHORT).show();
            }
        });

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment("Item one", DummyFragment.newInstance());
        adapter.addFragment("Item two", DummyFragment.newInstance());
        adapter.addFragment("Item three", DummyFragment.newInstance());

        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
    }
}
