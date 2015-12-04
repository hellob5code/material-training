package fr.erictruong.android.lists.stub;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import fr.erictruong.android.core.transform.CircleStrokeTransformation;
import fr.erictruong.android.lists.Bindable;
import fr.erictruong.android.lists.R;
import fr.erictruong.android.lists.item.Avatarable;

public class AvatarStub extends BaseStub implements Bindable<Avatarable> {

    @NonNull
    private ImageView avatar;

    private Picasso picasso;
    private CircleStrokeTransformation circleStrokeTransformation;

    public AvatarStub(View view) {
        super(view);
        this.avatar = (ImageView) view.findViewById(R.id.avatar);
        Context context = view.getContext();
        picasso = Picasso.with(context);
        circleStrokeTransformation = new CircleStrokeTransformation(context, Color.WHITE, 0);
    }

    @Override
    public void bind(Avatarable item) {
        picasso.load(item.getAvatarUrl())
                .placeholder(R.drawable.circle)
                .transform(circleStrokeTransformation)
                .into(avatar);
    }

    @Override
    public void unbind() {
        // Nothing to do
    }
}
