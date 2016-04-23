package fr.erictruong.material.training.ui.style

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.style.color.ColorFragment
import fr.erictruong.material.training.ui.style.icons.IconsFragment
import fr.erictruong.material.training.ui.style.imagery.ImageryFragment
import fr.erictruong.material.training.ui.style.typography.TypographyFragment
import fr.erictruong.material.training.ui.style.writing.WritingFragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class StyleActivity : BaseDrawerActivity(), AnkoLogger {

    override fun getSelectedFragment(id: Int): Fragment? {
        when (id) {
            R.id.nav_color -> return ColorFragment()
            R.id.nav_icons -> return IconsFragment()
            R.id.nav_imagery -> return ImageryFragment()
            R.id.nav_typography -> return TypographyFragment()
            R.id.nav_writing -> return WritingFragment()
            else -> {
                debug("Unknown ID: $id")
                return null
            }
        }
    }
}
