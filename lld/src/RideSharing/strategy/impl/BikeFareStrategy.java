package RideSharing.strategy.impl;

import RideSharing.strategy.FareStrategy;

public class BikeFareStrategy implements FareStrategy {

    private static final double BASE_FARE=10.0;
    private static final double PER_KM_RATE=5.0;

    @Override
    public double calculateFare(double distanceKm) {
        return BASE_FARE +(PER_KM_RATE*distanceKm);
    }

    @Override
    public String getDescription() {
        return "Bike (Base : 10 + 5/km)";
    }
}
