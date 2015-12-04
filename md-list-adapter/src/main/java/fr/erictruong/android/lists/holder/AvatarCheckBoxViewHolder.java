package fr.erictruong.android.lists.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import fr.erictruong.android.lists.Bindable;
import fr.erictruong.android.lists.item.MaterialListItem;
import fr.erictruong.android.lists.item.Avatarable;
import fr.erictruong.android.lists.item.Checkable;
import fr.erictruong.android.lists.item.Textable;
import fr.erictruong.android.lists.stub.ActionStub;
import fr.erictruong.android.lists.stub.AvatarStub;
import fr.erictruong.android.lists.stub.CheckBoxStub;
import fr.erictruong.android.lists.stub.TextStub;

public class AvatarCheckBoxViewHolder extends RecyclerView.ViewHolder implements Bindable<MaterialListItem> {

    private ActionStub actionStub;
    private TextStub textStub;
    private CheckBoxStub checkBoxStub;
    private AvatarStub avatarStub;

    public AvatarCheckBoxViewHolder(View itemView) {
        super(itemView);
        actionStub = new ActionStub(itemView);
        textStub = new TextStub(itemView);
        checkBoxStub = new CheckBoxStub(itemView);
        avatarStub = new AvatarStub(itemView);
    }

    @Override
    public void bind(MaterialListItem item) {
        actionStub.bind(item);
        textStub.bind((Textable) item);
        checkBoxStub.bind((Checkable) item);
        avatarStub.bind((Avatarable) item);
    }

    @Override
    public void unbind() {
        actionStub.unbind();
        textStub.unbind();
        checkBoxStub.unbind();
        avatarStub.unbind();
    }
}
