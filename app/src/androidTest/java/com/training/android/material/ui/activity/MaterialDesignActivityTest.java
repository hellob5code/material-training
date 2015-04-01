package com.training.android.material.ui.activity;

import com.squareup.spoon.Spoon;
import com.training.android.material.R;

public class MaterialDesignActivityTest extends NavigationDrawerActivityTest<MaterialDesignActivity> {

    private MaterialDesignActivity activity;

    public MaterialDesignActivityTest() {
        super(MaterialDesignActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testShowIntroductionFragment() {
        clickNavigationDrawerItem(activity.getString(R.string.navdrawer_child_introduction));
        Spoon.screenshot(activity, "initial_state");
    }
}
