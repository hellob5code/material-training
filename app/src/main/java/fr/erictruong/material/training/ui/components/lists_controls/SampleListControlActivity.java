package fr.erictruong.material.training.ui.components.lists_controls;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.model.DummyModel;
import fr.erictruong.material.training.ui.components.lists.MaterialListAdapter;
import fr.erictruong.material.training.ui.components.lists.MaterialListItem;
import fr.erictruong.material.training.ui.components.lists.MaterialListItemMapper;
import fr.erictruong.material.training.ui.components.lists.OnActionListener;
import fr.erictruong.material.training.ui.core.activity.RecyclerActivity;

import static fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_CHECKBOX_ICON;

public class SampleListControlActivity extends RecyclerActivity {

    public static final String EXTRA_LIST_VIEW_TYPE = "extra_list_view_type";

    private MaterialListAdapter<DummyModel> adapter;
    private List<DummyModel> items;

    public static void start(Context context, int viewType) {
        Intent starter = new Intent(context, SampleListControlActivity.class);
        starter.putExtra(EXTRA_LIST_VIEW_TYPE, viewType);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final RecyclerView recyclerView = getRecyclerView();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DummyModel item = new DummyModel(0, "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text");

        final int viewType = getIntent().getIntExtra(EXTRA_LIST_VIEW_TYPE, -1);
        switch (viewType) {
            case VIEW_TYPE_ONE_LINE_CHECKBOX_ICON:
                adapter = new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
                    @Override
                    public MaterialListItem map(DummyModel item) {
                        return new CheckBoxIconItem.Builder()
                                .id(item.getId())
                                .isChecked(false)
                                .icon(R.drawable.ic_message_24dp_alpha54)
                                .text1(item.getText1())
                                .text2(item.getText2())
                                .text3(item.getText3())
                                .action(new OnActionListener<DummyModel>() {
                                    @Override
                                    public void onClick(View v, DummyModel item) {
                                        Snackbar.make(recyclerView, "Action " + item, Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .actionPrimary(new OnCheckActionListener<DummyModel>() {
                                    @Override
                                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked, DummyModel item) {
                                        Snackbar.make(recyclerView, "Primary action " + item, Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .build();
                    }
                });
                break;
            default:
                throw new IllegalArgumentException("Unknown view type: " + viewType);
        }
        recyclerView.setAdapter(adapter);

        items = new ArrayList<>();
        for (int i = 0; i < 42; i++) {
            items.add(new DummyModel(i, item.getAvatarUrl(), item.getText1(), item.getText2(), item.getText3()));
        }
        adapter.swapData(items);
    }
}
