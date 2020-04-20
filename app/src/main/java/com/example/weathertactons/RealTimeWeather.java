package com.example.weathertactons;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.JsonReader;
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

public class RealTimeWeather extends AppCompatActivity {

    public final String TAG = "RealTimeWeather";

    private String API_KEY = BuildConfig.API_KEY;

    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_time_weather);
        responseText = (TextView) findViewById(R.id.responseText);
    }

    public void getAPIData(View view){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.openweathermap.org/data/2.5/forecast?id=6176821&units=metric&APPID=" + API_KEY;
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        String weather = "getting weather...";

                        try {
                            weather = parseResponse(response);
                        } catch (JSONException e) {
                            Log.e(TAG, e.toString());
                        }
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

    private String parseResponse(String response) throws JSONException {
        // Convert String to json object
        JSONArray responseJson = new JSONObject(response).getJSONArray("list");
        Log.d(TAG, responseJson.toString());

        JSONObject curWeather = responseJson.getJSONObject(0);
        JSONObject main = curWeather.getJSONObject("main");
        double feelsLike = main.getDouble("feels_like");
        String weather = curWeather.getJSONArray("weather").getJSONObject(0).getString("main");
        Log.d(TAG, weather);
        return "feelsLike " + feelsLike + " condition: " + weather;
    }

}
