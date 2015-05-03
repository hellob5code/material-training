package fr.erictruong.training.material.ui.fragment;

import android.content.Intent;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.activity.ContactsActivity;
import fr.erictruong.training.material.ui.activity.MyFilesActivity;
import fr.erictruong.training.material.ui.card.Card;
import fr.erictruong.training.material.ui.card.DisplayBodyCard;
import fr.erictruong.training.material.ui.card.HeadlineBodyThreeButtonCard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static android.support.v7.widget.RecyclerView.NO_ID;
import static fr.erictruong.training.material.ui.card.Card.TYPE_PRIMARY_DISPLAY_1_BODY_2;

public class BottomSheetsFragment extends MaterialTrainingNavigationDrawerFragment {

    @Override
    protected List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<>();
        dataset.add(new DisplayBodyCard(NO_ID, TYPE_PRIMARY_DISPLAY_1_BODY_2, getString(R.string.fragment_bottom_sheets), getString(R.string.fragment_bottom_sheets_txt)));
        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_bottom_sheets_list_style), null,
                "Example #1",
                "#2",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), ContactsActivity.class));
                        return null;
                    }
                },
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), MyFilesActivity.class));
                        return null;
                    }
                }));
        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_bottom_sheets_grid_style), null, "Example #1", null));
        return dataset;
    }
}
