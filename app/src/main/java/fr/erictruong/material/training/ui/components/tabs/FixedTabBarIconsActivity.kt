package fr.erictruong.material.training.ui.components.tabs

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import fr.erictruong.android.core.adapter.SimpleFragmentPagerAdapter
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.fragment.DummyFragment
import kotlinx.android.synthetic.main.activity_fixed_tab_bar.fixed_tab_bar_drawer_layout as drawerLayout
import kotlinx.android.synthetic.main.activity_fixed_tab_bar.fixed_tab_bar_tabs as tabs
import kotlinx.android.synthetic.main.activity_fixed_tab_bar.fixed_tab_bar_toolbar as toolbar
import kotlinx.android.synthetic.main.activity_fixed_tab_bar.fixed_tab_bar_view_pager as viewPager

class FixedTabBarIconsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fixed_tab_bar)

        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.access_navigation_drawer_open, R.string.access_navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val adapter = SimpleFragmentPagerAdapter(supportFragmentManager)
        adapter.addFragment("Recents", DummyFragment())
        adapter.addFragment("Favorites", DummyFragment())
        adapter.addFragment("Nearby", DummyFragment())

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        val tabTextColors = tabs.tabTextColors
        tabs.getTabAt(0)?.icon = getStateListDrawable(tabTextColors, R.drawable.ic_phone_white_24dp)
        tabs.getTabAt(1)?.icon = getStateListDrawable(tabTextColors, R.drawable.ic_favorite_white_24dp)
        tabs.getTabAt(2)?.icon = getStateListDrawable(tabTextColors, R.drawable.ic_person_pin_white_24dp)
    }

    private fun getStateListDrawable(colorStateList: ColorStateList?, @DrawableRes drawableResId: Int): Drawable {
        val drawable = ContextCompat.getDrawable(this, drawableResId)
        DrawableCompat.setTintList(drawable, colorStateList)
        return drawable
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
