package com.training.android.material.ui.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Space;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Callable;

public class HeadlineOneBodyCardViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.headline) TextView tvHeadline;
    @InjectView(R.id.body1) TextView tvBody1;
    @InjectView(R.id.space_headline_body1) Space spaceHeadlineBody1;

    public HeadlineOneBodyCardViewHolder(View v) {
        super(v);
        ButterKnife.inject(this, v);
    }

    public void setup(HeadlineOneBodyCard card) {
        setup(card.getHeadline(), card.getBody1());
    }

    protected void setup(String headline, String body1) {
        if (StringUtils.isNotEmpty(headline)) {
            tvHeadline.setVisibility(View.VISIBLE);
            tvHeadline.setText(headline);
        } else {
            tvHeadline.setVisibility(View.GONE);
        }
        if (StringUtils.isNotEmpty(body1)) {
            tvBody1.setVisibility(View.VISIBLE);
            tvBody1.setText(body1);
        } else {
            tvBody1.setVisibility(View.GONE);
        }

        if (tvHeadline.getVisibility() == View.GONE || tvBody1.getVisibility() == View.GONE) {
            spaceHeadlineBody1.setVisibility(View.GONE);
        }
    }
}
