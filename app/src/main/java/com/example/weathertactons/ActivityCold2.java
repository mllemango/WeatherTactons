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

public class ActivityCold2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cold2);

        Intent intent = getIntent();
    }

    public void rainYesClick(View view) {
        Intent intent = new Intent(this, ActivityVibration.class);
        startActivity(intent);
    }

    public void rainNoClick(View view) {
        Intent intent = new Intent(this, ActivityVibration.class);
        startActivity(intent);
    }

    public void snowYesClick(View view) {
        Intent intent = new Intent(this, ActivityVibration.class);
        startActivity(intent);
    }

    public void snowNoClick(View view) {
        Intent intent = new Intent(this, ActivityVibration.class);
        startActivity(intent);
    }
}
