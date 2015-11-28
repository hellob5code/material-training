package fr.erictruong.material.training.ui.components.subheaders;

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
import fr.erictruong.android.lists.SectionedListAdapter;
import fr.erictruong.android.lists.item.AvatarItem;
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

        MaterialListAdapter adapter = new MaterialListAdapter();
        SectionedListAdapter sectionedAdapter = new SectionedListAdapter(adapter);

        recyclerView.setAdapter(sectionedAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<MaterialListItem> items = new ArrayList<>(ITEM_COUNT);
        for (int i = 0; i < ITEM_COUNT; i++) {
            DummyModel dummyModel = new DummyModel(i, "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text");
            MaterialListItem item = mapItem(VIEW_TYPE_TWO_LINE_AVATAR, dummyModel);
            items.add(item);
        }
        adapter.swapData(items);

        List<SectionedListAdapter.Section> sections = new ArrayList<>();
        sections.add(new SectionedListAdapter.Section(0, "Subheader"));
        sections.add(new SectionedListAdapter.Section(5, "Subheader"));
        sections.add(new SectionedListAdapter.Section(12, "Subheader"));
        sections.add(new SectionedListAdapter.Section(14, "Subheader"));
        sections.add(new SectionedListAdapter.Section(20, "Subheader"));
        sectionedAdapter.setSections(sections.toArray(new SectionedListAdapter.Section[sections.size()]));
    }

    @NonNull
    private MaterialListItem mapItem(int viewType, DummyModel model) {
        return new AvatarItem.Builder()
                .id(model.getId())
                .viewType(viewType)
                .avatarUrl(model.getAvatarUrl())
                .text1(model.getText1())
                .text2(model.getText2())
                .action(new OnActionListener<AvatarItem>() {
                    @Override
                    public void onAction(View v, AvatarItem item) {
                        Snackbar.make(getRecyclerView(), "Action " + item, Snackbar.LENGTH_SHORT).show();
                    }
                })
                .build();
    }
}
