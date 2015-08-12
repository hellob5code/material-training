package fr.erictruong.material.training.ui.core.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.erictruong.material.training.R;

public class DummyFragment extends Fragment {

    public static DummyFragment newInstance() {
        Bundle args = new Bundle();
        DummyFragment fragment = new DummyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dummy, container, false);
    }
}
