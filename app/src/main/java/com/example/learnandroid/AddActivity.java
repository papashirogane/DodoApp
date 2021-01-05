package com.example.learnandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Add dodo to waddle
 */
public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Toolbar toolbar = findViewById(R.id.toolbarAdd);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add a Dodo");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dodo_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_add:
                Toast.makeText(this, "You are already in the Add Activity.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit_edit:
                Toast.makeText(this, "Heading to Edit Activity.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit_delete:
                Toast.makeText(this, "Heading to Delete Activity.", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, AddActivity.class);
    }
}