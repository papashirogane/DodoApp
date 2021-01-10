package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO;
import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

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
        getSupportActionBar().setTitle("Settings");

        setupDarkSwitch();
    }

    private void setupDarkSwitch() {
        Switch darkSwitch = (Switch) findViewById(R.id.switchDark);
        darkSwitch.setOnCheckedChangeListener((compoundButton, b) -> Toast.makeText(SettingsActivity.this, "Sorry, no dark mode.", Toast.LENGTH_LONG).show());

    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, SettingsActivity.class);
    }
}