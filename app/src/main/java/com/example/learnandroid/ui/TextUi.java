/*
package com.example.learnandroid.ui;

import model.dodo.Dodo;
import model.dodo.DodoCalculator;
import model.dodo.DodoWaddle;
import model.island.Island;
import model.island.IslandCalculator;
import model.sailor.Sailor;
import model.sailor.SailorHealthOpts;

import java.text.DecimalFormat;
import java.util.Scanner;

*/
/**
 * User picks a dodo, inputs dodo and sailor distances from cave, and chooses sailor health.
 * Prints out whether a dodo survives being hunted by sailor.
 *//*

public class TextUi {
    private DodoWaddle waddle = new DodoWaddle();
    private final Scanner in = new Scanner(System.in);
    private Dodo dodo;
    private Island island;

    public TextUi() {
        waddle.add(new Dodo("Baby", 3));
        waddle.add(new Dodo("Emo Teen", 5));
        waddle.add(new Dodo("Mama Dodo", 7));
        waddle.add(new Dodo("Happy Papi", 10));
        waddle.add(new Dodo("Big Uncle", 15));
        waddle.add(new Dodo("Lil Rhea", 20));
    }

    public void show() {
        boolean isDone = false;
        while (!isDone) {
            printDodos();
            System.out.println("Pick a dodo [0-" + (waddle.size() - 1) + "] or -1 to exit:");
            int choice = in.nextInt();
            if (choice == -1) {
                isDone = true;
            } else if (choice >= waddle.size()) {
                System.out.println("Sorry! Invalid Dodo number. Try again.");
            } else {
                dodo = waddle.get(choice);
                buildIsland();
                printSurvival();
            }
        }
    }

    private void buildIsland() {
        Sailor sailor = new Sailor(getDistToCave("burly sailor"), getSailorHealth());
        island = new Island(dodo, getDistToCave("cute dodo"), sailor);
    }

    private double getDistToCave(String animal) {
        while (true) {
            System.out.println("How far is your " + animal + " from the cave? (in metres):");
            double choice = in.nextInt();
            if (choice < 0) {
                System.out.println("Distance cannot be negative. Try again.");
            } else {
                return choice;
            }
        }
    }

    private int getSailorHealth() {
        boolean isDone = false;
        while (!isDone) {
            printSailorHealthOpts();
            int choice = in.nextInt();
            if (choice == -1) {
                isDone = true;
            } else if ((choice < 1) || (choice > 10)) {
                System.out.println("Sailor health must be between 1 and 10 inclusive. Try again.");
            } else {
                return choice;
            }
        }
        return 0;
    }

    private void printSailorHealthOpts() {
        SailorHealthOpts ops = new SailorHealthOpts();
        System.out.println(ops.getQuestion());
        for (String s : ops) {
            System.out.println(s);
        }
    }

    private void printSurvival() {
        new DodoCalculator(dodo);
        IslandCalculator c = new IslandCalculator(island);
        System.out.println("Dodo speed: " + format(dodo.maxSpeed) + "m/s, Dodo time: " + format(c.dodoTime) + "s");
        System.out.println("Sailor speed: " + format(island.sailor.getPersonalMaxSpeed()) + "m/s, Sailor time: " + format(c.sailorTime) + "s");
        if (!c.survival) {
            System.out.println("OM NOM NOM! The sailor is happy and full, unlike the dodo.");
        } else {
            System.out.println("Congrats! Your dodo " + dodo.getName() + " is now enjoying a snack of berries and crabs in its cave.");
        }
    }

    private void printDodos() {
        System.out.println("List of dodos in the Mauritius Island waddle:");
        int i = 0;
        for (Dodo d : waddle) {
            System.out.println("  " + i + ": " + d);
            i++;
        }
    }

    public String format(double amount) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(amount);
    }
}
*/
