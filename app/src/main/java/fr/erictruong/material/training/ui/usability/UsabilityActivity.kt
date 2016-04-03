package fr.erictruong.material.training.ui.usability

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.core.DummyFragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class UsabilityActivity : BaseDrawerActivity(), AnkoLogger {

    override fun getSelectedFragment(id: Int): Fragment? {
        when (id) {
            R.id.nav_accessibility -> return DummyFragment()
            R.id.nav_bidirectionality -> return DummyFragment()
            else -> {
                debug("Unknown ID: $id")
                return null
            }
        }
    }
}
