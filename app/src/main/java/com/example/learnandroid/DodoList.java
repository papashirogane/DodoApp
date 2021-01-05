package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class DodoList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodo_list);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, DodoList.class);
    }
}