package com.example.pam_drawer_app.ui.zad1;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pam_drawer_app.R;
import com.google.android.material.snackbar.Snackbar;

public class nav_zad1 extends Fragment {

    private NavZad1ViewModel mViewModel;

    public static nav_zad1 newInstance() {
        return new nav_zad1();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_zad1, container, false);

        Button button = view.findViewById(R.id.changeButton);
        EditText editText = view.findViewById(R.id.editText);
        CheckBox checkBox = view.findViewById(R.id.checkBoxToast);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if(text.length() == 0){
                        text = "NIE WPISANO TEKSTU";
                }

                if(checkBox.isChecked()){

                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else{
                    Snackbar.make(v, text, Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NavZad1ViewModel.class);
        // TODO: Use the ViewModel
    }




}