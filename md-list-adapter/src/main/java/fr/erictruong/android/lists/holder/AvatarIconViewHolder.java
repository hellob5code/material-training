package fr.erictruong.android.lists.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import fr.erictruong.android.lists.Bindable;
import fr.erictruong.android.lists.item.MaterialListItem;
import fr.erictruong.android.lists.item.Avatarable;
import fr.erictruong.android.lists.item.Iconable;
import fr.erictruong.android.lists.item.Textable;
import fr.erictruong.android.lists.stub.ActionStub;
import fr.erictruong.android.lists.stub.AvatarStub;
import fr.erictruong.android.lists.stub.IconStub;
import fr.erictruong.android.lists.stub.TextStub;

public class AvatarIconViewHolder extends RecyclerView.ViewHolder implements Bindable<MaterialListItem> {

    private ActionStub actionStub;
    private TextStub textStub;
    private IconStub iconStub;
    private AvatarStub avatarStub;

    public AvatarIconViewHolder(View itemView) {
        super(itemView);
        actionStub = new ActionStub(itemView);
        textStub = new TextStub(itemView);
        iconStub = new IconStub(itemView);
        avatarStub = new AvatarStub(itemView);
    }

    @Override
    public void bind(MaterialListItem item) {
        actionStub.bind(item);
        textStub.bind((Textable) item);
        iconStub.bind((Iconable) item);
        avatarStub.bind((Avatarable) item);
    }

    @Override
    public void unbind() {
        actionStub.unbind();
        textStub.unbind();
        iconStub.unbind();
        avatarStub.unbind();
    }
}
