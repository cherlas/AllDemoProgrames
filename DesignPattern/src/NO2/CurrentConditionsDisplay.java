package NO2;

/**
 * Created by Yogurt on 16/7/24.
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;
    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature=temp;
        this.humidity=humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: Temp= "+temperature+"   humidity= "+humidity);
    }
}
