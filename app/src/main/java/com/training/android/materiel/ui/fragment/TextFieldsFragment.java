package com.training.android.materiel.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.training.android.materiel.R;
import com.training.android.materiel.ui.activity.SearchableActivity;

public class TextFieldsFragment extends Fragment {

    @InjectView(R.id.text_fields_btn_search_filter) Button btnSearchSilter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_fields, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @OnClick(R.id.text_fields_btn_search_filter)
    protected void onButtonClicked(View view) {
        startActivity(new Intent(getActivity(), SearchableActivity.class));
    }
}
