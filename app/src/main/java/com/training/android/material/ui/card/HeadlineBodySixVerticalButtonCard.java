package com.training.android.material.ui.card;

import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Callable;

public class HeadlineBodySixVerticalButtonCard extends HeadlineBodyCard {

    protected CharSequence button1, button2, button3, button4, button5, button6;
    protected Callable action1, action2, action3, action4, action5, action6;

    public HeadlineBodySixVerticalButtonCard(int id, CharSequence headline, CharSequence body1, CharSequence button1, Callable action1) {
        this(id, headline, body1, button1, null, null, null, null, null, action1, null, null, null, null, null);
    }

    public HeadlineBodySixVerticalButtonCard(int id, CharSequence headline, CharSequence body1, CharSequence button1, CharSequence button2, Callable action1, Callable action2) {
        this(id, headline, body1, button1, button2, null, null, null, null, action1, action2, null, null, null, null);
    }

    public HeadlineBodySixVerticalButtonCard(int id, CharSequence headline, CharSequence body1, CharSequence button1, CharSequence button2, CharSequence button3, Callable action1, Callable action2, Callable action3) {
        this(id, headline, body1, button1, button2, button3, null, null, null, action1, action2, action3, null, null, null);
    }

    public HeadlineBodySixVerticalButtonCard(int id, CharSequence headline, CharSequence body1, CharSequence button1, CharSequence button2, CharSequence button3, CharSequence button4, Callable action1, Callable action2, Callable action3, Callable action4) {
        this(id, headline, body1, button1, button2, button3, button4, null, null, action1, action2, action3, action4, null, null);
    }

    public HeadlineBodySixVerticalButtonCard(int id, CharSequence headline, CharSequence body1, CharSequence button1, CharSequence button2, CharSequence button3, CharSequence button4, CharSequence button5, Callable action1, Callable action2, Callable action3, Callable action4, Callable action5) {
        this(id, headline, body1, button1, button2, button3, button4, button5, null, action1, action2, action3, action4, action5, null);
    }

    public HeadlineBodySixVerticalButtonCard(int id, CharSequence headline, CharSequence body1, CharSequence button1, CharSequence button2, CharSequence button3, CharSequence button4, CharSequence button5, CharSequence button6, Callable action1, Callable action2, Callable action3, Callable action4, Callable action5, Callable action6) {
        this(id, TYPE_HEADLINE_BODY_1_SIX_VERTICAL_BUTTON, headline, body1, button1, button2, button3, button4, button5, button6, action1, action2, action3, action4, action5, action6);
    }

    public HeadlineBodySixVerticalButtonCard(int id, int viewType, CharSequence headline, CharSequence body1, CharSequence button1, CharSequence button2, CharSequence button3, CharSequence button4, CharSequence button5, CharSequence button6, Callable action1, Callable action2, Callable action3, Callable action4, Callable action5, Callable action6) {
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

    public CharSequence getButton1() {
        return button1;
    }

    public CharSequence getButton2() {
        return button2;
    }

    public CharSequence getButton3() {
        return button3;
    }

    public CharSequence getButton4() {
        return button4;
    }

    public CharSequence getButton5() {
        return button5;
    }

    public CharSequence getButton6() {
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

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
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

        public ViewHolder(CardView v) {
            super(v);
            ButterKnife.inject(this, v);
        }

        @Override
        public void bindView(Card card, int position) {
            HeadlineBodySixVerticalButtonCard c = (HeadlineBodySixVerticalButtonCard) card;
            bindView(c.getHeadline(), c.getBody1(), c.getButton1(), c.getButton2(), c.getButton3(), c.getButton4(), c.getButton5(), c.getButton6(), c.getAction1(), c.getAction2(), c.getAction3(), c.getAction4(), c.getAction5(), c.getAction6());
        }

        protected void bindView(CharSequence headline, CharSequence body1, CharSequence button1, CharSequence button2, CharSequence button3, CharSequence button4, CharSequence button5, CharSequence button6, final Callable action1, final Callable action2, final Callable action3, final Callable action4, final Callable action5, final Callable action6) {
            super.bindView(headline, body1);
            disableOrHideButton(actionArea1, btn1, button1, action1);
            disableOrHideButton(actionArea2, btn2, button2, action2);
            disableOrHideButton(actionArea3, btn3, button3, action3);
            disableOrHideButton(actionArea4, btn4, button4, action4);
            disableOrHideButton(actionArea5, btn5, button5, action5);
            disableOrHideButton(actionArea6, btn6, button6, action6);
        }

        private void disableOrHideButton(ViewGroup area, Button btn, CharSequence button, final Callable action) {
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

