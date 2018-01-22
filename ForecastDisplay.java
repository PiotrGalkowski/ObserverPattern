package com.dev30plus;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {

    private float currentPressure = 1010.1f;
    private float lastPressure;

    public ForecastDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Prognoza: ");
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherData){
            WeatherData weatherData = (WeatherData) observable;
            this.lastPressure = currentPressure;
            this.currentPressure = weatherData.getPressure();
            display();
        }
    }
}
