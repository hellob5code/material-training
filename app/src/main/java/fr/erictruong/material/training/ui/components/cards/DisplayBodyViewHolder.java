package fr.erictruong.material.training.ui.components.cards;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.erictruong.material.training.R;

public class DisplayBodyViewHolder extends RecyclerView.ViewHolder implements MaterialCardViewHolder<DisplayBodyItem> {

    private TextView display;
    private TextView body;

    public DisplayBodyViewHolder(View itemView) {
        super(itemView);
        display = (TextView) itemView.findViewById(R.id.display);
        body = (TextView) itemView.findViewById(R.id.body);
    }

    @Override
    public void bind(DisplayBodyItem item) {
        display.setText(item.display);
        body.setText(item.body);
    }
}
