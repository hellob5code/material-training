package fr.erictruong.android.lists.stub;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import fr.erictruong.android.core.util.ViewUtils;
import fr.erictruong.android.lists.Bindable;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.item.Checkable;

public class CheckBoxStub extends BaseStub implements Bindable<Checkable> {

    @NonNull
    private CheckBox checkbox;

    public CheckBoxStub(View view) {
        super(view);
        checkbox = (CheckBox) view.findViewById(R.id.checkbox);
        int marginSmall = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_small);
        ViewUtils.expandTouchArea(view, checkbox, marginSmall);
    }

    @Override
    public void bind(final Checkable item) {
        checkbox.setChecked(item.isChecked());
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                item.setChecked(isChecked);
                item.getCheckAction().onAction(buttonView, item);
            }
        });
    }

    @Override
    public void unbind() {
        checkbox.setOnCheckedChangeListener(null);
    }
}
