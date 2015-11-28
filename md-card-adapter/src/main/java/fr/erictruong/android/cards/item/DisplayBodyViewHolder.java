package fr.erictruong.android.cards.item;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;

import fr.erictruong.android.cards.MaterialCardViewHolder;
import fr.erictruong.android.cards.R;

public class DisplayBodyViewHolder extends RecyclerView.ViewHolder implements MaterialCardViewHolder<DisplayBodyItem> {

    @NonNull
    private TextView display;
    @NonNull
    private TextView body;
    @NonNull
    private Space spaceDisplayBody;

    public DisplayBodyViewHolder(View itemView) {
        super(itemView);
        display = (TextView) itemView.findViewById(R.id.display);
        body = (TextView) itemView.findViewById(R.id.body);
        spaceDisplayBody = (Space) itemView.findViewById(R.id.space_display_body);
    }

    @Override
    public void bind(DisplayBodyItem item) {
        if (item.display == null || item.display.length() == 0) {
            display.setVisibility(View.GONE);
        } else {
            display.setVisibility(View.VISIBLE);
            display.setText(item.display);
        }

        if (item.body == null || item.body.length() == 0) {
            body.setVisibility(View.GONE);
        } else {
            body.setVisibility(View.VISIBLE);
            body.setText(item.body);
        }

        if (display.getVisibility() == View.VISIBLE && body.getVisibility() == View.VISIBLE) {
            spaceDisplayBody.setVisibility(View.VISIBLE);
        } else {
            spaceDisplayBody.setVisibility(View.GONE);
        }
    }
}
