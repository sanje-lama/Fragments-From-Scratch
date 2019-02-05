package com.example.stl.fragmentfromscratch.networks;

import com.example.stl.fragmentfromscratch.model.PlanetList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlanetService {

    @GET("/JDVila/storybook/master/planets.json")
    Call<PlanetList> planetData();
}
