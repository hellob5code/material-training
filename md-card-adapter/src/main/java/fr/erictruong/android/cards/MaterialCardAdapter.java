package fr.erictruong.android.cards;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import fr.erictruong.android.cards.item.DisplayBodyViewHolder;
import fr.erictruong.android.cards.item.HeadlineBodyViewHolder;

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

    public static final int VIEW_TYPE_IMAGE_BODY1 = 20;
    public static final int VIEW_TYPE_AVATAR_TITLE_SUBTITLE_IMAGE_BODY1_THREE_BUTTON = 25;
    public static final int VIEW_TYPE_AVATAR_TITLE_SUBTITLE_IMAGE_BODY1_SIX_BUTTON = 30;
    public static final int VIEW_TYPE_IMAGE_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON_EXPAND = 35;
    public static final int VIEW_TYPE_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON = 40;
    public static final int VIEW_TYPE_IMAGE_THREE_ICON = 45;
    public static final int VIEW_TYPE_IMAGE_THREE_ICON_VERTICAL = 50;
    public static final int VIEW_TYPE_BACKGROUND_HEADLINE_SUBTITLE_BODY1_THREE_BUTTON = 55;
    public static final int VIEW_TYPE_IMAGE_HEADLINE_THREE_ICON = 60;
    public static final int VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON = 65;
    public static final int VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON_SMALL = 70;
    public static final int VIEW_TYPE_HEADLINE_SUBTITLE_IMAGE_THREE_BUTTON_LARGE = 75;

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
        switch (viewType) {
            case VIEW_TYPE_DISPLAY1_BODY1:
                return new DisplayBodyViewHolder(inflater.inflate(R.layout.card_display1_body1, parent, false));
            case VIEW_TYPE_DISPLAY1_PRIMARY_BODY1:
                return new DisplayBodyViewHolder(inflater.inflate(R.layout.card_display1_primary_body1, parent, false));
            case VIEW_TYPE_DISPLAY1_BODY2:
                return new DisplayBodyViewHolder(inflater.inflate(R.layout.card_display1_body2, parent, false));
            case VIEW_TYPE_DISPLAY1_PRIMARY_BODY2:
                return new DisplayBodyViewHolder(inflater.inflate(R.layout.card_display1_primary_body2, parent, false));
            case VIEW_TYPE_HEADLINE_BODY1:
                return new HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_body1, parent, false));
            case VIEW_TYPE_HEADLINE_BODY1_THREE_BUTTON:
                return new HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_body1_three_button, parent, false));
            case VIEW_TYPE_HEADLINE_BODY1_SIX_BUTTON:
                return new HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_body1_six_button, parent, false));
            case VIEW_TYPE_HEADLINE_BODY2:
                return new HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_body2, parent, false));
            case VIEW_TYPE_HEADLINE_PRIMARY_BODY1:
                return new HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_primary_body1, parent, false));
            case VIEW_TYPE_HEADLINE_PRIMARY_BODY1_THREE_BUTTON:
                return new HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_primary_body1_three_button, parent, false));
            case VIEW_TYPE_HEADLINE_PRIMARY_BODY1_SIX_BUTTON:
                return new HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_primary_body1_six_button, parent, false));
            case VIEW_TYPE_HEADLINE_PRIMARY_BODY2:
                return new HeadlineBodyViewHolder(inflater.inflate(R.layout.card_headline_primary_body2, parent, false));
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
