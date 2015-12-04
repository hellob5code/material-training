package fr.erictruong.android.lists.stub;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import fr.erictruong.android.lists.Bindable;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.item.Iconable;

public class IconStub extends BaseStub implements Bindable<Iconable> {

    @NonNull
    private ImageView icon;

    public IconStub(View view) {
        super(view);
        this.icon = (ImageView) view.findViewById(R.id.icon);
    }

    @Override
    public void bind(Iconable item) {
        icon.setImageResource(item.getIcon());
    }

    @Override
    public void unbind() {
        // Nothing to do
    }
}
