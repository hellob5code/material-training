package fr.erictruong.material.training.ui.components

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.components.bottom_navigation.BottomNavigationFragment
import fr.erictruong.material.training.ui.components.bottom_sheets.BottomSheetsFragment
import fr.erictruong.material.training.ui.components.buttons.ButtonsFragment
import fr.erictruong.material.training.ui.components.buttons_floating_action_button.ButtonsFloatingActionButtonFragment
import fr.erictruong.material.training.ui.components.cards.CardsFragment
import fr.erictruong.material.training.ui.components.chips.ChipsFragment
import fr.erictruong.material.training.ui.components.data_tables.DataTablesFragment
import fr.erictruong.material.training.ui.components.dialogs.DialogsFragment
import fr.erictruong.material.training.ui.components.dividers.DividersFragment
import fr.erictruong.material.training.ui.components.grid_lists.GridListsFragment
import fr.erictruong.material.training.ui.components.lists.ListsFragment
import fr.erictruong.material.training.ui.components.lists_controls.ListsControlsFragment
import fr.erictruong.material.training.ui.components.menus.MenusFragment
import fr.erictruong.material.training.ui.components.pickers.PickersFragment
import fr.erictruong.material.training.ui.components.progress_and_activity.ProgressAndActivityFragment
import fr.erictruong.material.training.ui.components.selection_controls.SelectionControlsFragment
import fr.erictruong.material.training.ui.components.sliders.SlidersFragment
import fr.erictruong.material.training.ui.components.snackbars_and_toasts.SnackbarsAndToastsFragment
import fr.erictruong.material.training.ui.components.steppers.SteppersFragment
import fr.erictruong.material.training.ui.components.subheaders.SubheadersFragment
import fr.erictruong.material.training.ui.components.tabs.TabsFragment
import fr.erictruong.material.training.ui.components.text_fields.TextFieldsFragment
import fr.erictruong.material.training.ui.components.toolbars.ToolbarsFragment
import fr.erictruong.material.training.ui.components.tooltips.TooltipsFragment
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class ComponentsActivity : BaseDrawerActivity(), AnkoLogger {

    override fun getSelectedFragment(id: Int): Fragment? {
        when (id) {
            R.id.nav_bottom_navigation -> return BottomNavigationFragment()
            R.id.nav_bottom_sheets -> return BottomSheetsFragment()
            R.id.nav_buttons -> return ButtonsFragment()
            R.id.nav_buttons_floating_action_button -> return ButtonsFloatingActionButtonFragment()
            R.id.nav_cards -> return CardsFragment()
            R.id.nav_chips -> return ChipsFragment()
            R.id.nav_data_tables -> return DataTablesFragment()
            R.id.nav_dialogs -> return DialogsFragment()
            R.id.nav_dividers -> return DividersFragment()
            R.id.nav_grid_lists -> return GridListsFragment()
            R.id.nav_lists -> return ListsFragment()
            R.id.nav_lists_controls -> return ListsControlsFragment()
            R.id.nav_menus -> return MenusFragment()
            R.id.nav_pickers -> return PickersFragment()
            R.id.nav_progress_and_activity -> return ProgressAndActivityFragment()
            R.id.nav_selection_controls -> return SelectionControlsFragment()
            R.id.nav_sliders -> return SlidersFragment()
            R.id.nav_snackbars_and_toasts -> return SnackbarsAndToastsFragment()
            R.id.nav_steppers -> return SteppersFragment()
            R.id.nav_subheaders -> return SubheadersFragment()
            R.id.nav_tabs -> return TabsFragment()
            R.id.nav_text_fields -> return TextFieldsFragment()
            R.id.nav_toolbars -> return ToolbarsFragment()
            R.id.nav_tooltips -> return TooltipsFragment()
            else -> {
                debug("Unknown ID: $id")
                return null
            }
        }
    }
}
