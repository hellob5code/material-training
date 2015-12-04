package fr.erictruong.android.lists.stub;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import fr.erictruong.android.core.util.ViewUtils;
import fr.erictruong.android.lists.Bindable;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.item.Checkable;

public class SwitchStub  extends BaseStub implements Bindable<Checkable> {

    @NonNull
    private Switch aSwitch;

    public SwitchStub(View view) {
        super(view);
        aSwitch = (Switch) view.findViewById(R.id.a_switch);
        int marginSmall = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_small);
        ViewUtils.expandTouchArea(view, aSwitch, marginSmall);
    }

    @Override
    public void bind(final Checkable item) {
        aSwitch.setChecked(item.isChecked());
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                item.setChecked(isChecked);
                item.getCheckAction().onAction(buttonView, item);
            }
        });
    }

    @Override
    public void unbind() {
        aSwitch.setOnCheckedChangeListener(null);
    }
}
