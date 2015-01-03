package com.training.android.materiel.ui.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.training.android.materiel.R;
import com.training.android.materiel.model.Contact;
import com.training.android.materiel.util.EnumUtils;
import org.apache.commons.lang3.text.WordUtils;

public class RegisterContactActivity extends Activity {

    @InjectView(R.id.register_contact_medt_phone_type) MaterialEditText medtPhoneType;
    @InjectView(R.id.register_contact_medt_email_type) MaterialEditText medtEmailType;
    @InjectView(R.id.register_contact_medt_address_type) MaterialEditText medtAddressType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_contact);
        ButterKnife.inject(this);
        ActionBar toolbar = getActionBar();
        if (toolbar != null) {
            toolbar.setDisplayShowTitleEnabled(false);
        }

        setupDropdownViews();

        medtPhoneType.setText(WordUtils.capitalizeFully(Contact.PhoneType.MOBILE.toString()));
        medtEmailType.setText(WordUtils.capitalizeFully(Contact.EmailType.HOME.toString()));
        medtAddressType.setText(WordUtils.capitalizeFully(Contact.AddressType.HOME.name()));
    }

    private void setupDropdownViews() {
        Drawable arrow;
        StateListDrawable arrowSelector = new StateListDrawable();

        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.colorAccent, tv, true) && tv.resourceId > 0) {
            int selectedColor = getResources().getColor(tv.resourceId);
            arrow = getResources().getDrawable(R.drawable.navigation_ic_arrow_drop_down);
            arrow.mutate().setColorFilter(selectedColor, PorterDuff.Mode.SRC_IN);
            arrowSelector.addState(new int[]{ android.R.attr.state_pressed }, arrow);
            arrowSelector.addState(new int[]{ android.R.attr.state_focused }, arrow);
        }
        if (getTheme().resolveAttribute(android.R.attr.textColorSecondary, tv, true) && tv.resourceId > 0) {
            int secondaryColor = getResources().getColor(tv.resourceId);
            arrow = getResources().getDrawable(R.drawable.navigation_ic_arrow_drop_down);
            arrow.mutate().setColorFilter(secondaryColor, PorterDuff.Mode.SRC_IN);
            arrowSelector.addState(StateSet.WILD_CARD, arrow);
        }

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
