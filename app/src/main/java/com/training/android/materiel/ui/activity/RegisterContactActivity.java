package com.training.android.materiel.ui.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.training.android.materiel.R;
import com.training.android.materiel.model.Contact;
import com.training.android.materiel.util.EnumUtils;

public class RegisterContactActivity extends Activity {

    @InjectView(R.id.register_contact_spi_phone_type) Spinner spiPhoneType;
    @InjectView(R.id.register_contact_spi_email_type) Spinner spiEmailType;
    @InjectView(R.id.register_contact_spi_address_type) Spinner spiAddressType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_contact);
        ButterKnife.inject(this);
        ActionBar toolbar = getActionBar();
        if (toolbar != null) {
            toolbar.setDisplayShowTitleEnabled(false);
        }

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, EnumUtils.capitalizedFullyNames(Contact.PhoneType.class));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiPhoneType.setAdapter(adapter);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, EnumUtils.capitalizedFullyNames(Contact.EmailType.class));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiEmailType.setAdapter(adapter);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, EnumUtils.capitalizedFullyNames(Contact.AddressType.class));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiAddressType.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_validate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        } else if (id == R.id.action_validate) {
            // TODO: Perform action.
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
