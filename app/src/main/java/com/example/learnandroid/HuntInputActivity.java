package com.example.learnandroid;

import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnandroid.model.dodo.Dodo;
import com.example.learnandroid.model.dodo.DodoWaddle;
import com.example.learnandroid.model.island.Island;
import com.example.learnandroid.model.island.IslandCalculator;
import com.example.learnandroid.model.sailor.Sailor;

import java.util.Objects;

/**
 * Takes hunt info inputs from user and stores them in IslandCalculator
 */
public class HuntInputActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunt_input);

        Toolbar toolbar = findViewById(R.id.toolbarHunt);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Dodo Hunt");

        setupButton();
    }

    private void setupButton() {
        Button button = findViewById(R.id.hunt_btnSubmit);
        button.setOnClickListener(view -> {
            String strDistDodo = ((TextView) findViewById(R.id.hunt_txtfill1)).getText().toString();
            String strDistSailor = ((TextView) findViewById(R.id.hunt_txtfill2)).getText().toString();
            String strHealthSailor = ((TextView) findViewById(R.id.hunt_txtfill3)).getText().toString();
            double distDodo = Double.parseDouble(strDistDodo);
            double distSailor = Double.parseDouble(strDistSailor);
            int healthSailor = Integer.parseInt(strHealthSailor);

            if (strDistDodo.isEmpty() || strDistSailor.isEmpty() || strHealthSailor.isEmpty()) {
                Toast.makeText(HuntInputActivity.this, "All fields must be filled.", Toast.LENGTH_LONG).show();
            } else if (healthSailor < 1 || 10 < healthSailor) {
                Toast.makeText(HuntInputActivity.this, "Health must be from 1 to 10 inclusive.", Toast.LENGTH_LONG).show();
            } else {
                Sailor sailor = new Sailor(distSailor, healthSailor);
                Dodo dodo = DodoWaddle.getInstance().clickedDodo;
                Island island = new Island(dodo, distDodo, sailor);
                IslandCalculator c = IslandCalculator.getInstance();
                c.calcSurvival(island);
                startActivity(HuntResultsActivity.makeIntent(HuntInputActivity.this));
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, HuntInputActivity.class);
    }
}