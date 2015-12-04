package fr.erictruong.android.lists.stub;

import android.view.View;

public class BaseStub {

    private View view;

    public BaseStub(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
