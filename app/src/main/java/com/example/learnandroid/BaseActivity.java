package com.example.learnandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
        Intent intent;
        switch (item.getItemId()) {
            case R.id.edit_add:
                startActivity(AddActivity.makeIntent(BaseActivity.this));
                break;
            case R.id.edit_edit:
                Toast.makeText(this, "Heading to Edit Activity.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit_delete:
                Toast.makeText(this, "Heading to Delete Activity.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iconHome:
                startActivity(MainActivity.makeIntent(BaseActivity.this));
                break;
            default:
                break;
        }
        return true;
    }
}