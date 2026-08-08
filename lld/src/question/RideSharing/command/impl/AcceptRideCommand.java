package question.RideSharing.command.impl;

import question.RideSharing.command.RideCommand;
import question.RideSharing.enums.DriverStatus;
import question.RideSharing.enums.RideStatus;
import question.RideSharing.models.Driver;
import question.RideSharing.models.Ride;
import question.RideSharing.observer.RideEventPublisher;

public class AcceptRideCommand implements RideCommand
{
    private final Driver driver;
    private final Ride ride;
    private final RideEventPublisher publisher;

    public AcceptRideCommand(Driver driver, Ride ride, RideEventPublisher publisher) {
        this.driver = driver;
        this.ride = ride;
        this.publisher = publisher;
    }

    @Override
    public void execute() {

        if(ride.getStatus()!= RideStatus.REQUESTED){
            System.out.println("Cannot accept : ride is not in REQUEST state.");
            return;
        }

        ride.setDriver(driver);
        ride.setStatus(RideStatus.ACCEPTED);
        driver.setStatus(DriverStatus.ON_TRIP);
        System.out.println("Driver "+ driver.getName()+" accept Ride "+ride.getId());
        publisher.notifyObservers(ride);
    }
}
