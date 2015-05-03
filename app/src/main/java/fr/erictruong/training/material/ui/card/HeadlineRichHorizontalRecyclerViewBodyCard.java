package fr.erictruong.training.material.ui.card;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Picasso;
import fr.erictruong.training.material.R;

public class HeadlineRichHorizontalRecyclerViewBodyCard extends HeadlineBodyCard {

    protected int[] resourceIds;

    public HeadlineRichHorizontalRecyclerViewBodyCard(long id, int[] resourceIds, CharSequence headline, CharSequence body1) {
        this(id, TYPE_HEADLINE_RICH_HORIZONTAL_RECYCLER_VIEW_BODY_1, resourceIds, headline, body1);
    }

    public HeadlineRichHorizontalRecyclerViewBodyCard(long id, int viewType, int[] resourceIds, CharSequence headline, CharSequence body1) {
        super(id, viewType, headline, body1);
        this.resourceIds = resourceIds;
    }

    public int[] getDrawableIds() {
        return resourceIds;
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class ViewHolder extends HeadlineBodyCard.ViewHolder {

        @InjectView(R.id.recycler) RecyclerView recycler;
        private final Context context;

        public ViewHolder(CardView v) {
            super(v);
            context = v.getContext();
            ButterKnife.inject(this, v);
            recycler.getLayoutParams().height = context.getResources().getDimensionPixelSize(R.dimen.card_rich_media_height_material);
        }

        @Override
        public void bindView(Card card, int position) {
            HeadlineRichHorizontalRecyclerViewBodyCard c = (HeadlineRichHorizontalRecyclerViewBodyCard) card;
            bindView(c.getDrawableIds(), c.getHeadline(), c.getBody());
        }

        protected void bindView(int[] resourceIds, CharSequence headline, CharSequence body1) {
            super.bindView(headline, body1);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            recycler.setLayoutManager(layoutManager);
            recycler.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    if (parent.getChildLayoutPosition(view) < 1) {
                        outRect.set(0, 0, 0, 0);
                        return;
                    }
                    outRect.left = context.getResources().getDimensionPixelSize(R.dimen.margin_xsmall);
                }
            });
            RecyclerView.Adapter adapter = new HorizontalDrawableAdapter(resourceIds);
            recycler.setAdapter(adapter);
        }
    }

    public static class HorizontalDrawableAdapter extends RecyclerView.Adapter<HorizontalDrawableAdapter.ViewHolder> {

        private int[] resourceIds;

        public HorizontalDrawableAdapter(int[] resourceIds) {
            this.resourceIds = resourceIds;
        }

        /**
         * Create new views (invoked by the layout manager). Set the view's size, margins, paddings and layout parameters.
         */
        @Override
        public HorizontalDrawableAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(new ImageView(parent.getContext()));
        }

        /**
         * Replace the contents of a view (invoked by the layout manager). Get element from your dataset at this position
         * and replace the contents of the view with that element.
         */
        @Override
        public void onBindViewHolder(HorizontalDrawableAdapter.ViewHolder viewHolder, int position) {
            Context context = viewHolder.img.getContext();
            Picasso.with(context)
                    .load(resourceIds[position])
                    .resize(0, context.getResources().getDimensionPixelSize(R.dimen.card_rich_media_height_material))
                    .into(viewHolder.img);
        }

        @Override
        public int getItemCount() {
            return resourceIds.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public ImageView img;

            public ViewHolder(ImageView img) {
                super(img);
                this.img = img;
            }
        }
    }
}

