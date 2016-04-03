package fr.erictruong.material.training.ui.material_design

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.material_design.introduction.IntroductionFragment

class MaterialDesignActivity : BaseDrawerActivity() {

    override fun getSelectedFragment(id: Int): Fragment? {
        return when (id) {
            R.id.nav_material_design_introduction -> IntroductionFragment()
            else -> null
        }
    }
}
