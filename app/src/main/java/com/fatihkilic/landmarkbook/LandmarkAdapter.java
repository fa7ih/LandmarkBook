package com.fatihkilic.landmarkbook;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fatihkilic.landmarkbook.databinding.ActivityMainBinding;
import com.fatihkilic.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHoder> {

    ArrayList<LandMark> landMarkArrayList;

    public LandmarkAdapter(ArrayList<LandMark> landMarkArrayList) {
        this.landMarkArrayList = landMarkArrayList;
    }

    @NonNull

    //binding bağlama
    @Override
    public LandmarkHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHoder(recyclerRowBinding);
    }

    //LandmarkHolder sınıfı ile bağlandıktan sonra neler olacak
    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull LandmarkHoder holder, int position) {
        holder.binding.recyclerViewTextView.setText(landMarkArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenLandmark(landMarkArrayList.get(position));
                //intent.putExtra("landmark",landmarkList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    //examle in kaç defa oluşturduğunu söyler
    @Override
    public int getItemCount() {
        return landMarkArrayList.size();
    }

    public class LandmarkHoder extends RecyclerView.ViewHolder{

        private RecyclerRowBinding binding;

        public LandmarkHoder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }
    }


}
