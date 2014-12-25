package com.training.android.materiel.ui.listcontrol;

import android.content.Context;
import android.view.View;

public interface ListControl {

    int getInflatedId();

    int getLayoutId();

    int getLayoutSizeId();

    /**
     * @param context
     * @param view The view to setup.
     *
     * @return Return true if the view has been modified, false otherwise.
     */
    boolean setupView(Context context, View view);
}
