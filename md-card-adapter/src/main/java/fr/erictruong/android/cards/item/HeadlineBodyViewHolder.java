package fr.erictruong.android.cards.item;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Space;
import android.widget.TextView;

import fr.erictruong.android.cards.MaterialCardViewHolder;
import fr.erictruong.android.cards.R;

public class HeadlineBodyViewHolder extends RecyclerView.ViewHolder implements MaterialCardViewHolder<HeadlineBodyItem> {

    @NonNull
    private TextView headline;
    @NonNull
    private TextView body;
    @NonNull
    private Space spaceHeadlineBody;
    @Nullable
    private ViewGroup actionArea, actionArea1, actionArea2, actionArea3, actionArea4, actionArea5, actionArea6;
    @Nullable
    private Button btn1, btn2, btn3, btn4, btn5, btn6;

    public HeadlineBodyViewHolder(View itemView) {
        super(itemView);
        headline = (TextView) itemView.findViewById(R.id.headline);
        body = (TextView) itemView.findViewById(R.id.body);
        spaceHeadlineBody = (Space) itemView.findViewById(R.id.space_headline_body);
        actionArea = (ViewGroup) itemView.findViewById(R.id.action_area);
        actionArea1 = (ViewGroup) itemView.findViewById(R.id.action_area_1);
        actionArea2 = (ViewGroup) itemView.findViewById(R.id.action_area_2);
        actionArea3 = (ViewGroup) itemView.findViewById(R.id.action_area_3);
        actionArea4 = (ViewGroup) itemView.findViewById(R.id.action_area_4);
        actionArea5 = (ViewGroup) itemView.findViewById(R.id.action_area_5);
        actionArea6 = (ViewGroup) itemView.findViewById(R.id.action_area_6);
        btn1 = (Button) itemView.findViewById(R.id.button_1);
        btn2 = (Button) itemView.findViewById(R.id.button_2);
        btn3 = (Button) itemView.findViewById(R.id.button_3);
        btn4 = (Button) itemView.findViewById(R.id.button_4);
        btn5 = (Button) itemView.findViewById(R.id.button_5);
        btn6 = (Button) itemView.findViewById(R.id.button_6);
    }

    @Override
    public void bind(HeadlineBodyItem item) {
        if (item.headline == null || item.headline.length() == 0) {
            headline.setVisibility(View.GONE);
        } else {
            headline.setVisibility(View.VISIBLE);
            headline.setText(item.headline);
        }

        if (item.body == null || item.body.length() == 0) {
            body.setVisibility(View.GONE);
        } else {
            body.setVisibility(View.VISIBLE);
            body.setText(item.body);
        }

        if (headline.getVisibility() == View.VISIBLE && body.getVisibility() == View.VISIBLE) {
            spaceHeadlineBody.setVisibility(View.VISIBLE);
        } else {
            spaceHeadlineBody.setVisibility(View.GONE);
        }

        if (actionArea == null) {
            // Assume multiple action areas
            disableOrHideButton(actionArea1, btn1, item.button1, item.action1);
            disableOrHideButton(actionArea2, btn2, item.button2, item.action2);
            disableOrHideButton(actionArea3, btn3, item.button3, item.action3);
            disableOrHideButton(actionArea4, btn4, item.button4, item.action4);
            disableOrHideButton(actionArea5, btn5, item.button5, item.action5);
            disableOrHideButton(actionArea6, btn6, item.button6, item.action6);
        } else {
            // Assume one action area
            if (item.button1 == null || item.button1.length() == 0) {
                actionArea.setVisibility(View.GONE);
            } else {
                actionArea.setVisibility(View.VISIBLE);
                btn1.setText(item.button1);
                if (item.action1 == null) {
                    btn1.setEnabled(false);
                } else {
                    btn1.setEnabled(true);
                    btn1.setOnClickListener(item.action1);
                }
                disableOrHideButton(btn2, item.button2, item.action2);
                disableOrHideButton(btn3, item.button3, item.action3);
            }
        }
    }

    private void disableOrHideButton(ViewGroup area, Button btn, CharSequence button, View.OnClickListener action) {
        if (area != null) {
            if (button == null || button.length() == 0) {
                area.setVisibility(View.GONE);
            } else {
                area.setVisibility(View.VISIBLE);
                btn.setText(button);
                if (action == null) {
                    btn.setEnabled(false);
                } else {
                    btn.setEnabled(true);
                    btn.setOnClickListener(action);
                }
            }
        }
    }

    private void disableOrHideButton(Button btn, CharSequence button, View.OnClickListener action) {
        if (btn != null) {
            if (button == null || button.length() == 0) {
                btn.setVisibility(View.GONE);
            } else {
                btn.setVisibility(View.VISIBLE);
                btn.setText(button);
                if (action == null) {
                    btn.setEnabled(false);
                } else {
                    btn.setEnabled(true);
                    btn.setOnClickListener(action);
                }
            }
        }
    }
}
