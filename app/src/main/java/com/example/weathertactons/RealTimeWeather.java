package com.example.weathertactons;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static com.example.weathertactons.Helpers.isTempBetween;

public class RealTimeWeather extends AppCompatActivity {

    public final String TAG = "RealTimeWeather";

    private String API_KEY = BuildConfig.API_KEY;

    Double feelsLike;
    String condition = "";

    TextView responseText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_time_weather);
        responseText = (TextView) findViewById(R.id.responseText);
        //if "get me the weather" button is pressed, execute function weatherHaptics
        boolean mainFunction = getIntent().getBooleanExtra("combine", false);
//        if (mainFunction){
//            weatherHaptics();
//        }
        weatherHaptics();
    }

    private void weatherHaptics(){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.openweathermap.org/data/2.5/forecast?id=6176821&units=metric&APPID=" + API_KEY;
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        HashMap<String, String> weatherMap = null;
                        String weather = "getting weather...";

                        try {
                            weatherMap = parseResponse(response);

                        } catch (JSONException e) {
                            Log.e(TAG, e.toString());
                        }
                        feelsLike = Double.valueOf(weatherMap.get("feelsLike"));
                        condition = weatherMap.get("condition");
                        Log.d(TAG, "setting feelsLike and condition");

                        weather = "feelsLike " + feelsLike +
                                " condition: " + condition;
                        responseText.setText(weather);

                        determineHaptics();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,error.getMessage());
                responseText.setText("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    private void determineHaptics(){
        ActivityVibration vibration = new ActivityVibration();;
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (condition.contains("extreme")){
            vibration.extremeButtonClick(v);
        }

        if (feelsLike<0){
            //heavy jacket
            vibration.heavyJacketButtonClick(v);
            Log.d(TAG, "heavy jacket");
        }
        else if (isTempBetween(feelsLike, 0, 9)){
            //light jacket
            vibration.lightJacketButtonClick(v);
            Log.d(TAG, "light jacket");
        }
        else if (isTempBetween(feelsLike, 10, 19)){
            //sweater/pants
            vibration.sweaterPantsButtonClick(v);
            Log.d(TAG, "sweater/pants");
        }
        else if (isTempBetween(feelsLike, 20, 24)){
            //pants/tshirt
            vibration.tshirtPantsButtonClick(v);
            Log.d(TAG, "pants/shirt");
        }
        else {
            // shorts/tshirt
            vibration.tshirtShortsButtonClick(v);
            Log.d(TAG, "shorts/shirt");
        }

        try {
            // thread to sleep for 1000 milliseconds
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (condition.contains("rain")){
            vibration.umbrellaButtonClick(v);
            Log.d(TAG, "umbrella");
        }
        else if (condition.contains("snow")){
            vibration.bootsButtonClick(v);
            Log.d(TAG, "boots");
        }
    }


    public void getAPIData(View view){
        //array for access purposes
        final Double[] feelsLike = new Double[1];
        final String[] condition = new String[1];

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.openweathermap.org/data/2.5/forecast?id=6176821&units=metric&APPID=" + API_KEY;
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        HashMap<String, String> weatherMap = null;
                        String weather = "getting weather...";

                        try {
                            weatherMap = parseResponse(response);

                        } catch (JSONException e) {
                            Log.e(TAG, e.toString());
                        }
                        feelsLike[0] = Double.valueOf(weatherMap.get("feelsLike"));
                        condition[0] = weatherMap.get("condition");

                        weather = "feelsLike " + feelsLike[0] +
                                " condition: " + condition[0];
                        responseText.setText(weather);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,error.getMessage());
                responseText.setText("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private HashMap<String, String> parseResponse(String response) throws JSONException {
        HashMap<String, String> weather = new HashMap<>();

        // Convert String to json object
        JSONArray responseJson = new JSONObject(response).getJSONArray("list");
        Log.d(TAG, responseJson.toString());

        JSONObject curWeather = responseJson.getJSONObject(0);
        JSONObject main = curWeather.getJSONObject("main");
        double feelsLike = main.getDouble("feels_like");
        String condition = curWeather.getJSONArray("weather").getJSONObject(0).getString("main");
        Log.d(TAG, condition);

        weather.put("feelsLike", Double.toString(feelsLike));
        weather.put("condition", condition);

        return weather;
    }

}
