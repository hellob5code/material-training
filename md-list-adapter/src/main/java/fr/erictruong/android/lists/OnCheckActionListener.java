package fr.erictruong.android.lists;

import android.widget.CompoundButton;

public interface OnCheckActionListener<T> {

    void onCheckedChanged(CompoundButton buttonView, boolean isChecked, T object);
}
