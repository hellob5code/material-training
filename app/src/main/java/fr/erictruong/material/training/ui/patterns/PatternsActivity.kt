package fr.erictruong.material.training.ui.patterns

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.core.DummyFragment
import fr.erictruong.material.training.ui.patterns.swipe_to_refresh.SwipeToRefreshFragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class PatternsActivity : BaseDrawerActivity(), AnkoLogger {

    override fun getSelectedFragment(id: Int): Fragment? {
        when (id) {
            R.id.nav_app_structure -> return DummyFragment()
            R.id.nav_data_formats -> return DummyFragment()
            R.id.nav_empty_states -> return DummyFragment()
            R.id.nav_errors -> return DummyFragment()
            R.id.nav_gestures -> return DummyFragment()
            R.id.nav_fingerprint -> return DummyFragment()
            R.id.nav_launch_screens -> return DummyFragment()
            R.id.nav_loading_images -> return DummyFragment()
            R.id.nav_navigation -> return DummyFragment()
            R.id.nav_navigation_drawer -> return DummyFragment()
            R.id.nav_navigational_transitions -> return DummyFragment()
            R.id.nav_notifications -> return DummyFragment()
            R.id.nav_scrolling_techniques -> return DummyFragment()
            R.id.nav_search -> return DummyFragment()
            R.id.nav_selection -> return DummyFragment()
            R.id.nav_settings -> return DummyFragment()
            R.id.nav_swipe_to_refresh -> return SwipeToRefreshFragment()
            else -> {
                debug("Unknown ID: $id")
                return null
            }
        }
    }
}
