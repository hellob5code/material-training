package fr.erictruong.material.training.extension

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun prefs(context: Context, name: String, default: Long) = Preference(context, name, default)
fun prefs(context: Context, name: String, default: String) = Preference(context, name, default)
fun prefs(context: Context, name: String, default: Int) = Preference(context, name, default)
fun prefs(context: Context, name: String, default: Boolean) = Preference(context, name, default)
fun prefs(context: Context, name: String, default: Float) = Preference(context, name, default)

class Preference<T>(val context: Context, val name: String, val default: T) : ReadWriteProperty<Any?, T> {

    val prefs by lazy { context.getSharedPreferences("default", Context.MODE_PRIVATE) }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(name, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name, value)
    }

    @Suppress("UNCHECKED_CAST")
    private fun <U> findPreference(name: String, default: U): U = with(prefs) {
        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> throw IllegalArgumentException("This type can be saved into Preferences")
        }

        res as U
    }

    private fun <U> putPreference(name: String, value: U) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw IllegalArgumentException("This type can be saved into Preferences")
        }.apply()
    }
}