package com.training.android.material.util;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import com.training.android.material.R;

public class ViewUtils {

    public static void setMaxWidth(final View v, final int maxWdth) {
        v.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    v.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    v.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                if (v.getWidth() > maxWdth) {
                    v.getLayoutParams().width = maxWdth;
                }
            }
        });
    }
}
