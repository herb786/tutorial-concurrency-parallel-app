package com.hacaller.laureatesapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hacaller.business.Laureate;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Herbert Caller on 09/11/2018.
 */
public class LaureateAdapter extends RecyclerView.Adapter<LaureateAdapter.LaureateItemView> {


    List<Laureate> laureates = new ArrayList<>();

    public void setLaureates(List<Laureate> list) {
        laureates.clear();
        laureates.addAll(list);
        notifyDataSetChanged();
    }

    public void addLaureate(Laureate laureate){
        laureates.add(laureate);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LaureateItemView onCreateViewHolder(@NonNull ViewGroup v, int i) {
        View view = LayoutInflater.from(v.getContext()).inflate(R.layout.laureate_item,v, false);
        return new LaureateItemView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LaureateItemView laureateItemView, int i) {
        laureateItemView.bind(laureates.get(i));
    }

    @Override
    public int getItemCount() {
        return laureates.size();
    }

    class LaureateItemView extends RecyclerView.ViewHolder {

        TextView txtName;
        ImageView imgPhoto;

        public LaureateItemView(@NonNull View c) {
            super(c);
            txtName = c.findViewById(R.id.txtName);
            imgPhoto = c.findViewById(R.id.imgPhoto);
        }

        void bind(Laureate laureate){
            txtName.setText(laureate.getName());
            if (!laureate.getPhoto().isEmpty()) Picasso.get().load(laureate.getPhoto()).into(imgPhoto);
        }

    }

}
