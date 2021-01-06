package com.example.learnandroid.model.dodo;

public class Dodo {
    private final String name;
    public final double massKg;
    public double distDodoCaveM;
    public double maxSpeed; // change to be automatically inputted, although not shown
    private final String details;

    private int iconId;

    public Dodo(String name, double massKg, int iconId, String details) {
        this.name = name;
        this.massKg = massKg;
        this.iconId = iconId;
        this.details = details;
    }

    @Override
    public String toString() {
        return name;
    }

    public double getMassKg() {
        return massKg;
    }

    public String getName() {
        return name;
    }

    public int getIconId() {
        return iconId;
    }

    public String getDetails() {
        return details;
    }
}
