package fr.erictruong.material.training

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import fr.erictruong.material.training.extension.prefs
import fr.erictruong.material.training.ui.core.BaseDrawerActivity.Companion.NAV_ITEM_ID
import fr.erictruong.material.training.ui.material_design.MaterialDesignActivity
import org.jetbrains.anko.startActivity

/**
 * Launcher Activity used to forward to the default screen or the last visited screen.
 */
class MainActivity : AppCompatActivity() {

    var navItemId: Int by prefs(this, Prefs.NAV_ITEM_ID, Prefs.DEFAULT_NAV_ITEM_ID)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity<MaterialDesignActivity>(NAV_ITEM_ID to navItemId)
    }
}