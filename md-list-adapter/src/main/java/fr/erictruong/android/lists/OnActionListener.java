package fr.erictruong.android.lists;

import android.view.View;

public interface OnActionListener<T> {

     void onClick(View v, T object);
}
