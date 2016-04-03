package fr.erictruong.material.training.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.startActivity

import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.material_design.MaterialDesignActivity

/**
 * Launcher Activity used to forward to the default screen or the last visited screen.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startLastVisitedActivity()
    }

    private fun startLastVisitedActivity() {
        // TODO: Use preference to start the last activity visited.
        startActivity<MaterialDesignActivity>(BaseDrawerActivity.NAV_ID to R.id.nav_introduction)
    }
}
