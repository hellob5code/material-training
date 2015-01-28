package com.training.android.material.ui.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.material.R;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Callable;

public class HeadlineBodyThreeButtonCard extends HeadlineBodyCard {

    protected CharSequence button1, button2, button3;
    protected Callable action1, action2, action3;

    public HeadlineBodyThreeButtonCard(int id, CharSequence headline, CharSequence body1, CharSequence button1, Callable action1) {
        this(id, headline, body1, button1, null, null, action1, null, null);
    }

    public HeadlineBodyThreeButtonCard(int id, CharSequence headline, CharSequence body1, CharSequence button1, CharSequence button2, Callable action1, Callable action2) {
        this(id, headline, body1, button1, button2, null, action1, action2, null);
    }

    public HeadlineBodyThreeButtonCard(int id, CharSequence headline, CharSequence body1, CharSequence button1, CharSequence button2, CharSequence button3, Callable action1, Callable action2, Callable action3) {
        this(id, TYPE_HEADLINE_BODY_1_THREE_BUTTON, headline, body1, button1, button2, button3, action1, action2, action3);
    }

    public HeadlineBodyThreeButtonCard(int id, int viewType, CharSequence headline, CharSequence body1, CharSequence button1, CharSequence button2, CharSequence button3, Callable action1, Callable action2, Callable action3) {
        super(id, viewType, headline, body1);
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.action1 = action1;
        this.action2 = action2;
        this.action3 = action3;
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

    public Callable getAction1() {
        return action1;
    }

    public Callable getAction2() {
        return action2;
    }

    public Callable getAction3() {
        return action3;
    }

    /**
     * Provide a reference to the views for each data item. Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    public static class ViewHolder extends HeadlineBodyCard.ViewHolder {

        @InjectView(R.id.action_area) ViewGroup actionArea;
        @InjectView(R.id.button_1) Button btn1;
        @InjectView(R.id.button_2) Button btn2;
        @InjectView(R.id.button_3) Button btn3;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }

        @Override
        public void bindView(Card card, int position) {
            HeadlineBodyThreeButtonCard c = (HeadlineBodyThreeButtonCard) card;
            bindView(c.getHeadline(), c.getBody1(), c.getButton1(), c.getButton2(), c.getButton3(), c.getAction1(), c.getAction2(), c.getAction3());
        }

        protected void bindView(CharSequence headline, CharSequence body1, CharSequence button1, CharSequence button2, CharSequence button3, final Callable action1, final Callable action2, final Callable action3) {
            super.bindView(headline, body1);
            if (StringUtils.isNotEmpty(button1)) {
                actionArea.setVisibility(View.VISIBLE);
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
                actionArea.setVisibility(View.GONE);
            }
        }

        private void disableOrHideButton(Button btn, CharSequence button, final Callable action) {
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
}

