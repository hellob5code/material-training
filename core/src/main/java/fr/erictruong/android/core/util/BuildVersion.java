package fr.erictruong.android.core.util;

import android.os.Build;

public class BuildVersion {

    private BuildVersion() {
        throw new AssertionError("No instances.");
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.CUPCAKE} (3) or above.
     *
     * @return True if the API level is 3 or above.
     * @see Build.VERSION_CODES#CUPCAKE
     * @see Build.VERSION_CODES#DONUT
     */
    public static boolean isCupcake() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.DONUT} (4) or above.
     *
     * @return True if the API level is 4 or above.
     * @see Build.VERSION_CODES#DONUT
     * @see Build.VERSION_CODES#ECLAIR
     */
    public static boolean isDonut() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.ECLAIR} (5) or above.
     *
     * @return True if the API level is 5 or above.
     * @see Build.VERSION_CODES#ECLAIR
     * @see Build.VERSION_CODES#FROYO
     */
    public static boolean isEclair() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.FROYO} (8) or above.
     *
     * @return True if the API level is 8 or above.
     * @see Build.VERSION_CODES#FROYO
     * @see Build.VERSION_CODES#GINGERBREAD
     */
    public static boolean isFroyo() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.GINGERBREAD} (9) or above.
     *
     * @return True if the API level is 9 or above.
     * @see Build.VERSION_CODES#GINGERBREAD
     * @see Build.VERSION_CODES#GINGERBREAD_MR1
     */
    public static boolean isGingerbread() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.GINGERBREAD_MR1} (10) or above.
     *
     * @return True if the API level is 10 or above.
     * @see Build.VERSION_CODES#GINGERBREAD_MR1
     * @see Build.VERSION_CODES#HONEYCOMB
     */
    public static boolean isGingerbreadMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.HONEYCOMB} (11) or above.
     *
     * @return True if the API level is 11 or above.
     * @see Build.VERSION_CODES#HONEYCOMB
     * @see Build.VERSION_CODES#HONEYCOMB_MR1
     */
    public static boolean isHoneycomb() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.HONEYCOMB_MR1} (12) or above.
     *
     * @return True if the API level is 12 or above.
     * @see Build.VERSION_CODES#HONEYCOMB_MR1
     * @see Build.VERSION_CODES#HONEYCOMB_MR2
     */
    public static boolean isHoneycombMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.HONEYCOMB_MR2} (13) or above.
     *
     * @return True if the API level is 13 or above.
     * @see Build.VERSION_CODES#HONEYCOMB_MR2
     * @see Build.VERSION_CODES#ICE_CREAM_SANDWICH
     */
    public static boolean isHoneycombMR2() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.ICE_CREAM_SANDWICH} (14) or above.
     *
     * @return True if the API level is 14 or above.
     * @see Build.VERSION_CODES#ICE_CREAM_SANDWICH
     * @see Build.VERSION_CODES#ICE_CREAM_SANDWICH_MR1
     */
    public static boolean isIceCreamSandwich() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1} (15) or above.
     *
     * @return True if the API level is 15 or above.
     * @see Build.VERSION_CODES#ICE_CREAM_SANDWICH_MR1
     * @see Build.VERSION_CODES#JELLY_BEAN
     */
    public static boolean isIceCreamSandwichMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.JELLY_BEAN} (16) or above.
     *
     * @return True if the API level is 16 or above.
     * @see Build.VERSION_CODES#JELLY_BEAN
     * @see Build.VERSION_CODES#JELLY_BEAN_MR1
     */
    public static boolean isJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.JELLY_BEAN_MR1} (17) or above.
     *
     * @return True if the API level is 17 or above.
     * @see Build.VERSION_CODES#JELLY_BEAN_MR1
     * @see Build.VERSION_CODES#JELLY_BEAN_MR2
     */
    public static boolean isJellyBeanMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.JELLY_BEAN_MR2} (18) or above.
     *
     * @return True if the API level is 18 or above.
     * @see Build.VERSION_CODES#JELLY_BEAN_MR2
     * @see Build.VERSION_CODES#KITKAT
     */
    public static boolean isJellyBeanMR2() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.KITKAT} (19) or above.
     *
     * @return True if the API level is 19 or above.
     * @see Build.VERSION_CODES#KITKAT
     * @see Build.VERSION_CODES#KITKAT_WATCH
     */
    public static boolean isKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.KITKAT_WATCH} (20) or above.
     *
     * @return True if the API level is 20 or above.
     * @see Build.VERSION_CODES#KITKAT_WATCH
     * @see Build.VERSION_CODES#LOLLIPOP
     */
    public static boolean isKitKatWatch() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH;
    }

    /**
     * Returns {@code true} if the Android API level is {@code Build.VERSION_CODES.LOLLIPOP} (21) or above.
     *
     * @return True if the API level is 21 or above.
     * @see Build.VERSION_CODES#LOLLIPOP
     */
    public static boolean isLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }
}