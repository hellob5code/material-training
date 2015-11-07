package fr.erictruong.android.lists.action;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import fr.erictruong.android.core.util.ViewUtils;
import fr.erictruong.android.lists.MaterialListTileViewHolder;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.state.TextViewHolder;

public class CheckBoxViewHolder<T> extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<CheckBoxItem, T> {

    private TextViewHolder<T> textHolder;

    @NonNull
    private CheckBox checkbox;

    public CheckBoxViewHolder(View itemView) {
        super(itemView);
        textHolder = new TextViewHolder<>(itemView);
        checkbox = (CheckBox) itemView.findViewById(R.id.checkbox);
        int marginSmall = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_small);
        ViewUtils.expandTouchArea(itemView, checkbox, marginSmall);
    }

    @Override
    public void bind(final CheckBoxItem item, final T object) {
        textHolder.bind(item, object);
        checkbox.setChecked(item.isChecked);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
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
