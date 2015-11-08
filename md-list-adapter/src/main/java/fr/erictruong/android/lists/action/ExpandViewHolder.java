package fr.erictruong.android.lists.action;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import fr.erictruong.android.core.util.ThemeUtils;
import fr.erictruong.android.core.util.ViewUtils;
import fr.erictruong.android.lists.MaterialListTileViewHolder;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.state.TextViewHolder;

public class ExpandViewHolder<T> extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<ExpandItem, T> {

    private TextViewHolder<T> textHolder;

    @NonNull
    private TextView text1;
    @NonNull
    private CheckBox checkbox;

    @ColorInt
    private int defaultColor, colorAccent;

    public ExpandViewHolder(View itemView) {
        super(itemView);
        textHolder = new TextViewHolder<>(itemView);
        text1 = (TextView) itemView.findViewById(R.id.text1);
        defaultColor = text1.getTextColors().getDefaultColor();
        colorAccent = ThemeUtils.obtainColorAccent(itemView.getContext());
        checkbox = (CheckBox) itemView.findViewById(R.id.checkbox);
        checkbox.setButtonDrawable(R.drawable.selector_expand);
        int marginSmall = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_small);
        ViewUtils.expandTouchArea(itemView, checkbox, marginSmall);
    }

    @Override
    public void bind(final ExpandItem item, final T object) {
        textHolder.bind(item, object);
        text1.setTextColor(item.isChecked ? colorAccent : defaultColor);
        checkbox.setChecked(item.isChecked);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                text1.setTextColor(isChecked ? colorAccent : defaultColor);
                item.checkAction.onCheckedChanged(buttonView, isChecked, object);
            }
        });
    }

    @Override
    public void unbind() {
        textHolder.unbind();
        checkbox.setOnCheckedChangeListener(null);
    }
}
