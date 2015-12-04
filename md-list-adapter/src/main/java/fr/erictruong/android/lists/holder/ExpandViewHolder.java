package fr.erictruong.android.lists.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import fr.erictruong.android.lists.Bindable;
import fr.erictruong.android.lists.item.Checkable;
import fr.erictruong.android.lists.item.MaterialListItem;
import fr.erictruong.android.lists.item.Textable;
import fr.erictruong.android.lists.stub.ActionStub;
import fr.erictruong.android.lists.stub.ExpandStub;
import fr.erictruong.android.lists.stub.TextStub;

public class ExpandViewHolder extends RecyclerView.ViewHolder implements Bindable<MaterialListItem> {

    private ActionStub actionStub;
    private TextStub textStub;
    private ExpandStub expandStub;

    public ExpandViewHolder(View itemView) {
        super(itemView);
        actionStub = new ActionStub(itemView);
        textStub = new TextStub(itemView);
        expandStub = new ExpandStub(itemView);
    }

    @Override
    public void bind(MaterialListItem item) {
        actionStub.bind(item);
        textStub.bind((Textable) item);
        expandStub.bind((Checkable) item);
    }

    @Override
    public void unbind() {
        actionStub.unbind();
        textStub.unbind();
        expandStub.unbind();
    }
}
