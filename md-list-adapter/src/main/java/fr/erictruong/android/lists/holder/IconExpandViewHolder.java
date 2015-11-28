package fr.erictruong.android.lists.holder;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import fr.erictruong.android.core.util.ThemeUtils;
import fr.erictruong.android.core.util.ViewUtils;
import fr.erictruong.android.lists.MaterialListTileViewHolder;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.item.IconExpandItem;

public class IconExpandViewHolder extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<IconExpandItem> {

    private TextViewHolder textHolder;

    @NonNull
    private ImageView icon;
    @NonNull
    private TextView text1;
    @NonNull
    private CheckBox checkbox;

    @ColorInt
    private int defaultColor, colorAccent;

    public IconExpandViewHolder(View itemView) {
        super(itemView);
        icon = (ImageView) itemView.findViewById(R.id.icon);
        textHolder = new TextViewHolder(itemView);
        text1 = (TextView) itemView.findViewById(R.id.text1);
        defaultColor = text1.getTextColors().getDefaultColor();
        colorAccent = ThemeUtils.obtainColorAccent(itemView.getContext());
        checkbox = (CheckBox) itemView.findViewById(R.id.checkbox);
        checkbox.setButtonDrawable(R.drawable.selector_expand);
        int marginSmall = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_small);
        ViewUtils.expandTouchArea(itemView, checkbox, marginSmall);
    }

    @Override
    public void bind(final IconExpandItem item) {
        icon.setImageResource(item.getIcon());
        if (item.isChecked()) {
            icon.setColorFilter(colorAccent);
        } else {
            icon.clearColorFilter();
        }
        textHolder.bind(item);
        text1.setTextColor(item.isChecked() ? colorAccent : defaultColor);
        checkbox.setChecked(item.isChecked());
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    icon.setColorFilter(colorAccent);
                } else {
                    icon.clearColorFilter();
                }
                text1.setTextColor(isChecked ? colorAccent : defaultColor);
                item.setIsChecked(isChecked);
                item.getCheckAction().onAction(buttonView, item);
            }
        });
    }

    @Override
    public void unbind() {
        textHolder.unbind();
        checkbox.setOnCheckedChangeListener(null);
    }
}
