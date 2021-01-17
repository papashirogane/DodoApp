package com.example.learnandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * First page the user sees. Has ImageView button to go to dodo list.
 */
public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // R = all the stuff (ids) that the compiler is generating for me

        setupStartButton();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupStartButton() {
        ImageView btn = findViewById(R.id.btnStart);
        btn.setOnClickListener(view -> {
            Intent intent = DodoListActivity.makeIntent(MainActivity.this);
            startActivity(intent);
            btn.setImageDrawable(getDrawable(R.drawable.dodo_aves_runny_motion));
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
}