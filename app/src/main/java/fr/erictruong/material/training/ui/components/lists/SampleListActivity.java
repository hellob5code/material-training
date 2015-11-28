package fr.erictruong.material.training.ui.components.lists;

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
import fr.erictruong.android.lists.MaterialListItem;
import fr.erictruong.android.lists.OnActionListener;
import fr.erictruong.android.lists.item.AvatarIconItem;
import fr.erictruong.android.lists.item.AvatarItem;
import fr.erictruong.android.lists.item.IconItem;
import fr.erictruong.android.lists.item.TextItem;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.model.DummyModel;

import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_ICON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_AVATAR;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_AVATAR_ICON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_ICON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_AVATAR;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_AVATAR_ICON;
import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_ICON;

public class SampleListActivity extends RecyclerActivity {

    public static final String EXTRA_LIST_VIEW_TYPE = "extra_list_view_type";

    private static final int ITEM_COUNT = 42;

    public static void start(Context context, int viewType) {
        Intent starter = new Intent(context, SampleListActivity.class);
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
            case VIEW_TYPE_ONE_LINE:
                return mapOneLineItem(viewType, model);
            case VIEW_TYPE_ONE_LINE_ICON:
                return mapOneLineIconItem(viewType, model);
            case VIEW_TYPE_ONE_LINE_AVATAR:
                return mapOneLineAvatarItem(viewType, model);
            case VIEW_TYPE_ONE_LINE_AVATAR_ICON:
                return mapOneLineAvatarIconItem(viewType, model);
            case VIEW_TYPE_TWO_LINE:
                return mapTwoLineItem(viewType, model);
            case VIEW_TYPE_TWO_LINE_ICON:
                return mapTwoLineIconItem(viewType, model);
            case VIEW_TYPE_TWO_LINE_AVATAR:
                return mapTwoLineAvatarItem(viewType, model);
            case VIEW_TYPE_TWO_LINE_AVATAR_ICON:
                return mapTwoLineAvatarIconItem(viewType, model);
            case VIEW_TYPE_THREE_LINE:
                return mapThreeLineItem(viewType, model);
            case VIEW_TYPE_THREE_LINE_ICON:
                return mapThreeLineIconItem(viewType, model);
            case VIEW_TYPE_THREE_LINE_AVATAR:
                return mapThreeLineAvatarItem(viewType, model);
            case VIEW_TYPE_THREE_LINE_AVATAR_ICON:
                return mapThreeLineAvatarIconItem(viewType, model);
            default:
                throw new IllegalArgumentException("Unknown view type: " + viewType);
        }
    }

    @NonNull
    private MaterialListItem mapOneLineItem(int viewType, DummyModel model) {
        return new TextItem.Builder()
                .id(model.getId())
                .text1("Single-line item")
                .action(new OnActionListener<TextItem>() {
                    @Override
                    public void onAction(View v, TextItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    @NonNull
    private MaterialListItem mapOneLineIconItem(int viewType, DummyModel model) {
        return new IconItem.Builder()
                .id(model.getId())
                .icon(R.drawable.gray)
                .text1("Single-line item")
                .action(new OnActionListener<IconItem>() {
                    @Override
                    public void onAction(View v, IconItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    @NonNull
    private MaterialListItem mapOneLineAvatarItem(int viewType, DummyModel model) {
        return new AvatarItem.Builder()
                .id(model.getId())
                .avatarUrl(model.getAvatarUrl())
                .text1("Single-line item")
                .action(new OnActionListener<AvatarItem>() {
                    @Override
                    public void onAction(View v, AvatarItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    @NonNull
    private MaterialListItem mapOneLineAvatarIconItem(int viewType, DummyModel model) {
        return new AvatarIconItem.Builder()
                .id(model.getId())
                .avatarUrl(model.getAvatarUrl())
                .icon(R.drawable.gray)
                .text1("Single-line item")
                .action(new OnActionListener<AvatarIconItem>() {
                    @Override
                    public void onAction(View v, AvatarIconItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    @NonNull
    private MaterialListItem mapTwoLineItem(int viewType, DummyModel model) {
        return new TextItem.Builder()
                .id(model.getId())
                .viewType(viewType)
                .text1("Two-line item")
                .text2(model.getText2())
                .action(new OnActionListener<TextItem>() {
                    @Override
                    public void onAction(View v, TextItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    @NonNull
    private MaterialListItem mapTwoLineIconItem(int viewType, DummyModel model) {
        return new IconItem.Builder()
                .id(model.getId())
                .viewType(viewType)
                .icon(R.drawable.gray)
                .text1("Two-line item")
                .text2(model.getText2())
                .action(new OnActionListener<IconItem>() {
                    @Override
                    public void onAction(View v, IconItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    @NonNull
    private MaterialListItem mapTwoLineAvatarItem(int viewType, DummyModel model) {
        return new AvatarItem.Builder()
                .id(model.getId())
                .viewType(viewType)
                .avatarUrl(model.getAvatarUrl())
                .text1("Two-line item")
                .text2(model.getText2())
                .action(new OnActionListener<AvatarItem>() {
                    @Override
                    public void onAction(View v, AvatarItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    @NonNull
    private MaterialListItem mapTwoLineAvatarIconItem(int viewType, DummyModel model) {
        return new AvatarIconItem.Builder()
                .id(model.getId())
                .viewType(viewType)
                .avatarUrl(model.getAvatarUrl())
                .icon(R.drawable.gray)
                .text1("Two-line item")
                .text2(model.getText2())
                .action(new OnActionListener<AvatarIconItem>() {
                    @Override
                    public void onAction(View v, AvatarIconItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    @NonNull
    private MaterialListItem mapThreeLineItem(int viewType, DummyModel model) {
        return new TextItem.Builder()
                .id(model.getId())
                .viewType(viewType)
                .text1("Three-line item")
                .text2(model.getText2())
                .text3(model.getText3())
                .action(new OnActionListener<TextItem>() {
                    @Override
                    public void onAction(View v, TextItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    @NonNull
    private MaterialListItem mapThreeLineIconItem(int viewType, DummyModel model) {
        return new IconItem.Builder()
                .id(model.getId())
                .viewType(viewType)
                .icon(R.drawable.gray)
                .text1("Three-line item")
                .text2(model.getText2())
                .text3(model.getText3())
                .action(new OnActionListener<IconItem>() {
                    @Override
                    public void onAction(View v, IconItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    @NonNull
    private MaterialListItem mapThreeLineAvatarItem(int viewType, DummyModel model) {
        return new AvatarItem.Builder()
                .id(model.getId())
                .viewType(viewType)
                .avatarUrl(model.getAvatarUrl())
                .text1("Three-line item")
                .text2(model.getText2())
                .text3(model.getText3())
                .action(new OnActionListener<AvatarItem>() {
                    @Override
                    public void onAction(View v, AvatarItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    @NonNull
    private MaterialListItem mapThreeLineAvatarIconItem(int viewType, DummyModel model) {
        return new AvatarIconItem.Builder()
                .id(model.getId())
                .viewType(viewType)
                .avatarUrl(model.getAvatarUrl())
                .icon(R.drawable.gray)
                .text1("Three-line item")
                .text2(model.getText2())
                .text3(model.getText3())
                .action(new OnActionListener<AvatarIconItem>() {
                    @Override
                    public void onAction(View v, AvatarIconItem item) {
                        Snackbar.make(getRecyclerView(), "Action #" + item.getId(), Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }
}
