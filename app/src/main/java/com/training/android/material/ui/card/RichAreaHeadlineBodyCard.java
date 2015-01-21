package com.training.android.material.ui.card;

import android.view.View;
import android.view.ViewStub;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;

public class RichAreaHeadlineBodyCard extends HeadlineBodyCard {

    protected int richAreaLayoutId;

    public RichAreaHeadlineBodyCard(int id, int richAreaLayoutId, String headline, String body1) {
        this(id, TYPE_RICH_AREA_HEADLINE_BODY_1, richAreaLayoutId, headline, body1);
    }

    public RichAreaHeadlineBodyCard(int id, int viewType, int richAreaLayoutId, String headline, String body1) {
        super(id, viewType, headline, body1);
        this.richAreaLayoutId = richAreaLayoutId;
    }

    public int getRichAreaLayoutId() {
        return richAreaLayoutId;
    }

    public String getHeadline() {
        return headline;
    }

    public String getBody1() {
        return body1;
    }

    public static class ViewHolder extends HeadlineBodyCard.ViewHolder {

        @InjectView(R.id.stub) ViewStub stubRichArea;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }

        public void setup(RichAreaHeadlineBodyCard card) {
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
}

