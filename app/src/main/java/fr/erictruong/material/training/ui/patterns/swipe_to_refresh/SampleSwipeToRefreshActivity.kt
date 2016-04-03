package fr.erictruong.material.training.ui.patterns.swipe_to_refresh

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.widget.SwipeRefreshLayout

import fr.erictruong.android.core.activity.RefreshActivity
import fr.erictruong.android.core.util.ThemeUtils
import fr.erictruong.material.training.R

class SampleSwipeToRefreshActivity : RefreshActivity(), SwipeRefreshLayout.OnRefreshListener {

    private var refreshLayout: SwipeRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_dummy)
        refreshLayout = swipeRefreshLayout
        refreshLayout!!.setOnRefreshListener(this)
        refreshLayout!!.setColorSchemeColors(ThemeUtils.obtainColorAccent(this), ThemeUtils.obtainColorPrimaryDark(this))
    }

    override fun onRefresh() {
        Handler().postDelayed({ refreshLayout!!.isRefreshing = false }, 5000)
    }
}
