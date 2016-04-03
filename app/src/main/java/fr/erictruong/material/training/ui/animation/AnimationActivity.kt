package fr.erictruong.material.training.ui.animation

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.core.DummyFragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class AnimationActivity : BaseDrawerActivity(), AnkoLogger {

    override fun getSelectedFragment(id: Int): Fragment? {
        when (id) {
            R.id.nav_authentic_motion -> return DummyFragment()
            R.id.nav_responsive_interaction -> return DummyFragment()
            R.id.nav_meaningful_transitions -> return DummyFragment()
            R.id.nav_delightful_details -> return DummyFragment()
            else -> {
                debug("Unknown ID: $id")
                return null
            }
        }
    }
}
