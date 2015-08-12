package fr.erictruong.material.training.ui.components.tabs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ExtendedAppBarTabBarActivity extends AppCompatActivity {

//    @Bind(R.id.extended_app_bar_tab_bar_toolbar) Toolbar toolbar;
//    @Bind(R.id.extended_app_bar_tab_bar_tabs) TabLayout tabs;
//    @Bind(R.id.extended_app_bar_tab_bar_view_pager) ViewPager viewPager;

    public static void start(Context context) {
        Intent starter = new Intent(context, ExtendedAppBarTabBarActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_extended_app_bar_tab_bar);
//        ButterKnife.bind(this);
    }
}
