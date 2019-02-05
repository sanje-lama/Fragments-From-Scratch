package com.example.stl.fragmentfromscratch.model;

import java.util.List;

public class PlanetList {
    private List<Planets> planets;

    public PlanetList(List<Planets> planets) {
        this.planets = planets;
    }

    public List<Planets> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planets> planets) {
        this.planets = planets;
    }
}
