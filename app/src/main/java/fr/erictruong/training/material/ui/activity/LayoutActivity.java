package fr.erictruong.training.material.ui.activity;

import android.app.Fragment;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.fragment.MetricsAndKeylinesFragment;
import fr.erictruong.training.material.ui.fragment.PrinciplesFragment;
import fr.erictruong.training.material.ui.fragment.StructureFragment;
import fr.erictruong.training.material.ui.fragment.UnitsAndMeasurementsFragment;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;
import fr.erictruong.training.material.ui.tile.NavigationDrawerGroup;
import fr.erictruong.training.material.ui.tile.Tile;

public class LayoutActivity extends MaterialTrainingActivity {

    private static final String TAG = LayoutActivity.class.getSimpleName();

    @Override
    protected int getSelectedNavigationDrawerGroupId() {
        return NAVDRAWER_GROUP_LAYOUT_ID;
    }

    @Override
    protected String getNavigationDrawerClosedTitle() {
        return getString(R.string.navdrawer_group_layout);
    }

    @Override
    protected int getDefaultSelectedFragment() {
        return NAVDRAWER_CHILD_PRINCIPLES_ID;
    }

    @Override
    protected Fragment getSelectedFragment(int id) {
        switch (id) {
            case NAVDRAWER_CHILD_PRINCIPLES_ID:
                return new PrinciplesFragment();
            case NAVDRAWER_CHILD_UNITS_AND_MEASUREMENTS_ID:
                return new UnitsAndMeasurementsFragment();
            case NAVDRAWER_CHILD_METRICS_AND_KEYLINES_ID:
                return new MetricsAndKeylinesFragment();
            case NAVDRAWER_CHILD_STRUCTURE_ID:
                return new StructureFragment();
            default:
                return super.getSelectedFragment(id);
        }
    }

    @Override
    protected NavigationDrawerChild getPreviousNavigationDrawerItem(NavigationDrawerExpandableListAdapter adapter, int id) {
        switch (id) {
            case NAVDRAWER_CHILD_PRINCIPLES_ID:
                return adapter.getGroupById(NAVDRAWER_GROUP_STYLE_ID).getLastChild();
            default:
                return super.getPreviousNavigationDrawerItem(adapter, id);
        }
    }

    @Override
    protected NavigationDrawerChild getNextNavigationDrawerItem(NavigationDrawerExpandableListAdapter adapter, int id) {
        switch (id) {
            case NAVDRAWER_CHILD_STRUCTURE_ID:
                return adapter.getGroupById(NAVDRAWER_GROUP_COMPONENTS_ID).getFirstChild();
            default:
                return super.getNextNavigationDrawerItem(adapter, id);
        }
    }
}
