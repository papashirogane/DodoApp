package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class DeleteActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Toolbar toolbar = findViewById(R.id.toolbarDelete);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Delete a dodo.");
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, DeleteActivity.class);
    }
}