package fr.erictruong.material.training.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.erictruong.material.training.R;
import fr.erictruong.material.training.ui.material_design.MaterialDesignActivity;

/**
 * Launcher Activity used to forward to the default screen or the last visited screen.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startLastVisitedActivity();
    }

    private void startLastVisitedActivity() {
        MaterialDesignActivity.start(this, R.id.nav_introduction);
    }
}
