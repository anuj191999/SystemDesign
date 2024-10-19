package ObserverDesignPattern.Observable;

import ObserverDesignPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StocksObservable{

    public List<NotificationAlertObserver> observersList = new ArrayList<>();
    public int stockCount=0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observersList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver observer : observersList) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        // Some Business logic
        if(stockCount==0)
        {
            notifySubscribers();
        }
        stockCount=stockCount+newStockAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
