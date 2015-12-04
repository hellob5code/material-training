package fr.erictruong.android.lists.stub;

import android.view.View;

import fr.erictruong.android.lists.Bindable;
import fr.erictruong.android.lists.item.MaterialListItem;

public class ActionStub extends BaseStub implements Bindable<MaterialListItem> {

    public ActionStub(View view) {
        super(view);
    }

    @Override
    public void bind(final MaterialListItem item) {
        getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.getAction() != null) {
                    item.getAction().onAction(v, item);
                }
            }
        });
    }

    @Override
    public void unbind() {
        // Nothing to do
    }
}
