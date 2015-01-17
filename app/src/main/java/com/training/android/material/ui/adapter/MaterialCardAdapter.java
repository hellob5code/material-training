package com.training.android.material.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.training.android.material.R;
import com.training.android.material.ui.card.*;

import java.util.List;

import static com.training.android.material.ui.card.HeaderCard.TYPE_HEADER;
import static com.training.android.material.ui.card.HeadlineOneBodyCard.TYPE_HEADLINE_ONE_BODY;
import static com.training.android.material.ui.card.HeadlineOneBodySixVerticalButtonCard.TYPE_HEADLINE_ONE_BODY_SIX_VERTICAL_BUTTON;
import static com.training.android.material.ui.card.HeadlineOneBodyThreeButtonCard.TYPE_HEADLINE_ONE_BODY_THREE_BUTTON;
import static com.training.android.material.ui.card.RichAreaHeadlineOneBodyCard.TYPE_RICH_AREA_HEADLINE_ONE_BODY;

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
            viewHolder = new HeaderCardViewHolder(v);
        } else if (viewType == TYPE_HEADLINE_ONE_BODY) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_headline_one_body_material, parent, false);
            viewHolder = new HeadlineOneBodyCardViewHolder(v);
        } else if (viewType == TYPE_HEADLINE_ONE_BODY_THREE_BUTTON) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_headline_one_body_three_button_material, parent, false);
            viewHolder = new HeadlineOneBodyThreeButtonCardViewHolder(v);
        } else if (viewType == TYPE_HEADLINE_ONE_BODY_SIX_VERTICAL_BUTTON) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_headline_one_body_six_vertical_button_material, parent, false);
            viewHolder = new HeadlineOneBodySixVerticalButtonCardViewHolder(v);
        } else if (viewType == TYPE_RICH_AREA_HEADLINE_ONE_BODY) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_rich_area_headline_one_body_material, parent, false);
            viewHolder = new RichAreaHeadlineOneBodyCardViewHolder(v);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == TYPE_HEADER) {
            HeaderCard card = (HeaderCard) dataset.get(position);
            ((HeaderCardViewHolder) viewHolder).setup(card);
        } else if (viewType == TYPE_HEADLINE_ONE_BODY) {
            HeadlineOneBodyCard card = (HeadlineOneBodyCard) dataset.get(position);
            ((HeadlineOneBodyCardViewHolder) viewHolder).setup(card);
        } else if (viewType == TYPE_HEADLINE_ONE_BODY_THREE_BUTTON) {
            HeadlineOneBodyThreeButtonCard card = (HeadlineOneBodyThreeButtonCard) dataset.get(position);
            ((HeadlineOneBodyThreeButtonCardViewHolder) viewHolder).setup(card);
        } else if (viewType == TYPE_HEADLINE_ONE_BODY_SIX_VERTICAL_BUTTON) {
            HeadlineOneBodySixVerticalButtonCard card = (HeadlineOneBodySixVerticalButtonCard) dataset.get(position);
            ((HeadlineOneBodySixVerticalButtonCardViewHolder) viewHolder).setup(card);
        }else if (viewType == TYPE_RICH_AREA_HEADLINE_ONE_BODY) {
            RichAreaHeadlineOneBodyCard card = (RichAreaHeadlineOneBodyCard) dataset.get(position);
            ((RichAreaHeadlineOneBodyCardViewHolder) viewHolder).setup(card);
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
