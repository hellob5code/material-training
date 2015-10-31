package fr.erictruong.material.training.ui.components.lists_controls;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.components.lists.IconViewHolder;
import fr.erictruong.material.training.ui.components.lists.MaterialListTileViewHolder;
import fr.erictruong.material.training.util.ViewUtils;

public class CheckBoxIconViewHolder<T> extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<CheckBoxIconItem, T> {

    private IconViewHolder viewHolder;

    @NonNull
    private CheckBox checkbox;

    public CheckBoxIconViewHolder(View view) {
        super(view);
        viewHolder = new IconViewHolder(view);
        checkbox = (CheckBox) view.findViewById(R.id.checkbox);
        int marginSmall = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_small);
        ViewUtils.expandTouchArea(view, checkbox, marginSmall);
    }

    @Override
    public void bind(final CheckBoxIconItem item, final T object) {
        viewHolder.bind(item, object);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                item.actionPrimary.onCheckedChanged(buttonView, isChecked, object);
            }
        });
        checkbox.setChecked(item.isChecked);
    }
}
