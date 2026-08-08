package question.RideSharing.command;

import question.RideSharing.command.impl.AcceptRideCommand;
import question.RideSharing.command.impl.CancelRideCommand;
import question.RideSharing.command.impl.EndRideCommand;
import question.RideSharing.command.impl.StartRideCommand;
import question.RideSharing.models.Driver;
import question.RideSharing.models.Ride;
import question.RideSharing.observer.RideEventPublisher;

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
