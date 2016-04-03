package fr.erictruong.material.training.ui.components.tabs

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import fr.erictruong.android.core.adapter.SimpleFragmentPagerAdapter
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.DummyFragment
import kotlinx.android.synthetic.main.activity_extended_app_bar_tab_bar.extended_app_bar_tab_bar_collapsing_toolbar as collapsingToolbar
import kotlinx.android.synthetic.main.activity_extended_app_bar_tab_bar.extended_app_bar_tab_bar_drawer_layout as drawerLayout
import kotlinx.android.synthetic.main.activity_extended_app_bar_tab_bar.extended_app_bar_tab_bar_tabs as tabs
import kotlinx.android.synthetic.main.activity_extended_app_bar_tab_bar.extended_app_bar_tab_bar_toolbar as toolbar
import kotlinx.android.synthetic.main.activity_extended_app_bar_tab_bar.extended_app_bar_tab_bar_view_pager as viewPager

class ExtendedAppBarTabBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extended_app_bar_tab_bar)

        collapsingToolbar.title = title

        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.access_navigation_drawer_open, R.string.access_navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val adapter = SimpleFragmentPagerAdapter(supportFragmentManager)
        adapter.addFragment("Item one", DummyFragment())
        adapter.addFragment("Item two", DummyFragment())
        adapter.addFragment("Item three", DummyFragment())

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_light, menu)
        inflater.inflate(R.menu.settings, menu)
        return true
    }
}
