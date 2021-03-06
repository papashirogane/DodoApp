package com.example.learnandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Objects;

/**
 * User never sees this activity
 * Extended by every other activity (except MainActivity)
 * Deals with menu selections in toolbar
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Toolbar toolbar = findViewById(R.id.toolbarBase);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Base");
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
            case R.id.edit_edit:
                startActivity(Edit1Activity.makeIntent(BaseActivity.this));
                finish();
                break;
                case R.id.edit_delete:
                startActivity(DeleteActivity.makeIntent(BaseActivity.this));
                finish();
                break;
            case R.id.iconHome:
                startActivity(MainActivity.makeIntent(BaseActivity.this));
                finish();
                break;
            case R.id.settings:
                startActivity(SettingsActivity.makeIntent(BaseActivity.this));
                finish();
                break;
            case R.id.learn:
                startActivity(LearnActivity.makeIntent(BaseActivity.this));
                finish();
                break;
            case R.id.about:
                startActivity(AboutActivity.makeIntent(BaseActivity.this));
                finish();
                break;
            case R.id.refs:
                startActivity(ReferencesActivity.makeIntent(BaseActivity.this));
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}