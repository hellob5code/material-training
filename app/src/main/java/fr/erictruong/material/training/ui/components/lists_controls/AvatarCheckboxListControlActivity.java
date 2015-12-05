package fr.erictruong.material.training.ui.components.lists_controls;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fr.erictruong.android.core.activity.RecyclerActivity;
import fr.erictruong.android.lists.MaterialListAdapter;
import fr.erictruong.android.lists.OnActionListener;
import fr.erictruong.android.lists.OnCheckActionListener;
import fr.erictruong.android.lists.item.AvatarCheckBoxItem;
import fr.erictruong.android.lists.item.MaterialListItem;
import fr.erictruong.material.training.model.DummyModel;

public class AvatarCheckboxListControlActivity extends RecyclerActivity {

    private static final int ITEM_COUNT = 42;

    private static final DummyModel MODEL = new DummyModel(0, "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text");

    public static void start(Context context) {
        Intent starter = new Intent(context, AvatarCheckboxListControlActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final RecyclerView recyclerView = getRecyclerView();

        MaterialListAdapter adapter = new MaterialListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<MaterialListItem> items = new ArrayList<>(ITEM_COUNT);
        for (int i = 0; i < ITEM_COUNT; i++) {
            MaterialListItem item = new AvatarCheckBoxItem.Builder()
                    .id(i)
                    .avatarUrl(MODEL.getAvatarUrl())
                    .text1(MODEL.getText1())
                    .action(new OnActionListener<AvatarCheckBoxItem>() {
                        @Override
                        public void onAction(View v, AvatarCheckBoxItem item) {
                            Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                        }
                    })
                    .actionSecondary(new OnCheckActionListener<AvatarCheckBoxItem>() {
                        @Override
                        public void onAction(View v, AvatarCheckBoxItem item) {
                            Snackbar.make(getRecyclerView(), "Secondary action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                        }
                    })
                    .build();
            items.add(item);
        }
        adapter.swapData(items);
    }
}
