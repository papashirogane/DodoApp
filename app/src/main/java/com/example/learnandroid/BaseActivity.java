package com.example.learnandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
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
                startActivity(AddActivity.makeIntent(BaseActivity.this)); // gotta check if BaseActivity is properly replaced by AddActivity or DodoListActivity
                finish();
                break;
            case R.id.edit_delete:
                Toast.makeText(this, "Heading to Delete Activity.", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.iconHome:
                startActivity(DodoListActivity.makeIntent(BaseActivity.this));
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}