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

public class DisplayBodyCard extends Card {

    protected CharSequence display, body;

    public DisplayBodyCard(long id, CharSequence display, CharSequence body) {
        this(id, TYPE_DISPLAY_1_BODY_1, display, body);
    }

    public DisplayBodyCard(long id, int viewType, CharSequence display, CharSequence body) {
        super(id, viewType);
        this.display = display;
        this.body = body;
    }

    public CharSequence getDisplay() {
        return display;
    }

    public CharSequence getBody() {
        return body;
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements CardHolder {

        @InjectView(R.id.tv_display) TextView tvDisplay;
        @InjectView(R.id.tv_body) TextView tvBody;
        @Optional @InjectView(R.id.space_display_body) Space spaceDisplayBody;

        public ViewHolder(CardView v) {
            super(v);
            ButterKnife.inject(this, v);
        }

        @Override
        public void bindView(Card card, int position) {
            DisplayBodyCard c = (DisplayBodyCard) card;
            bindView(c.getDisplay(), c.getBody());
        }

        protected void bindView(CharSequence display, CharSequence body1) {
            // Hide display view if text empty
            if (StringUtils.isNotEmpty(display)) {
                tvDisplay.setVisibility(View.VISIBLE);
                tvDisplay.setText(display);
            } else {
                tvDisplay.setVisibility(View.GONE);
            }
            // Hide body view if text empty
            if (StringUtils.isNotEmpty(body1)) {
                tvBody.setVisibility(View.VISIBLE);
                tvBody.setText(body1);
            } else {
                tvBody.setVisibility(View.GONE);
            }

            if (spaceDisplayBody != null) {
                if (tvDisplay.getVisibility() == View.VISIBLE && tvBody.getVisibility() == View.VISIBLE) {
                    spaceDisplayBody.setVisibility(View.VISIBLE);
                } else {
                    spaceDisplayBody.setVisibility(View.GONE);
                }
            }
        }
    }
}

