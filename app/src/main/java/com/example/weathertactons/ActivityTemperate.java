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

public class ActivityTemperate extends AppCompatActivity {

    public ArrayList vibration_categories = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperate);

        Intent intent = getIntent();
        vibration_categories = (ArrayList)intent.getStringArrayListExtra("VIBRATIONSARRAY");
    }

    public void rainYesClick(View view) {
        Intent intent = new Intent(this, ActivityVibration.class);
        vibration_categories.add("raining");
        intent.putExtra("VIBRATIONSARRAY",vibration_categories);
        startActivity(intent);
    }

    public void rainNoClick(View view) {
        Intent intent = new Intent(this, ActivityVibration.class);
        intent.putExtra("VIBRATIONSARRAY",vibration_categories);
        startActivity(intent);
    }
}
