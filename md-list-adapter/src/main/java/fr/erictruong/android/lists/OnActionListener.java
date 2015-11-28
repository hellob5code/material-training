package fr.erictruong.android.lists;

import android.view.View;

public interface OnActionListener<I extends MaterialListItem> {

     void onAction(View v, I item);
}
