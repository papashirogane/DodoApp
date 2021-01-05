package com.example.learnandroid.model.island;

import com.example.learnandroid.model.dodo.Dodo;
import com.example.learnandroid.model.sailor.Sailor;

/**
 * Stores current run's island, with dodo and sailor information
 */
public class Island {
    public Dodo dodo;
    public Sailor sailor;

    public Island(Dodo dodo, double distDodoCaveM, Sailor sailor) {
        this.dodo = dodo;
        this.dodo.distDodoCaveM = distDodoCaveM;
        this.sailor = sailor;
    }
}
