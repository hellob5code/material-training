package fr.erictruong.training.material.ui.card;

import android.support.v7.widget.CardView;
import android.view.ViewStub;
import butterknife.ButterKnife;
import butterknife.InjectView;
import fr.erictruong.training.material.R;

public class RichAreaHeadlineBodyCard extends HeadlineBodyCard {

    protected int richAreaLayoutId;

    public RichAreaHeadlineBodyCard(long id, int richAreaLayoutId, CharSequence headline, CharSequence body1) {
        this(id, TYPE_RICH_AREA_HEADLINE_BODY_1, richAreaLayoutId, headline, body1);
    }

    public RichAreaHeadlineBodyCard(long id, int viewType, int richAreaLayoutId, CharSequence headline, CharSequence body1) {
        super(id, viewType, headline, body1);
        this.richAreaLayoutId = richAreaLayoutId;
    }

    public int getRichAreaLayoutId() {
        return richAreaLayoutId;
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class ViewHolder extends HeadlineBodyCard.ViewHolder {

        @InjectView(R.id.stub) ViewStub stubRichArea;

        public ViewHolder(CardView v) {
            super(v);
            ButterKnife.inject(this, v);
        }

        @Override
        public void bindView(Card card, int position) {
            RichAreaHeadlineBodyCard c = (RichAreaHeadlineBodyCard) card;
            bindView(c.getRichAreaLayoutId(), c.getHeadline(), c.getBody());
        }

        protected void bindView(int richAreaLayoutId, CharSequence headline, CharSequence body1) {
            super.bindView(headline, body1);
            if (stubRichArea != null) {
                stubRichArea.setLayoutResource(richAreaLayoutId);
                stubRichArea.inflate();
                stubRichArea = null;
            }
        }
    }
}

