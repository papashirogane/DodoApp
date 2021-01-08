package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnandroid.model.dodo.Dodo;
import com.example.learnandroid.model.dodo.DodoWaddle;
import com.example.learnandroid.model.island.Island;
import com.example.learnandroid.model.island.IslandCalculator;
import com.example.learnandroid.model.sailor.Sailor;

public class HuntInputActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunt_input);

        Toolbar toolbar = findViewById(R.id.toolbarHunt);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dodo Hunt");

        setupButton();
    }

    private void setupButton() {
        Button button = (Button) findViewById(R.id.hunt_btnSubmit);
        button.setOnClickListener(view -> {
            String strDistDodo = ((TextView) findViewById(R.id.hunt_txtfill1)).getText().toString();
            String strDistSailor = ((TextView) findViewById(R.id.hunt_txtfill2)).getText().toString();
            String strHealthSailor = ((TextView) findViewById(R.id.hunt_txtfill3)).getText().toString();
            if (strDistDodo.isEmpty() || strDistSailor.isEmpty() || strHealthSailor.isEmpty()) {
                Toast.makeText(HuntInputActivity.this, "All fields must be filled.", Toast.LENGTH_LONG).show();
            } else {
                Double distDodo = Double.parseDouble(strDistDodo);
                Double distSailor = Double.parseDouble(strDistSailor);
                Integer healthSailor = Integer.parseInt(strHealthSailor);

                Sailor sailor = new Sailor(distSailor, healthSailor);
                Dodo dodo = DodoWaddle.getInstance().clickedDodo;
                Island island = new Island(dodo, distDodo, sailor);
                IslandCalculator c = new IslandCalculator(island);
                Toast.makeText(HuntInputActivity.this, c.getMessage()
                        + "\nYour sailor's speed was " + sailor.getPersonalMaxSpeed()
                        + ".\nYour dodo's speed was " + dodo.maxSpeed, Toast.LENGTH_LONG).show();
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, HuntInputActivity.class);
    }
}