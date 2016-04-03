package fr.erictruong.material.training.ui.whats_new

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.core.fragment.DummyFragment
import fr.erictruong.material.training.ui.whats_new.whats_new.WhatsNewFragment
import org.jetbrains.anko.AnkoLogger

class WhatsNewActivity : BaseDrawerActivity() {

    override fun getSelectedFragment(id: Int): Fragment? {
        return when (id) {
            R.id.nav_whats_new_whats_new -> WhatsNewFragment()
            else -> null
        }
    }
}
