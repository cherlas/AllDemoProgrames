package NO2;

/**
 * Created by Yogurt on 16/7/24.
 */
public class WeatherStation {
    public static void main(String[] args){
        WeatherData weatherData=new WeatherData();
        CurrentConditionsDisplay currentCD=new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80,60,30.4f);
        weatherData.setMeasurements(82,70,29.4f);
        weatherData.setMeasurements(78,80,33.4f);
    }
}
