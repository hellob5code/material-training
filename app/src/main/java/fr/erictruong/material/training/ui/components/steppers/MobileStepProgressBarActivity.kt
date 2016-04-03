package fr.erictruong.material.training.ui.components.steppers;

//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v4.view.GravityCompat;
//import android.support.v4.view.ViewPager;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.widget.Button;
//import android.widget.ProgressBar;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//import fr.erictruong.android.core.adapter.SimpleFragmentPagerAdapter;
//import fr.erictruong.material.training.R;
//import fr.erictruong.material.training.ui.core.DummyFragment;
//
//public class MobileStepProgressBarActivity extends AppCompatActivity {
//
//    @Bind(R.id.mobile_step_progress_bar_drawer_layout)
//    DrawerLayout drawerLayout;
//    @Bind(R.id.mobile_step_progress_bar_toolbar)
//    Toolbar toolbar;
//    @Bind(R.id.mobile_step_progress_bar_view_pager)
//    ViewPager viewPager;
//
//    @Bind(R.id.mobile_step_progress_bar_indicator) ProgressBar indicator;
//    @Bind(R.id.mobile_step_progress_bar_btn_back) Button btnBack;
//    @Bind(R.id.mobile_step_progress_bar_btn_next) Button btnNext;
//
//    public static void start(Context context) {
//        Intent starter = new Intent(context, MobileStepProgressBarActivity.class);
//        context.startActivity(starter);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mobile_step_progress_bar);
//        ButterKnife.bind(this);
//
//        setSupportActionBar(toolbar);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.access_navigation_drawer_open, R.string.access_navigation_drawer_close);
//        drawerLayout.setDrawerListener(toggle);
//        toggle.syncState();
//
//        final SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
//        adapter.addFragment("Page one", new DummyFragment());
//        adapter.addFragment("Page two", new DummyFragment());
//        adapter.addFragment("Page three", new DummyFragment());
//        adapter.addFragment("Page four", new DummyFragment());
//        adapter.addFragment("Page five", new DummyFragment());
//        adapter.addFragment("Page six", new DummyFragment());
//        adapter.addFragment("Page seven", new DummyFragment());
//
//        viewPager.setAdapter(adapter);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                // Do nothing
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                int pageCount = adapter.getCount();
//                indicator.setProgress(position);
//                btnBack.setEnabled(position != 0);
//                btnNext.setEnabled(position != pageCount - 1);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                // Do nothing
//            }
//        });
//        indicator.setMax(adapter.getCount() - 1);
//        btnBack.setEnabled(false);
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    @OnClick(R.id.mobile_step_progress_bar_btn_back)
//    protected void onBackClicked() {
//        int currentItem = viewPager.getCurrentItem();
//        viewPager.setCurrentItem(--currentItem, true);
//    }
//
//    @OnClick(R.id.mobile_step_progress_bar_btn_next)
//    protected void onNextClicked() {
//        int currentItem = viewPager.getCurrentItem();
//        viewPager.setCurrentItem(++currentItem, true);
//    }
//}
