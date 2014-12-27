package com.training.android.materiel.ui.listcontrol;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

public class AvatarListControl implements ListControl {

    private static final int CONTROL_LAYOUT_SIZE_DP = 40;
    private static final int CONTROL_INFLATED_ID = 0;
    private static final int CONTROL_LAYOUT_ID = 0;

    private int layoutSize;

    @Override
    public int getInflatedId() {
        return CONTROL_INFLATED_ID;
    }

    @Override
    public int getLayoutId() {
        return CONTROL_LAYOUT_ID;
    }

    @Override
    public boolean inflateStub(ViewStub viewStub) {
        View inflatedView;
        if (viewStub != null) {
            viewStub.setInflatedId(getInflatedId());
            viewStub.setLayoutResource(getLayoutId());
            ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
            layoutParams.width = layoutSize;
            layoutParams.height = layoutSize;
//            inflatedView = viewStub.inflate();

            return true;
        }
        return false;
    }
}
