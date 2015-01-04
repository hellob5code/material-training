package com.training.android.material.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;
import com.training.android.material.ui.activity.*;
import com.training.android.material.ui.card.*;
import com.training.android.material.util.ApiUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static com.training.android.material.ui.card.HeaderCard.TYPE_HEADER;
import static com.training.android.material.ui.card.HeadlineOneBodyThreeButtonCard.TYPE_HEADLINE_ONE_BODY_THREE_BUTTON;

public class TextFieldsFragment extends Fragment {

    @InjectView(R.id.recycler_view) RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        ButterKnife.inject(this, view);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
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

        List<Card> dataset = populateDataset();

        mAdapter = new InternalAdapter(dataset);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    private List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<Card>();
        dataset.add(new HeaderCard(Card.TYPE_NONE, "Single-line text field"));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "Single-line fields", "Single-line fields automatically scroll their content to the left as the text input cursor reaches the right edge of the input field.",
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
        dataset.add(new HeaderCard(Card.TYPE_NONE, "Floating labels"));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "Floating labels", "With floating inline labels, when the user engages with the text input field, the labels move to float above the field.",
                "Example #1",
                "#2",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), RegisterApplicationActivity.class));
                        return null;
                    }
                },
                null));
        dataset.add(new HeaderCard(Card.TYPE_NONE, "Multi-line text field"));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, null, "Multi-line text fields automatically break to a new line for overflow text and scroll vertically when the cursor reaches the lower edge.",
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
        dataset.add(new HeaderCard(Card.TYPE_NONE, "Full-width text field"));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, null, "Full-width text fields are useful for more in-depth tasks.",
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
        dataset.add(new HeaderCard(Card.TYPE_NONE, "Character counter"));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, null, "Use a character counter in fields where a character restriction is in place.",
                null,
                null,
                null,
                null));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "Single line with character counter", null,
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
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "Multi-line with character counter", null,
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
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "Full width with character counter", null,
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
        dataset.add(new HeaderCard(Card.TYPE_NONE, "Auto-complete text field"));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, null, "Use auto-complete text fields to present real-time suggestions or completions in dropdowns, so users can enter information more accurately and efficiently.",
                null,
                null));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "Full-width auto-complete", null,
                "Example #1",
                null));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "Inset auto-complete", null,
                "Example #1",
                null));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "Full-width inline auto-complete", null,
                "Example #1",
                null));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "In-line auto-complete", null,
                "Example #1",
                null));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, null, "The app bar can act as a text input field. As the user types, the content underneath it is filtered and sorted.",
                null,
                null));
        dataset.add(new HeaderCard(Card.TYPE_NONE, "Search filter"));
        dataset.add(new HeadlineOneBodyThreeButtonCard(Card.TYPE_NONE, "Full-width text field in app bar", null,
                "Example #1",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), SearchableActivity.class));
                        return null;
                    }
                }));
        return dataset;
    }

    public class InternalAdapter extends RecyclerView.Adapter {

        private List<Card> dataset;

        public InternalAdapter(List<Card> dataset) {
            this.dataset = dataset;
        }

        @Override
        public int getItemViewType(int position) {
            return dataset.get(position).getViewType();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            RecyclerView.ViewHolder viewHolder = null;
            if (viewType == TYPE_HEADER) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_header_material, parent, false);
                viewHolder = new HeaderCardViewHolder(v);
            } else if (viewType == TYPE_HEADLINE_ONE_BODY_THREE_BUTTON) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_headline_one_body_three_button_material, parent, false);
                viewHolder = new HeadlineOneBodyThreeButtonCardViewHolder(v);
            }
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            int viewType = getItemViewType(position);
            if (viewType == TYPE_HEADER) {
                HeaderCard card = (HeaderCard) dataset.get(position);
                ((HeaderCardViewHolder) viewHolder).setup(card);
            } else if (viewType == TYPE_HEADLINE_ONE_BODY_THREE_BUTTON) {
                HeadlineOneBodyThreeButtonCard card = (HeadlineOneBodyThreeButtonCard) dataset.get(position);
                ((HeadlineOneBodyThreeButtonCardViewHolder) viewHolder).setup(card);
            }
        }

        @Override
        public int getItemCount() {
            return dataset.size();
        }
    }
}
