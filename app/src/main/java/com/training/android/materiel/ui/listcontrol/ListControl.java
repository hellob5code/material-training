package com.training.android.materiel.ui.listcontrol;

import android.view.ViewStub;

public interface ListControl {

    int getLayoutId();

    int getInflatedId();

    /**
     * @param viewStub The viewStub to setup.
     *
     * @return Return true if the view has been modified, false otherwise.
     */
    boolean inflateStub(ViewStub viewStub);
}
