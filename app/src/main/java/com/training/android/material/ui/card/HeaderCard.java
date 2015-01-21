package com.training.android.material.ui.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;

public class HeaderCard extends Card {

    private String text;

    public HeaderCard(int id, String text) {
        super(id, TYPE_HEADER);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.text) TextView tvText;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }

        public void setup(HeaderCard card) {
            setup(card.getText());
        }

        protected void setup(String text) {
            tvText.setText(text);
        }
    }

}
