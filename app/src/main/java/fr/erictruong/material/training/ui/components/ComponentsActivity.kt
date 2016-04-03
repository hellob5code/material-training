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
import fr.erictruong.material.training.ui.components.expansion_panels.ExpansionPanelsFragment
import fr.erictruong.material.training.ui.components.grid_lists.GridListsFragment
import fr.erictruong.material.training.ui.components.lists.ListsFragment
import fr.erictruong.material.training.ui.components.lists_controls.ListsControlsFragment
import fr.erictruong.material.training.ui.components.menus.MenusFragment
import fr.erictruong.material.training.ui.components.pickers.PickersFragment
import fr.erictruong.material.training.ui.components.progress_activity.ProgressActivityFragment
import fr.erictruong.material.training.ui.components.selection_controls.SelectionControlsFragment
import fr.erictruong.material.training.ui.components.sliders.SlidersFragment
import fr.erictruong.material.training.ui.components.snackbars_toasts.SnackbarsToastsFragment
import fr.erictruong.material.training.ui.components.steppers.SteppersFragment
import fr.erictruong.material.training.ui.components.subheaders.SubheadersFragment
import fr.erictruong.material.training.ui.components.tabs.TabsFragment
import fr.erictruong.material.training.ui.components.text_fields.TextFieldsFragment
import fr.erictruong.material.training.ui.components.toolbars.ToolbarsFragment
import fr.erictruong.material.training.ui.components.tooltips.TooltipsFragment
import fr.erictruong.material.training.ui.core.BaseDrawerActivity

class ComponentsActivity : BaseDrawerActivity() {

    override fun getSelectedFragment(id: Int): Fragment? {
        return when (id) {
            R.id.nav_components_bottom_navigation -> BottomNavigationFragment()
            R.id.nav_components_bottom_sheets -> BottomSheetsFragment()
            R.id.nav_components_buttons -> ButtonsFragment()
            R.id.nav_components_buttons_floating_action_button -> ButtonsFloatingActionButtonFragment()
            R.id.nav_components_cards -> CardsFragment()
            R.id.nav_components_chips -> ChipsFragment()
            R.id.nav_components_data_tables -> DataTablesFragment()
            R.id.nav_components_dialogs -> DialogsFragment()
            R.id.nav_components_dividers -> DividersFragment()
            R.id.nav_components_expansion_panels -> ExpansionPanelsFragment()
            R.id.nav_components_grid_lists -> GridListsFragment()
            R.id.nav_components_lists -> ListsFragment()
            R.id.nav_components_lists_controls -> ListsControlsFragment()
            R.id.nav_components_menus -> MenusFragment()
            R.id.nav_components_pickers -> PickersFragment()
            R.id.nav_components_progress_activity -> ProgressActivityFragment()
            R.id.nav_components_selection_controls -> SelectionControlsFragment()
            R.id.nav_components_sliders -> SlidersFragment()
            R.id.nav_components_snackbars_toasts -> SnackbarsToastsFragment()
            R.id.nav_components_steppers -> SteppersFragment()
            R.id.nav_components_subheaders -> SubheadersFragment()
            R.id.nav_components_tabs -> TabsFragment()
            R.id.nav_components_text_fields -> TextFieldsFragment()
            R.id.nav_components_toolbars -> ToolbarsFragment()
            R.id.nav_components_tooltips -> TooltipsFragment()
            else -> null
        }
    }
}
