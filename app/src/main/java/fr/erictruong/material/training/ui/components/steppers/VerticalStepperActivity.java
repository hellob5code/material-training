package fr.erictruong.material.training.ui.components.steppers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.erictruong.material.training.R;

public class VerticalStepperActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, VerticalStepperActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_stepper);
    }
}
