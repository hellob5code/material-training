package fr.erictruong.training.material.util;

import android.util.Log;
import fr.erictruong.training.material.BuildConfig;

public class LogUtils {

    private static final String TAG = "MaterialTraining";

    /**
     * @see Log#d
     * @param clazz The class where the log call occurs.
     * @param message The message you would like logged.
     */
    public static void d(Class clazz, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, format(clazz, message));
        }
    }

    /**
     * @see Log#d
     * @param clazz The class where the log call occurs.
     * @param message The message you would like logged.
     * @param args The {@link String#format} arguments of the message.
     */
    public static void d(Class clazz, String message, Object... args) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, format(clazz, message, args));
        }
    }

    /**
     * @see Log#i
     * @param clazz The class where the log call occurs.
     * @param message The message you would like logged.
     */
    public static void i(Class clazz, String message) {
        Log.i(TAG, format(clazz, message));
    }

    /**
     * @see Log#i
     * @param clazz The class where the log call occurs.
     * @param message The message you would like logged.
     * @param args The {@link String#format} arguments of the message.
     */
    public static void i(Class clazz, String message, Object... args) {
        Log.i(TAG, format(clazz, message, args));
    }

    /**
     * @see Log#w
     * @param clazz The class where the log call occurs.
     * @param message The message you would like logged.
     */
    public static void w(Class clazz, String message) {
        Log.w(TAG, format(clazz, message));
    }

    /**
     * @see Log#w
     * @param clazz The class where the log call occurs.
     * @param message The message you would like logged.
     * @param args The {@link String#format} arguments of the message.
     */
    public static void w(Class clazz, String message, Object... args) {
        Log.w(TAG, format(clazz, message, args));
    }

    /**
     * @see Log#w
     * @param clazz The class where the log call occurs.
     * @param message The message you would like logged.
     * @param tr An exception to log.
     */
    public static void w(Class clazz, String message, Throwable tr) {
        Log.w(TAG, format(clazz, message), tr);
    }

    /**
     * @see Log#w
     * @param clazz The class where the log call occurs.
     * @param message The message you would like logged.
     * @param tr An exception to log.
     * @param args The {@link String#format} arguments of the message.
     */
    public static void w(Class clazz, String message, Throwable tr, Object... args) {
        Log.w(TAG, format(clazz, message, args), tr);
    }

    /**
     * @see Log#e
     * @param clazz The class where the log call occurs.
     * @param message The message you would like logged.
     */
    public static void e(Class clazz, String message) {
        Log.e(TAG, format(clazz, message));
    }

    /**
     * @see Log#e
     * @param clazz The class where the log call occurs.
     * @param message The message you would like logged.
     * @param args The {@link String#format} arguments of the message.
     */
    public static void e(Class clazz, String message, Object... args) {
        Log.e(TAG, format(clazz, message, args));
    }

    /**
     * @see Log#e
     * @param clazz The class where the log call occurs.
     * @param message The message you would like logged.
     * @param tr An exception to log.
     */
    public static void e(Class clazz, String message, Throwable tr) {
        Log.e(TAG, format(clazz, message), tr);
    }

    /**
     * @see Log#e
     * @param clazz The class where the log call occurs.
     * @param message The message you would like logged.
     * @param tr An exception to log.
     * @param args The {@link String#format} arguments of the message.
     */
    public static void e(Class clazz, String message, Throwable tr, Object... args) {
        Log.e(TAG, format(clazz, message, args), tr);
    }

    private static String format(Class<?> clazz, String message) {
        return "[" + clazz.getSimpleName() + "] " + message;
    }

    private static String format(Class<?> clazz, String message, Object... args) {
        return "[" + clazz.getSimpleName() + "] " + String.format(message, args);
    }
}
