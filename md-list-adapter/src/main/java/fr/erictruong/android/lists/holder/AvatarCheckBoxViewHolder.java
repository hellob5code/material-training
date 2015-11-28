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
import fr.erictruong.android.lists.item.AvatarCheckBoxItem;

public class AvatarCheckBoxViewHolder extends RecyclerView.ViewHolder implements MaterialListTileViewHolder<AvatarCheckBoxItem> {

    private CheckBoxViewHolder checkboxHolder;

    @NonNull
    private ImageView avatar;

    private Picasso picasso;
    private CircleStrokeTransformation circleStrokeTransformation;

    public AvatarCheckBoxViewHolder(View itemView) {
        super(itemView);
        checkboxHolder = new CheckBoxViewHolder(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        Context context = itemView.getContext();
        picasso = Picasso.with(context);
        circleStrokeTransformation = new CircleStrokeTransformation(context, Color.WHITE, 0);
    }

    @Override
    public void bind(final AvatarCheckBoxItem item) {
        checkboxHolder.bind(item);
        picasso.load(item.getAvatarUrl())
                .placeholder(R.drawable.circle)
                .transform(circleStrokeTransformation)
                .into(avatar);
    }

    @Override
    public void unbind() {
        checkboxHolder.unbind();
    }
}
