package fr.erictruong.material.training.ui.core

import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.SettingsActivity
import fr.erictruong.material.training.ui.animation.AnimationActivity
import fr.erictruong.material.training.ui.components.ComponentsActivity
import fr.erictruong.material.training.ui.layout.LayoutActivity
import fr.erictruong.material.training.ui.material_design.MaterialDesignActivity
import fr.erictruong.material.training.ui.patterns.PatternsActivity
import fr.erictruong.material.training.ui.resources.ResourcesActivity
import fr.erictruong.material.training.ui.style.StyleActivity
import fr.erictruong.material.training.ui.usability.UsabilityActivity
import fr.erictruong.material.training.ui.what_is_material.WhatIsMaterialActivity
import fr.erictruong.material.training.ui.whats_new.WhatsNewActivity
import kotlinx.android.synthetic.main.activity_base_drawer.*
import org.jetbrains.anko.startActivity

abstract class BaseDrawerActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {
        val NAV_ID = "extra_nav_id"
    }

    private val shortAnimTime by lazy { resources.getInteger(android.R.integer.config_shortAnimTime) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_drawer)

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

        setSupportActionBar(drawer_toolbar)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, drawer_toolbar, R.string.access_navigation_drawer_open, R.string.access_navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        drawer_navigation.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            // Initialze content
            val selectedNavId = intent.getIntExtra(NAV_ID, -1)
            drawer_navigation.setCheckedItem(selectedNavId)
            val fragment = getSelectedFragment(selectedNavId)
            if (fragment != null) {
                supportFragmentManager.beginTransaction()
                        .add(R.id.drawer_content, fragment)
                        .commit()
                fadeInContent()
            }
        }
    }

    override fun onBackPressed() {
        // We close the drawer before popping anything from the back stack
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val title = item.title.toString()

        drawer_navigation.setCheckedItem(id)
        val fragment = getSelectedFragment(id)
        if (fragment != null) {
            replaceFragment(fragment, title)
//            intent.putExtra(NAV_ID, id) // Update the current navigation ID
            drawer_layout.closeDrawer(GravityCompat.START)
            return true
        }

        when (id) {
            R.id.nav_app_prefs -> startActivity<SettingsActivity>()
            R.id.nav_about -> startActivity<SettingsActivity>()
            else -> {
                // Perform action after a short delay to allow the close animation to play
                Handler().postDelayed({
                    startGroup(item, id)
                    finish()
                }, shortAnimTime.toLong())
                fadeOutContent()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun startGroup(item: MenuItem, id: Int) {
        val groupId = item.groupId
        when (groupId) {
            R.id.group_material_design -> startActivity<MaterialDesignActivity>(NAV_ID to id)
            R.id.group_what_is_material -> startActivity<WhatIsMaterialActivity>(NAV_ID to id)
            R.id.group_animation -> startActivity<AnimationActivity>(NAV_ID to id)
            R.id.group_style -> startActivity<StyleActivity>(NAV_ID to id)
            R.id.group_layout -> startActivity<LayoutActivity>(NAV_ID to id)
            R.id.group_components -> startActivity<ComponentsActivity>(NAV_ID to id)
            R.id.group_patterns -> startActivity<PatternsActivity>(NAV_ID to id)
            R.id.group_usability -> startActivity<UsabilityActivity>(NAV_ID to id)
            R.id.group_resources -> startActivity<ResourcesActivity>(NAV_ID to id)
            R.id.group_whats_new -> startActivity<WhatsNewActivity>(NAV_ID to id)
            else -> throw IllegalStateException("Unknown navigation group: " + groupId)
        }
    }

    /**
     * Return an fragment instance given the navigation menu item ID of the desired content.
     *
     * @param id The navigation menu item ID of the desired content.
     * @return A [Fragment] instance or `null` if the menu item ID was unresolved.
     */
    protected abstract fun getSelectedFragment(id: Int): Fragment?

    /**
     * Replace an existing fragment that was added to the drawer content container and play the in-&-out transition animations sequentially.
     *
     * @param fragment The new fragment to place in the container.
     * @param tag      The tag name for the fragment.
     */
    protected fun replaceFragment(fragment: Fragment, tag: String) {
        // Fade in an out sequentially
        Handler().postDelayed({
            supportFragmentManager.beginTransaction()
                    .replace(R.id.drawer_content, fragment, tag)
                    .commit()
            fadeInContent()
        }, shortAnimTime.toLong())
        fadeOutContent()
    }

    private fun fadeInContent() {
        drawer_content.clearAnimation()
        drawer_content.animate()
                .setInterpolator(DecelerateInterpolator())
                .alpha(1f)
                .duration = shortAnimTime.toLong()
    }

    private fun fadeOutContent() {
        drawer_content.clearAnimation()
        drawer_content.animate()
                .setInterpolator(AccelerateInterpolator())
                .alpha(0f)
                .duration = shortAnimTime.toLong()
    }
}
