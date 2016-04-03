package fr.erictruong.material.training.ui.components.tabs

import android.graphics.drawable.StateListDrawable
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.StateSet
import android.view.Menu
import fr.erictruong.android.core.adapter.SimpleFragmentPagerAdapter
import fr.erictruong.android.core.util.ThemeUtils
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.DummyFragment
import kotlinx.android.synthetic.main.activity_colored_tab_bar.colored_tab_bar_drawer_layout as drawerLayout
import kotlinx.android.synthetic.main.activity_colored_tab_bar.colored_tab_bar_tabs as tabs
import kotlinx.android.synthetic.main.activity_colored_tab_bar.colored_tab_bar_toolbar as toolbar
import kotlinx.android.synthetic.main.activity_colored_tab_bar.colored_tab_bar_view_pager as viewPager


class ColoredTabBarIconsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colored_tab_bar)

        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.access_navigation_drawer_open, R.string.access_navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val adapter = SimpleFragmentPagerAdapter(supportFragmentManager)
        adapter.addFragment(DummyFragment())
        adapter.addFragment(DummyFragment())
        adapter.addFragment(DummyFragment())

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)?.icon = getStateListDrawable(R.drawable.ic_phone_black_24dp_alpha54)
        tabs.getTabAt(1)?.icon = getStateListDrawable(R.drawable.ic_favorite_black_24dp_alpha54)
        tabs.getTabAt(2)?.icon = getStateListDrawable(R.drawable.ic_person_pin_black_24dp_alpha54)
    }

    private fun getStateListDrawable(@DrawableRes drawableResId: Int): StateListDrawable {
        val accentDrawable = ThemeUtils.getAccentTintedDrawable(this, drawableResId)
        val defaultDrawable = ContextCompat.getDrawable(this, drawableResId)
        val stateListDrawable = StateListDrawable()
        stateListDrawable.addState(intArrayOf(android.R.attr.state_selected), accentDrawable)
        stateListDrawable.addState(StateSet.WILD_CARD, defaultDrawable)
        return stateListDrawable
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
        inflater.inflate(R.menu.search_dark, menu)
        inflater.inflate(R.menu.settings, menu)
        return true
    }
}
