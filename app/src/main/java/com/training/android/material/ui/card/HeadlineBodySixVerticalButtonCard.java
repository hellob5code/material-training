package com.training.android.material.ui.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Callable;

public class HeadlineBodySixVerticalButtonCard extends HeadlineBodyCard {

    protected String button1, button2, button3, button4, button5, button6;
    protected Callable action1, action2, action3, action4, action5, action6;

    public HeadlineBodySixVerticalButtonCard(int id, String headline, String body1, String button1, Callable action1) {
        this(id, headline, body1, button1, null, null, null, null, null, action1, null, null, null, null, null);
    }

    public HeadlineBodySixVerticalButtonCard(int id, String headline, String body1, String button1, String button2, Callable action1, Callable action2) {
        this(id, headline, body1, button1, button2, null, null, null, null, action1, action2, null, null, null, null);
    }

    public HeadlineBodySixVerticalButtonCard(int id, String headline, String body1, String button1, String button2, String button3, Callable action1, Callable action2, Callable action3) {
        this(id, headline, body1, button1, button2, button3, null, null, null, action1, action2, action3, null, null, null);
    }

    public HeadlineBodySixVerticalButtonCard(int id, String headline, String body1, String button1, String button2, String button3, String button4, Callable action1, Callable action2, Callable action3, Callable action4) {
        this(id, headline, body1, button1, button2, button3, button4, null, null, action1, action2, action3, action4, null, null);
    }

    public HeadlineBodySixVerticalButtonCard(int id, String headline, String body1, String button1, String button2, String button3, String button4, String button5, Callable action1, Callable action2, Callable action3, Callable action4, Callable action5) {
        this(id, headline, body1, button1, button2, button3, button4, button5, null, action1, action2, action3, action4, action5, null);
    }

    public HeadlineBodySixVerticalButtonCard(int id, String headline, String body1, String button1, String button2, String button3, String button4, String button5, String button6, Callable action1, Callable action2, Callable action3, Callable action4, Callable action5, Callable action6) {
        this(id, TYPE_HEADLINE_BODY_1_SIX_VERTICAL_BUTTON, headline, body1, button1, button2, button3, button4, button5, button6, action1, action2, action3, action4, action5, action6);
    }

    public HeadlineBodySixVerticalButtonCard(int id, int viewType, String headline, String body1, String button1, String button2, String button3, String button4, String button5, String button6, Callable action1, Callable action2, Callable action3, Callable action4, Callable action5, Callable action6) {
        super(id, viewType, headline, body1);
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.button4 = button4;
        this.button5 = button5;
        this.button6 = button6;
        this.action1 = action1;
        this.action2 = action2;
        this.action3 = action3;
        this.action4 = action4;
        this.action5 = action5;
        this.action6 = action6;
    }

    public String getButton1() {
        return button1;
    }

    public String getButton2() {
        return button2;
    }

    public String getButton3() {
        return button3;
    }

    public String getButton4() {
        return button4;
    }

    public String getButton5() {
        return button5;
    }

    public String getButton6() {
        return button6;
    }

    public Callable getAction1() {
        return action1;
    }

    public Callable getAction2() {
        return action2;
    }

    public Callable getAction3() {
        return action3;
    }

    public Callable getAction4() {
        return action4;
    }

    public Callable getAction5() {
        return action5;
    }

    public Callable getAction6() {
        return action6;
    }

    public static class ViewHolder extends HeadlineBodyCard.ViewHolder {

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

        public ViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }

        public void setup(HeadlineBodySixVerticalButtonCard card) {
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
}

