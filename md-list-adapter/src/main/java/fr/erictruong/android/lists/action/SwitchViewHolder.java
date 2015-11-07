package fr.erictruong.android.lists.action;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import fr.erictruong.android.core.util.ViewUtils;
import fr.erictruong.android.lists.MaterialListTileViewHolder;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.state.TextViewHolder;

public class SwitchViewHolder<T> extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<CheckBoxItem, T> {

    private TextViewHolder<T> textHolder;

    @NonNull
    private Switch toggle;

    public SwitchViewHolder(View itemView) {
        super(itemView);
        textHolder = new TextViewHolder<>(itemView);
        toggle = (Switch) itemView.findViewById(R.id.toggle);
        int marginSmall = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_small);
        ViewUtils.expandTouchArea(itemView, toggle, marginSmall);
    }

    @Override
    public void bind(final CheckBoxItem item, final T object) {
        textHolder.bind(item, object);
        toggle.setChecked(item.isChecked);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                item.checkAction.onCheckedChanged(buttonView, isChecked, object);
            }
        });
    }

    @Override
    public void unbind() {
        textHolder.unbind();
        toggle.setOnCheckedChangeListener(null);
    }
}
