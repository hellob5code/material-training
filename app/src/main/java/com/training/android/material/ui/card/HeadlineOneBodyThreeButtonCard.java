package com.training.android.material.ui.card;

import java.util.concurrent.Callable;

public class HeadlineOneBodyThreeButtonCard extends HeadlineOneBodyCard {

    public static final int TYPE_HEADLINE_ONE_BODY_THREE_BUTTON = 2;

    private String button1, button2, button3;
    private Callable action1, action2, action3;

    public HeadlineOneBodyThreeButtonCard(int id, String headline, String body1, String button1, Callable action1) {
        super(id, TYPE_HEADLINE_ONE_BODY_THREE_BUTTON, headline, body1);
        this.button1 = button1;
        this.action1 = action1;
    }

    public HeadlineOneBodyThreeButtonCard(int id, String headline, String body1, String button1, String button2, Callable action1, Callable action2) {
        super(id, TYPE_HEADLINE_ONE_BODY_THREE_BUTTON, headline, body1);
        this.button1 = button1;
        this.button2 = button2;
        this.action1 = action1;
        this.action2 = action2;
    }

    public HeadlineOneBodyThreeButtonCard(int id, String headline, String body1, String button1, String button2, String button3, Callable action1, Callable action2, Callable action3) {
        super(id, TYPE_HEADLINE_ONE_BODY_THREE_BUTTON, headline, body1);
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.action1 = action1;
        this.action2 = action2;
        this.action3 = action3;
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

    public Callable getAction1() {
        return action1;
    }

    public Callable getAction2() {
        return action2;
    }

    public Callable getAction3() {
        return action3;
    }
}

