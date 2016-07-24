package NO2;

/**
 * Created by Yogurt on 16/7/24.
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void unRegisterObserver(Observer observer);
    public void notifyObservers();
}
