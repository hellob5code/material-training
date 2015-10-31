package fr.erictruong.material.training.ui.components.lists;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.core.transform.CircleStrokeTransformation;

public class AvatarViewHolder<T> extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<AvatarItem, T> {

    private TextViewHolder viewHolder;

    @NonNull
    private ImageView avatar;

    private Picasso picasso;
    private CircleStrokeTransformation circleStrokeTransformation;

    public AvatarViewHolder(View view) {
        super(view);
        viewHolder = new TextViewHolder(view);
        avatar = (ImageView) view.findViewById(R.id.avatar);
        Context context = view.getContext();
        picasso = Picasso.with(context);
        circleStrokeTransformation = new CircleStrokeTransformation(context, Color.WHITE, 0);
    }

    @Override
    public void bind(AvatarItem item, T object) {
        viewHolder.bind(item, object);
        picasso.load(item.avatarUrl)
                .placeholder(R.drawable.circle)
                .transform(circleStrokeTransformation)
                .into(avatar);
    }
}
