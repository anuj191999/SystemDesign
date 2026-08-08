package question.RideSharing.service;

import question.RideSharing.enums.DriverStatus;
import question.RideSharing.models.Driver;
import question.RideSharing.models.Location;
import question.RideSharing.models.Ride;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DriverMatchingService {

    public Optional<Driver> findNearestDriver(Ride ride, List<Driver> allDrivers){

        Location pickup=ride.getPickupLocation();

        return allDrivers.stream()
                .filter(d->d.getStatus()== DriverStatus.AVAILABLE)
                .filter(d->d.getVehicleType()==ride.getRideType())
                .min(Comparator.comparingDouble(d->d.getCurrentLocation().distanceTo(pickup)));
    }
}
