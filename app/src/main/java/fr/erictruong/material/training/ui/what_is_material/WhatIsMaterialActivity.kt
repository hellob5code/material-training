package fr.erictruong.material.training.ui.what_is_material

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.what_is_material.elevation_and_shadows.ElevationAndShadowsFragment
import fr.erictruong.material.training.ui.what_is_material.environment.EnvironmentFragment
import fr.erictruong.material.training.ui.what_is_material.material_properties.MaterialPropertiesFragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class WhatIsMaterialActivity : BaseDrawerActivity(), AnkoLogger {

    override fun getSelectedFragment(id: Int): Fragment? {
        when (id) {
            R.id.nav_environment -> return EnvironmentFragment()
            R.id.nav_material_properties -> return MaterialPropertiesFragment()
            R.id.nav_elevation_and_shadows -> return ElevationAndShadowsFragment()
            else -> {
                debug("Unknown ID: $id")
                return null
            }
        }
    }
}
