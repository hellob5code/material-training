package fr.erictruong.material.training.ui.components.lists_controls;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

import fr.erictruong.android.core.activity.RecyclerActivity;
import fr.erictruong.android.lists.MaterialListAdapter;
import fr.erictruong.android.lists.MaterialListItem;
import fr.erictruong.android.lists.MaterialListItemMapper;
import fr.erictruong.android.lists.OnActionListener;
import fr.erictruong.android.lists.OnCheckActionListener;
import fr.erictruong.android.lists.action.AvatarCheckBoxItem;
import fr.erictruong.android.lists.action.CheckBoxIconItem;
import fr.erictruong.android.lists.action.IconSwitchItem;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.model.DummyModel;

import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_CHECKBOX;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_CHECKBOX_ICON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON_SWITCH;

public class SampleListControlActivity extends RecyclerActivity {

    public static final String EXTRA_LIST_VIEW_TYPE = "extra_list_view_type";

    private static final int ITEM_COUNT = 42;

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

        final int viewType = getIntent().getIntExtra(EXTRA_LIST_VIEW_TYPE, -1);
        MaterialListAdapter<DummyModel> adapter = newAdapter(viewType);
        recyclerView.setAdapter(adapter);

        DummyModel item = new DummyModel(0, "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text");
        List<DummyModel> items = new ArrayList<>(ITEM_COUNT);
        for (int i = 0; i < ITEM_COUNT; i++) {
            items.add(new DummyModel(i, item.getAvatarUrl(), item.getText1(), item.getText2(), item.getText3()));
        }
        adapter.swapData(items);
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newAdapter(int viewType) {
        switch (viewType) {
            case VIEW_TYPE_ONE_LINE_CHECKBOX_ICON:
                return newOneLineCheckboxIconAdapter();
            case VIEW_TYPE_ONE_LINE_AVATAR_CHECKBOX:
                return newOneLineAvatarCheckboxAdapter();
            case VIEW_TYPE_ONE_LINE_ICON_SWITCH:
                return newOneLineIconSwitchAdapter();
            default:
                throw new IllegalArgumentException("Unknown view type: " + viewType);
        }
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newOneLineCheckboxIconAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
            @Override
            public MaterialListItem map(DummyModel item) {
                return new CheckBoxIconItem.Builder()
                        .id(item.getId())
                        .isChecked(item.getFlag())
                        .icon(R.drawable.ic_message_24dp_alpha54)
                        .text1(item.getText1())
                        .text2(item.getText2())
                        .text3(item.getText3())
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .actionPrimary(new OnCheckActionListener<DummyModel>() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Primary action " + item, Snackbar.LENGTH_SHORT).show();
                                item.setFlag(isChecked);
                            }
                        })
                        .build();
            }
        });
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newOneLineAvatarCheckboxAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
            @Override
            public MaterialListItem map(DummyModel item) {
                return new AvatarCheckBoxItem.Builder()
                        .id(item.getId())
                        .avatarUrl(item.getAvatarUrl())
                        .isChecked(item.getFlag())
                        .text1(item.getText1())
                        .text2(item.getText2())
                        .text3(item.getText3())
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .actionSecondary(new OnCheckActionListener<DummyModel>() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Secondary action " + item, Snackbar.LENGTH_SHORT).show();
                                item.setFlag(isChecked);
                            }
                        })
                        .build();
            }
        });
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newOneLineIconSwitchAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
            @Override
            public MaterialListItem map(DummyModel item) {
                return new IconSwitchItem.Builder()
                        .id(item.getId())
                        .icon(R.drawable.gray)
                        .isChecked(item.getFlag())
                        .text1(item.getText1())
                        .text2(item.getText2())
                        .text3(item.getText3())
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .actionSecondary(new OnCheckActionListener<DummyModel>() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Secondary action " + item, Snackbar.LENGTH_SHORT).show();
                                item.setFlag(isChecked);
                            }
                        })
                        .build();
            }
        });
    }
}
