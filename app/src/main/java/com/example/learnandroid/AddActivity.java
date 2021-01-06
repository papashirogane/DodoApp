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
 * Add dodo to waddle
 */
public class AddActivity extends BaseActivity {
    DodoWaddle waddle = DodoWaddle.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Toolbar toolbar = findViewById(R.id.toolbarAdd);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Create Your Dodo!");

        setupCreateButton();
    }

    private void setupCreateButton() {
        Button button = (Button) findViewById(R.id.add_btnCreate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((TextView) findViewById(R.id.add_txtfillName)).getText().toString();
                String details = ((TextView) findViewById(R.id.add_txtfillDetails)).getText().toString();
                String tempMass = ((TextView) findViewById(R.id.add_txtfillMass)).getText().toString();
                Double mass = Double.parseDouble(tempMass);

                if (name == "") Toast.makeText(AddActivity.this, "Name cannot be empty. Try again.", Toast.LENGTH_LONG).show();
                else {
                    Dodo newDodo = new Dodo(name, mass, R.drawable.lazy1, details);
                    waddle.add(newDodo);
                    Toast.makeText(AddActivity.this, "You created a dodo!", Toast.LENGTH_SHORT).show();
                    Intent intent = DodoListActivity.makeIntent(AddActivity.this);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, AddActivity.class);
    }
}