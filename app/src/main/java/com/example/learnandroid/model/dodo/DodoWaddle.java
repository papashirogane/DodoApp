package com.example.learnandroid.model.dodo;

import com.example.learnandroid.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List of dodos (a group of dodos is called a "waddle").
 */
public class DodoWaddle implements Iterable<Dodo> {
    private static DodoWaddle single_instance = null;
    public List<Dodo> waddle = new ArrayList<>();
    public Dodo clickedDodo;
    public final int[] iconOpts = {R.drawable.ic_add, R.drawable.ic_settings
            , R.drawable.ic_home, R.drawable.ic_info
            , R.drawable.ic_night, R.drawable.ic_edit};

    private DodoWaddle() {
        waddle.add(new Dodo("Baby", 3, R.drawable.lazy1, "One day I'm gonna be 15 metres tall!"));
        waddle.add(new Dodo("Gizzard", 7, R.drawable.lazy3, "Gizzard stones play an important role in my species' digestion."));
        waddle.add(new Dodo("Mayor", 10, R.drawable.lazy4, "Humans call me a mayor to insinuate that I'm rich and fat."));
        waddle.add(new Dodo("Chomper", 15, R.drawable.lazy5, "I use my strong beak to crush raw fruit... and to bite sailors."));
        waddle.add(new Dodo("Lil Rhea", 20, R.drawable.lazy6, "I'm about the same mass as a small Rhea americana."));
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
