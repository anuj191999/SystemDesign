package RideSharing.observer;

import RideSharing.models.Ride;

public interface RideObserver {
    void onRideStatusChanged(Ride ride);
}
