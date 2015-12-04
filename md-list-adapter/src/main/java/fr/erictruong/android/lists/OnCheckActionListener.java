package fr.erictruong.android.lists;

import android.view.View;

import fr.erictruong.android.lists.item.Checkable;

public interface OnCheckActionListener<I extends Checkable> {

     void onAction(View v, I item);
}
