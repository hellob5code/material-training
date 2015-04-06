package fr.erictruong.training.material.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;

public class ThemeUtils {

    public static int obtainColorPrimary(Context context) {
        int colorPrimaryId = context.getResources().getIdentifier("colorPrimary", "attr", context.getPackageName());
        if (colorPrimaryId > 0) {
            TypedValue typedValue = new TypedValue();
            TypedArray a = context.getTheme().obtainStyledAttributes(typedValue.data, new int[]{ colorPrimaryId });
            int color = a.getColor(0, 0);
            a.recycle();
            return color;
        }
        return Color.BLACK;
    }

    public static int obtainColorAccent(Context context) {
        int colorAccentId = context.getResources().getIdentifier("colorAccent", "attr", context.getPackageName());
        if (colorAccentId > 0) {
            TypedValue typedValue = new TypedValue();
            TypedArray a = context.getTheme().obtainStyledAttributes(typedValue.data, new int[]{ colorAccentId });
            int color = a.getColor(0, 0);
            a.recycle();
            return color;
        }
        return Color.BLACK;
    }
}
