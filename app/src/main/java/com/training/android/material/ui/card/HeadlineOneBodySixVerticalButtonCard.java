package com.training.android.material.ui.card;

import java.util.concurrent.Callable;

public class HeadlineOneBodySixVerticalButtonCard extends HeadlineOneBodyCard {

    public static final int TYPE_HEADLINE_ONE_BODY_SIX_VERTICAL_BUTTON = 4;

    private String button1, button2, button3, button4, button5, button6;
    private Callable action1, action2, action3, action4, action5, action6;

    public HeadlineOneBodySixVerticalButtonCard(int id, String headline, String body1, String button1, Callable action1) {
        super(id, TYPE_HEADLINE_ONE_BODY_SIX_VERTICAL_BUTTON, headline, body1);
        this.button1 = button1;
        this.action1 = action1;
    }

    public HeadlineOneBodySixVerticalButtonCard(int id, String headline, String body1, String button1, String button2, Callable action1, Callable action2) {
        super(id, TYPE_HEADLINE_ONE_BODY_SIX_VERTICAL_BUTTON, headline, body1);
        this.button1 = button1;
        this.button2 = button2;
        this.action1 = action1;
        this.action2 = action2;
    }

    public HeadlineOneBodySixVerticalButtonCard(int id, String headline, String body1, String button1, String button2, String button3, Callable action1, Callable action2, Callable action3) {
        super(id, TYPE_HEADLINE_ONE_BODY_SIX_VERTICAL_BUTTON, headline, body1);
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.action1 = action1;
        this.action2 = action2;
        this.action3 = action3;
    }

    public HeadlineOneBodySixVerticalButtonCard(int id, String headline, String body1, String button1, String button2, String button3, String button4, Callable action1, Callable action2, Callable action3, Callable action4) {
        super(id, TYPE_HEADLINE_ONE_BODY_SIX_VERTICAL_BUTTON, headline, body1);
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.button4 = button4;
        this.action1 = action1;
        this.action2 = action2;
        this.action3 = action3;
        this.action4 = action4;
    }

    public HeadlineOneBodySixVerticalButtonCard(int id, String headline, String body1, String button1, String button2, String button3, String button4, String button5, Callable action1, Callable action2, Callable action3, Callable action4, Callable action5) {
        super(id, TYPE_HEADLINE_ONE_BODY_SIX_VERTICAL_BUTTON, headline, body1);
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.button4 = button4;
        this.button5 = button5;
        this.action1 = action1;
        this.action2 = action2;
        this.action3 = action3;
        this.action4 = action4;
        this.action5 = action5;
    }

    public HeadlineOneBodySixVerticalButtonCard(int id, String headline, String body1, String button1, String button2, String button3, String button4, String button5, String button6, Callable action1, Callable action2, Callable action3, Callable action4, Callable action5, Callable action6) {
        super(id, TYPE_HEADLINE_ONE_BODY_SIX_VERTICAL_BUTTON, headline, body1);
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
}

