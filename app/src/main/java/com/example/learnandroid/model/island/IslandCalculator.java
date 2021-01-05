package com.example.learnandroid.model.island;

/**
 * Takes an island (dodo distance from cave and sailor distance from cave) and calculates whether dodo will survive or be caught.
 * If sailor can get to cave faster than dodo, dodo dies.
 * If dodo can get to cave faster than sailor, dodo survives.
 */
public class IslandCalculator {
    private final Island island;
    public double sailorTime;
    public double dodoTime;
    public boolean survival = false;

    public IslandCalculator(Island island) {
        this.island = island;
        calcSurvival();
    }

    public void calcSurvival() {
        sailorTime = calcSailorTime();
        dodoTime = calcDodoTime();
        if (dodoTime < sailorTime) {
            survival = true;
        }
    }

    private double calcSailorTime() {
        return island.sailor.getDistSailorCaveM() / island.sailor.getPersonalMaxSpeed();
    }

    private double calcDodoTime() {
        return island.dodo.distDodoCaveM / island.dodo.maxSpeed;
    }
}
