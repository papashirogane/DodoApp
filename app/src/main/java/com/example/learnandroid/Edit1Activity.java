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
 * Shows a list of dodos.
 * When a dodo is clicked, proceeds to Edit2Activity where dodo info can be edited
 */
public class Edit1Activity extends BaseActivity {
    DodoWaddle MyWaddle = DodoWaddle.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Toolbar toolbar = findViewById(R.id.toolbarDodoList);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Edit a dodo!");

        populateListView();
        registerClickCallback();
    }


    private void registerClickCallback() {
        ListView list = findViewById(R.id.listviewDodo);
        list.setOnItemClickListener((adapterView, view, i, l) -> {
            MyWaddle.clickedDodo = MyWaddle.get(i);
            Intent intent = Edit2Activity.makeIntent(Edit1Activity.this);
            startActivity(intent);
            finish();
        });
    }

    private void populateListView() {
        ArrayAdapter<Dodo> adapter = new Edit1Activity.DodoAdapter();
        ListView list = findViewById(R.id.listviewDodo);
        list.setAdapter(adapter);
    }

    private class DodoAdapter extends ArrayAdapter<Dodo> {
        public DodoAdapter() {
            super(Edit1Activity.this, R.layout.item_view, MyWaddle.waddle);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }
            Dodo currentDodo = MyWaddle.get(position);
            ImageView imageView = itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(currentDodo.getIconId());
            TextView dodoName = itemView.findViewById(R.id.item_txtName);
            dodoName.setText(currentDodo.getName());
            TextView dodoMass = itemView.findViewById(R.id.item_txtMass);
            dodoMass.setText(String.format("%s kg", currentDodo.getMassKg()));
            TextView dodoDetails = itemView.findViewById(R.id.item_txtDetails);
            dodoDetails.setText(String.format("\"%s\"", currentDodo.getDetails()));
            return itemView;
        }
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, Edit1Activity.class);
    }
}