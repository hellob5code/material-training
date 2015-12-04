package fr.erictruong.android.lists.stub;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import fr.erictruong.android.core.util.ThemeUtils;
import fr.erictruong.android.core.util.ViewUtils;
import fr.erictruong.android.lists.Bindable;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.item.Checkable;

public class ExpandStub extends BaseStub implements Bindable<Checkable> {

    @Nullable
    private ImageView icon;
    @NonNull
    private TextView text1;
    @NonNull
    private CheckBox checkbox;

    @ColorInt
    private int defaultColor, colorAccent;

    public ExpandStub(View view) {
        super(view);
        icon = (ImageView) view.findViewById(R.id.icon);
        text1 = (TextView) view.findViewById(R.id.text1);
        defaultColor = text1.getTextColors().getDefaultColor();
        colorAccent = ThemeUtils.obtainColorAccent(view.getContext());
        checkbox = (CheckBox) view.findViewById(R.id.checkbox);
        checkbox.setButtonDrawable(R.drawable.selector_expand);
        int marginSmall = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_small);
        ViewUtils.expandTouchArea(view, checkbox, marginSmall);
    }

    @Override
    public void bind(final Checkable item) {
        if (icon != null) {
            if (item.isChecked()) {
                icon.setColorFilter(colorAccent);
            } else {
                icon.clearColorFilter();
            }
        }
        text1.setTextColor(item.isChecked() ? colorAccent : defaultColor);
        checkbox.setChecked(item.isChecked());
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (icon != null) {
                    if (isChecked) {
                        icon.setColorFilter(colorAccent);
                    } else {
                        icon.clearColorFilter();
                    }
                }
                text1.setTextColor(isChecked ? colorAccent : defaultColor);
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
