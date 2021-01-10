package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // R = all the stuff (ids) that the compiler is generating for me

        setupStartButton();
    }

    private void setupStartButton() {
        ImageView btn = (ImageView) findViewById(R.id.btnStart);
        btn.setOnClickListener(view -> {
            Intent intent = DodoListActivity.makeIntent(MainActivity.this);
            startActivity(intent);
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
}