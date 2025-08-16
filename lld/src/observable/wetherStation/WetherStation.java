package observable.wetherStation;

import java.util.ArrayList;
import java.util.List;

public class WetherStation implements Subject{
    private double temperature;
    private double humidity;
    private List<Observer> observersList;

    WetherStation() {
        observersList = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {

        if(!observersList.contains(observer)){
            observersList.add(observer);
        }
        else{
            System.out.println("Observer already exists");
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if(observersList.contains(observer)){
            observersList.remove(observer);
        }
        else{
            System.out.println("Observer doesn't exists");
        }
    }

    @Override
    public void notifyObservers() {

        for(Observer observer : observersList){
            observer.update(temperature, humidity);
        }
    }

    @Override
    public void setData(double updatedTemperature, double updatedHumidity) {

        this.temperature=updatedTemperature;
        this.humidity=updatedHumidity;
        notifyObservers();
    }
}
