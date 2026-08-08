package question.RideSharing.command.impl;

import question.RideSharing.command.RideCommand;
import question.RideSharing.enums.RideStatus;
import question.RideSharing.models.Ride;
import question.RideSharing.observer.RideEventPublisher;

import java.time.LocalDateTime;

public class StartRideCommand implements RideCommand {

    private final Ride ride;
    private final RideEventPublisher rideEventPublisher;

    public StartRideCommand( Ride ride, RideEventPublisher rideEventPublisher) {

        this.ride = ride;
        this.rideEventPublisher = rideEventPublisher;
    }

    @Override
    public void execute() {
        if(ride.getStatus()!= RideStatus.ACCEPTED && ride.getStatus()!=RideStatus.DRIVER_ARRIVED){
            System.out.println("Cannot Start: ride must be Accepted or DRIVER_ARRIVED");
            return;
        }

        ride.setStatus(RideStatus.IN_PROGRESS);
        ride.setStartedAt(LocalDateTime.now());
        System.out.println("Ride "+ride.getId()+ "has Started");
        rideEventPublisher.notifyObservers(ride);
    }
}
