package com.training.android.materiel.util;

import org.apache.commons.lang3.text.WordUtils;

public class EnumUtils {

    public static String[] names(Class<? extends Enum<?>> e) {
        Enum<?>[] types = e.getEnumConstants();
        String[] names = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            names[i] = types[i].name();
        }
        return names;
    }

    public static String[] capitalizedFullyNames(Class<? extends Enum<?>> e) {
        Enum<?>[] types = e.getEnumConstants();
        String[] names = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            names[i] = WordUtils.capitalizeFully(types[i].name());
        }
        return names;
    }
}
