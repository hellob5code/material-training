package com.training.android.material.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.training.android.material.R;
import com.training.android.material.ui.card.*;

import java.util.List;

import static com.training.android.material.ui.card.Card.*;

public class MaterialCardAdapter extends RecyclerView.Adapter {

    private List<Card> dataset;

    public MaterialCardAdapter(List<Card> dataset) {
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
            viewHolder = new HeaderCard.ViewHolder(v);
        } else if (viewType == TYPE_HEADLINE_BODY_1) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_headline_body1_material, parent, false);
            viewHolder = new HeadlineBodyCard.ViewHolder(v);
        } else if (viewType == TYPE_HEADLINE_BODY_1_THREE_BUTTON) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_headline_body1_three_button_material, parent, false);
            viewHolder = new HeadlineBodyThreeButtonCard.ViewHolder(v);
        } else if (viewType == TYPE_HEADLINE_BODY_1_SIX_VERTICAL_BUTTON) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_headline_body1_six_vertical_button_material, parent, false);
            viewHolder = new HeadlineBodySixVerticalButtonCard.ViewHolder(v);
        } else if (viewType == TYPE_PRIMARY_HEADLINE_BODY_2) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_primary_headline_body2_material, parent, false);
            viewHolder = new HeadlineBodyCard.ViewHolder(v);
        } else if (viewType == TYPE_ACCENT_HEADLINE_BODY_2) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_accent_headline_body2_material, parent, false);
            viewHolder = new HeadlineBodyCard.ViewHolder(v);
        } else if (viewType == TYPE_RICH_AREA_HEADLINE_BODY_1) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_rich_area_headline_body1_material, parent, false);
            viewHolder = new RichAreaHeadlineBodyCard.ViewHolder(v);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == TYPE_HEADER) {
            HeaderCard card = (HeaderCard) dataset.get(position);
            ((HeaderCard.ViewHolder) viewHolder).setup(card);
        } else if (viewType == TYPE_HEADLINE_BODY_1
                || viewType == TYPE_PRIMARY_HEADLINE_BODY_2
                || viewType == TYPE_ACCENT_HEADLINE_BODY_2) {
            HeadlineBodyCard card = (HeadlineBodyCard) dataset.get(position);
            ((HeadlineBodyCard.ViewHolder) viewHolder).setup(card);
        } else if (viewType == TYPE_HEADLINE_BODY_1_THREE_BUTTON) {
            HeadlineBodyThreeButtonCard card = (HeadlineBodyThreeButtonCard) dataset.get(position);
            ((HeadlineBodyThreeButtonCard.ViewHolder) viewHolder).setup(card);
        } else if (viewType == TYPE_HEADLINE_BODY_1_SIX_VERTICAL_BUTTON) {
            HeadlineBodySixVerticalButtonCard card = (HeadlineBodySixVerticalButtonCard) dataset.get(position);
            ((HeadlineBodySixVerticalButtonCard.ViewHolder) viewHolder).setup(card);
        }else if (viewType == TYPE_RICH_AREA_HEADLINE_BODY_1) {
            RichAreaHeadlineBodyCard card = (RichAreaHeadlineBodyCard) dataset.get(position);
            ((RichAreaHeadlineBodyCard.ViewHolder) viewHolder).setup(card);
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
