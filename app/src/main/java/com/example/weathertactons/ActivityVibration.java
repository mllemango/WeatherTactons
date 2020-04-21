package com.example.weathertactons;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import java.util.ArrayList;

public class ActivityVibration extends AppCompatActivity {

    public ArrayList vibration_categories = new ArrayList();
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibration);

        Intent intent = getIntent();
        vibration_categories = (ArrayList)intent.getStringArrayListExtra("VIBRATIONSARRAY");
        Log.d("VIBRATION ARRAY", "VIBRATIONS PAGE: " + vibration_categories);
    }

    public void mainpageClick(View view) {
        Log.d("IN MAIN PAGE CLICK", "YEP");
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void runVibrations(View view) {
        if(vibration_categories.contains("EXTREME")){
            Log.d("IN RUN VIBRATIONS", "EXTREME" + vibration_categories);
            extremeButtonClick();
        }

        if(vibration_categories.contains("tshirt_shorts")){
            Log.d("IN RUN VIBRATIONS", "TSHIRT SHORTS" + vibration_categories);
            tshirtShortsButtonClick();
        }else if(vibration_categories.contains("tshirt_pants")){
            Log.d("IN RUN VIBRATIONS", "TSHIRT PANTS" + vibration_categories);
            tshirtPantsButtonClick();
        }else if(vibration_categories.contains("light_jacket")){
            Log.d("IN RUN VIBRATIONS", "LIGHT JACKET" + vibration_categories);
            lightJacketButtonClick();
        }else if(vibration_categories.contains("heavy_jacket")){
            Log.d("IN RUN VIBRATIONS", "HEAVYH JACKET" + vibration_categories);
            heavyJacketButtonClick();
        }else if(vibration_categories.contains("sweater_pants")){
            Log.d("IN RUN VIBRATIONS", "TSHIRT PANTS" + vibration_categories);
            sweaterPantsButtonClick();
        }

        try {
            // thread to sleep for 1000 milliseconds
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println(e);
        }

        if(vibration_categories.contains("raining")){
            Log.d("IN RUN VIBRATIONS", "RAINING" + vibration_categories);
            umbrellaButtonClick();
        }else if(vibration_categories.contains("snowing")){
            Log.d("IN RUN VIBRATIONS", "SNOWING" + vibration_categories);
            bootsButtonClick();
        }

    }

    public void extremeButtonClick(){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = new long[]{1000, 800, 200, 800, 200, 800};

        // An amplitude of 0 implies no vibration (i.e. off), and any pairs with a timing value of 0 will be ignored.
        int[] amps = new int[]{0, 255, 0, 255, 0, 255};

        // -1 : Do not repeat this pattern
        // pass 0 if you want to repeat this pattern from 0th index
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createWaveform(pattern, amps, -1));
        } else {
            //deprecated in API 26
            v.vibrate(pattern, -1);
        }
    }

    public void tshirtShortsButtonClick() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = new long[]{1000, 200, 200, 200};

        // An amplitude of 0 implies no vibration (i.e. off), and any pairs with a timing value of 0 will be ignored.
        int[] amps = new int[]{0, 100, 0, 100};

        // -1 : Do not repeat this pattern
        // pass 0 if you want to repeat this pattern from 0th index
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createWaveform(pattern, amps, -1));
        } else {
            //deprecated in API 26
            v.vibrate(pattern, -1);
        }
    }

    public void tshirtPantsButtonClick() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = new long[]{1000, 200, 200, 800};

        // An amplitude of 0 implies no vibration (i.e. off), and any pairs with a timing value of 0 will be ignored.
        int[] amps = new int[]{0, 100, 0, 100};

        // -1 : Do not repeat this pattern
        // pass 0 if you want to repeat this pattern from 0th index
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createWaveform(pattern, amps, -1));
        } else {
            //deprecated in API 26
            v.vibrate(pattern, -1);
        }
    }

    public void sweaterPantsButtonClick() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = new long[]{1000, 200, 200, 200};

        // An amplitude of 0 implies no vibration (i.e. off), and any pairs with a timing value of 0 will be ignored.
        int[] amps = new int[]{0, 225, 0, 225};

        // -1 : Do not repeat this pattern
        // pass 0 if you want to repeat this pattern from 0th index
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createWaveform(pattern, amps, -1));
        } else {
            //deprecated in API 26
            v.vibrate(pattern, -1);
        }
    }

    public void heavyJacketButtonClick() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = new long[]{1000, 200, 200, 200, 200, 200, 200, 800};

        // An amplitude of 0 implies no vibration (i.e. off), and any pairs with a timing value of 0 will be ignored.
        int[] amps = new int[]{0, 200, 0, 200, 0, 200, 0, 255};

        // -1 : Do not repeat this pattern
        // pass 0 if you want to repeat this pattern from 0th index
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createWaveform(pattern, amps, -1));
        } else {
            //deprecated in API 26
            v.vibrate(pattern, -1);
        }
    }

    public void lightJacketButtonClick() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = new long[]{1000, 200, 200, 200, 200, 200, 200, 800};

        // An amplitude of 0 implies no vibration (i.e. off), and any pairs with a timing value of 0 will be ignored.
        int[] amps = new int[]{0, 100, 0, 100, 0, 100, 0, 50};

        // -1 : Do not repeat this pattern
        // pass 0 if you want to repeat this pattern from 0th index
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createWaveform(pattern, amps, -1));
        } else {
            //deprecated in API 26
            v.vibrate(pattern, -1);
        }
    }

    public void bootsButtonClick(){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = new long[]{1000, 1000};

        // An amplitude of 0 implies no vibration (i.e. off), and any pairs with a timing value of 0 will be ignored.
        int[] amps = new int[]{0, 100};

        // -1 : Do not repeat this pattern
        // pass 0 if you want to repeat this pattern from 0th index
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createWaveform(pattern, amps, -1));
        } else {
            //deprecated in API 26
            v.vibrate(pattern, -1);
        }
    }

    public void umbrellaButtonClick(){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = new long[]{1000, 150, 150, 150, 150, 150, 150, 150, 150, 150};

        // An amplitude of 0 implies no vibration (i.e. off), and any pairs with a timing value of 0 will be ignored.
        int[] amps = new int[]{0, 75, 0, 75, 0, 75, 0, 75, 0, 75};

        // -1 : Do not repeat this pattern
        // pass 0 if you want to repeat this pattern from 0th index
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createWaveform(pattern, amps, -1));
        } else {
            //deprecated in API 26
            v.vibrate(pattern, -1);
        }
    }


}
