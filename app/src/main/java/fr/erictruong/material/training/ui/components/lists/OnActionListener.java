package fr.erictruong.material.training.ui.components.lists;

import android.view.View;

public interface OnActionListener<T extends MaterialListItem> {

     void onClick(View v, T item);
}
