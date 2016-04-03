package fr.erictruong.material.training.ui.core

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.view.SupportMenuInflater
import android.support.v7.view.menu.MenuBuilder
import android.support.v7.view.menu.MenuItemImpl
import android.view.*
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import fr.erictruong.material.training.Prefs
import fr.erictruong.material.training.R
import fr.erictruong.material.training.extension.consume
import fr.erictruong.material.training.extension.prefs
import fr.erictruong.material.training.supportLollipop
import fr.erictruong.material.training.ui.components.ComponentsActivity
import fr.erictruong.material.training.ui.growth_communications.GrowthCommunicationsActivity
import fr.erictruong.material.training.ui.layout.LayoutActivity
import fr.erictruong.material.training.ui.material_design.MaterialDesignActivity
import fr.erictruong.material.training.ui.motion.MotionActivity
import fr.erictruong.material.training.ui.patterns.PatternsActivity
import fr.erictruong.material.training.ui.resources.ResourcesActivity
import fr.erictruong.material.training.ui.style.StyleActivity
import fr.erictruong.material.training.ui.usability.UsabilityActivity
import fr.erictruong.material.training.ui.what_is_material.WhatIsMaterialActivity
import fr.erictruong.material.training.ui.whats_new.WhatsNewActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import kotlinx.android.synthetic.main.activity_base_drawer.drawer_content as drawerContent
import kotlinx.android.synthetic.main.activity_base_drawer.drawer_layout as drawerLayout
import kotlinx.android.synthetic.main.activity_base_drawer.drawer_toolbar as drawerToolbar
import kotlinx.android.synthetic.main.activity_base_drawer.drawer_navigation as drawerNavigation
import kotlinx.android.synthetic.main.nav_bottom_bar.bottom_bar_previous as previousLayout
import kotlinx.android.synthetic.main.nav_bottom_bar.bottom_bar_next as nextLayout
import kotlinx.android.synthetic.main.nav_bottom_bar.bottom_bar_tv_previous as tvPrevious
import kotlinx.android.synthetic.main.nav_bottom_bar.bottom_bar_tv_next as tvNext
import org.jetbrains.anko.startActivity

abstract class BaseDrawerActivity : BaseActivity(), AnkoLogger, NavigationView.OnNavigationItemSelectedListener {

    companion object {
        val NAV_ITEM_ID = "extra_nav_item_id"
    }

    var navItemId: Int by prefs(this, Prefs.NAV_ITEM_ID, Prefs.DEFAULT_NAV_ITEM_ID)

    val shortAnimTime by lazy { resources.getInteger(android.R.integer.config_shortAnimTime) }

