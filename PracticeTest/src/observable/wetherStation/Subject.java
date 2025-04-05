package observable.wetherStation;

public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    void setData(double updatedTemperature,double updatedHumidity);
}
