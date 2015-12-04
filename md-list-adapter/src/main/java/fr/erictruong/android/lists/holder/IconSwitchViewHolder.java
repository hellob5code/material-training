package fr.erictruong.android.lists.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import fr.erictruong.android.lists.Bindable;
import fr.erictruong.android.lists.item.MaterialListItem;
import fr.erictruong.android.lists.item.Checkable;
import fr.erictruong.android.lists.item.Iconable;
import fr.erictruong.android.lists.item.Textable;
import fr.erictruong.android.lists.stub.ActionStub;
import fr.erictruong.android.lists.stub.IconStub;
import fr.erictruong.android.lists.stub.SwitchStub;
import fr.erictruong.android.lists.stub.TextStub;

public class IconSwitchViewHolder extends RecyclerView.ViewHolder implements Bindable<MaterialListItem> {

    private ActionStub actionStub;
    private TextStub textStub;
    private SwitchStub switchStub;
    private IconStub iconStub;

    public IconSwitchViewHolder(View itemView) {
        super(itemView);
        actionStub = new ActionStub(itemView);
        textStub = new TextStub(itemView);
        switchStub = new SwitchStub(itemView);
        iconStub = new IconStub(itemView);
    }

    @Override
    public void bind(MaterialListItem item) {
        actionStub.bind(item);
        textStub.bind((Textable) item);
        switchStub.bind((Checkable) item);
        iconStub.bind((Iconable) item);
    }

    @Override
    public void unbind() {
        actionStub.unbind();
        textStub.unbind();
        switchStub.unbind();
        iconStub.unbind();
    }
}
