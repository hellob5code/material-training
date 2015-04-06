package fr.erictruong.training.material.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.ButterKnife;
import butterknife.InjectView;
import android.widget.MaterialEditText;
import fr.erictruong.training.material.R;

public class RegisterApplicationActivity extends ActionBarActivity {

    @InjectView(R.id.register_application_edt_title) MaterialEditText edtTitle;
    @InjectView(R.id.register_application_edt_price) MaterialEditText edtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_application);
        ButterKnife.inject(this);
        ActionBar toolbar = getSupportActionBar();
        if (toolbar != null) {
            toolbar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_validate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_validate) {
//            if (edtTitle.validateWith(new RegexpValidator("Cannot be empty!", "^\\w+( \\w+)*$"))) {
//                // TODO: Perform action after true validation.
//                Toast.makeText(this, "Added!", Toast.LENGTH_SHORT).show();
//            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
