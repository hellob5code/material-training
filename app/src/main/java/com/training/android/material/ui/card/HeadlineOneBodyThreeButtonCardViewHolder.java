package com.training.android.material.ui.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Callable;

public class HeadlineOneBodyThreeButtonCardViewHolder extends HeadlineOneBodyCardViewHolder {

    @InjectView(R.id.button_group) ViewGroup btnGroup;
    @InjectView(R.id.button1) Button btn1;
    @InjectView(R.id.button2) Button btn2;
    @InjectView(R.id.button3) Button btn3;

    public HeadlineOneBodyThreeButtonCardViewHolder(View v) {
        super(v);
        ButterKnife.inject(this, v);
    }

    public void setup(HeadlineOneBodyThreeButtonCard card) {
        setup(card.getHeadline(), card.getBody1(), card.getButton1(), card.getButton2(), card.getButton3(), card.getAction1(), card.getAction2(), card.getAction3());
    }

    protected void setup(String headline, String body1, String button1, String button2, String button3, final Callable action1, final Callable action2, final Callable action3) {
        super.setup(headline, body1);
        if (StringUtils.isNotEmpty(button1)) {
            btnGroup.setVisibility(View.VISIBLE);
            btn1.setText(button1);
            if (action1 != null) {
                btn1.setEnabled(true);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            action1.call();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else {
                btn1.setEnabled(false);
            }
            disableOrHideButton(btn2, button2, action2);
            disableOrHideButton(btn3, button3, action3);
        } else {
            btnGroup.setVisibility(View.GONE);
        }
    }

    private void disableOrHideButton(Button btn, String button, final Callable action) {
        if (StringUtils.isNotEmpty(button)) {
            btn.setVisibility(View.VISIBLE);
            btn.setText(button);
            if (action != null) {
                btn.setEnabled(true);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            action.call();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else {
                btn.setEnabled(false);
            }
        } else {
            btn.setVisibility(View.GONE);
        }
    }
}
