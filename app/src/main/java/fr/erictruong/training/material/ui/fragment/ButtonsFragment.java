package fr.erictruong.training.material.ui.fragment;

import android.content.Intent;
import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.activity.DummyInlineButtons1Activity;
import fr.erictruong.training.material.ui.activity.DummyInlineButtons2Activity;
import fr.erictruong.training.material.ui.activity.DummyInlineButtons3Activity;
import fr.erictruong.training.material.ui.activity.DummyPersistentFooterButtonsActivity;
import fr.erictruong.training.material.ui.card.Card;
import fr.erictruong.training.material.ui.card.DisplayBodyCard;
import fr.erictruong.training.material.ui.card.HeadlineBodyCard;
import fr.erictruong.training.material.ui.card.HeadlineBodyThreeButtonCard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static android.support.v7.widget.RecyclerView.NO_ID;
import static fr.erictruong.training.material.ui.card.Card.TYPE_PRIMARY_DISPLAY_1_BODY_2;

public class ButtonsFragment extends MaterialTrainingNavigationDrawerFragment {

    @Override
    protected List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<>();
        dataset.add(new DisplayBodyCard(NO_ID, TYPE_PRIMARY_DISPLAY_1_BODY_2, getString(R.string.fragment_buttons), getString(R.string.fragment_buttons_txt)));
//        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_buttons_buttons_in_dialogs), null, "Example #1", null));
//        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_buttons_buttons_inline), null, "Example #1",
//                new Callable() {
//                    public Void call() {
//                        startActivity(new Intent(getActivity(), DummyInlineButtons1Activity.class));
//                        return null;
//                    }
//                }));
//        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_buttons_persistent_footer_buttons), null, "Example #1",
//                new Callable() {
//                    public Void call() {
//                        startActivity(new Intent(getActivity(), DummyPersistentFooterButtonsActivity.class));
//                        return null;
//                    }
//                }));
//        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_buttons_raised_buttons), null, "Example #1", "#2", "#3",
//                new Callable() {
//                    public Void call() {
//                        startActivity(new Intent(getActivity(), DummyInlineButtons2Activity.class));
//                        return null;
//                    }
//                },
//                new Callable() {
//                    public Void call() {
//                        startActivity(new Intent(getActivity(), DummyInlineButtons3Activity.class));
//                        return null;
//                    }
//                },
//                null));
//        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_buttons_flat_buttons), null, "Example #1", null));
//        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_buttons_floating_action_button), null, "Example #1", null));
        return dataset;
    }
}
