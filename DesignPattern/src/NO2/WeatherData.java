package NO2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yogurt on 16/7/24.
 */
public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers=new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unRegisterObserver(Observer observer) {
        int index=observers.indexOf(observer);
        if (index>=0) observers.remove(index);
    }

    @Override
    public void notifyObservers() {
        for (int i=0;i<observers.size();i++){
            Observer observer=observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }

    public void measurementChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementChanged();
    }

    public float getPressure() {
        return this.pressure;
    }
}