    val menuItems = mutableListOf<MenuItem>()
    lateinit var currentItem: MenuItem
    var previousItem: MenuItem? = null
    var nextItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_drawer)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

        setUpNavigation()

        // Initialze content
        if (savedInstanceState == null) {
            currentItem = findItemById(menuItems, intent.getIntExtra(NAV_ITEM_ID, navItemId))
            navigateTo(currentItem)
        } else {
            currentItem = findItemById(menuItems, savedInstanceState.getInt(NAV_ITEM_ID))
            setUpBottomBar()
        }

        setUpToolbar()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(NAV_ITEM_ID, currentItem.itemId)
    }

    private fun setUpNavigation() {
        val menuResId = R.menu.drawer_base
        drawerNavigation.inflateMenu(menuResId)
        drawerNavigation.setNavigationItemSelectedListener(this)

        // Keep sub-menu items in a list
        val menuBuilder = MenuBuilder(this)
        MenuInflater(this).inflate(menuResId, menuBuilder)
        menuBuilder.visibleItems.forEach { item ->
            if (item.hasSubMenu() && item.subMenu.hasVisibleItems()) {
                for (i in 0..item.subMenu.size() - 1) {
                    val menuItem = item.subMenu.getItem(i)
                    if (menuItem.isVisible) {
                        menuItems.add(menuItem)
                    }
                }
            }
        }
        debug("Navigation menu: menuItems=$menuItems")
    }

    private fun setUpToolbar() {
        setSupportActionBar(drawerToolbar)
        supportActionBar?.title = currentItem.title

        val toggle = ActionBarDrawerToggle(this, drawerLayout, drawerToolbar, R.string.access_navigation_drawer_open, R.string.access_navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun setUpBottomBar() {
        val previousIndex = findItemIndexById(menuItems, currentItem.itemId) - 1
        if (previousIndex >= 0) {
            previousItem = menuItems[previousIndex]
            tvPrevious.text = (previousItem as MenuItem).title
            previousLayout.setOnClickListener { onPreviousClicked() }
            previousLayout.visibility = View.VISIBLE
        } else {
            previousLayout.visibility = View.GONE
        }
        val nextIndex = findItemIndexById(menuItems, currentItem.itemId) + 1
        if (nextIndex < menuItems.size) {
            nextItem = menuItems[nextIndex]
            tvNext.text = (nextItem as MenuItem).title
            nextLayout.setOnClickListener { onNextClicked() }
            nextLayout.visibility = View.VISIBLE
        } else {
            nextLayout.visibility = View.GONE
        }
    }

    private fun findItemById(menuItems: List<MenuItem>, id: Int): MenuItem {
        menuItems.forEach {
            if (it.itemId == id) {
                return it
            }
        }
        throw IllegalArgumentException("Cannot find item matching given ID $id")
    }

    private fun findItemIndexById(menuItems: List<MenuItem>, id: Int): Int {
        menuItems.forEachIndexed { i, menuItem ->
            if (menuItem.itemId == id) {
                return i
            }
        }
        throw IllegalArgumentException("Cannot find item index matching given ID $id")
    }

    override fun onBackPressed() {
        // We close the drawer before popping anything from the back stack
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // TODO: Handle item reselection, i.e. just close the drawer
//        if (item.itemId == currentItem.itemId) {
//            drawerLayout.closeDrawer(GravityCompat.START)
//            return false
//        } else {
            navItemId = item.itemId

            val fragment = getSelectedFragment(item.itemId)
            if (fragment != null) {
                return drawerLayout.consume {
                    drawerNavigation.setCheckedItem(item.itemId)
                    supportActionBar?.title = item.title
                    currentItem = item
                    replaceFragment(fragment, item.title.toString())
                    setUpBottomBar()
                }
            }

            return when (item.groupId) {
                R.id.group_material_design -> drawerLayout.consume { startActivityDelayed<MaterialDesignActivity>(item.itemId) }
                R.id.group_what_is_material -> drawerLayout.consume { startActivityDelayed<WhatIsMaterialActivity>(item.itemId) }
                R.id.group_motion -> drawerLayout.consume { startActivityDelayed<MotionActivity>(item.itemId) }
                R.id.group_style -> drawerLayout.consume { startActivityDelayed<StyleActivity>(item.itemId) }
                R.id.group_layout -> drawerLayout.consume { startActivityDelayed<LayoutActivity>(item.itemId) }
                R.id.group_components -> drawerLayout.consume { startActivityDelayed<ComponentsActivity>(item.itemId) }
                R.id.group_patterns -> drawerLayout.consume { startActivityDelayed<PatternsActivity>(item.itemId) }
                R.id.group_growth_communications -> drawerLayout.consume { startActivityDelayed<GrowthCommunicationsActivity>(item.itemId) }
                R.id.group_usability -> drawerLayout.consume { startActivityDelayed<UsabilityActivity>(item.itemId) }
                R.id.group_resources -> drawerLayout.consume { startActivityDelayed<ResourcesActivity>(item.itemId) }
                R.id.group_whats_new -> drawerLayout.consume { startActivityDelayed<WhatsNewActivity>(item.itemId) }
                else -> throw IllegalStateException("Unknown group ID ${item.groupId}")
            }
//        }
    }

    inline fun <reified T : Activity> startActivityDelayed(itemId: Int) {
        drawerLayout.postDelayed({
            startActivity<T>(NAV_ITEM_ID to itemId)
            finish()
        }, shortAnimTime.toLong())
    }

    /**
     * Replace an existing fragment that was added to the drawer content container and play the in-&-out transition animations sequentially.
     *
     * @param fragment The new fragment to place in the container.
     * @param tag      The tag name for the fragment.
     */
    protected fun replaceFragment(fragment: Fragment, tag: String) {
        // Fade in an out sequentially
        drawerContent.postDelayed({
            supportFragmentManager.beginTransaction()
                    .replace(R.id.drawer_content, fragment, tag)
                    .commit()
            fadeInContent()
        }, shortAnimTime.toLong())
        fadeOutContent()
    }

    private fun fadeInContent() {
        drawerContent.clearAnimation()
        drawerContent.animate()
                .setInterpolator(DecelerateInterpolator())
                .alpha(1f)
                .duration = shortAnimTime.toLong()
    }

    private fun fadeOutContent() {
        drawerContent.clearAnimation()
        drawerContent.animate()
                .setInterpolator(AccelerateInterpolator())
                .alpha(0f)
                .duration = shortAnimTime.toLong()
    }

    protected fun navigateTo(menuItem: MenuItem) {
        onNavigationItemSelected(menuItem)
    }

    private fun onPreviousClicked() {
        navigateTo(previousItem as MenuItem)
    }

    private fun onNextClicked() {
        navigateTo(nextItem as MenuItem)
    }

    /**
     * Return an fragment instance given the navigation menu item ID of the desired content.
     *
     * @param id The navigation menu item ID of the desired content.
     * @return A [Fragment] instance or `null` if the menu item ID was unresolved.
     */
    protected abstract fun getSelectedFragment(id: Int): Fragment?
}