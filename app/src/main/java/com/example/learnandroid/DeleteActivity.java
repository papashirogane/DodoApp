package com.example.learnandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
import android.widget.Toast;

import com.example.learnandroid.model.dodo.Dodo;
import com.example.learnandroid.model.dodo.DodoWaddle;

import java.util.Objects;

/**
 * Deletes a dodo from the list after user confirms "yes" on an AlertDialog.
 */
public class DeleteActivity extends BaseActivity {
    DodoWaddle MyWaddle = DodoWaddle.getInstance();
    ArrayAdapter<Dodo> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Toolbar toolbar = findViewById(R.id.toolbarDodoList);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Delete a dodo.");

        populateListView();
        registerClickCallback();
    }

    // AlertDialog is learned from David Hedlund and Hariharan's answers in
    // https://stackoverflow.com/questions/2115758/how-do-i-display-an-alert-dialog-on-android
    private void registerClickCallback() {
        ListView list = findViewById(R.id.listviewDodo);
        list.setOnItemClickListener((adapterView, view, i, l) -> {
            Dodo clickedDodo = MyWaddle.waddle.get(i);
            new AlertDialog.Builder(DeleteActivity.this)
                    .setTitle("Delete dodo")
                    .setMessage("Are you sure you want to delete dodo " + clickedDodo.getName() + "?")
                    .setPositiveButton("Yes", (dialogInterface, i1) -> {
                        MyWaddle.waddle.remove(i);
                        Toast.makeText(DeleteActivity.this
                                , "You deleted a dodo!", Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();
                        dialogInterface.dismiss();
                    })
                    .setNegativeButton("No", null)
                    .show();
        });
    }

    private void populateListView() {
        adapter = new DeleteActivity.DodoAdapter();
        ListView list = findViewById(R.id.listviewDodo);
        list.setAdapter(adapter);
    }

    private class DodoAdapter extends ArrayAdapter<Dodo> {
        public DodoAdapter() {
            super(DeleteActivity.this, R.layout.item_view, MyWaddle.waddle);
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
        return new Intent(context, DeleteActivity.class);
    }
}