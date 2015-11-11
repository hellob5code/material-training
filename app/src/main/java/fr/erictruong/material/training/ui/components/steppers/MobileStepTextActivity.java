package fr.erictruong.material.training.ui.components.steppers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class MobileStepTextActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, MobileStepTextActivity.class);
        context.startActivity(starter);
    }
}
