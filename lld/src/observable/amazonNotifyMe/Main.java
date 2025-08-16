package observable.amazonNotifyMe;

import observable.amazonNotifyMe.itemObservable.Iphone;
import observable.amazonNotifyMe.observerUser.User;

public class Main {
    public static void main(String[] args) {

        User user1=new User("user-1");
        User user2=new User("user-2");
        User user3=new User("user-3");

        Iphone iphoneObservable=new Iphone();


        user1.registerObserver(iphoneObservable);
        user2.registerObserver(iphoneObservable);
        user3.registerObserver(iphoneObservable);

        iphoneObservable.setData(10);

    }
}
