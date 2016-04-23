package fr.erictruong.material.training.ui.layout

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.layout.metrics_and_keylines.MetricsAndKeylinesFragment
import fr.erictruong.material.training.ui.layout.principles.PrinciplesFragment
import fr.erictruong.material.training.ui.layout.responsive_ui.ResponsiveUiFragment
import fr.erictruong.material.training.ui.layout.split_screen.SplitScreenFragment
import fr.erictruong.material.training.ui.layout.structure.StructureFragment
import fr.erictruong.material.training.ui.layout.units_and_measurements.UnitsAndMeasurementsFragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class LayoutActivity : BaseDrawerActivity(), AnkoLogger {

    override fun getSelectedFragment(id: Int): Fragment? {
        when (id) {
            R.id.nav_principles -> return PrinciplesFragment()
            R.id.nav_units_and_measurements -> return UnitsAndMeasurementsFragment()
            R.id.nav_metrics_and_keylines -> return MetricsAndKeylinesFragment()
            R.id.nav_structure -> return StructureFragment()
            R.id.nav_responsive_ui -> return ResponsiveUiFragment()
            R.id.nav_split_screen -> return SplitScreenFragment()
            else -> {
                debug("Unknown ID: $id")
                return null
            }
        }
    }
}
