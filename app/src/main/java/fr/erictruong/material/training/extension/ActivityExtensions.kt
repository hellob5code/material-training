package fr.erictruong.material.training.extension

import android.app.Activity

inline fun Activity.consume(f: () -> Unit): Boolean {
    f()
    return true
}