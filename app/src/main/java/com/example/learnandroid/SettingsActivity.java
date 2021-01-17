package com.example.learnandroid;

import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Objects;

/**
 * Settings. Contains dark mode theme change (unimplemented)
 */
public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = findViewById(R.id.toolbarSettings);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Settings");

        setupDarkSwitch();
    }

    private void setupDarkSwitch() {
        Switch darkSwitch = findViewById(R.id.switchDark);
        darkSwitch.setOnCheckedChangeListener((compoundButton, b) -> Toast.makeText
                (SettingsActivity.this, "Sorry, no dark mode.", Toast.LENGTH_SHORT)
                .show());

    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, SettingsActivity.class);
    }
}