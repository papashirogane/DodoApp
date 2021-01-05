package com.example.learnandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnandroid.model.dodo.Dodo;

import java.util.ArrayList;
import java.util.List;

public class DodoListActivity extends AppCompatActivity {
    private List<Dodo> waddle = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodo_list);
        
        populateWaddle();
        populateListView();
        registerClickCallback();
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.dodoListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dodo clickedDodo = waddle.get(i);
                Toast.makeText(DodoListActivity.this, "You clicked on " + clickedDodo.getName(), Toast.LENGTH_SHORT).show();
                /*Intent intent = ThirdActivity.makeIntent(DodoListActivity.this);
                startActivity(intent);*/
                // opens new activity which has fill-in-the-blanks for sailor health, sailor distance, and dodo distance in metres
                // maybe pass in an extra?
                // need to keep track of clicked dodo
            }
        });
    }

    private void populateWaddle() {
        waddle.add(new Dodo("Baby", 3, R.drawable.lazy1, "Waaaaa!"));
        waddle.add(new Dodo("Emo Teen", 5, R.drawable.lazy2, "Go away mom."));
        waddle.add(new Dodo("Mama Dodo", 7, R.drawable.lazy3, "I gotta quit smoking."));
        waddle.add(new Dodo("Happy Papi", 10, R.drawable.lazy4, "Borgor."));
        waddle.add(new Dodo("Big Uncle", 15, R.drawable.lazy5, "Look at these GUNS *slaps biceps*"));
        waddle.add(new Dodo("Lil Rhea", 20, R.drawable.lazy6, "Uuuhhhhh..."));
    }

    private void populateListView() {
        // Use an ArrayAdapter
        ArrayAdapter<Dodo> adapter = new DodoAdapter();
        ListView list = (ListView) findViewById(R.id.dodoListView);
        list.setAdapter(adapter);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, DodoListActivity.class);
    }

    private class DodoAdapter extends ArrayAdapter<Dodo> {
        public DodoAdapter() {
            super(DodoListActivity.this, R.layout.item_view, waddle);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }
            // Now we have a view, but it's just using the defaults I put in item_view.xml. I want to put in my own icon, name, weight, and height.
            Dodo currentDodo = waddle.get(position);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.item_icon); // not sure why we have to findViewById inside of ImageView instead of just this activity
            imageView.setImageResource(currentDodo.getIconId());

            TextView dodoName = (TextView) itemView.findViewById(R.id.item_txtName);
            dodoName.setText(currentDodo.getName());

            TextView dodoMass = (TextView) itemView.findViewById(R.id.item_txtMass);
            dodoMass.setText("" + currentDodo.getMassKg());

            TextView dodoDetails = (TextView) itemView.findViewById(R.id.item_txtDetails);
            dodoDetails.setText("" + currentDodo.getDetails());

            return itemView;
        }
    }


}