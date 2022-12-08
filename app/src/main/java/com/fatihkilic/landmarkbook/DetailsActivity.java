package com.fatihkilic.landmarkbook;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fatihkilic.landmarkbook.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Intent intent = getIntent();
        //LandMark selectedLandmark = (LandMark) intent.getSerializableExtra("landmark");

        Singleton singleton = Singleton.getInstance();
        LandMark selectedLandmark=singleton.getSentLandmark();


        //LandMark selectedLandmark = chosenLandmark;
        binding.nameText.setText(selectedLandmark.name);
        binding.countryText.setText(selectedLandmark.country);
        binding.imageView.setImageResource(selectedLandmark.image);

    }
}