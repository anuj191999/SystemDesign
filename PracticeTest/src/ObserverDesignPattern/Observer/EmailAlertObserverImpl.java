package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    private String emailId;
    StocksObservable observable;
    public EmailAlertObserverImpl(String emailId, StocksObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }


    @Override
    public void update() {
        sendMail(emailId, "Product is in stock hurry up!!");
    }

    private void sendMail(String emailId, String message) {
        System.out.println("mail sent to " + emailId);

        // Actual Send mail logic
    }
}
