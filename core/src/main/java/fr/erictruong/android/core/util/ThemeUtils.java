package fr.erictruong.android.core.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;

public class ThemeUtils {

    private ThemeUtils() {
        throw new AssertionError("No instances.");
    }

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

    public static Drawable getTintedDrawable(Context context, @DrawableRes int drawableResId, @ColorRes int colorResId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableResId).mutate();
        int color = ContextCompat.getColor(context, colorResId);
        drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    public static Drawable getTintedDrawable(Drawable drawable, @ColorInt int color) {
        drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    public static Drawable getAccentTintedDrawable(Context context, @DrawableRes int drawableResId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableResId).mutate();
        drawable.setColorFilter(obtainColorAccent(context), PorterDuff.Mode.SRC_IN);
        return drawable;
    }
}
