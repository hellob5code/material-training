package fr.erictruong.android.lists;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import fr.erictruong.android.core.transform.CircleStrokeTransformation;

public class AvatarIconViewHolder<T> extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<AvatarIconItem, T> {

    private IconViewHolder viewHolder;

    @NonNull
    private ImageView avatar;

    private Picasso picasso;
    private CircleStrokeTransformation circleStrokeTransformation;

    public AvatarIconViewHolder(View view) {
        super(view);
        viewHolder = new IconViewHolder(view);
        avatar = (ImageView) view.findViewById(R.id.avatar);
        Context context = view.getContext();
        picasso = Picasso.with(context);
        circleStrokeTransformation = new CircleStrokeTransformation(context, Color.WHITE, 0);
    }

    @Override
    public void bind(AvatarIconItem item, T object) {
        viewHolder.bind(item, object);
        picasso.load(item.avatarUrl)
                .placeholder(R.drawable.circle)
                .transform(circleStrokeTransformation)
                .into(avatar);
    }
}
