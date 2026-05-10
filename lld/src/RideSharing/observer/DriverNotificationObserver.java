package RideSharing.observer;

import RideSharing.models.Ride;


public class DriverNotificationObserver implements RideObserver{

    @Override
    public void onRideStatusChanged(Ride ride) {

        if(ride.getRider()==null) return;

        String message = switch (ride.getStatus()) {
            case CANCELLED   -> "Ride " + ride.getId() + " was cancelled by the rider.";
            case COMPLETED   -> String.format("Ride %s completed. Earned: ₹%.2f", ride.getId(), ride.getFare());
            default          -> null;
        };
        if (message != null) {
            System.out.println("  [APP → Driver " + ride.getDriver().getName() + "]: " + message);
        }
    }
}
