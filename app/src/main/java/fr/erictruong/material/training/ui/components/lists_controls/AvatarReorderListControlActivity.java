package fr.erictruong.material.training.ui.components.lists_controls;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fr.erictruong.android.core.activity.RecyclerActivity;
import fr.erictruong.android.lists.MaterialListAdapter;
import fr.erictruong.android.lists.OnActionListener;
import fr.erictruong.android.lists.item.AvatarReorderableItem;
import fr.erictruong.android.lists.item.MaterialListItem;
import fr.erictruong.material.training.model.DummyModel;

public class AvatarReorderListControlActivity extends RecyclerActivity {

    private static final int ITEM_COUNT = 42;

    private static final DummyModel MODEL = new DummyModel(0, "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text");

    public static void start(Context context) {
        Intent starter = new Intent(context, AvatarReorderListControlActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final RecyclerView recyclerView = getRecyclerView();

        MaterialListAdapter adapter = new MaterialListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ReorderItemTouchHelperCallback(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);

        List<MaterialListItem> items = new ArrayList<>(ITEM_COUNT);
        for (int i = 0; i < ITEM_COUNT; i++) {
            MaterialListItem item = new AvatarReorderableItem.Builder()
                    .id(i)
                    .avatarUrl(MODEL.getAvatarUrl())
                    .itemTouchHelper(itemTouchHelper)
                    .text1(MODEL.getText1() + " #" + i)
                    .action(new OnActionListener<AvatarReorderableItem>() {
                        @Override
                        public void onAction(View v, AvatarReorderableItem item) {
                            Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                        }
                    })
                    .build();
            items.add(item);
        }
        adapter.swapData(items);
    }

    public class ReorderItemTouchHelperCallback extends ItemTouchHelper.Callback {

        private final MaterialListAdapter adapter;

        public ReorderItemTouchHelperCallback(MaterialListAdapter adapter) {
            this.adapter = adapter;
        }

        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            return makeMovementFlags(dragFlags, 0);
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            if (viewHolder.getItemViewType() != target.getItemViewType()) {
                return false;
            }

            // Notify the adapter of the move
            adapter.moveItem(viewHolder.getAdapterPosition(), target.getAdapterPosition());
            return true;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            // Not supported
        }

        @Override
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            // We only want the active item to change
            if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                // TODO: Change background appearance.
//                viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
            }
            super.onSelectedChanged(viewHolder, actionState);
        }

        @Override
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            // TODO: Restore default background appearance.
//            viewHolder.itemView.setBackgroundColor(0);
        }
    }
}
