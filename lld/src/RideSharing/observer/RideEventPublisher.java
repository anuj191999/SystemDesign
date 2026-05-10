package RideSharing.observer;

import RideSharing.models.Ride;

import java.util.ArrayList;
import java.util.List;

public class RideEventPublisher {

    private final List<RideObserver> observerList=new ArrayList<>();

    public  void subscribe(RideObserver observer){
        observerList.add(observer);
    }

    public void unsubscribe(RideObserver observer){
        observerList.remove(observer);
    }

    public void notifyObservers(Ride ride){
        for (RideObserver rideObserver: observerList){
            rideObserver.onRideStatusChanged(ride);
        }
    }
}
