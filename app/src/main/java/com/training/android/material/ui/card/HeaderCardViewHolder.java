package com.training.android.material.ui.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;

public class HeaderCardViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.text) TextView tvText;

    public HeaderCardViewHolder(View v) {
        super(v);
        ButterKnife.inject(this, v);
    }

    public void setup(HeaderCard card) {
        setup(card.getText());
    }

    public void setup(String text) {
        tvText.setText(text);
    }
}
