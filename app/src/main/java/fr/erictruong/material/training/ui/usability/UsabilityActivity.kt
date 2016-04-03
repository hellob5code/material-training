package fr.erictruong.material.training.ui.usability

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.usability.accessibility.AccessibilityFragment
import fr.erictruong.material.training.ui.usability.bidirectionality.BidirectionalityFragment
import org.jetbrains.anko.AnkoLogger

class UsabilityActivity : BaseDrawerActivity() {

    override fun getSelectedFragment(id: Int): Fragment? {
        return when (id) {
            R.id.nav_usability_accessibility -> AccessibilityFragment()
            R.id.nav_usability_bidirectionality -> BidirectionalityFragment()
            else -> null
        }
    }
}
