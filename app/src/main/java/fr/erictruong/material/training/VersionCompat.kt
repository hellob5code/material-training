package fr.erictruong.material.training

import android.os.Build

inline fun supportLollipop(f: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        f()
    }
}
