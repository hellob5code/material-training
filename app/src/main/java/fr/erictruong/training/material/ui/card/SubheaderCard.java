package fr.erictruong.training.material.ui.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import fr.erictruong.training.material.R;

public class SubheaderCard extends Card {

    private CharSequence subhead;

    public SubheaderCard(long id, CharSequence subhead) {
        super(id, TYPE_SUBHEADER);
        this.subhead = subhead;
    }

    public CharSequence getSubhead() {
        return subhead;
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements CardHolder {

        @InjectView(R.id.tv_subhead) TextView tvSubhead;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }

        @Override
        public void bindView(Card card, int position) {
            SubheaderCard c = (SubheaderCard) card;
            bindView(c.getSubhead());
        }

        protected void bindView(CharSequence text) {
            tvSubhead.setText(text);
        }
    }
}
