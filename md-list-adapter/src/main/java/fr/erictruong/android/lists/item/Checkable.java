package fr.erictruong.android.lists.item;

import fr.erictruong.android.lists.OnCheckActionListener;

public interface Checkable {

    boolean isChecked();

    void setChecked(boolean isChecked);

    OnCheckActionListener getCheckAction();

    void setCheckAction(OnCheckActionListener checkAction);
}
