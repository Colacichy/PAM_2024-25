package com.example.pam_drawer_app.ui.zad3;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pam_drawer_app.R;

import java.util.ArrayList;

public class nav_zad3 extends Fragment {

    private ListView listView;
    private TextView textView;
    private View buttonAdd;
    private ArrayList<String> itemsList;
    private MyCustomAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nav_zad3, container, false);
        listView = view.findViewById(R.id.listView);
        textView = view.findViewById(R.id.textView2);
        buttonAdd = view.findViewById(R.id.buttonAdd);

        itemsList = new ArrayList<>();
        adapter = new MyCustomAdapter(itemsList);

        listView.setAdapter(adapter);

        buttonAdd.setOnClickListener(v -> {
            String text = textView.getText().toString().trim();
            if (!text.isEmpty()) {
                itemsList.add(text);
                adapter.notifyDataSetChanged();
                textView.setText("");
            } else {
                Toast.makeText(view.getContext(), "Wpisz cokolwiek", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private class MyCustomAdapter extends BaseAdapter {
        private ArrayList<String> data;

        MyCustomAdapter(ArrayList<String> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int item) {
            return data.get(item);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }

            TextView itemText = convertView.findViewById(R.id.itemText);
            ImageView deleteIcon = convertView.findViewById(R.id.deleteIcon);

            itemText.setText(data.get(position));

            deleteIcon.setOnClickListener(v -> {
                data.remove(position);
                notifyDataSetChanged();
            });

            return convertView;
        }
    }
}
