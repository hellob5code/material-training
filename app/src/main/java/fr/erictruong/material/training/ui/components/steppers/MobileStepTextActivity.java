package fr.erictruong.material.training.ui.components.steppers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.erictruong.android.core.adapter.SimpleFragmentPagerAdapter;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.DummyFragment;

public class MobileStepTextActivity extends AppCompatActivity {

    @Bind(R.id.mobile_step_text_drawer_layout) DrawerLayout drawerLayout;
    @Bind(R.id.mobile_step_text_toolbar) Toolbar toolbar;
    @Bind(R.id.mobile_step_text_view_pager) ViewPager viewPager;

    @Bind(R.id.mobile_step_text_indicator) TextView indicator;
    @Bind(R.id.mobile_step_text_btn_back) Button btnBack;
    @Bind(R.id.mobile_step_text_btn_next) Button btnNext;

    public static void start(Context context) {
        Intent starter = new Intent(context, MobileStepTextActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_step_text);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.access_navigation_drawer_open, R.string.access_navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        final SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment("Page one", DummyFragment.newInstance());
        adapter.addFragment("Page two", DummyFragment.newInstance());
        adapter.addFragment("Page three", DummyFragment.newInstance());
        adapter.addFragment("Page four", DummyFragment.newInstance());
        adapter.addFragment("Page five", DummyFragment.newInstance());
        adapter.addFragment("Page six", DummyFragment.newInstance());
        adapter.addFragment("Page seven", DummyFragment.newInstance());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Do nothing
            }

            @Override
            public void onPageSelected(int position) {
                int pageCount = adapter.getCount();
                indicator.setText(getString(R.string.aaa, position + 1, pageCount));
                if (position == 0) {
                    btnBack.setEnabled(false);
                } else {
                    btnBack.setEnabled(true);
                }
                if (position == pageCount - 1) {
                    btnNext.setEnabled(false);
                } else {
                    btnNext.setEnabled(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Do nothing
            }
        });
        indicator.setText(getString(R.string.aaa, 1, adapter.getCount()));
        btnBack.setEnabled(false);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @OnClick(R.id.mobile_step_text_btn_back)
    protected void onBackClicked() {
        int currentItem = viewPager.getCurrentItem();
        viewPager.setCurrentItem(--currentItem, true);
    }

    @OnClick(R.id.mobile_step_text_btn_next)
    protected void onNextClicked() {
        int currentItem = viewPager.getCurrentItem();
        viewPager.setCurrentItem(++currentItem, true);
    }
}
