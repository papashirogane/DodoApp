package com.example.learnandroid.model.island;

import com.example.learnandroid.model.dodo.DodoCalculator;

/**
 * Takes an island (dodo distance from cave and sailor distance from cave) and calculates whether dodo will survive or be caught.
 * If sailor can get to cave faster than dodo, dodo dies.
 * If dodo can get to cave faster than sailor, dodo survives.
 */
public class IslandCalculator {
    private static IslandCalculator single_instance = null;
    public Island island;
    public double sailorTime;
    public double dodoTime;
    public boolean survival = false;
    public final static String[] messages = new String[]
            {"Om nom nom! Your hungry sailor is no longer hungry.", "Congrats! Your cute dodo made it back home in one piece."};

    public static IslandCalculator getInstance() {
        if (single_instance == null) {
            single_instance = new IslandCalculator();
        }
        return single_instance;
    }

    public void calcSurvival(Island island) {
        this.island = island;
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
        DodoCalculator c = new DodoCalculator(island.dodo);
        return island.dodo.distDodoCaveM / island.dodo.maxSpeed;
    }

    public String getMessage() {
        if (survival) { return messages[1]; }
        else { return messages[0]; }
    }
}
