package com.example.learnandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.learnandroid.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Shows basic biological information about the dodo and its speed factors
 */
public class LearnActivity extends BaseActivity {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        Toolbar toolbar = findViewById(R.id.toolbarLearn);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Learn about Dodos!");

        setupClickableText();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setupClickableText() {
        Util util = Util.getSingleton();
        List<Integer> textBodyIds = new ArrayList<>();
        textBodyIds.add(R.id.learn_txtIntroBody);
        textBodyIds.add(R.id.learn_txtDegBody);
        textBodyIds.add(R.id.learn_txtStrengthBody);
        textBodyIds.add(R.id.learn_txtBalanceBody);
        textBodyIds.add(R.id.learn_txtConcBody);

        for (Integer id : textBodyIds) {
            TextView view = findViewById(id);
            util.searchClickableText(LearnActivity.this, view);
        }
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, LearnActivity.class);
    }
}