package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ReferencesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references);

        Toolbar toolbar = findViewById(R.id.toolbarReferences);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("References");
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, ReferencesActivity.class);
    }
}