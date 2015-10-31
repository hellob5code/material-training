package fr.erictruong.material.training.ui.components.cards;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import fr.erictruong.material.training.R;

public class MaterialCardAdapter extends RecyclerView.Adapter {

    public static final int VIEW_TYPE_DISPLAY1_BODY1 = 0;
    public static final int VIEW_TYPE_DISPLAY1_PRIMARY_BODY1 = 1;
    public static final int VIEW_TYPE_DISPLAY1_BODY2 = 2;
    public static final int VIEW_TYPE_DISPLAY1_PRIMARY_BODY2 = 3;
    public static final int VIEW_TYPE_HEADLINE_BODY1 = 4;
    public static final int VIEW_TYPE_HEADLINE_BODY1_THREE_BUTTON = 5;
    public static final int VIEW_TYPE_HEADLINE_BODY1_SIX_BUTTON = 6;
    public static final int VIEW_TYPE_HEADLINE_BODY2 = 7;
    public static final int VIEW_TYPE_HEADLINE_PRIMARY_BODY1 = 8;
    public static final int VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON = 9;
    public static final int VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON = 10;
    public static final int VIEW_TYPE_HEADLINE_PRIMARY_BODY2 = 11;

    private List<MaterialCardItem> dataset = Collections.emptyList();

    public MaterialCardAdapter() {
    }

    public void swapData(List<MaterialCardItem> items) {
        this.dataset = items;
        notifyDataSetChanged();
    }

    public MaterialCardItem getItem(int position) {
        return dataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).id;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).viewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView cardView;
        switch (viewType) {
            case VIEW_TYPE_DISPLAY1_BODY1:
                cardView = (CardView) inflater.inflate(R.layout.card_display1_body1, parent, false);
                return new DisplayBodyViewHolder(cardView);
            case VIEW_TYPE_DISPLAY1_PRIMARY_BODY1:
                cardView = (CardView) inflater.inflate(R.layout.card_display1_primary_body1, parent, false);
                return new DisplayBodyViewHolder(cardView);
            case VIEW_TYPE_DISPLAY1_BODY2:
                cardView = (CardView) inflater.inflate(R.layout.card_display1_body2, parent, false);
                return new DisplayBodyViewHolder(cardView);
            case VIEW_TYPE_DISPLAY1_PRIMARY_BODY2:
                cardView = (CardView) inflater.inflate(R.layout.card_display1_primary_body2, parent, false);
                return new DisplayBodyViewHolder(cardView);
            case VIEW_TYPE_HEADLINE_BODY1:
                cardView = (CardView) inflater.inflate(R.layout.card_headline_body1, parent, false);
                return new HeadlineBodyViewHolder(cardView);
            case VIEW_TYPE_HEADLINE_BODY1_THREE_BUTTON:
                cardView = (CardView) inflater.inflate(R.layout.card_headline_body1_three_button, parent, false);
                return new HeadlineBodyViewHolder(cardView);
            case VIEW_TYPE_HEADLINE_BODY1_SIX_BUTTON:
                cardView = (CardView) inflater.inflate(R.layout.card_headline_body1_six_button, parent, false);
                return new HeadlineBodyViewHolder(cardView);
            case VIEW_TYPE_HEADLINE_BODY2:
                cardView = (CardView) inflater.inflate(R.layout.card_headline_body2, parent, false);
                return new HeadlineBodyViewHolder(cardView);
            case VIEW_TYPE_HEADLINE_PRIMARY_BODY1:
                cardView = (CardView) inflater.inflate(R.layout.card_headline_primary_body1, parent, false);
                return new HeadlineBodyViewHolder(cardView);
            case VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON:
                cardView = (CardView) inflater.inflate(R.layout.card_headline_primary_body1_three_button, parent, false);
                return new HeadlineBodyViewHolder(cardView);
            case VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON:
                cardView = (CardView) inflater.inflate(R.layout.card_headline_primary_body1_six_button, parent, false);
                return new HeadlineBodyViewHolder(cardView);
            case VIEW_TYPE_HEADLINE_PRIMARY_BODY2:
                cardView = (CardView) inflater.inflate(R.layout.card_headline_primary_body2, parent, false);
                return new HeadlineBodyViewHolder(cardView);
            default:
                throw new IllegalArgumentException("Unknown view type: " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((MaterialCardViewHolder) viewHolder).bind(getItem(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}