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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //{sleep, vibrate, sleep, vibrate...}
    // 0 : Start without a delay
    // 400 : Vibrate for 400 milliseconds
    // 200 : Pause for 200 milliseconds
    // 400 : Vibrate for 400 milliseconds
    // repeat

    public void hotButtonClick(View view) {
//        Log.d("HOT","inside hot button");
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(500);
        }

    }

    public void coldButtonClick(View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = new long[]{0, 400, 200, 400, 200, 400, 200, 400};

        // An amplitude of 0 implies no vibration (i.e. off), and any pairs with a timing value of 0 will be ignored.
        int[] amps = new int[]{0, 200, 0, 100, 0, 50, 0, 5};

        // -1 : Do not repeat this pattern
        // pass 0 if you want to repeat this pattern from 0th index
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createWaveform(pattern, amps, -1));
        } else {
            //deprecated in API 26
            v.vibrate(pattern, -1);
        }
    }

    public void extremeButtonClick(View view){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = new long[]{0, 800, 200, 800, 200, 800};

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

    public void tshirtShortsButtonClick(View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = new long[]{0, 200, 200, 200};

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

    public void sweaterPantsButtonClick(View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = new long[]{0, 200, 200, 200};

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

    public void heavyJacketButtonClick(View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = new long[]{0, 200, 200, 200, 200, 200, 200, 800};

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

    public void lightJacketButtonClick(View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = new long[]{0, 200, 200, 200, 200, 200, 200, 800};

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

}
