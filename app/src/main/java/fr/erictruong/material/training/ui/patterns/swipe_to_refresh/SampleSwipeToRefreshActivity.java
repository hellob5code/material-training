package fr.erictruong.material.training.ui.patterns.swipe_to_refresh;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.activity.RefreshActivity;
import fr.erictruong.material.training.util.ThemeUtils;

public class SampleSwipeToRefreshActivity extends RefreshActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout refreshLayout;

    public static void start(Context context) {
        Intent starter = new Intent(context, SampleSwipeToRefreshActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dummy);
        refreshLayout = getSwipeRefreshLayout();
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeColors(ThemeUtils.obtainColorAccent(this), ThemeUtils.obtainColorPrimaryDark(this));
    }

    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
            }
        }, 5000);
    }
}
