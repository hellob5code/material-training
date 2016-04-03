package fr.erictruong.material.training.ui.motion

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.motion.choreography.ChoreographyFragment
import fr.erictruong.material.training.ui.motion.creative_customization.CreativeCustomizationFragment
import fr.erictruong.material.training.ui.motion.duration_easing.DurationEasingFragment
import fr.erictruong.material.training.ui.motion.material_motion.MaterialMotionFragment
import fr.erictruong.material.training.ui.motion.movement.MovementFragment
import fr.erictruong.material.training.ui.motion.transforming_material.TransformingMaterialFragment
import org.jetbrains.anko.AnkoLogger

class MotionActivity : BaseDrawerActivity() {

    override fun getSelectedFragment(id: Int): Fragment? {
        return when (id) {
            R.id.nav_motion_material_motion -> MaterialMotionFragment()
            R.id.nav_motion_duration_easing -> DurationEasingFragment()
            R.id.nav_motion_movement -> MovementFragment()
            R.id.nav_motion_transforming_material -> TransformingMaterialFragment()
            R.id.nav_motion_choreography -> ChoreographyFragment()
            R.id.nav_motion_creative_customization -> CreativeCustomizationFragment()
            else -> null
        }
    }
}
