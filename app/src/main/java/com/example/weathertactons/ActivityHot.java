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

public class ActivityHot extends AppCompatActivity {

    ArrayList vibration_categories = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot);

        Intent intent = getIntent();
        vibration_categories = (ArrayList)intent.getStringArrayListExtra("VIBRATIONSARRAY");
    }

    public void up25Click(View view) {
        Intent intent = new Intent(this, ActivityHot2.class);
        vibration_categories.add("tshirt_shorts");
        intent.putExtra("VIBRATIONSARRAY",vibration_categories);
        startActivity(intent);
    }

    public void between2025Click(View view) {
        Intent intent = new Intent(this, ActivityHot2.class);
        vibration_categories.add("tshirt_pants");
        intent.putExtra("VIBRATIONSARRAY",vibration_categories);
        startActivity(intent);
    }
}
