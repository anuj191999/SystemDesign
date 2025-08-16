package observable.amazonNotifyMe.itemObservable;

import observable.amazonNotifyMe.Observable;
import observable.amazonNotifyMe.Observer;

import java.util.ArrayList;
import java.util.List;

public class Iphone implements Observable {
    int stock;
    List<Observer> observerList;
    public Iphone() {
        observerList = new ArrayList<>();
        stock = 0;
    }
    @Override
    public void addObserver(Observer observer) {
     observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Iphone notifyObservers() method invoked");
        for (Observer observer : observerList) {
            observer.update(this.stock);
        }
    }

    @Override
    public void setData(int newStock) {
        System.out.println("Iphone setData() method invoked");
        this.stock=newStock;
        notifyObservers();
    }
}
