package fr.erictruong.material.training.ui.layout

import android.support.v4.app.Fragment
import fr.erictruong.material.training.R
import fr.erictruong.material.training.ui.core.BaseDrawerActivity
import fr.erictruong.material.training.ui.layout.metrics_keylines.MetricsKeylinesFragment
import fr.erictruong.material.training.ui.layout.principles.PrinciplesFragment
import fr.erictruong.material.training.ui.layout.responsive_ui.ResponsiveUiFragment
import fr.erictruong.material.training.ui.layout.split_screen.SplitScreenFragment
import fr.erictruong.material.training.ui.layout.structure.StructureFragment
import fr.erictruong.material.training.ui.layout.units_measurements.UnitsMeasurementsFragment
import org.jetbrains.anko.AnkoLogger

class LayoutActivity : BaseDrawerActivity() {

    override fun getSelectedFragment(id: Int): Fragment? {
        return when (id) {
            R.id.nav_layout_principles -> PrinciplesFragment()
            R.id.nav_layout_units_measurements -> UnitsMeasurementsFragment()
            R.id.nav_layout_metrics_keylines -> MetricsKeylinesFragment()
            R.id.nav_layout_structure -> StructureFragment()
            R.id.nav_layout_responsive_ui -> ResponsiveUiFragment()
            R.id.nav_layout_split_screen -> SplitScreenFragment()
            else -> null
        }
    }
}
