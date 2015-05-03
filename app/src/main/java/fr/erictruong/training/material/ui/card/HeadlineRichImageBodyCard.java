package fr.erictruong.training.material.ui.card;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Picasso;
import fr.erictruong.training.material.R;

public class HeadlineRichImageBodyCard extends HeadlineBodyCard {

    protected int resourceId;

    public HeadlineRichImageBodyCard(long id, int resourceId, CharSequence headline, CharSequence body1) {
        this(id, TYPE_HEADLINE_RICH_IMAGE_BODY_1, resourceId, headline, body1);
    }

    public HeadlineRichImageBodyCard(long id, int viewType, int resourceId, CharSequence headline, CharSequence body1) {
        super(id, viewType, headline, body1);
        this.resourceId = resourceId;
    }

    public int getDrawableId() {
        return resourceId;
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class ViewHolder extends HeadlineBodyCard.ViewHolder {

        @InjectView(R.id.img) ImageView img;
        private final Context context;

        public ViewHolder(final CardView v) {
            super(v);
            context = v.getContext();
            ButterKnife.inject(this, v);
        }

        @Override
        public void bindView(Card card, int position) {
            HeadlineRichImageBodyCard c = (HeadlineRichImageBodyCard) card;
            bindView(c.getDrawableId(), c.getHeadline(), c.getBody());
        }

        protected void bindView(final int resourceId, CharSequence headline, CharSequence body1) {
            super.bindView(headline, body1);
            itemView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        itemView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        itemView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    Picasso.with(context)
                            .load(resourceId)
                            .resize(itemView.getWidth(), 0)
                            .into(img);
                }
            });
        }
    }
}
