package fr.erictruong.material.training.ui.components.lists_controls;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import fr.erictruong.android.lists.item.AvatarItem;
import fr.erictruong.android.lists.item.CheckBoxIconItem;
import fr.erictruong.android.lists.item.IconExpandItem;
import fr.erictruong.android.lists.item.IconSwitchItem;
import fr.erictruong.android.lists.item.MaterialListItem;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.model.DummyModel;

import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_CHECKBOX;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_REORDER;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_CHECKBOX_ICON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON_EXPAND;
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

        MaterialListAdapter adapter = new MaterialListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        int viewType = getIntent().getIntExtra(EXTRA_LIST_VIEW_TYPE, -1);

        List<MaterialListItem> items = new ArrayList<>(ITEM_COUNT);
        for (int i = 0; i < ITEM_COUNT; i++) {
            DummyModel dummyModel = new DummyModel(i, "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text");
            MaterialListItem item = mapItem(viewType, dummyModel);
            items.add(item);
        }
        adapter.swapData(items);
    }

    @NonNull
    private MaterialListItem mapItem(int viewType, DummyModel model) {
        switch (viewType) {
            case VIEW_TYPE_ONE_LINE_CHECKBOX_ICON:
                return mapOneLineCheckboxIconItem(viewType, model);
            case VIEW_TYPE_ONE_LINE_AVATAR_CHECKBOX:
                return mapOneLineAvatarCheckboxItem(viewType, model);
            case VIEW_TYPE_ONE_LINE_ICON_SWITCH:
                return mapOneLineIconSwitchItem(viewType, model);
            case VIEW_TYPE_ONE_LINE_AVATAR_REORDER:
                return mapOneLineAvatarReorderItem(viewType, model);
            case VIEW_TYPE_ONE_LINE_ICON_EXPAND:
                return mapOneLineIconExpandItem(viewType, model);
            default:
                throw new IllegalArgumentException("Unknown view type: " + viewType);
        }
    }

    @NonNull
    private MaterialListItem mapOneLineCheckboxIconItem(int viewType, DummyModel model) {
        return new CheckBoxIconItem.Builder()
                .id(model.getId())
                .icon(R.drawable.ic_message_24dp_alpha54)
                .text1(model.getText1())
                .action(new OnActionListener<CheckBoxIconItem>() {
                    @Override
                    public void onAction(View v, CheckBoxIconItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .actionPrimary(new OnCheckActionListener<CheckBoxIconItem>() {
                    @Override
                    public void onAction(View v, CheckBoxIconItem item) {
                        Snackbar.make(getRecyclerView(), "Primary action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    @NonNull
    private MaterialListItem mapOneLineAvatarCheckboxItem(int viewType, DummyModel model) {
        return new AvatarCheckBoxItem.Builder()
                .id(model.getId())
                .avatarUrl(model.getAvatarUrl())
                .text1(model.getText1())
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
    }

    @NonNull
    private MaterialListItem mapOneLineIconSwitchItem(int viewType, DummyModel model) {
        return new IconSwitchItem.Builder()
                .id(model.getId())
                .icon(R.drawable.gray)
                .text1(model.getText1())
                .action(new OnActionListener<IconSwitchItem>() {
                    @Override
                    public void onAction(View v, IconSwitchItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .actionSecondary(new OnCheckActionListener<IconSwitchItem>() {
                    @Override
                    public void onAction(View v, IconSwitchItem item) {
                        Snackbar.make(getRecyclerView(), "Secondary action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    @NonNull
    private MaterialListItem mapOneLineAvatarReorderItem(int viewType, DummyModel model) {
        return new AvatarItem.Builder()
                .id(model.getId())
                .viewType(viewType)
                .avatarUrl(model.getAvatarUrl())
                .text1(model.getText1())
                .action(new OnActionListener<AvatarItem>() {
                    @Override
                    public void onAction(View v, AvatarItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    @NonNull
    private MaterialListItem mapOneLineIconExpandItem(int viewType, DummyModel model) {
        return new IconExpandItem.Builder()
                .id(model.getId())
                .icon(R.drawable.gray)
                .text1(model.getText1())
                .action(new OnActionListener<IconExpandItem>() {
                    @Override
                    public void onAction(View v, IconExpandItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .actionSecondary(new OnCheckActionListener<IconExpandItem>() {
                    @Override
                    public void onAction(View v, IconExpandItem item) {
                        Snackbar.make(getRecyclerView(), "Secondary action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }
}
