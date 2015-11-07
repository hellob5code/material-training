package fr.erictruong.android.lists.action;

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
import fr.erictruong.android.lists.state.IconViewHolder;

public class AvatarIconViewHolder<T> extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<AvatarIconItem, T> {

    private IconViewHolder<T> iconHolder;

    @NonNull
    private ImageView avatar;

    private Picasso picasso;
    private CircleStrokeTransformation circleStrokeTransformation;

    public AvatarIconViewHolder(View itemView) {
        super(itemView);
        iconHolder = new IconViewHolder<>(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        Context context = itemView.getContext();
        picasso = Picasso.with(context);
        circleStrokeTransformation = new CircleStrokeTransformation(context, Color.WHITE, 0);
    }

    @Override
    public void bind(AvatarIconItem item, T object) {
        iconHolder.bind(item, object);
        picasso.load(item.avatarUrl)
                .placeholder(R.drawable.circle)
                .transform(circleStrokeTransformation)
                .into(avatar);
    }

    @Override
    public void unbind() {
        iconHolder.unbind();
    }
}
