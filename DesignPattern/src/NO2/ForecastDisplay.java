package NO2;

import java.util.*;

/**
 * Created by Yogurt on 16/7/24.
 */
public class ForecastDisplay implements java.util.Observer,DisplayElement {
    Observable observable;
    private float currentPressure=29.92f;
    private float lastPressure;
    public ForecastDisplay(Observable observable){
        this.observable=observable;
        observable.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData){
            WeatherData weatherData=(WeatherData)o;
            this.lastPressure=currentPressure;
            this.currentPressure=weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("LastPressure= "+lastPressure+"     currentPressure= "+currentPressure);
    }
}
