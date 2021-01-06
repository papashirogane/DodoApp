package com.example.learnandroid;

import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Add dodo to waddle
 */
public class AddActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Toolbar toolbar = findViewById(R.id.toolbarAdd);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add a Dodo");
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, AddActivity.class);
    }
}