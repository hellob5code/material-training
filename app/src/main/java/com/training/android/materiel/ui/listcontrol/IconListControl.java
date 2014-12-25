package com.training.android.materiel.ui.listcontrol;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.training.android.materiel.R;

public class IconListControl implements ListControl {

    private static final int ICON_CONTROL_ID = R.id.list_control_icon_material;
    private static final int ICON_CONTROL_LAYOUT_ID = R.layout.list_control_icon_material;
    private static final int ICON_CONTROL_LAYOUT_SIZE_ID = R.dimen.material_list_icon_size;

    private int drawableId;
    private Integer color;

    public IconListControl(int drawableId) {
        this.drawableId = drawableId;
    }

    public IconListControl(int drawableId, Integer color) {
        this.drawableId = drawableId;
        this.color = color;
    }

    public IconListControl(Context context, int drawableId, int colorId) {
        this.drawableId = drawableId;
        this.color = context.getResources().getColor(colorId);
    }

    @Override
    public int getInflatedId() {
        return ICON_CONTROL_ID;
    }

    @Override
    public int getLayoutId() {
        return ICON_CONTROL_LAYOUT_ID;
    }

    @Override
    public int getLayoutSizeId() {
        return ICON_CONTROL_LAYOUT_SIZE_ID;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public Integer getColor() {
        return color;
    }

    @Override
    public boolean setupView(Context context, View view) {
        if (view == null) {
            return false;
        }
        Drawable drawable = context.getResources().getDrawable(drawableId);
        if (color != null) {
            drawable.mutate().setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
        ((ImageView) view).setImageDrawable(drawable);
        return true;
    }
}