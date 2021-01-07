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

public class HuntInputActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunt_input);

        Toolbar toolbar = findViewById(R.id.toolbarHunt);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dodo Speed Calculator");

        setupButton();
    }

    private void setupButton() {
        Button button = (Button) findViewById(R.id.hunt_btnSubmit);
        button.setOnClickListener(view -> {
            String distDodo = ((TextView) findViewById(R.id.hunt_txt1)).getText().toString();
            String distSailor = ((TextView) findViewById(R.id.hunt_txt2)).getText().toString();
            String healthSailor = ((TextView) findViewById(R.id.hunt_txt3)).getText().toString();
            if (distDodo.isEmpty() || distSailor.isEmpty() || healthSailor.isEmpty()) {
                Toast.makeText(HuntInputActivity.this, "All fields must be filled.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(HuntInputActivity.this, "Good job!", Toast.LENGTH_LONG).show();
                startActivity(MainActivity.makeIntent(HuntInputActivity.this));
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, HuntInputActivity.class);
    }
}