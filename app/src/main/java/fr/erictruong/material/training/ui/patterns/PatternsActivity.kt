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

class PatternsActivity : BaseDrawerActivity() {

    override fun getSelectedFragment(id: Int): Fragment? {
        return when (id) {
            R.id.nav_patterns_data_formats -> DataFormatsFragment()
            R.id.nav_patterns_empty_states -> EmptyStatesFragment()
            R.id.nav_patterns_errors -> ErrorsFragment()
            R.id.nav_patterns_fingerprint -> FingerprintFragment()
            R.id.nav_patterns_gestures -> GesturesFragment()
            R.id.nav_patterns_launch_screens -> LaunchScreensFragment()
            R.id.nav_patterns_loading_images -> LoadingImagesFragment()
            R.id.nav_patterns_navigation -> NavigationFragment()
            R.id.nav_patterns_navigation_drawer -> NavigationDrawerFragment()
            R.id.nav_patterns_navigational_transitions -> NavigationalTransitionsFragment()
            R.id.nav_patterns_notifications -> NotificationsFragment()
            R.id.nav_patterns_permissions -> PermissionsFragment()
            R.id.nav_patterns_scrolling_techniques -> ScrollingTechniquesFragment()
            R.id.nav_patterns_search -> SearchFragment()
            R.id.nav_patterns_selection -> SelectionFragment()
            R.id.nav_patterns_settings -> SettingsFragment()
            R.id.nav_patterns_swipe_to_refresh -> SwipeToRefreshFragment()
            else -> null
        }
    }
}
