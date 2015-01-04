package com.training.android.material.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import com.training.android.material.R;

public class ThemeUtils {

    public static int obtainPrimaryColor(Context context) {
        TypedValue typedValue = new TypedValue();
        TypedArray a = context.getTheme().obtainStyledAttributes(typedValue.data, new int[]{ R.attr.primaryColor });
        int color = a.getColor(0, 0);
        a.recycle();
        return color;
    }

    public static int obtainAccentColor(Context context) {
        TypedValue typedValue = new TypedValue();
        TypedArray a = context.getTheme().obtainStyledAttributes(typedValue.data, new int[]{ R.attr.colorAccent });
        int color = a.getColor(0, 0);
        a.recycle();
        return color;
    }
}
