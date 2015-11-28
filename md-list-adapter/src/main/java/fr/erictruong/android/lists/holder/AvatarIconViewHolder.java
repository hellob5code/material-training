package fr.erictruong.android.lists.holder;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import fr.erictruong.android.core.transform.CircleStrokeTransformation;
import fr.erictruong.android.lists.MaterialListTileViewHolder;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.item.AvatarIconItem;

public class AvatarIconViewHolder extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<AvatarIconItem> {

    private IconViewHolder iconHolder;

    @NonNull
    private ImageView avatar;

    private Picasso picasso;
    private CircleStrokeTransformation circleStrokeTransformation;

    public AvatarIconViewHolder(View itemView) {
        super(itemView);
        iconHolder = new IconViewHolder(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        Context context = itemView.getContext();
        picasso = Picasso.with(context);
        circleStrokeTransformation = new CircleStrokeTransformation(context, Color.WHITE, 0);
    }

    @Override
    public void bind(AvatarIconItem item) {
        iconHolder.bind(item);
        picasso.load(item.getAvatarUrl())
                .placeholder(R.drawable.circle)
                .transform(circleStrokeTransformation)
                .into(avatar);
    }

    @Override
    public void unbind() {
        iconHolder.unbind();
    }
}
