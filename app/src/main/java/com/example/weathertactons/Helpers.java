package com.example.weathertactons;

public class Helpers {

    public static boolean isTempBetween(double temp, double lower, double higher){
        return (temp>lower && temp<higher);
    }
}
