package fr.erictruong.android.lists;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class TextViewHolder<T> extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<TextItem, T> {

    @NonNull
    private TextView text1;
    @Nullable
    private TextView text2;
    @Nullable
    private TextView text3;

    public TextViewHolder(View view) {
        super(view);
        text1 = (TextView) view.findViewById(R.id.text1);
        text2 = (TextView) view.findViewById(R.id.text2);
        text3 = (TextView) view.findViewById(R.id.text3);
    }

    @Override
    public void bind(final TextItem item, final T object) {
        text1.setText(item.text1);
        if (text2 != null) {
            text2.setText(item.text2);
        }
        if (text3 != null) {
            text3.setText(item.text3);
        }
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.action != null) {
                    item.action.onClick(v, object);
                }
            }
        });
    }
}
