package fr.erictruong.material.training.ui.components.tabs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class FixedTabBarActivity extends AppCompatActivity {

    @Bind(R.id.fixed_tab_bar_toolbar) Toolbar toolbar;
    @Bind(R.id.fixed_tab_bar_tabs) TabLayout tabs;
    @Bind(R.id.fixed_tab_bar_view_pager) ViewPager viewPager;

    public static void start(Context context) {
        Intent starter = new Intent(context, FixedTabBarActivity.class);
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
                Snackbar.make(toolbar, "Navigation!", Snackbar.LENGTH_SHORT).show();
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
