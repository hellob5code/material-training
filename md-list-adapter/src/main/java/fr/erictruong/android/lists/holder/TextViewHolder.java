package fr.erictruong.android.lists.holder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.erictruong.android.lists.MaterialListTileViewHolder;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.item.TextItem;


public class TextViewHolder extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<TextItem> {

    @NonNull
    private TextView text1;
    @Nullable
    private TextView text2;
    @Nullable
    private TextView text3;

    public TextViewHolder(View itemView) {
        super(itemView);
        text1 = (TextView) itemView.findViewById(R.id.text1);
        text2 = (TextView) itemView.findViewById(R.id.text2);
        text3 = (TextView) itemView.findViewById(R.id.text3);
    }

    @Override
    public void bind(final TextItem item) {
        text1.setText(item.getText1());
        if (text2 != null) {
            text2.setText(item.getText2());
        }
        if (text3 != null) {
            text3.setText(item.getText3());
        }
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.getAction() != null) {
                    item.getAction().onAction(v, item);
                }
            }
        });
    }

    @Override
    public void unbind() {
        // Nothing to do
    }
}
