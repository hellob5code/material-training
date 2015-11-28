package fr.erictruong.android.lists.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import fr.erictruong.android.core.util.ViewUtils;
import fr.erictruong.android.lists.MaterialListTileViewHolder;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.item.CheckBoxItem;

public class SwitchViewHolder extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<CheckBoxItem> {

    private TextViewHolder textHolder;

    @NonNull
    private Switch toggle;

    public SwitchViewHolder(View itemView) {
        super(itemView);
        textHolder = new TextViewHolder(itemView);
        toggle = (Switch) itemView.findViewById(R.id.toggle);
        int marginSmall = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_small);
        ViewUtils.expandTouchArea(itemView, toggle, marginSmall);
    }

    @Override
    public void bind(final CheckBoxItem item) {
        textHolder.bind(item);
        toggle.setChecked(item.isChecked());
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                item.setIsChecked(isChecked);
                item.getCheckAction().onAction(buttonView, item);
            }
        });
    }

    @Override
    public void unbind() {
        textHolder.unbind();
        toggle.setOnCheckedChangeListener(null);
    }
}
