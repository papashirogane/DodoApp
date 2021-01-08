package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnandroid.model.island.IslandCalculator;

import java.text.DecimalFormat;

public class HuntResultsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunt_results);

        Toolbar toolbar = findViewById(R.id.toolbarHuntResults);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dodo Hunt");

        setupTable();
        setupLearnMoreButton();
        setupHuntAgainButton();
    }

    private void setupTable() {
        TextView textView = findViewById(R.id.results_txtTable);
        textView.setText(String.format(
                "Dodo time: %s s\nSailor time: %s s\n\nDodo speed: %s m/s\nSailor speed: %s m/s"
                , format(IslandCalculator.getInstance().dodoTime)
                , format(IslandCalculator.getInstance().sailorTime)
                , format(IslandCalculator.getInstance().island.dodo.maxSpeed)
                , format(IslandCalculator.getInstance().island.sailor.getPersonalMaxSpeed())));
    }

    private void setupLearnMoreButton() {
        Button button = (Button) findViewById(R.id.results_btnLearn);
        button.setOnClickListener(view -> {
            Toast.makeText(HuntResultsActivity.this, "Learning More", Toast.LENGTH_LONG).show();
        });
    }

    private void setupHuntAgainButton() {
        Button button = (Button) findViewById(R.id.results_btnAgain);
        button.setOnClickListener(view -> {
            Toast.makeText(HuntResultsActivity.this, "Hunting Again", Toast.LENGTH_LONG).show();
        });
    }

    public String format(double amount) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(amount);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, HuntResultsActivity.class);
    }
}