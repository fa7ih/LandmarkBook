package com.fatihkilic.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.fatihkilic.landmarkbook.databinding.ActivityDetailsBinding;
import com.fatihkilic.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ArrayList<LandMark> landMarkArrayList;
    private ActivityMainBinding binding;
//    static  LandMark chosenLandmark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landMarkArrayList = new ArrayList<>();

        LandMark landMark = new LandMark("Pisa","Italy",R.drawable.pisa);
        LandMark landMark2 = new LandMark("Eiffel","France",R.drawable.eyfel);
        LandMark landMark3 = new LandMark("Collesseum","Italy",R.drawable.collosseum);
        LandMark landMark4 = new LandMark("London Bridge","England",R.drawable.londonbridge);

        landMarkArrayList.add(landMark);
        landMarkArrayList.add(landMark2);
        landMarkArrayList.add(landMark3);
        landMarkArrayList.add(landMark4);

        //RecylclerView
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext())); //listeleri alt alta yazmak için
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landMarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);

    }
}