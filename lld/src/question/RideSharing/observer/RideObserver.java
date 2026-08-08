package question.RideSharing.observer;

import question.RideSharing.models.Ride;

public interface RideObserver {
    void onRideStatusChanged(Ride ride);
}
