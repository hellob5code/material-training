package com.training.android.material.ui.listcontrol;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.training.android.material.R;

public class IconListControl implements ListControl {

    public static final int CONTROL_LAYOUT_ID = R.layout.list_control_icon_material;
    public static final int CONTROL_INFLATED_ID = R.id.list_control_icon_material;

    private int layoutSize;
    private Drawable drawable;

    public IconListControl(Context context, int drawable) {
        this.layoutSize = context.getResources().getDimensionPixelSize(R.dimen.list_icon_size_material);
        if (drawable > 0) {
            this.drawable = context.getResources().getDrawable(drawable);
        }
    }

    public Drawable getDrawable() {
        return drawable;
    }

    @Override
    public int getLayoutId() {
        return CONTROL_LAYOUT_ID;
    }

    @Override
    public int getInflatedId() {
        return CONTROL_INFLATED_ID;
    }

    @Override
    public boolean inflateStub(ViewStub viewStub) {
        if (viewStub != null) {
            viewStub.setLayoutResource(getLayoutId());
            viewStub.setInflatedId(getInflatedId());
            ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
            layoutParams.width = layoutSize;
            layoutParams.height = layoutSize;
            viewStub.inflate();
            return true;
        }
        return false;
    }
}