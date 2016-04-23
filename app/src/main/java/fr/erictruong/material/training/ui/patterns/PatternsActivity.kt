package fr.erictruong.material.training.ui.patterns

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.patterns.data_formats.DataFormatsFragment
import fr.erictruong.material.training.ui.patterns.empty_states.EmptyStatesFragment
import fr.erictruong.material.training.ui.patterns.errors.ErrorsFragment
import fr.erictruong.material.training.ui.patterns.fingerprint.FingerprintFragment
import fr.erictruong.material.training.ui.patterns.gestures.GesturesFragment
import fr.erictruong.material.training.ui.patterns.launch_screens.LaunchScreensFragment
import fr.erictruong.material.training.ui.patterns.loading_images.LoadingImagesFragment
import fr.erictruong.material.training.ui.patterns.navigation.NavigationFragment
import fr.erictruong.material.training.ui.patterns.navigation_drawer.NavigationDrawerFragment
import fr.erictruong.material.training.ui.patterns.navigational_transitions.NavigationalTransitionsFragment
import fr.erictruong.material.training.ui.patterns.notifications.NotificationsFragment
import fr.erictruong.material.training.ui.patterns.permissions.PermissionsFragment
import fr.erictruong.material.training.ui.patterns.scrolling_techniques.ScrollingTechniquesFragment
import fr.erictruong.material.training.ui.patterns.search.SearchFragment
import fr.erictruong.material.training.ui.patterns.selection.SelectionFragment
import fr.erictruong.material.training.ui.patterns.settings.SettingsFragment
import fr.erictruong.material.training.ui.patterns.swipe_to_refresh.SwipeToRefreshFragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class PatternsActivity : BaseDrawerActivity(), AnkoLogger {

    override fun getSelectedFragment(id: Int): Fragment? {
        when (id) {
            R.id.nav_data_formats -> return DataFormatsFragment()
            R.id.nav_empty_states -> return EmptyStatesFragment()
            R.id.nav_errors -> return ErrorsFragment()
            R.id.nav_gestures -> return GesturesFragment()
            R.id.nav_fingerprint -> return FingerprintFragment()
            R.id.nav_launch_screens -> return LaunchScreensFragment()
            R.id.nav_loading_images -> return LoadingImagesFragment()
            R.id.nav_navigation -> return NavigationFragment()
            R.id.nav_navigation_drawer -> return NavigationDrawerFragment()
            R.id.nav_navigational_transitions -> return NavigationalTransitionsFragment()
            R.id.nav_notifications -> return NotificationsFragment()
            R.id.nav_permissions -> return PermissionsFragment()
            R.id.nav_scrolling_techniques -> return ScrollingTechniquesFragment()
            R.id.nav_search -> return SearchFragment()
            R.id.nav_selection -> return SelectionFragment()
            R.id.nav_settings -> return SettingsFragment()
            R.id.nav_swipe_to_refresh -> return SwipeToRefreshFragment()
            else -> {
                debug("Unknown ID: $id")
                return null
            }
        }
    }
}
