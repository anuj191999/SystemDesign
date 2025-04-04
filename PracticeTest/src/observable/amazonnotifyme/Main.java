package observable.amazonnotifyme;

import observable.amazonnotifyme.itemObservable.Iphone;
import observable.amazonnotifyme.observerUser.User;

public class Main {
    public static void main(String[] args) {

        User user1=new User("user-1");
        User user2=new User("user-2");
        User user3=new User("user-3");

        Iphone iphoneObservable=new Iphone();

        iphoneObservable.addObserver(user1);
        iphoneObservable.addObserver(user2);
        iphoneObservable.addObserver(user3);

        iphoneObservable.setData(10);

    }
}
