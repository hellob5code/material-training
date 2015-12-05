package fr.erictruong.android.lists.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import fr.erictruong.android.lists.Bindable;
import fr.erictruong.android.lists.item.Avatarable;
import fr.erictruong.android.lists.item.MaterialListItem;
import fr.erictruong.android.lists.item.Reorderable;
import fr.erictruong.android.lists.item.Textable;
import fr.erictruong.android.lists.stub.ActionStub;
import fr.erictruong.android.lists.stub.AvatarStub;
import fr.erictruong.android.lists.stub.ReorderStub;
import fr.erictruong.android.lists.stub.TextStub;

public class AvatarReorderViewHolder extends RecyclerView.ViewHolder implements Bindable<MaterialListItem> {

    private ActionStub actionStub;
    private TextStub textStub;
    private ReorderStub reorderStub;
    private AvatarStub avatarStub;

    public AvatarReorderViewHolder(View itemView) {
        super(itemView);
        actionStub = new ActionStub(itemView);
        textStub = new TextStub(itemView);
        reorderStub = new ReorderStub(itemView);
        avatarStub = new AvatarStub(itemView);
    }

    @Override
    public void bind(MaterialListItem item) {
        actionStub.bind(item);
        textStub.bind((Textable) item);
        reorderStub.bind((Reorderable) item);
        reorderStub.setViewHolder(this);
        avatarStub.bind((Avatarable) item);
    }

    @Override
    public void unbind() {
        actionStub.unbind();
        textStub.unbind();
        reorderStub.unbind();
        avatarStub.unbind();
    }
}
