package fr.erictruong.android.lists.stub;

import android.support.annotation.NonNull;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import fr.erictruong.android.lists.Bindable;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.item.Reorderable;

public class ReorderStub extends BaseStub implements Bindable<Reorderable> {

    @NonNull
    private ImageView icon;

    private RecyclerView.ViewHolder holder;

    public ReorderStub(View view) {
        super(view);
        this.icon = (ImageView) view.findViewById(R.id.icon);
    }

    @Override
    public void bind(final Reorderable item) {
        icon.setImageResource(R.drawable.ic_reorder_black_24dp_alpha54);
        icon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    item.getItemTouchHelper().startDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public void unbind() {
        // Nothing to do
    }

    public void setViewHolder(RecyclerView.ViewHolder holder) {
        this.holder = holder;
    }
}
