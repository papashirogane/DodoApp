package com.example.learnandroid.model.sailor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SailorHealthOpts implements Iterable<String> {
    private List<String> healthOps = new ArrayList<>();
    private String question = "How healthy is your sailor on a scale of 1 to 10?:";

    public SailorHealthOpts() {
        healthOps.add("  1: Pretty much dead.");
        healthOps.add("  2: Fallen and can't get up.");
        healthOps.add("  3: Just got stabbed by a treacherous crewmate.");
        healthOps.add("  4: Limping after last night's debacle.");
        healthOps.add("  5: Healthy, but drinking bubble tea with no lid.");
        healthOps.add("  6: A young 17th-century deckhand.");
        healthOps.add("  7: A burly 17th-century experienced sailor.");
        healthOps.add("  8: Literally Usain Bolt.");
        healthOps.add("  9: Me.");
        healthOps.add("  10: ??");
    }

    @Override
    public Iterator<String> iterator() {
        return healthOps.iterator();
    }

    public String getQuestion() {
        return question;
    }
}
