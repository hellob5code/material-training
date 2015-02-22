package com.training.android.material.ui.adapter;

import android.app.Activity;
import android.graphics.Point;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.training.android.material.R;
import com.training.android.material.ui.card.*;

import java.util.List;

import static com.training.android.material.ui.card.Card.*;

public class MaterialCardAdapter extends RecyclerView.Adapter {

    private final int sreenWidth;
    private final int maxCardWdth;
    private List<Card> dataset;

    public MaterialCardAdapter(Activity activity, List<Card> dataset) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        sreenWidth = size.x;
        maxCardWdth = activity.getResources().getDimensionPixelSize(R.dimen.card_max_width_material);
        this.dataset = dataset;
    }

    @Override
    public int getItemViewType(int position) {
        return dataset.get(position).getViewType();
    }

    /**
     * Create new views (invoked by the layout manager). Set the view's size, margins, paddings and layout parameters.
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case TYPE_SUBHEADER: {
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_subheader_material, parent, false);
                viewHolder = new SubheaderCard.ViewHolder(v);
                break;
            }
            case TYPE_HEADLINE_BODY_1: {
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_headline_body1_material, parent, false);
                viewHolder = new HeadlineBodyCard.ViewHolder(v);
                break;
            }
            case TYPE_HEADLINE_BODY_1_THREE_BUTTON: {
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_headline_body1_three_button_material, parent, false);
                viewHolder = new HeadlineBodyThreeButtonCard.ViewHolder(v);
                break;
            }
            case TYPE_HEADLINE_BODY_1_SIX_VERTICAL_BUTTON: {
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_headline_body1_six_vertical_button_material, parent, false);
                viewHolder = new HeadlineBodySixVerticalButtonCard.ViewHolder(v);
                break;
            }
            case TYPE_PRIMARY_HEADLINE_BODY_2: {
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_primary_headline_body2_material, parent, false);
                viewHolder = new HeadlineBodyCard.ViewHolder(v);
                break;
            }
            case TYPE_ACCENT_HEADLINE_BODY_2: {
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_accent_headline_body2_material, parent, false);
                viewHolder = new HeadlineBodyCard.ViewHolder(v);
                break;
            }
            case TYPE_RICH_AREA_HEADLINE_BODY_1: {
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_rich_area_headline_body1_material, parent, false);
                viewHolder = new RichAreaHeadlineBodyCard.ViewHolder(v);
                break;
            }
        }

//        View card = v.findViewById(R.id.card);
//        if (card != null && sreenWidth > maxCardWdth) {
//            card.getLayoutParams().width = maxCardWdth;
//        }
        if (sreenWidth > maxCardWdth) {
            v.getLayoutParams().width = maxCardWdth;
        }

        return viewHolder;
    }

    /**
     * Replace the contents of a view (invoked by the layout manager). Get element from your dataset at this position
     * and replace the contents of the view with that element.
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        Card card = dataset.get(position);
        ((Card.CardHolder) viewHolder).bindView(card, position);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
