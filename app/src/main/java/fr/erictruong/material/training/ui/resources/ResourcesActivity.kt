package fr.erictruong.material.training.ui.resources

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.resources.color_palettes.ColorPalettesFragment
import fr.erictruong.material.training.ui.resources.devices.DevicesFragment
import fr.erictruong.material.training.ui.resources.layout_templates.LayoutTemplatesFragment
import fr.erictruong.material.training.ui.resources.roboto_noto_fonts.RobotoNotoFontsFragment
import fr.erictruong.material.training.ui.resources.sticker_sheets_icons.StickerSheetsIconsFragment
import org.jetbrains.anko.AnkoLogger

class ResourcesActivity : BaseDrawerActivity() {

    override fun getSelectedFragment(id: Int): Fragment? {
        return when (id) {
            R.id.nav_resources_color_palettes -> ColorPalettesFragment()
            R.id.nav_resources_devices -> DevicesFragment()
            R.id.nav_resources_layout_templates -> LayoutTemplatesFragment()
            R.id.nav_resources_roboto_noto_fonts -> RobotoNotoFontsFragment()
            R.id.nav_resources_sticker_sheets_icons -> StickerSheetsIconsFragment()
            else -> null
        }
    }
}
