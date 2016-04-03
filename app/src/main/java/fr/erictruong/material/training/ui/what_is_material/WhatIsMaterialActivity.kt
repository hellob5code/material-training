package fr.erictruong.material.training.ui.what_is_material

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.what_is_material.elevation_shadows.ElevationShadowsFragment
import fr.erictruong.material.training.ui.what_is_material.environment.EnvironmentFragment
import fr.erictruong.material.training.ui.what_is_material.material_properties.MaterialPropertiesFragment
import org.jetbrains.anko.AnkoLogger

class WhatIsMaterialActivity : BaseDrawerActivity() {

    override fun getSelectedFragment(id: Int): Fragment? {
        return when (id) {
            R.id.nav_what_is_material_environment -> EnvironmentFragment()
            R.id.nav_what_is_material_material_properties -> MaterialPropertiesFragment()
            R.id.nav_what_is_material_elevation_shadows -> ElevationShadowsFragment()
            else -> null
        }
    }
}
