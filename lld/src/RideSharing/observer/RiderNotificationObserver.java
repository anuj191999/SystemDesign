package RideSharing.observer;

import RideSharing.models.Ride;

public class RiderNotificationObserver implements RideObserver{

    @Override
    public void onRideStatusChanged(Ride ride) {
        String message=switch (ride.getStatus()){
            case ACCEPTED -> "Your ride has been accepted by "+ ride.getDriver().getName();
            case DRIVER_ARRIVED -> "Your driver has arrived at pickup!";
            case IN_PROGRESS -> "Your ride has started. Enjoy the trip!";
            case COMPLETED -> String.format("Ride Completed! Fare: %.3f ",ride.getFare());
            case CANCELLED -> "Your ride has been Cancelled";
            default -> null;
        };

        if(message!=null){
            System.out.println("[SMS -> Rider "+ride.getRider().getName()+"]: "+message);
        }
    }
}
