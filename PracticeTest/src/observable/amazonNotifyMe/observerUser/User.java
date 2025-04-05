package observable.amazonNotifyMe.observerUser;

import observable.amazonNotifyMe.Observable;
import observable.amazonNotifyMe.Observer;
public class User implements Observer {
    private int newStock;
    private String name;
    public User(String name) {
        this.newStock=0;
        this.name = name;
    }
    @Override
    public void update(int newStock) {
        this.newStock=newStock;
        display();
    }

    @Override
    public void registerObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void unregisterObserver(Observable observable) {
        observable.removeObserver(this);
    }


    private void display() {
        System.out.println(this.name+": New Stock: "+newStock);
    }
}
