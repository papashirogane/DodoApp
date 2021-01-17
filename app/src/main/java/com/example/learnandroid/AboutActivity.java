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
 * About this app; shows user information about the purpose and calculations done in the app
 */
public class AboutActivity extends BaseActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = findViewById(R.id.toolbarAbout);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("About This App");

        setupClickableText();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setupClickableText() {
        Util util = Util.getSingleton();
        List<Integer> textBodyIds = new ArrayList<>();
        textBodyIds.add(R.id.about_txtPurposeBody);
        textBodyIds.add(R.id.about_txtHuntBody);
        textBodyIds.add(R.id.about_txtMathBody);
        textBodyIds.add(R.id.about_txtDiscussionBody);
        textBodyIds.add(R.id.about_txtLimitsBody);

        for (Integer id : textBodyIds) {
            TextView view = findViewById(id);
            util.searchClickableText(AboutActivity.this, view);
        }
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, AboutActivity.class);
    }
}