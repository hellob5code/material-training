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

class StyleActivity : BaseDrawerActivity() {

    override fun getSelectedFragment(id: Int): Fragment? {
        return when (id) {
            R.id.nav_style_color -> ColorFragment()
            R.id.nav_style_icons -> IconsFragment()
            R.id.nav_style_imagery -> ImageryFragment()
            R.id.nav_style_typography -> TypographyFragment()
            R.id.nav_style_writing -> WritingFragment()
            else -> null
        }
    }
}
