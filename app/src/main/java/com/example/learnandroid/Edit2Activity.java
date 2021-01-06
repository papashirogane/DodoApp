package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Edit2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit2);

        Toolbar toolbar = findViewById(R.id.toolbarEdit2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit a dodo!");
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, Edit2Activity.class);
    }
}