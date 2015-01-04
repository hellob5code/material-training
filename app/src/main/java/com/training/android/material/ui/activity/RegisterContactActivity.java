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
import android.widget.PopupMenu;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.training.android.material.R;
import com.training.android.material.model.Contact;
import com.training.android.material.util.EnumUtils;
import com.training.android.material.util.ThemeUtils;
import org.apache.commons.lang3.text.WordUtils;

public class RegisterContactActivity extends ActionBarActivity {

    @InjectView(R.id.register_contact_medt_phone_type) MaterialEditText medtPhoneType;
    @InjectView(R.id.register_contact_medt_email_type) MaterialEditText medtEmailType;
    @InjectView(R.id.register_contact_medt_address_type) MaterialEditText medtAddressType;

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

        medtPhoneType.setText(WordUtils.capitalizeFully(Contact.PhoneType.MOBILE.toString()));
        medtEmailType.setText(WordUtils.capitalizeFully(Contact.EmailType.HOME.toString()));
        medtAddressType.setText(WordUtils.capitalizeFully(Contact.AddressType.HOME.name()));
    }

    private void setupDropdownViews() {
        Drawable arrow;
        StateListDrawable arrowSelector = new StateListDrawable();

        int selectedColor = ThemeUtils.obtainAccentColor(this);
        arrow = getResources().getDrawable(R.drawable.ic_arrow_drop_down_black_24dp);
        arrow.mutate().setColorFilter(selectedColor, PorterDuff.Mode.SRC_IN);
        arrowSelector.addState(new int[]{ android.R.attr.state_pressed }, arrow);
        arrowSelector.addState(new int[]{ android.R.attr.state_focused }, arrow);

        arrow = getResources().getDrawable(R.drawable.ic_arrow_drop_down_grey600_24dp);
        arrowSelector.addState(StateSet.WILD_CARD, arrow);

        medtPhoneType.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector.getConstantState().newDrawable(), null);
        medtEmailType.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector.getConstantState().newDrawable(), null);
        medtAddressType.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, arrowSelector.getConstantState().newDrawable(), null);

        medtPhoneType.setFocusableInTouchMode(false);
        medtEmailType.setFocusableInTouchMode(false);
        medtAddressType.setFocusableInTouchMode(false);
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

    @OnClick(R.id.register_contact_medt_phone_type)
    protected void onPhoneTypeEditTextClick(View v) {
        makePopup((TextView) v, EnumUtils.capitalizedFullyNames(Contact.PhoneType.class)).show();
    }

    @OnClick(R.id.register_contact_medt_email_type)
    protected void onEmailTypeEditTextClick(View v) {
        makePopup((TextView) v, EnumUtils.capitalizedFullyNames(Contact.EmailType.class)).show();
    }

    @OnClick(R.id.register_contact_medt_address_type)
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
