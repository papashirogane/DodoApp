package com.example.learnandroid.model.dodo;

import com.example.learnandroid.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List of dodos (a group of dodos is called a "waddle").
 * Keeps track of which dodo was most recently clicked.
 * Includes list of icon options (for adding or editing dodos).
 */
public class DodoWaddle implements Iterable<Dodo> {
    private static DodoWaddle single_instance = null;
    public List<Dodo> waddle = new ArrayList<>();
    public Dodo clickedDodo;
    public final int[] iconOpts = {R.drawable.ic_beak, R.drawable.ic_egg
            , R.drawable.ic_gizzard, R.drawable.ic_mayor
            , R.drawable.ic_rhea, R.drawable.ic_wing};

    private DodoWaddle() {
        waddle.add(new Dodo("Baby", 3, R.drawable.ic_egg, "One day I'm gonna be 15 metres tall!"));
        waddle.add(new Dodo("Gizzard", 7, R.drawable.ic_gizzard, "Gizzard stones play an important role in my species' digestion."));
        waddle.add(new Dodo("Mayor", 10, R.drawable.ic_wing, "Humans call me a mayor to insinuate that I'm rich and fat."));
        waddle.add(new Dodo("Chomper", 15, R.drawable.ic_beak, "I use my strong beak to crush raw fruit... and to bite sailors."));
        waddle.add(new Dodo("Lil Rhea", 20, R.drawable.ic_rhea, "I'm about the same mass as a small Rhea americana."));
    }

    public static DodoWaddle getInstance() {
        if (single_instance == null) {
            single_instance = new DodoWaddle();
        }
        return single_instance;
    }

    public void add(Dodo dodo) {
        waddle.add(dodo);
    }

    public int size() {
        return waddle.size();
    }

    public Dodo get(int i) {
        return waddle.get(i);
    }

    @Override
    public Iterator<Dodo> iterator() {
        return waddle.iterator();
    }
}
