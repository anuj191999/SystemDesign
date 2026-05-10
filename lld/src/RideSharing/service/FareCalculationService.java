package RideSharing.service;

import RideSharing.enums.RideType;
import RideSharing.models.Ride;
import RideSharing.strategy.FareStrategy;
import RideSharing.strategy.FareStrategyFactory;

public class FareCalculationService {


    public double calculateFare(Ride ride){
        FareStrategy fareStrategy= FareStrategyFactory.getStrategy(ride.getRideType());
        double fare=fareStrategy.calculateFare(ride.getDistanceKm());
        System.out.printf("  Fare calculated using %s → ₹%.2f%n", fareStrategy.getDescription(), fare);
        return  fare;

    }

    public double estimateFare(double distanceKm, RideType rideType) {
        FareStrategy strategy = FareStrategyFactory.getStrategy(rideType);
        return strategy.calculateFare(distanceKm);
    }
}
