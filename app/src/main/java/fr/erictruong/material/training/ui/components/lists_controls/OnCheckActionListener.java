package fr.erictruong.material.training.ui.components.lists_controls;

import android.widget.CompoundButton;

import fr.erictruong.material.training.ui.components.lists.MaterialListItem;

public interface OnCheckActionListener<T extends MaterialListItem> {

    void onCheckedChanged(CompoundButton buttonView, boolean isChecked, T item);
}
