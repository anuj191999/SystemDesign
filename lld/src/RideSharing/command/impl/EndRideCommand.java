package RideSharing.command.impl;

import RideSharing.command.RideCommand;
import RideSharing.enums.DriverStatus;
import RideSharing.enums.RideStatus;
import RideSharing.models.Ride;
import RideSharing.observer.RideEventPublisher;

import java.time.LocalDateTime;

public class EndRideCommand implements RideCommand {

    private final Ride ride;
    private final RideEventPublisher rideEventPublisher;

    public EndRideCommand(Ride ride, RideEventPublisher rideEventPublisher) {
        this.ride = ride;
        this.rideEventPublisher = rideEventPublisher;
    }

    @Override
    public void execute() {
        if(ride.getStatus()!= RideStatus.IN_PROGRESS){
            System.out.println("Cannot end : ride is not IN_PROGRESS");
            return;
        }

        ride.setStatus(RideStatus.COMPLETED);
        ride.setCompletedAt(LocalDateTime.now());
        ride.getDriver().setStatus(DriverStatus.AVAILABLE);
        System.out.println("Ride "+ride.getId()+" completed");
        rideEventPublisher.notifyObservers(ride);
    }
}
