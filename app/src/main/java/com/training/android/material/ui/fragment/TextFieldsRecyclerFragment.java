package com.training.android.material.ui.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.training.android.material.R;
import com.training.android.material.ui.activity.*;
import com.training.android.material.ui.adapter.MaterialCardAdapter;
import com.training.android.material.ui.card.*;
import com.training.android.material.util.ApiUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class TextFieldsRecyclerFragment extends RecyclerFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                if (parent.getChildPosition(view) < 1)
                    return;
                if (ApiUtils.isLollipop()) {
                    outRect.top = getResources().getDimensionPixelSize(R.dimen.margin_small);
                } else {
                    outRect.top = getResources().getDimensionPixelSize(R.dimen.margin_xsmall);
                }
            }
        });
        setRecyclerAdapter(new MaterialCardAdapter(populateDataset()));
    }

    private List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<Card>();
        dataset.add(new HeaderCard(0, "Single-line text field"));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Single-line fields", "Single-line fields automatically scroll their content to the left as the text input cursor reaches the right edge of the input field.",
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
        dataset.add(new HeaderCard(0, "Floating labels"));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Floating labels", "With floating inline labels, when the user engages with the text input field, the labels move to float above the field.",
                "Example #1",
                "#2",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), RegisterApplicationActivity.class));
                        return null;
                    }
                },
                null));
        dataset.add(new HeaderCard(0, "Multi-line text field"));
        dataset.add(new HeadlineBodyThreeButtonCard(0, null, "Multi-line text fields automatically break to a new line for overflow text and scroll vertically when the cursor reaches the lower edge.",
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
        dataset.add(new HeaderCard(0, "Full-width text field"));
        dataset.add(new HeadlineBodyThreeButtonCard(0, null, "Full-width text fields are useful for more in-depth tasks.",
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
        dataset.add(new HeaderCard(0, "Character counter"));
        dataset.add(new HeadlineBodyCard(0, null, "Use a character counter in fields where a character restriction is in place."));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Single line with character counter", null,
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
                        startActivity(new Intent(getActivity(), RegisterNoteActivity.class));
                        return null;
                    }
                }));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Multi-line with character counter", null,
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
                        startActivity(new Intent(getActivity(), RegisterNoteActivity.class));
                        return null;
                    }
                }));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Full width with character counter", null,
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
        dataset.add(new HeaderCard(0, "Auto-complete text field"));
        dataset.add(new HeadlineBodyCard(0, null, "Use auto-complete text fields to present real-time suggestions or completions in dropdowns, so users can enter information more accurately and efficiently."));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Full-width auto-complete", null,
                "Example #1",
                null));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Inset auto-complete", null,
                "Example #1",
                null));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Full-width inline auto-complete", null,
                "Example #1",
                null));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "In-line auto-complete", null,
                "Example #1",
                null));
        dataset.add(new HeaderCard(0, "Search filter"));
        dataset.add(new HeadlineBodyCard(0, null, "The app bar can act as a text input field. As the user types, the content underneath it is filtered and sorted."));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Full-width text field in app bar", null,
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
