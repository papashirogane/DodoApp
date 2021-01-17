package com.example.learnandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.learnandroid.model.dodo.Dodo;
import com.example.learnandroid.model.dodo.DodoWaddle;

import java.util.Objects;

/**
 * List of dodos; clicking a dodo proceeds to a hunt
 * Its XML file is included in Edit1Activity and DeleteActivity's XML files
 */
public class DodoListActivity extends BaseActivity {
    private DodoWaddle MyWaddle = DodoWaddle.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodo_list);
        Toolbar toolbar = findViewById(R.id.toolbarDodoList);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Dodo Hunt");

        populateListView();
        registerClickCallback();
    }

    private void populateListView() {
        ArrayAdapter<Dodo> adapter = new DodoAdapter();
        ListView list = findViewById(R.id.listviewDodo);
        list.setAdapter(adapter);
    }

    private class DodoAdapter extends ArrayAdapter<Dodo> {
        public DodoAdapter() {
            super(DodoListActivity.this, R.layout.item_view, MyWaddle.waddle);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }
            // Now we have a view, but it's just using the defaults I put in item_view.xml.
            // I want to put in my own icon, name, weight, and height values.
            Dodo currentDodo = MyWaddle.get(position);
            ImageView imageView = itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(currentDodo.getIconId());
            TextView dodoName = itemView.findViewById(R.id.item_txtName);
            dodoName.setText(currentDodo.getName());
            TextView dodoMass = itemView.findViewById(R.id.item_txtMass);
            dodoMass.setText(String.format("%s kg", currentDodo.getMassKg()));
            TextView dodoDetails = itemView.findViewById(R.id.item_txtDetails);
            dodoDetails.setText(currentDodo.getDetails());
            return itemView;
        }
    }

    private void registerClickCallback() {
        ListView list = findViewById(R.id.listviewDodo);
        list.setOnItemClickListener((adapterView, view, i, l) -> {
            MyWaddle.clickedDodo = MyWaddle.get(i);
            startActivity(HuntInputActivity.makeIntent(DodoListActivity.this));
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, DodoListActivity.class);
    }
}