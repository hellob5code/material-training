package fr.erictruong.material.training.ui.components

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.components.cards.CardsFragment
import fr.erictruong.material.training.ui.components.lists.ListsFragment
import fr.erictruong.material.training.ui.components.lists_controls.ListsControlsFragment
import fr.erictruong.material.training.ui.components.steppers.SteppersFragment
import fr.erictruong.material.training.ui.components.subheaders.SubheadersFragment
import fr.erictruong.material.training.ui.components.tabs.TabsFragment
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.core.DummyFragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class ComponentsActivity : BaseDrawerActivity(), AnkoLogger {

    override fun getSelectedFragment(id: Int): Fragment? {
        when (id) {
            R.id.nav_bottom_sheets -> return DummyFragment()
            R.id.nav_buttons -> return DummyFragment()
            R.id.nav_buttons_floating_action_button -> return DummyFragment()
            R.id.nav_cards -> return CardsFragment()
            R.id.nav_chips -> return DummyFragment()
            R.id.nav_data_tables -> return DummyFragment()
            R.id.nav_dialogs -> return DummyFragment()
            R.id.nav_dividers -> return DummyFragment()
            R.id.nav_grid_lists -> return DummyFragment()
            R.id.nav_lists -> return ListsFragment()
            R.id.nav_lists_controls -> return ListsControlsFragment()
            R.id.nav_menus -> return DummyFragment()
            R.id.nav_pickers -> return DummyFragment()
            R.id.nav_progress_and_activity -> return DummyFragment()
            R.id.nav_selection_controls -> return DummyFragment()
            R.id.nav_sliders -> return DummyFragment()
            R.id.nav_snackbars_and_toasts -> return DummyFragment()
            R.id.nav_steppers -> return SteppersFragment()
            R.id.nav_subheaders -> return SubheadersFragment()
            R.id.nav_tabs -> return TabsFragment()
            R.id.nav_text_fields -> return DummyFragment()
            R.id.nav_toolbars -> return DummyFragment()
            R.id.nav_tooltips -> return DummyFragment()
            else -> {
                debug("Unknown ID: $id")
                return null
            }
        }
    }
}
