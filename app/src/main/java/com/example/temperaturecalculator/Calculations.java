package com.example.temperaturecalculator;

public class Calculations {
    protected static float convertCelciusToFahrenheit(Float value) {
        Float ans = (value - 32) * 5/9;
        return ans;
    }
    protected static float convertFahrenheitToCelcius(Float value) {
        Float ans = (value * 9/5) + 32;
        return ans;
    }
}
