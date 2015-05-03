package fr.erictruong.training.material.ui.card;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;
import fr.erictruong.training.material.R;
import org.apache.commons.lang3.StringUtils;

public class HeadlineBodyCard extends Card {

    protected CharSequence headline, body;

    public HeadlineBodyCard(long id, CharSequence headline, CharSequence body) {
        this(id, TYPE_HEADLINE_BODY_1, headline, body);
    }

    public HeadlineBodyCard(long id, int viewType, CharSequence headline, CharSequence body) {
        super(id, viewType);
        this.headline = headline;
        this.body = body;
    }

    public CharSequence getHeadline() {
        return headline;
    }

    public CharSequence getBody() {
        return body;
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements CardHolder {

        @InjectView(R.id.tv_headline) TextView tvHeadline;
        @InjectView(R.id.tv_body) TextView tvBody;
        @Optional @InjectView(R.id.space_headline_body) Space spaceHeadlineBody;

        public ViewHolder(CardView v) {
            super(v);
            ButterKnife.inject(this, v);
        }

        @Override
        public void bindView(Card card, int position) {
            HeadlineBodyCard c = (HeadlineBodyCard) card;
            bindView(c.getHeadline(), c.getBody());
        }

        protected void bindView(CharSequence headline, CharSequence body1) {
            // Hide headline view if text empty
            if (StringUtils.isNotEmpty(headline)) {
                tvHeadline.setVisibility(View.VISIBLE);
                tvHeadline.setText(headline);
            } else {
                tvHeadline.setVisibility(View.GONE);
            }
            // Hide body view if text empty
            if (StringUtils.isNotEmpty(body1)) {
                tvBody.setVisibility(View.VISIBLE);
                tvBody.setText(body1);
            } else {
                tvBody.setVisibility(View.GONE);
            }

            if (spaceHeadlineBody != null) {
                if (tvHeadline.getVisibility() == View.VISIBLE && tvBody.getVisibility() == View.VISIBLE) {
                    spaceHeadlineBody.setVisibility(View.VISIBLE);
                } else {
                    spaceHeadlineBody.setVisibility(View.GONE);
                }
            }
        }
    }
}

