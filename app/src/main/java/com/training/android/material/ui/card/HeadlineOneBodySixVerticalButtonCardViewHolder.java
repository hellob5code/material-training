package com.training.android.material.ui.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Callable;

public class HeadlineOneBodySixVerticalButtonCardViewHolder extends HeadlineOneBodyCardViewHolder {

    @InjectView(R.id.action_area_1) ViewGroup actionArea1;
    @InjectView(R.id.action_area_2) ViewGroup actionArea2;
    @InjectView(R.id.action_area_3) ViewGroup actionArea3;
    @InjectView(R.id.action_area_4) ViewGroup actionArea4;
    @InjectView(R.id.action_area_5) ViewGroup actionArea5;
    @InjectView(R.id.action_area_6) ViewGroup actionArea6;
    @InjectView(R.id.button_1) Button btn1;
    @InjectView(R.id.button_2) Button btn2;
    @InjectView(R.id.button_3) Button btn3;
    @InjectView(R.id.button_4) Button btn4;
    @InjectView(R.id.button_5) Button btn5;
    @InjectView(R.id.button_6) Button btn6;

    public HeadlineOneBodySixVerticalButtonCardViewHolder(View v) {
        super(v);
        ButterKnife.inject(this, v);
    }

    public void setup(HeadlineOneBodySixVerticalButtonCard card) {
        setup(card.getHeadline(), card.getBody1(), card.getButton1(), card.getButton2(), card.getButton3(), card.getButton4(), card.getButton5(), card.getButton6(), card.getAction1(), card.getAction2(), card.getAction3(), card.getAction4(), card.getAction5(), card.getAction6());
    }

    protected void setup(String headline, String body1, String button1, String button2, String button3, String button4, String button5, String button6, final Callable action1, final Callable action2, final Callable action3, final Callable action4, final Callable action5, final Callable action6) {
        super.setup(headline, body1);
        disableOrHideButton(actionArea1, btn1, button1, action1);
        disableOrHideButton(actionArea2, btn2, button2, action2);
        disableOrHideButton(actionArea3, btn3, button3, action3);
        disableOrHideButton(actionArea4, btn4, button4, action4);
        disableOrHideButton(actionArea5, btn5, button5, action5);
        disableOrHideButton(actionArea6, btn6, button6, action6);
    }

    private void disableOrHideButton(ViewGroup area, Button btn, String button, final Callable action) {
        if (StringUtils.isNotEmpty(button)) {
            area.setVisibility(View.VISIBLE);
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
            area.setVisibility(View.GONE);
        }
    }
}
