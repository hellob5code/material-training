package fr.erictruong.android.core.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import fr.erictruong.android.core.R;

public abstract class RecyclerActivity extends AppCompatActivity {

     RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    @Override
    public void setContentView(int layoutResID) {
        View v = getLayoutInflater().inflate(layoutResID, recyclerView, false);
        setContentView(v);
    }

    @Override
    public void setContentView(View view) {
        setContentView(view, view.getLayoutParams());
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        recyclerView.addView(view, params);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
