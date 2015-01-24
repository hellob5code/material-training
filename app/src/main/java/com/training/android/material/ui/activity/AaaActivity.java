package com.training.android.material.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Slider;
import android.widget.SlidingPanelLayout;
import android.widget.SlidingPanelLayout.SlidingPanelState;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnTouch;
import com.training.android.material.R;

import static android.widget.Slider.DECELERATE_INTERPOLATOR;
import static android.widget.Slider.OVERSHOOT_INTERPOLATOR;

public class AaaActivity extends ActionBarActivity {

    @InjectView(R.id.btn_aaa) Button btnAaa;

    @InjectView(R.id.slidingPanelContainer)  SlidingPanelLayout slidingPanelContainer;
    @InjectView(R.id.panel)  View panel;
    @InjectView(R.id.panelHeader)  View panelHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aaa);
        ButterKnife.inject(this);
        slidingPanelContainer.setPanelView(panel);
        slidingPanelContainer.setPanelHeaderView(panelHeader);
    }

    @OnClick(R.id.btn_aaa)
    protected void aaa() {
        System.out.println("AAA aaa");

        SlidingPanelState state = slidingPanelContainer.getState();

        if (state == SlidingPanelState.CLOSED) {
            slidingPanelContainer.changeSlidingPanelState(SlidingPanelState.SMALL);
        } else {
            slidingPanelContainer.changeSlidingPanelState(state);
//            slidingPanelContainer.postDelayed(new Runnable() {
//                public void run() {
//                }
//            }, 200);
        }
    }
}
