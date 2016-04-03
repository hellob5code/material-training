package fr.erictruong.material.training.ui.layout

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.core.DummyFragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class LayoutActivity : BaseDrawerActivity(), AnkoLogger {

    override fun getSelectedFragment(id: Int): Fragment? {
        when (id) {
            R.id.nav_principles -> return DummyFragment()
            R.id.nav_units_and_measurements -> return DummyFragment()
            R.id.nav_metrics_and_keylines -> return DummyFragment()
            R.id.nav_structure -> return DummyFragment()
            R.id.nav_adaptive_ui -> return DummyFragment()
            else -> {
                debug("Unknown ID: $id")
                return null
            }
        }
    }
}
