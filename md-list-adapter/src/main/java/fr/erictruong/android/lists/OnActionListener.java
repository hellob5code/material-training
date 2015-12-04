package fr.erictruong.android.lists;

import android.view.View;

import fr.erictruong.android.lists.item.MaterialListItem;

public interface OnActionListener<I extends MaterialListItem> {

     void onAction(View v, I item);
}
