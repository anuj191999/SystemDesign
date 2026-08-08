package question.RideSharing.command.impl;

import question.RideSharing.command.RideCommand;
import question.RideSharing.enums.DriverStatus;
import question.RideSharing.enums.RideStatus;
import question.RideSharing.models.Ride;
import question.RideSharing.observer.RideEventPublisher;

public class CancelRideCommand implements RideCommand {

    private final Ride ride;
    private final RideEventPublisher rideEventPublisher;

    public CancelRideCommand(Ride ride, RideEventPublisher rideEventPublisher) {
        this.ride = ride;
        this.rideEventPublisher = rideEventPublisher;
    }

    @Override
    public void execute() {
        if (ride.getStatus() == RideStatus.COMPLETED || ride.getStatus() == RideStatus.CANCELLED) {
            System.out.println("Cannot cancel: ride is already " + ride.getStatus());
            return;
        }
        if (ride.getDriver() != null) {
            ride.getDriver().setStatus(DriverStatus.AVAILABLE);
        }
        ride.setStatus(RideStatus.CANCELLED);
        System.out.println("Ride " + ride.getId() + " cancelled.");
        rideEventPublisher.notifyObservers(ride);
    }
}
