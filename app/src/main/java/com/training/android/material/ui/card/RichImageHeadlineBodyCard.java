package com.training.android.material.ui.card;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Picasso;
import com.training.android.material.R;
import com.training.android.material.ui.transformation.RoundedTransformation;
import com.training.android.material.util.ApiUtils;

public class RichImageHeadlineBodyCard extends HeadlineBodyCard {

    protected int resourceId;

    public RichImageHeadlineBodyCard(int id, int resourceId, CharSequence headline, CharSequence body1) {
        this(id, TYPE_RICH_IMAGE_HEADLINE_BODY_1, resourceId, headline, body1);
    }

    public RichImageHeadlineBodyCard(int id, int viewType, int resourceId, CharSequence headline, CharSequence body1) {
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
            if (!ApiUtils.isLollipop()) {
                v.setPreventCornerOverlap(false);
            }
        }

        @Override
        public void bindView(Card card, int position) {
            RichImageHeadlineBodyCard c = (RichImageHeadlineBodyCard) card;
            bindView(c.getDrawableId(), c.getHeadline(), c.getBody1());
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
                    if (ApiUtils.isLollipop()) {
                        Picasso.with(context)
                                .load(resourceId)
                                .resize(itemView.getWidth(), 0)
                                .into(img);
                    } else {
                        int cornerRadius = context.getResources().getDimensionPixelSize(R.dimen.control_corner_material);
                        Picasso.with(context)
                                .load(resourceId)
                                .resize(itemView.getWidth(), 0)
                                .transform(new RoundedTransformation(cornerRadius, 0))
                                .into(img);
                    }
                }
            });
        }
    }
}

