package fr.erictruong.training.material.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;

public class ThemeUtils {

    /**
     * Obtains the color of the compatibility theme from the {@code colorPrimary} attribute or {@code Color.BLACK} by default.
     *
     * @param context The Android context.
     * @return The primary color of the compatibility theme or {@code Color.BLACK} by default.
     */
    public static int obtainColorPrimary(Context context) {
        int colorId = context.getResources().getIdentifier("colorPrimary", "attr", context.getPackageName());
        if (colorId > 0) {
            TypedValue typedValue = new TypedValue();
            TypedArray a = context.getTheme().obtainStyledAttributes(typedValue.data, new int[]{ colorId });
            int color = a.getColor(0, 0);
            a.recycle();
            return color;
        }
        return Color.BLACK;
    }

    /**
     * Obtains the color of the compatibility theme from the {@code colorPrimaryDark} attribute or {@code Color.BLACK} by default.
     *
     * @param context The Android context.
     * @return The primary dark color of the compatibility theme or {@code Color.BLACK} by default.
     */
    public static int obtainColorPrimaryDark(Context context) {
        int colorId = context.getResources().getIdentifier("colorPrimaryDark", "attr", context.getPackageName());
        if (colorId > 0) {
            TypedValue typedValue = new TypedValue();
            TypedArray a = context.getTheme().obtainStyledAttributes(typedValue.data, new int[]{ colorId });
            int color = a.getColor(0, 0);
            a.recycle();
            return color;
        }
        return Color.BLACK;
    }

    /**
     * Obtains the color of the compatibility theme from the {@code colorAccent} attribute or {@code Color.BLACK} by default.
     *
     * @param context The Android context.
     * @return The accent color of the compatibility theme or {@code Color.BLACK} by default.
     */
    public static int obtainColorAccent(Context context) {
        int colorId = context.getResources().getIdentifier("colorAccent", "attr", context.getPackageName());
        if (colorId > 0) {
            TypedValue typedValue = new TypedValue();
            TypedArray a = context.getTheme().obtainStyledAttributes(typedValue.data, new int[]{ colorId });
            int color = a.getColor(0, 0);
            a.recycle();
            return color;
        }
        return Color.BLACK;
    }
}
