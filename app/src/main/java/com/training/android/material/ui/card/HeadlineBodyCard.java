package com.training.android.material.ui.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;
import org.apache.commons.lang3.StringUtils;

public class HeadlineBodyCard extends Card {

    protected String headline, body1;

    public HeadlineBodyCard(int id, String headline, String body1) {
        this(id, TYPE_HEADLINE_BODY_1, headline, body1);
    }

    public HeadlineBodyCard(int id, int viewType, String headline, String body1) {
        super(id, viewType);
        this.headline = headline;
        this.body1 = body1;
    }

    public String getHeadline() {
        return headline;
    }

    public String getBody1() {
        return body1;
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements CardHolder {

        @InjectView(R.id.tv_headline) TextView tvHeadline;
        @InjectView(R.id.tv_body) TextView tvBody1;
        @InjectView(R.id.space_headline_body) Space spaceHeadlineBody1;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }

        @Override
        public void bindView(Card card, int position) {
            HeadlineBodyCard c = (HeadlineBodyCard) card;
            bindView(c.getHeadline(), c.getBody1());
        }

        protected void bindView(String headline, String body1) {
            // Hide headline view if text empty
            if (StringUtils.isNotEmpty(headline)) {
                tvHeadline.setVisibility(View.VISIBLE);
                tvHeadline.setText(headline);
            } else {
                tvHeadline.setVisibility(View.GONE);
            }
            // Hide body view if text empty
            if (StringUtils.isNotEmpty(body1)) {
                tvBody1.setVisibility(View.VISIBLE);
                tvBody1.setText(body1);
            } else {
                tvBody1.setVisibility(View.GONE);
            }

            if (tvHeadline.getVisibility() == View.GONE || tvBody1.getVisibility() == View.GONE) {
                spaceHeadlineBody1.setVisibility(View.GONE);
            }
        }
    }
}
