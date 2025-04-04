package observable.amazonNotifyMe;
public interface Observable {
     void addObserver(Observer observer);
     void removeObserver(Observer observer);
     void notifyObservers();
     void setData(int newStock);
}
