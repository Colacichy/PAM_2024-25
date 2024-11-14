package com.example.pam_drawer_app.ui.zad2;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pam_drawer_app.R;

import java.lang.reflect.Array;

public class nav_zad2 extends Fragment {

    private NavZad2ViewModel mViewModel;

    public static nav_zad2 newInstance() {
        return new nav_zad2();
    }

    private ImageView imageView;
    private Button previousButton;
    private Button nextButton;
    private TextView textUnder;
    private int[] images = {
            R.drawable.obraz1,
            R.drawable.obraz2,
            R.drawable.obraz3,
            R.drawable.obraz4,
            R.drawable.obraz5,
            R.drawable.obraz6,
            R.drawable.obraz7
    };
    private String[] texts = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec id rutrum justo. Sed eu mi purus. Quisque dignissim, diam ornare dapibus mollis, justo arcu dignissim felis, vitae sodales risus mauris eget metus. In egestas lectus nec vestibulum facilisis. Donec egestas leo id diam mattis, vitae laoreet lectus volutpat. Mauris tincidunt libero purus, sit amet eleifend est suscipit at. Sed non dapibus quam. Aliquam aliquam magna eget ante rutrum, non vulputate orci mollis. Donec a risus eget nulla ornare gravida in quis nunc. Aenean non ipsum nibh.",
            "Donec ullamcorper tortor nec ultricies dictum. Donec cursus turpis tempor urna laoreet condimentum. Aenean semper diam justo, at fringilla quam sagittis sit amet. Mauris lobortis dapibus lacus at ornare. Mauris tellus eros, placerat id velit id, ultrices aliquam mi. Aenean felis elit, vulputate eget volutpat eget, feugiat nec felis. Vivamus at ligula auctor, iaculis lorem sed, porttitor felis.",
            "Curabitur hendrerit nulla enim, ut sodales sem placerat ac. Maecenas scelerisque velit eget varius ultrices. Integer non posuere ex. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Cras a ultrices lorem, vitae ultrices arcu. Ut ac orci pharetra, eleifend felis a, volutpat turpis. In hac habitasse platea dictumst.",
            "Donec ut placerat metus. Morbi tincidunt, lorem non dignissim bibendum, ex dolor dictum augue, eu posuere elit erat sed sem. Etiam sed arcu sagittis, volutpat quam eget, tempor orci. Nulla sagittis rutrum laoreet. Nam maximus ipsum ut aliquet aliquam. Nam pretium tincidunt sollicitudin. Quisque in ultricies est. Integer euismod eget erat non congue. In bibendum feugiat velit, ut sagittis ipsum feugiat in.",
            "Nam orci leo, varius eget eros ac, pretium hendrerit felis. Mauris sit amet augue quis arcu vehicula condimentum vel vel quam. Curabitur vitae quam vel mi gravida consequat vel quis lorem. Etiam at neque aliquam, elementum velit id, tristique nunc. Sed quis pulvinar lectus, sit amet imperdiet ipsum. In hac habitasse platea dictumst. Maecenas vestibulum viverra urna, et vestibulum elit euismod ac.",
            "Proin volutpat a odio eget suscipit. Integer consectetur lacus non tortor maximus, at dignissim leo commodo. Morbi tempor diam eu pharetra bibendum. Mauris rutrum maximus nibh, at ornare elit. In consequat justo iaculis, condimentum massa non, efficitur nunc. Phasellus vel placerat ante. Maecenas id lacus a augue blandit condimentum vitae vel est. ",
            "Nullam nunc lectus, dapibus id imperdiet ac, pulvinar vel felis. Cras egestas magna elit, id aliquam nulla congue sit amet. Suspendisse potenti. Vestibulum tempus vehicula sem, quis vulputate tortor suscipit sit amet. Aliquam at lacus felis. Pellentesque tempus lorem et quam viverra, eu maximus purus viverra."};
    private int currentIndex;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_zad2, container, false);

        imageView = view.findViewById(R.id.photoCarousel);
        previousButton = view.findViewById(R.id.prevButton);
        nextButton = view.findViewById(R.id.nxtButton);
        textUnder = view.findViewById(R.id.textUnder);

        imageView.setImageResource(images[currentIndex]);
        textUnder.setText(texts[currentIndex]);
        updateButtonStatus();
        currentIndex = 0;

        previousButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                if (currentIndex > 0){
                    currentIndex --;
                    imageView.setImageResource(images[currentIndex]);
                    textUnder.setText(texts[currentIndex]);
                    updateButtonStatus();
                }

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                if (currentIndex < images.length){
                    currentIndex ++;
                    imageView.setImageResource(images[currentIndex]);
                    textUnder.setText(texts[currentIndex]);
                    updateButtonStatus();
                }
            }
        });

        return view;
    }

    private void updateButtonStatus(){
        previousButton.setEnabled(currentIndex > 0);
        nextButton.setEnabled(currentIndex < (images.length - 1));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NavZad2ViewModel.class);
        // TODO: Use the ViewModel
    }

}