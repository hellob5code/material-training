package com.training.android.materiel.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.training.android.materiel.R;
import com.training.android.materiel.ui.activity.*;

public class TextFieldsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_fields, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @OnClick(R.id.text_fields_btn_register_event)
    protected void onRegisterEventButtonClicked() {
        startActivity(new Intent(getActivity(), RegisterEventActivity.class));
    }

    @OnClick(R.id.text_fields_btn_register_contact)
    protected void onRegisterContactButtonClicked() {
        startActivity(new Intent(getActivity(), RegisterContactActivity.class));
    }

    @OnClick(R.id.text_fields_btn_register_application)
    protected void onRegisterApplicationButtonClicked() {
        startActivity(new Intent(getActivity(), RegisterApplicationActivity.class));
    }

    @OnClick(R.id.text_fields_btn_register_application_filled)
    protected void onRegisterApplicationFilledButtonClicked() {
        startActivity(new Intent(getActivity(), RegisterApplicationActivity.class));
    }

    @OnClick(R.id.text_fields_btn_compose_email)
    protected void onComposeEmailButtonClicked() {
        startActivity(new Intent(getActivity(), ComposeEmailActivity.class));
    }

    @OnClick(R.id.text_fields_btn_compose_email_no_sender)
    protected void onComposeEmailNoSenderButtonClicked() {
        startActivity(new Intent(getActivity(), ComposeEmailActivity.class));
    }

    @OnClick(R.id.text_fields_btn_register_note)
    protected void onRegisterNoteButtonClicked() {
        startActivity(new Intent(getActivity(), RegisterNoteActivity.class));
    }

    @OnClick(R.id.text_fields_btn_search_filter)
    protected void onSearchFilterButtonClicked() {
        startActivity(new Intent(getActivity(), SearchableActivity.class));
    }
}
