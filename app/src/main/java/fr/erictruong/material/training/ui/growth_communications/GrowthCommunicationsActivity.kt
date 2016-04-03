package fr.erictruong.material.training.ui.growth_communications

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.growth_communications.feature_discovery.FeatureDiscoveryFragment
import fr.erictruong.material.training.ui.growth_communications.gesture_education.GestureEducationFragment
import fr.erictruong.material.training.ui.growth_communications.introduction.IntroductionFragment
import fr.erictruong.material.training.ui.growth_communications.onboarding.OnboardingFragment
import org.jetbrains.anko.AnkoLogger

class GrowthCommunicationsActivity : BaseDrawerActivity() {

    override fun getSelectedFragment(id: Int): Fragment? {
        return when (id) {
            R.id.nav_growth_communications_introduction -> IntroductionFragment()
            R.id.nav_growth_communications_onboarding -> OnboardingFragment()
            R.id.nav_growth_communications_feature_discovery -> FeatureDiscoveryFragment()
            R.id.nav_growth_communications_gesture_education -> GestureEducationFragment()
            else -> null
        }
    }
}
