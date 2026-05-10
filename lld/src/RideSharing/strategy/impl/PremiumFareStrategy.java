package RideSharing.strategy.impl;

import RideSharing.strategy.FareStrategy;

public class PremiumFareStrategy implements FareStrategy {

    private static final double BASE_FARE = 80.0;
    private static final double PER_KM_RATE = 25.0;

    @Override
    public double calculateFare(double distanceKm) {
        return BASE_FARE + (PER_KM_RATE * distanceKm);
    }

    @Override
    public String getDescription() { return "Premium (Base: 80 + 25/km)"; }
}
