package RideSharing.command;

import RideSharing.command.impl.AcceptRideCommand;
import RideSharing.command.impl.CancelRideCommand;
import RideSharing.command.impl.EndRideCommand;
import RideSharing.command.impl.StartRideCommand;
import RideSharing.models.Driver;
import RideSharing.models.Ride;
import RideSharing.observer.RideEventPublisher;

public class RideCommandFactory {

    private final RideEventPublisher publisher;

    public RideCommandFactory(RideEventPublisher publisher){
        this.publisher=publisher;
    }
    public RideCommand acceptRide(Driver driver, Ride ride) {
        return new AcceptRideCommand(driver, ride, publisher);
    }

    public RideCommand startRide(Ride ride) {
        return new StartRideCommand(ride, publisher);
    }

    public RideCommand endRide(Ride ride) {
        return new EndRideCommand(ride, publisher);
    }

    public RideCommand cancelRide(Ride ride) {
        return new CancelRideCommand(ride, publisher);
    }
}
