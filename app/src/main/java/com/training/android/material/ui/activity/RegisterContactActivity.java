package com.training.android.material.ui.activity;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.StateSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import android.widget.MaterialEditText;
import com.training.android.material.R;
import com.training.android.material.model.Contact;
import com.training.android.material.util.EnumUtils;
import com.training.android.material.util.ThemeUtils;
import org.apache.commons.lang3.text.WordUtils;

public class RegisterContactActivity extends ActionBarActivity {

    @InjectView(R.id.register_contact_edt_phone_type) MaterialEditText edtPhoneType;
    @InjectView(R.id.register_contact_edt_email_type) MaterialEditText edtEmailType;
    @InjectView(R.id.register_contact_edt_address_type) MaterialEditText edtAddressType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_contact);
        ButterKnife.inject(this);
        ActionBar toolbar = getSupportActionBar();
        if (toolbar != null) {
            toolbar.setDisplayShowTitleEnabled(false);
            toolbar.setDisplayHomeAsUpEnabled(true);
        }

        setupDropdownViews();

        edtPhoneType.setText(WordUtils.capitalizeFully(Contact.PhoneType.MOBILE.toString()));
        edtEmailType.setText(WordUtils.capitalizeFully(Contact.EmailType.HOME.toString()));
        edtAddressType.setText(WordUtils.capitalizeFully(Contact.AddressType.HOME.name()));
    }

    private void setupDropdownViews() {
        Drawable arrow;
        StateListDrawable arrowSelector = new StateListDrawable();

        arrow = getResources().getDrawable(R.drawable.ic_arrow_drop_down_black_24dp);
        arrow.setColorFilter(ThemeUtils.obtainColorAccent(this), PorterDuff.Mode.SRC_ATOP);
        arrowSelector.addState(new int[]{ android.R.attr.state_pressed }, arrow);
        arrowSelector.addState(new int[]{ android.R.attr.state_focused }, arrow);

        arrow = getResources().getDrawable(R.drawable.ic_arrow_drop_down_grey600_24dp);
        arrowSelector.addState(StateSet.WILD_CARD, arrow);

        edtPhoneType.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector.getConstantState().newDrawable(), null);
        edtEmailType.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector.getConstantState().newDrawable(), null);
        edtAddressType.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector.getConstantState().newDrawable(), null);

        edtPhoneType.setFocusableInTouchMode(false);
        edtEmailType.setFocusableInTouchMode(false);
        edtAddressType.setFocusableInTouchMode(false);
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
            // TODO: Perform action after true validation.
            Toast.makeText(this, "Added!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.register_contact_edt_phone_type)
    protected void onPhoneTypeEditTextClick(View v) {
        makePopup((TextView) v, EnumUtils.capitalizedFullyNames(Contact.PhoneType.class)).show();
    }

    @OnClick(R.id.register_contact_edt_email_type)
    protected void onEmailTypeEditTextClick(View v) {
        makePopup((TextView) v, EnumUtils.capitalizedFullyNames(Contact.EmailType.class)).show();
    }

    @OnClick(R.id.register_contact_edt_address_type)
    protected void onAddressTypeEditTextClick(View v) {
        makePopup((TextView) v, EnumUtils.capitalizedFullyNames(Contact.AddressType.class)).show();
    }

    private PopupMenu makePopup(final TextView v, String[] items) {
        PopupMenu popup = new PopupMenu(this, v);
        for (int i = 0; i < items.length; i++) {
            popup.getMenu().add(Menu.NONE, Menu.NONE, Menu.NONE, items[i]);
        }
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                v.setText(item.getTitle());
                return true;
            }
        });
        return popup;
    }
}
