package com.example.learnandroid;

import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnandroid.model.dodo.Dodo;
import com.example.learnandroid.model.dodo.DodoWaddle;

/**
 * Adds a dodo to DodoWaddle
 */
public class AddActivity extends BaseActivity {
    DodoWaddle waddle = DodoWaddle.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Toolbar toolbar = findViewById(R.id.toolbarInput);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Create Your Dodo!");

        setupHints();
        setupButton();
    }

    private void setupHints() {
        TextView textView = (TextView) findViewById(R.id.input_txtfill1);
        textView.setHint(R.string.add_hintName);
        textView = (TextView) findViewById(R.id.input_txtfill2);
        textView.setHint(R.string.add_hintMass);
        textView = (TextView) findViewById(R.id.input_txtfill3);
        textView.setHint(R.string.add_hintDetails);
    }

    private void setupButton() {
        Button button = (Button) findViewById(R.id.input_btnSubmit);
        button.setText(R.string.add_txtSubmit);
        button.setOnClickListener(view -> {
            String name = ((TextView) findViewById(R.id.input_txtfill1)).getText().toString();
            String details = ((TextView) findViewById(R.id.input_txtfill3)).getText().toString();
            String tempMass = ((TextView) findViewById(R.id.input_txtfill2)).getText().toString();
            Double mass = Double.parseDouble(tempMass);

            if (name == "") Toast.makeText(AddActivity.this, "Name cannot be empty. Try again.", Toast.LENGTH_LONG).show();
            else {
                Dodo newDodo = new Dodo(name, mass, R.drawable.lazy1, details);
                waddle.add(newDodo);
                Toast.makeText(AddActivity.this, "You created a dodo!", Toast.LENGTH_LONG).show();
                Intent intent = DodoListActivity.makeIntent(AddActivity.this);
                startActivity(intent);
                finish();
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, AddActivity.class);
    }
}