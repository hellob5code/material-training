package fr.erictruong.material.training.ui.components.subheaders;

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
import fr.erictruong.android.lists.MaterialListItem;
import fr.erictruong.android.lists.MaterialListItemMapper;
import fr.erictruong.android.lists.OnActionListener;
import fr.erictruong.android.lists.SectionedListAdapter;
import fr.erictruong.android.lists.state.AvatarItem;
import fr.erictruong.material.training.model.DummyModel;

import static fr.erictruong.android.lists.MaterialListAdapter.VIEW_TYPE_TWO_LINE_AVATAR;

public class SampleListSubheaderActivity extends RecyclerActivity {

    private static final int ITEM_COUNT = 42;

    public static void start(Context context) {
        Intent starter = new Intent(context, SampleListSubheaderActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final RecyclerView recyclerView = getRecyclerView();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MaterialListAdapter<DummyModel> adapter = new MaterialListAdapter<>(new MaterialListItemMapper<DummyModel>() {
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

        List<SectionedListAdapter.Section> sections = new ArrayList<>();
        sections.add(new SectionedListAdapter.Section(0, "Subheader"));
        sections.add(new SectionedListAdapter.Section(5, "Subheader"));
        sections.add(new SectionedListAdapter.Section(12, "Subheader"));
        sections.add(new SectionedListAdapter.Section(14, "Subheader"));
        sections.add(new SectionedListAdapter.Section(20, "Subheader"));

        SectionedListAdapter sectionedAdapter = new SectionedListAdapter(adapter);
        sectionedAdapter.setSections(sections.toArray(new SectionedListAdapter.Section[sections.size()]));

        recyclerView.setAdapter(sectionedAdapter);

        DummyModel item = new DummyModel(0, "http://placehold.it/100/888/888/", "Two-line item", "Secondary text", "Tertiary text");
        List<DummyModel> items = new ArrayList<>(ITEM_COUNT);
        for (int i = 0; i < ITEM_COUNT; i++) {
            items.add(new DummyModel(i, item.getAvatarUrl(), item.getText1(), item.getText2(), item.getText3()));
        }
        adapter.swapData(items);
    }
}
