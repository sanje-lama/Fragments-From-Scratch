package com.example.stl.fragmentfromscratch.controllers;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stl.fragmentfromscratch.R;

import com.example.stl.fragmentfromscratch.model.Planets;
import com.example.stl.fragmentfromscratch.view.PlanetViewHolder;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetViewHolder> {
    private List<Planets> planetsList;

    public PlanetAdapter(List<Planets> planetsList) {
        this.planetsList = planetsList;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,viewGroup,false);
        return new PlanetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder planetViewHolder, int i) {
        Planets planets = planetsList.get(i);
        planetViewHolder.onBind(planets);

    }

    @Override
    public int getItemCount() {
        return planetsList.size();
    }
}
