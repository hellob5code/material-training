package com.training.android.material.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.training.android.material.R;
import com.training.android.material.ui.activity.*;
import com.training.android.material.ui.adapter.MaterialCardAdapter;
import com.training.android.material.ui.card.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static com.training.android.material.ui.card.Card.TYPE_PRIMARY_HEADLINE_BODY_2;

public class TextFieldsCardFragment extends CardFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerAdapter(new MaterialCardAdapter(getActivity(), populateDataset()));
    }

    private List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<Card>();
        dataset.add(new HeadlineBodyCard(0, TYPE_PRIMARY_HEADLINE_BODY_2, getString(R.string.fragment_text_fields), getString(R.string.fragment_text_fields_txt)));
        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_text_fields_single_line_text_field), null,
                "Example #1",
                "#2",
                "#3",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), RegisterEventActivity.class));
                        return null;
                    }
                },
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), RegisterContactActivity.class));
                        return null;
                    }
                },
                null));
        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_text_fields_floating_labels), null,
                "Example #1",
                "#2",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), RegisterApplicationActivity.class));
                        return null;
                    }
                },
                null));
        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_text_fields_multi_line_text_field), null,
                "Example #1",
                "#2",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), RegisterApplicationActivity.class));
                        return null;
                    }
                },
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), RegisterApplicationActivity.class));
                        return null;
                    }
                }));
        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_text_fields_full_width_text_field), null,
                "Example #1",
                "#2",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), ComposeEmailActivity.class));
                        return null;
                    }
                },
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), ComposeEmailActivity.class));
                        return null;
                    }
                }));
        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_text_fields_character_counter), null,
                "Example #1",
                "#2",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), RegisterNoteActivity.class));
                        return null;
                    }
                },
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), ComposeEmailActivity.class));
                        return null;
                    }
                }));
        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_text_fields_auto_complete_text_field), null,
                "Example #1",
                null,
                null,
                null,
                null,
                null));
        dataset.add(new HeadlineBodyThreeButtonCard(0, getString(R.string.fragment_text_fields_search_filter), null,
                "Example #1",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), SearchableActivity.class));
                        return null;
                    }
                }));
        return dataset;
    }
}
