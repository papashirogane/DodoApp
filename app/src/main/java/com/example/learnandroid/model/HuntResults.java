package com.example.learnandroid.model;

/**
 * Singleton class that stores the Results from the most recent hunt
 * These results include a basic scientific explanation of the differences in bipedal locomotion
 *
 *
 * why not just put these in a new activity, and pass in their respective speeds and times through extras?
 * ..doing extras would take too much code. this is more simple
 * ....okay, then why not grab the respective speeds from a singleton of IslandCalculator so they stick around?
 * ....island calculator would have to be rewritten each time
 * ....okay, make islandcalculator a singleton
 */
public class HuntResults {
    private static HuntResults single_instance = null;
    public double dodoSpeed;
    public double dodoTime;
    public double sailorSpeed;
    public double sailorTime;

    private HuntResults() {
    }

    public static HuntResults getInstance() {
        if (single_instance == null) {
            single_instance = new HuntResults();
        }
        return single_instance;
    }

    public void setFields(double dodoSpeed, double dodoTime, double sailorSpeed, double sailorTime) {
        this.dodoSpeed = dodoSpeed;
        this.dodoTime = dodoTime;
        this.sailorSpeed = sailorSpeed;
        this.sailorTime = sailorTime;
    }
}
