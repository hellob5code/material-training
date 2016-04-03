package fr.erictruong.material.training.ui.material_design

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.material_design.introduction.IntroductionFragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class MaterialDesignActivity : BaseDrawerActivity(), AnkoLogger {

    override fun getSelectedFragment(id: Int): Fragment? {
        when (id) {
            R.id.nav_introduction -> return IntroductionFragment()
            else -> {
                debug("Unknown ID: $id")
                return null
            }
        }
    }
}
