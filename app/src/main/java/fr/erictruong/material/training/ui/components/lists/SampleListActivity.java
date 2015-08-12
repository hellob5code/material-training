package fr.erictruong.material.training.ui.components.lists;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.model.DummyModel;

import static fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE;
import static fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR;
import static fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_ICON;
import static fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON;
import static fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE;
import static fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_AVATAR;
import static fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_AVATAR_ICON;
import static fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.VIEW_TYPE_THREE_LINE_ICON;
import static fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE;
import static fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_AVATAR;
import static fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_AVATAR_ICON;
import static fr.erictruong.material.training.ui.components.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_ICON;

public class SampleListActivity extends AppCompatActivity {

    public static final String EXTRA_LIST_VIEW_TYPE = "extra_list_view_type";

    @Bind(R.id.recycler_view) RecyclerView recyclerView;

    public static void start(Context context, int viewType) {
        Intent starter = new Intent(context, SampleListActivity.class);
        starter.putExtra(EXTRA_LIST_VIEW_TYPE, viewType);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DummyModel item = new DummyModel(0, "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text");

        MaterialListAdapter<DummyModel> adapter;
        final int viewType = getIntent().getIntExtra(EXTRA_LIST_VIEW_TYPE, -1);
        switch (viewType) {
            case VIEW_TYPE_ONE_LINE:
                adapter = new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
                    @Override
                    public MaterialListItem map(DummyModel item) {
                        return new TextItem.Builder()
                                .id(item.getId())
                                .text1(item.getText1())
                                .action(new OnActionListener<TextItem>() {
                                    @Override
                                    public void onClick(View v, TextItem item) {
                                        Snackbar.make(recyclerView, "Action ID=" + item.id + "!", Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .build();
                    }
                });
                item.setText1("Single-line item");
                break;
            case VIEW_TYPE_ONE_LINE_ICON:
                adapter = new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
                    @Override
                    public MaterialListItem map(DummyModel item) {
                        return new IconItem.Builder()
                                .id(item.getId())
                                .icon(R.drawable.gray)
                                .text1(item.getText1())
                                .action(new OnActionListener<IconItem>() {
                                    @Override
                                    public void onClick(View v, IconItem item) {
                                        Snackbar.make(recyclerView, "Action ID=" + item.id + "!", Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .build();
                    }
                });
                item.setText1("Single-line item");
                break;
            case VIEW_TYPE_ONE_LINE_AVATAR:
                adapter = new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
                    @Override
                    public MaterialListItem map(DummyModel item) {
                        return new AvatarItem.Builder()
                                .id(item.getId())
                                .avatarUrl(item.getAvatarUrl())
                                .text1(item.getText1())
                                .action(new OnActionListener<AvatarItem>() {
                                    @Override
                                    public void onClick(View v, AvatarItem item) {
                                        Snackbar.make(recyclerView, "Action ID=" + item.id + "!", Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .build();
                    }
                });
                item.setText1("Single-line item");
                break;
            case VIEW_TYPE_ONE_LINE_AVATAR_ICON:
                adapter = new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
                    @Override
                    public MaterialListItem map(DummyModel item) {
                        return new AvatarIconItem.Builder()
                                .id(item.getId())
                                .avatarUrl(item.getAvatarUrl())
                                .icon(R.drawable.gray)
                                .text1(item.getText1())
                                .action(new OnActionListener<AvatarIconItem>() {
                                    @Override
                                    public void onClick(View v, AvatarIconItem item) {
                                        Snackbar.make(recyclerView, "Action ID=" + item.id + "!", Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .build();
                    }
                });
                item.setText1("Single-line item");
                break;
            case VIEW_TYPE_TWO_LINE:
                adapter = new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
                    @Override
                    public MaterialListItem map(DummyModel item) {
                        return new TextItem.Builder()
                                .id(item.getId())
                                .viewType(VIEW_TYPE_TWO_LINE)
                                .text1(item.getText1())
                                .text2(item.getText2())
                                .action(new OnActionListener<TextItem>() {
                                    @Override
                                    public void onClick(View v, TextItem item) {
                                        Snackbar.make(recyclerView, "Action ID=" + item.id + "!", Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .build();
                    }
                });
                item.setText1("Two-line item");
                break;
            case VIEW_TYPE_TWO_LINE_ICON:
                adapter = new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
                    @Override
                    public MaterialListItem map(DummyModel item) {
                        return new IconItem.Builder()
                                .id(item.getId())
                                .viewType(VIEW_TYPE_TWO_LINE_ICON)
                                .icon(R.drawable.gray)
                                .text1(item.getText1())
                                .text2(item.getText2())
                                .action(new OnActionListener<IconItem>() {
                                    @Override
                                    public void onClick(View v, IconItem item) {
                                        Snackbar.make(recyclerView, "Action ID=" + item.id + "!", Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .build();
                    }
                });
                item.setText1("Two-line item");
                break;
            case VIEW_TYPE_TWO_LINE_AVATAR:
                adapter = new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
                    @Override
                    public MaterialListItem map(DummyModel item) {
                        return new AvatarItem.Builder()
                                .id(item.getId())
                                .viewType(VIEW_TYPE_TWO_LINE_AVATAR)
                                .avatarUrl(item.getAvatarUrl())
                                .text1(item.getText1())
                                .text2(item.getText2())
                                .action(new OnActionListener<AvatarItem>() {
                                    @Override
                                    public void onClick(View v, AvatarItem item) {
                                        Snackbar.make(recyclerView, "Action ID=" + item.id + "!", Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .build();
                    }
                });
                item.setText1("Two-line item");
                break;
            case VIEW_TYPE_TWO_LINE_AVATAR_ICON:
                adapter = new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
                    @Override
                    public MaterialListItem map(DummyModel item) {
                        return new AvatarIconItem.Builder()
                                .id(item.getId())
                                .viewType(VIEW_TYPE_TWO_LINE_AVATAR_ICON)
                                .avatarUrl(item.getAvatarUrl())
                                .icon(R.drawable.gray)
                                .text1(item.getText1())
                                .text2(item.getText2())
                                .action(new OnActionListener<AvatarIconItem>() {
                                    @Override
                                    public void onClick(View v, AvatarIconItem item) {
                                        Snackbar.make(recyclerView, "Action ID=" + item.id + "!", Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .build();
                    }
                });
                item.setText1("Two-line item");
                break;
            case VIEW_TYPE_THREE_LINE:
                adapter = new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
                    @Override
                    public MaterialListItem map(DummyModel item) {
                        return new TextItem.Builder()
                                .id(item.getId())
                                .viewType(VIEW_TYPE_THREE_LINE)
                                .text1(item.getText1())
                                .text2(item.getText2())
                                .text3(item.getText3())
                                .action(new OnActionListener<TextItem>() {
                                    @Override
                                    public void onClick(View v, TextItem item) {
                                        Snackbar.make(recyclerView, "Action ID=" + item.id + "!", Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .build();
                    }
                });
                item.setText1("Three-line item");
                break;
            case VIEW_TYPE_THREE_LINE_ICON:
                adapter = new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
                    @Override
                    public MaterialListItem map(DummyModel item) {
                        return new IconItem.Builder()
                                .id(item.getId())
                                .viewType(VIEW_TYPE_THREE_LINE_ICON)
                                .icon(R.drawable.gray)
                                .text1(item.getText1())
                                .text2(item.getText2())
                                .text3(item.getText3())
                                .action(new OnActionListener<IconItem>() {
                                    @Override
                                    public void onClick(View v, IconItem item) {
                                        Snackbar.make(recyclerView, "Action ID=" + item.id + "!", Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .build();
                    }
                });
                item.setText1("Three-line item");
                break;
            case VIEW_TYPE_THREE_LINE_AVATAR:
                adapter = new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
                    @Override
                    public MaterialListItem map(DummyModel item) {
                        return new AvatarItem.Builder()
                                .id(item.getId())
                                .viewType(VIEW_TYPE_THREE_LINE_AVATAR)
                                .avatarUrl(item.getAvatarUrl())
                                .text1(item.getText1())
                                .text2(item.getText2())
                                .text3(item.getText3())
                                .action(new OnActionListener<AvatarItem>() {
                                    @Override
                                    public void onClick(View v, AvatarItem item) {
                                        Snackbar.make(recyclerView, "Action ID=" + item.id + "!", Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .build();
                    }
                });
                item.setText1("Three-line item");
                break;
            case VIEW_TYPE_THREE_LINE_AVATAR_ICON:
                adapter = new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
                    @Override
                    public MaterialListItem map(DummyModel item) {
                        return new AvatarIconItem.Builder()
                                .id(item.getId())
                                .viewType(VIEW_TYPE_THREE_LINE_AVATAR_ICON)
                                .avatarUrl(item.getAvatarUrl())
                                .icon(R.drawable.gray)
                                .text1(item.getText1())
                                .text2(item.getText2())
                                .text3(item.getText3())
                                .action(new OnActionListener<AvatarIconItem>() {
                                    @Override
                                    public void onClick(View v, AvatarIconItem item) {
                                        Snackbar.make(recyclerView, "Action ID=" + item.id + "!", Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .build();
                    }
                });
                item.setText1("Three-line item");
                break;
            default:
                throw new IllegalArgumentException("Unknown view type: " + viewType);
        }
        recyclerView.setAdapter(adapter);

        List<DummyModel> items = new ArrayList<>();
        for (int i = 0; i < 42; i++) {
            items.add(new DummyModel(i, item.getAvatarUrl(), item.getText1(), item.getText2(), item.getText3()));
        }
        adapter.swapData(items);
    }
}
