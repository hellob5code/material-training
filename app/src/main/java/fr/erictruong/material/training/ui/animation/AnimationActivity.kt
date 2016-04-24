package fr.erictruong.material.training.ui.animation

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.animation.authentic_motion.AuthenticMotionFragment
import fr.erictruong.material.training.ui.animation.delightful_details.DelightfulDetailsFragment
import fr.erictruong.material.training.ui.animation.meaningful_transitions.MeaningfulTransitionsFragment
import fr.erictruong.material.training.ui.animation.responsive_interaction.ResponsiveInteractionFragment
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class AnimationActivity : BaseDrawerActivity(), AnkoLogger {

    override fun getSelectedFragment(id: Int): Fragment? {
        when (id) {
            R.id.nav_authentic_motion -> return AuthenticMotionFragment()
            R.id.nav_responsive_interaction -> return ResponsiveInteractionFragment()
            R.id.nav_meaningful_transitions -> return MeaningfulTransitionsFragment()
            R.id.nav_delightful_details -> return DelightfulDetailsFragment()
            else -> {
                debug("Unknown ID: $id")
                return null
            }
        }
    }
}
