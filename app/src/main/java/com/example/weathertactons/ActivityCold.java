package com.example.weathertactons;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import java.util.ArrayList;

public class ActivityCold extends AppCompatActivity {

    public ArrayList vibration_categories = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cold);

        Intent intent = getIntent();
        vibration_categories = (ArrayList)intent.getStringArrayListExtra("VIBRATIONSARRAY");
    }

    public void down0Click(View view) {
        Intent intent = new Intent(this, ActivityCold2.class);
        vibration_categories.add("heavy_jacket");
        intent.putExtra("VIBRATIONSARRAY",vibration_categories);
        startActivity(intent);
    }

    public void between010Click(View view) {
        Intent intent = new Intent(this, ActivityCold2.class);
        vibration_categories.add("light_jacket");
        intent.putExtra("VIBRATIONSARRAY",vibration_categories);
        startActivity(intent);
    }
}
