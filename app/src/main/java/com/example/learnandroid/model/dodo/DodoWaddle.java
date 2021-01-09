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

    private DodoWaddle() {
        waddle.add(new Dodo("Baby", 3, R.drawable.lazy1, "Waaaaa!"));
        waddle.add(new Dodo("Emo Teen", 5, R.drawable.lazy2, "Go away mom."));
        waddle.add(new Dodo("Mama Dodo", 7, R.drawable.lazy3, "I gotta quit smoking."));
        waddle.add(new Dodo("Happy Papi", 10, R.drawable.lazy4, "Borgor."));
        waddle.add(new Dodo("Big Uncle", 15, R.drawable.lazy5, "Look at these GUNS *slaps biceps*"));
        waddle.add(new Dodo("Lil Rhea", 20, R.drawable.lazy6, "I'm about the size and mass of a "));
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
