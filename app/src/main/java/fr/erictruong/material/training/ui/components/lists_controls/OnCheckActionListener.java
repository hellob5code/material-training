package fr.erictruong.material.training.ui.components.lists_controls;

import android.widget.CompoundButton;

public interface OnCheckActionListener<T> {

    void onCheckedChanged(CompoundButton buttonView, boolean isChecked, T object);
}
