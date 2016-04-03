package fr.erictruong.material.training.ui.style

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.core.DummyFragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class StyleActivity : BaseDrawerActivity(), AnkoLogger {

    override fun getSelectedFragment(id: Int): Fragment? {
        when (id) {
            R.id.nav_color -> return DummyFragment()
            R.id.nav_icons -> return DummyFragment()
            R.id.nav_imagery -> return DummyFragment()
            R.id.nav_typography -> return DummyFragment()
            R.id.nav_writing -> return DummyFragment()
            else -> {
                debug("Unknown ID: $id")
                return null
            }
        }
    }
}
