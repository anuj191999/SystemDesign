package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{

    private String userName;
    private StocksObservable observable;

    public MobileAlertObserverImpl(String userName, StocksObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(userName,"Product is in Stock hurry up!!");
    }
    private void sendMsgOnMobile(String userName, String msg){
        System.out.println("msg sent to :"+userName);
        // Implement the actual Logic
    }
}
