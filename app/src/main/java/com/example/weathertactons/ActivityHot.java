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

public class ActivityHot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot);

        Intent intent = getIntent();
    }

    public void up25Click(View view) {
        Intent intent = new Intent(this, ActivityHot2.class);
        startActivity(intent);
    }

    public void between2025Click(View view) {
        Intent intent = new Intent(this, ActivityHot2.class);
        startActivity(intent);
    }
}
