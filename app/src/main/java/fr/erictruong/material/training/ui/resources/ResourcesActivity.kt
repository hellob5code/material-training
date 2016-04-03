package fr.erictruong.material.training.ui.resources

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.core.DummyFragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class ResourcesActivity : BaseDrawerActivity(), AnkoLogger {

    override fun getSelectedFragment(id: Int): Fragment? {
        when (id) {
            R.id.nav_color_palettes -> return DummyFragment()
            R.id.nav_devices -> return DummyFragment()
            R.id.nav_layout_templates -> return DummyFragment()
            R.id.nav_roboto_and_noto_fonts -> return DummyFragment()
            R.id.nav_sticker_sheets_and_icons -> return DummyFragment()
            else -> {
                debug("Unknown ID: $id")
                return null
            }
        }
    }
}
