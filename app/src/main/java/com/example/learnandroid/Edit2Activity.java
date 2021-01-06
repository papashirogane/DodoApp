package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
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

public class Edit2Activity extends AppCompatActivity {
    DodoWaddle MyWaddle = DodoWaddle.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit2);

        Toolbar toolbar = findViewById(R.id.toolbarAdd);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit a dodo!");

        setupText();
        setupEditButton();
    }

    private void setupText() {
        Dodo dodo = MyWaddle.clickedDodo;
        TextView textView = (TextView) findViewById(R.id.add_txtfillName);
        textView.setText(dodo.getName());
        textView = (TextView) findViewById(R.id.add_txtfillMass);
        textView.setText("" + dodo.getMassKg());
        textView = (TextView) findViewById(R.id.add_txtfillDetails);
        textView.setText(dodo.getDetails());
        Button button = (Button) findViewById(R.id.add_btnCreate);
        textView.setHint(R.string.edit_txtSubmit);
    }

    private void setupEditButton() {
        Button button = (Button) findViewById(R.id.add_btnCreate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((TextView) findViewById(R.id.add_txtfillName)).getText().toString();
                String details = ((TextView) findViewById(R.id.add_txtfillDetails)).getText().toString();
                String tempMass = ((TextView) findViewById(R.id.add_txtfillMass)).getText().toString();
                Double mass = Double.parseDouble(tempMass);

                if (name == "") Toast.makeText(Edit2Activity.this, "Name cannot be empty. Try again.", Toast.LENGTH_LONG).show();
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
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, Edit2Activity.class);
    }
}