package com.training.android.material.persistence.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static com.training.android.material.ui.activity.MaterialTrainingNavigationDrawerActivity.NAVDRAWER_CHILD_INTRODUCTION_ID;
import static com.training.android.material.ui.activity.MaterialTrainingNavigationDrawerActivity.NAVDRAWER_GROUP_MATERIAL_DESIGN_ID;

public final class AppPrefs {

    private static final String PREF_LAST_VISITED_GROUP_ID = "pref_last_visited_group_id";
    private static final String PREF_LAST_VISITED_CHILD_ID = "pref_last_visited_child_id";

    public static final int PREF_LAST_VISITED_GROUP_ID_DEFAULT = NAVDRAWER_GROUP_MATERIAL_DESIGN_ID;
    public static final int PREF_LAST_VISITED_CHILD_ID_DEFAULT = NAVDRAWER_CHILD_INTRODUCTION_ID;

    private AppPrefs() {}

    public static void putLastVisitedGroupId(Context context, int id) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putInt(PREF_LAST_VISITED_GROUP_ID, id).apply();
    }

    public static int getLastVisitedGroupId(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getInt(PREF_LAST_VISITED_GROUP_ID, PREF_LAST_VISITED_GROUP_ID_DEFAULT);
    }

    public static void putLastVisitedChildId(Context context, int id) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putInt(PREF_LAST_VISITED_CHILD_ID, id).apply();
    }

    public static int getLastVisitedChildId(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getInt(PREF_LAST_VISITED_CHILD_ID, PREF_LAST_VISITED_CHILD_ID_DEFAULT);
    }
}