package com.example.learnandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnandroid.model.dodo.Dodo;
import com.example.learnandroid.model.dodo.DodoWaddle;

import java.util.Objects;

/**
 * Shows dodo information fiels that can be edited
 */
public class Edit2Activity extends BaseActivity {
    DodoWaddle MyWaddle = DodoWaddle.getInstance();
    private int clickedIconId = R.drawable.dodo;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit2);

        Toolbar toolbar = findViewById(R.id.toolbarInput);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Edit a dodo!");

        setupTextFills();
        setupTableButtons();
        setupEditButton();
    }

    private void setupTextFills() {
        Dodo dodo = MyWaddle.clickedDodo;
        TextView textView = findViewById(R.id.input_txtfill1);
        textView.setText(dodo.getName());
        textView = findViewById(R.id.input_txtfill2);
        textView.setText(String.format("%s", dodo.getMassKg()));
        textView = findViewById(R.id.input_txtfill3);
        textView.setText(dodo.getDetails());
    }

    /**
     * Based on Vinayak Bevinakatti's answer from
     * https://stackoverflow.com/questions/5327553/android-highlight-an-imagebutton-when-clicked
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @SuppressLint("ClickableViewAccessibility")
    private void setupTableButtons() {
        TableLayout table = findViewById(R.id.input_tableLayout);
        int rows = table.getChildCount();
        for (int y = 0; y < rows; y++) {
            TableRow row = (TableRow) table.getChildAt(y);
            int cols = row.getChildCount();
            for (int x = 0; x < cols; x++) {
                int[] images = MyWaddle.iconOpts;
                ImageButton button = (ImageButton) row.getChildAt(x);
                Drawable clickedIcon = getDrawable(images[(y * cols) + x]);
                button.setImageDrawable(clickedIcon);

                final int finalY = y;
                final int finalX = x;
                button.setOnTouchListener((view, motionEvent) -> {
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            if (!view.isPressed()) {
                                clearPressed();
                                view.setPressed(true);
                                view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                                view.invalidate();
                            }
                            break;
                        case MotionEvent.ACTION_UP:
                            clickedIconId = images[ finalY *cols + finalX];
                        default:
                            break;
                    }
                    return true;
                });
            }
        }
    }

    private void clearPressed() {
        TableLayout table = findViewById(R.id.input_tableLayout);
        int rows = table.getChildCount();
        for (int y = 0; y < rows; y++) {
            TableRow row = (TableRow) table.getChildAt(y);
            int cols = row.getChildCount();
            for (int x = 0; x < cols; x++) {
                ImageButton button = (ImageButton) row.getChildAt(x);
                button.setPressed(false);
                button.getBackground().clearColorFilter();
                button.invalidate();
            }
        }
    }

    private void setupEditButton() {
        Button button = findViewById(R.id.input_btnSubmit);
        button.setText(R.string.edit_txtSubmit);
        button.setOnClickListener(view -> {
            String name = ((TextView) findViewById(R.id.input_txtfill1)).getText().toString();
            String details = ((TextView) findViewById(R.id.input_txtfill3)).getText().toString();
            String tempMass = ((TextView) findViewById(R.id.input_txtfill2)).getText().toString();

            if (name.isEmpty() || tempMass.isEmpty())
                Toast.makeText(Edit2Activity.this,
                        "Name and mass cannot be empty. Try again.", Toast.LENGTH_LONG).show();
            else {
                double mass = Double.parseDouble(tempMass);
                Dodo dodo = MyWaddle.clickedDodo;
                dodo.name = name;
                dodo.massKg = mass;
                dodo.details = details;
                dodo.iconId = clickedIconId;
                Toast.makeText(Edit2Activity.this, "You edited a dodo!", Toast.LENGTH_SHORT).show();
                Intent intent = DodoListActivity.makeIntent(Edit2Activity.this);
                startActivity(intent);
                finish();
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, Edit2Activity.class);
    }
}