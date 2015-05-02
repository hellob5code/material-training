package fr.erictruong.training.material.util;

import android.util.Log;
import fr.erictruong.training.material.BuildConfig;

public class LogUtils {

    private static final String TAG = "MaterialTraining";

    public static void d(Class clazz, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, format(clazz, message));
        }
    }

    public static void d(Class clazz, String message, Object... args) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, format(clazz, message, args));
        }
    }

    public static void i(Class clazz, String message) {
        Log.i(TAG, format(clazz, message));
    }

    public static void i(Class clazz, String message, Object... args) {
        Log.i(TAG, format(clazz, message, args));
    }

    public static void w(Class clazz, String message) {
        Log.w(TAG, format(clazz, message));
    }

    public static void w(Class clazz, String message, Object... args) {
        Log.w(TAG, format(clazz, message, args));
    }

    public static void w(Class clazz, String message, Exception e) {
        Log.w(TAG, format(clazz, message), e);
    }

    public static void w(Class clazz, String message, Exception e, Object... args) {
        Log.w(TAG, format(clazz, message, args), e);
    }

    public static void e(Class clazz, String message) {
        Log.e(TAG, format(clazz, message));
    }

    public static void e(Class clazz, String message, Object... args) {
        Log.e(TAG, format(clazz, message, args));
    }

    public static void e(Class clazz, String message, Exception e) {
        Log.e(TAG, format(clazz, message), e);
    }

    public static void e(Class clazz, String message, Exception e, Object... args) {
        Log.e(TAG, format(clazz, message, args), e);
    }

    private static String format(Class<?> clazz, String message) {
        return "[" + clazz.getSimpleName() + "] " + message;
    }

    private static String format(Class<?> clazz, String message, Object... args) {
        return "[" + clazz.getSimpleName() + "] " + String.format(message, args);
    }
}
