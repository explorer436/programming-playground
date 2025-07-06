package com.my.company.observerpattern.firstshot;

public class WeatherData {

    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementsChanged() {
        float temperature = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();

        // currentConditionsDisplay.update(temperature, humidity, pressure);
        // statisticsDisplay.update(temperature, humidity, pressure);
        // forecastDisplay.update(temperature, humidity, pressure);
    }

    // Grab the most recent measurements by calling the WeatherData's getter methods.

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    // Other helpful methods
}