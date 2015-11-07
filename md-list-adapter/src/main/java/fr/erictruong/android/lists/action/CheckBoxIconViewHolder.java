package fr.erictruong.android.lists.action;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import fr.erictruong.android.core.util.ViewUtils;
import fr.erictruong.android.lists.MaterialListTileViewHolder;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.state.IconViewHolder;

public class CheckBoxIconViewHolder<T> extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<CheckBoxIconItem, T> {

    private IconViewHolder<T> iconHolder;

    @NonNull
    private CheckBox checkbox;

    public CheckBoxIconViewHolder(View itemView) {
        super(itemView);
        iconHolder = new IconViewHolder<>(itemView);
        checkbox = (CheckBox) itemView.findViewById(R.id.checkbox);
        int marginSmall = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_small);
        ViewUtils.expandTouchArea(itemView, checkbox, marginSmall);
    }

    @Override
    public void bind(final CheckBoxIconItem item, final T object) {
        iconHolder.bind(item, object);
        checkbox.setChecked(item.isChecked);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                item.actionPrimary.onCheckedChanged(buttonView, isChecked, object);
            }
        });
    }

    @Override
    public void unbind() {
        iconHolder.unbind();
        checkbox.setOnCheckedChangeListener(null);
    }
}
