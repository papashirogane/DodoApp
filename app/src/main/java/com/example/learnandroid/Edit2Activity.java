package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnandroid.model.dodo.Dodo;
import com.example.learnandroid.model.dodo.DodoWaddle;

/**
 * Shows dodo information fiels that can be edited
 */
public class Edit2Activity extends AppCompatActivity {
    DodoWaddle MyWaddle = DodoWaddle.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit2);

        Toolbar toolbar = findViewById(R.id.toolbarInput);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit a dodo!");

        setupTextFills();
        setupEditButton();
    }

    private void setupTextFills() {
        Dodo dodo = MyWaddle.clickedDodo;
        TextView textView = (TextView) findViewById(R.id.input_txtfill1);
        textView.setText(dodo.getName());
        textView = (TextView) findViewById(R.id.input_txtfill2);
        textView.setText("" + dodo.getMassKg());
        textView = (TextView) findViewById(R.id.input_txtfill3);
        textView.setText(dodo.getDetails());
    }

    private void setupEditButton() {
        Button button = (Button) findViewById(R.id.input_btnSubmit);
        button.setText(R.string.edit_txtSubmit);
        button.setOnClickListener(view -> {
            String name = ((TextView) findViewById(R.id.input_txtfill1)).getText().toString();
            String details = ((TextView) findViewById(R.id.input_txtfill3)).getText().toString();
            String tempMass = ((TextView) findViewById(R.id.input_txtfill2)).getText().toString();
            Double mass = Double.parseDouble(tempMass);

            if (name.isEmpty()) Toast.makeText(Edit2Activity.this, "Name cannot be empty. Try again.", Toast.LENGTH_LONG).show();
            else {
                Dodo dodo = MyWaddle.clickedDodo;
                dodo.name = name;
                dodo.massKg = mass;
                dodo.details = details;
                Toast.makeText(Edit2Activity.this, "You edited a dodo!", Toast.LENGTH_LONG).show();
                Intent intent = DodoListActivity.makeIntent(Edit2Activity.this);
                startActivity(intent);
                finish();
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, Edit2Activity.class);
    }
}