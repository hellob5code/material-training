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

import fr.erictruong.android.lists.AvatarIconItem;
import fr.erictruong.android.lists.AvatarItem;
import fr.erictruong.android.lists.IconItem;
import fr.erictruong.android.lists.MaterialListAdapter;
import fr.erictruong.android.lists.MaterialListItem;
import fr.erictruong.android.lists.MaterialListItemMapper;
import fr.erictruong.android.lists.OnActionListener;
import fr.erictruong.android.lists.TextItem;
import fr.erictruong.material.training.R;
import fr.erictruong.material.training.model.DummyModel;
import fr.erictruong.android.core.activity.RecyclerActivity;

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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final int viewType = getIntent().getIntExtra(EXTRA_LIST_VIEW_TYPE, -1);
        MaterialListAdapter<DummyModel> adapter = newAdapter(viewType);
        recyclerView.setAdapter(adapter);

        DummyModel item = newItem(viewType);
        List<DummyModel> items = new ArrayList<>(ITEM_COUNT);
        for (int i = 0; i < ITEM_COUNT; i++) {
            items.add(new DummyModel(i, item.getAvatarUrl(), item.getText1(), item.getText2(), item.getText3()));
        }
        adapter.swapData(items);
    }

    @NonNull
    private DummyModel newItem(int viewType) {
        DummyModel item = new DummyModel(0, "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text");
        switch (viewType) {
            case VIEW_TYPE_ONE_LINE:
            case VIEW_TYPE_ONE_LINE_ICON:
            case VIEW_TYPE_ONE_LINE_AVATAR:
            case VIEW_TYPE_ONE_LINE_AVATAR_ICON:
                item.setText1("Single-line item");
                break;
            case VIEW_TYPE_TWO_LINE:
            case VIEW_TYPE_TWO_LINE_ICON:
            case VIEW_TYPE_TWO_LINE_AVATAR:
            case VIEW_TYPE_TWO_LINE_AVATAR_ICON:
                item.setText1("Two-line item");
                break;
            case VIEW_TYPE_THREE_LINE:
            case VIEW_TYPE_THREE_LINE_ICON:
            case VIEW_TYPE_THREE_LINE_AVATAR:
            case VIEW_TYPE_THREE_LINE_AVATAR_ICON:
                item.setText1("Three-line item");
                break;
            default:
                throw new IllegalArgumentException("Unknown view type: " + viewType);
        }
        return item;
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newAdapter(int viewType) {
        switch (viewType) {
            case VIEW_TYPE_ONE_LINE:
                return newOneLineAdapter();
            case VIEW_TYPE_ONE_LINE_ICON:
                return newOneLineIconAdapter();
            case VIEW_TYPE_ONE_LINE_AVATAR:
                return newOneLineAvatarAdapter();
            case VIEW_TYPE_ONE_LINE_AVATAR_ICON:
                return newOneLineAvatarIconAdapter();
            case VIEW_TYPE_TWO_LINE:
                return newTwoLineAdapter();
            case VIEW_TYPE_TWO_LINE_ICON:
                return newTwoLineIconAdapter();
            case VIEW_TYPE_TWO_LINE_AVATAR:
                return newTwoLineAvatarAdapter();
            case VIEW_TYPE_TWO_LINE_AVATAR_ICON:
                return newTwoLineAvatarIconAdapter();
            case VIEW_TYPE_THREE_LINE:
                return newThreeLineAdapter();
            case VIEW_TYPE_THREE_LINE_ICON:
                return newThreeLineIconAdapter();
            case VIEW_TYPE_THREE_LINE_AVATAR:
                return newThreeLineAvatarAdapter();
            case VIEW_TYPE_THREE_LINE_AVATAR_ICON:
                return newThreeLineAvatarIconAdapter();
            default:
                throw new IllegalArgumentException("Unknown view type: " + viewType);
        }
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newOneLineAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
            @Override
            public MaterialListItem map(DummyModel item) {
                return new TextItem.Builder()
                        .id(item.getId())
                        .text1(item.getText1())
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        });
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newOneLineIconAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
            @Override
            public MaterialListItem map(DummyModel item) {
                return new IconItem.Builder()
                        .id(item.getId())
                        .icon(R.drawable.gray)
                        .text1(item.getText1())
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        });
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newOneLineAvatarAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
            @Override
            public MaterialListItem map(DummyModel item) {
                return new AvatarItem.Builder()
                        .id(item.getId())
                        .avatarUrl(item.getAvatarUrl())
                        .text1(item.getText1())
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        });
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newOneLineAvatarIconAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
            @Override
            public MaterialListItem map(DummyModel item) {
                return new AvatarIconItem.Builder()
                        .id(item.getId())
                        .avatarUrl(item.getAvatarUrl())
                        .icon(R.drawable.gray)
                        .text1(item.getText1())
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        });
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newTwoLineAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
            @Override
            public MaterialListItem map(DummyModel item) {
                return new TextItem.Builder()
                        .id(item.getId())
                        .viewType(VIEW_TYPE_TWO_LINE)
                        .text1(item.getText1())
                        .text2(item.getText2())
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        });
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newTwoLineIconAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
            @Override
            public MaterialListItem map(DummyModel item) {
                return new IconItem.Builder()
                        .id(item.getId())
                        .viewType(VIEW_TYPE_TWO_LINE_ICON)
                        .icon(R.drawable.gray)
                        .text1(item.getText1())
                        .text2(item.getText2())
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        });
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newTwoLineAvatarAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
            @Override
            public MaterialListItem map(DummyModel item) {
                return new AvatarItem.Builder()
                        .id(item.getId())
                        .viewType(VIEW_TYPE_TWO_LINE_AVATAR)
                        .avatarUrl(item.getAvatarUrl())
                        .text1(item.getText1())
                        .text2(item.getText2())
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        });
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newTwoLineAvatarIconAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
            @Override
            public MaterialListItem map(DummyModel item) {
                return new AvatarIconItem.Builder()
                        .id(item.getId())
                        .viewType(VIEW_TYPE_TWO_LINE_AVATAR_ICON)
                        .avatarUrl(item.getAvatarUrl())
                        .icon(R.drawable.gray)
                        .text1(item.getText1())
                        .text2(item.getText2())
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        });
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newThreeLineAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
            @Override
            public MaterialListItem map(DummyModel item) {
                return new TextItem.Builder()
                        .id(item.getId())
                        .viewType(VIEW_TYPE_THREE_LINE)
                        .text1(item.getText1())
                        .text2(item.getText2())
                        .text3(item.getText3())
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        });
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newThreeLineIconAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
            @Override
            public MaterialListItem map(DummyModel item) {
                return new IconItem.Builder()
                        .id(item.getId())
                        .viewType(VIEW_TYPE_THREE_LINE_ICON)
                        .icon(R.drawable.gray)
                        .text1(item.getText1())
                        .text2(item.getText2())
                        .text3(item.getText3())
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        });
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newThreeLineAvatarAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
            @Override
            public MaterialListItem map(DummyModel item) {
                return new AvatarItem.Builder()
                        .id(item.getId())
                        .viewType(VIEW_TYPE_THREE_LINE_AVATAR)
                        .avatarUrl(item.getAvatarUrl())
                        .text1(item.getText1())
                        .text2(item.getText2())
                        .text3(item.getText3())
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        });
    }

    @NonNull
    private MaterialListAdapter<DummyModel> newThreeLineAvatarIconAdapter() {
        return new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
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
                        .action(new OnActionListener<DummyModel>() {
                            @Override
                            public void onClick(View v, DummyModel item) {
                                Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        });
    }
}
