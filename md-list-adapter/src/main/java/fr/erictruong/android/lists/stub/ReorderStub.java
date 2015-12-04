package fr.erictruong.android.lists.stub;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import fr.erictruong.android.lists.Bindable;
import fr.erictruong.android.lists.R;

public class ReorderStub extends BaseStub implements Bindable {

    @NonNull
    private ImageView icon;

    public ReorderStub(View view) {
        super(view);
        this.icon = (ImageView) view.findViewById(R.id.icon);
    }

    @Override
    public void bind(Object item) {
        icon.setImageResource(R.drawable.ic_reorder_black_24dp_alpha54);
    }

    @Override
    public void unbind() {
        // Nothing to do
    }
}
