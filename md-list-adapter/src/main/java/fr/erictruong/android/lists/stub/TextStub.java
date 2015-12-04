package fr.erictruong.android.lists.stub;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import fr.erictruong.android.lists.Bindable;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.item.Textable;

public class TextStub extends BaseStub implements Bindable<Textable> {

    @NonNull
    private TextView text1;
    @Nullable
    private TextView text2;
    @Nullable
    private TextView text3;

    public TextStub(View view) {
        super(view);
        this.text1 = (TextView) view.findViewById(R.id.text1);
        this.text2 = (TextView) view.findViewById(R.id.text2);
        this.text3 = (TextView) view.findViewById(R.id.text3);
    }

    @Override
    public void bind(final Textable item) {
        text1.setText(item.getText1());
        if (text2 != null) {
            text2.setText(item.getText2());
        }
        if (text3 != null) {
            text3.setText(item.getText3());
        }
    }

    @Override
    public void unbind() {
        // Nothing to do
    }
}
