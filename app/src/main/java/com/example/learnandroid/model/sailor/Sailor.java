package com.example.learnandroid.model.sailor;

/**
 * Sailor running info
 *
 * Inputs:
 *      distance from cave
 *      health (affects personal max speed)
 */
public class Sailor {
    private double distSailorCaveM;
    private static double homoMaxSpeed = 11;    // guess from Blanco 2003, it suggests humans can likely go higher
    private static double personalMaxSpeed;
    private final int health;
    private final double healthAdjuster = 7;    // Assumes that Health Option 7 (burly sailor) has personalMaxSpeed of 11

    public Sailor(double distSailorCaveM, int health) {
        this.distSailorCaveM = distSailorCaveM;
        this.health = health;
        personalMaxSpeed = homoMaxSpeed * (health / healthAdjuster);
    }

    public double getPersonalMaxSpeed() {
        return personalMaxSpeed;
    }

    public double getDistSailorCaveM() {
        return distSailorCaveM;
    }
}
