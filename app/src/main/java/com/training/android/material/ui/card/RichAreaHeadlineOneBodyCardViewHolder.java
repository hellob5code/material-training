package com.training.android.material.ui.card;

import android.view.View;
import android.view.ViewStub;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;

public class RichAreaHeadlineOneBodyCardViewHolder extends HeadlineOneBodyCardViewHolder {

    @InjectView(R.id.stub) ViewStub stubRichArea;

    public RichAreaHeadlineOneBodyCardViewHolder(View v) {
        super(v);
        ButterKnife.inject(this, v);
    }

    public void setup(RichAreaHeadlineOneBodyCard card) {
        setup(card.getRichAreaLayoutId(), card.getHeadline(), card.getBody1());
    }

    protected void setup(int richAreaLayoutId, String headline, String body1) {
        super.setup(headline, body1);
        if (stubRichArea != null) {
            stubRichArea.setLayoutResource(richAreaLayoutId);
            stubRichArea.inflate();
            stubRichArea = null;
        }
    }
}
