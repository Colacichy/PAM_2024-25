package com.example.pam_drawer_app.ui.zad16;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pam_drawer_app.R;

public class nav_zad16 extends Fragment {

    private NavZad16ViewModel mViewModel;

    public static nav_zad16 newInstance() {
        return new nav_zad16();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nav_zad16, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NavZad16ViewModel.class);
        // TODO: Use the ViewModel
    }

}