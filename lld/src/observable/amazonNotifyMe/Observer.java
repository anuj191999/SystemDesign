package observable.amazonNotifyMe;

public interface Observer {
    void update(int newStock);
    void registerObserver(Observable observable);
    void unregisterObserver(Observable observable);
}
