package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class LearnActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        Toolbar toolbar = findViewById(R.id.toolbarLearn);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Learn more");
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, LearnActivity.class);
    }
}