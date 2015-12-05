package fr.erictruong.android.lists.item;

import android.support.v7.widget.helper.ItemTouchHelper;

public interface Reorderable {

    ItemTouchHelper getItemTouchHelper();

    void setItemTouchHelper(ItemTouchHelper helper);
}
