package RideSharing.strategy.impl;

import RideSharing.strategy.FareStrategy;

public class XLFareStrategy implements FareStrategy {
    private static final double BASE_FARE = 50.0;
    private static final double PER_KM_RATE = 18.0;

    @Override
    public double calculateFare(double distanceKm) {
        return BASE_FARE + (PER_KM_RATE * distanceKm);
    }

    @Override
    public String getDescription() { return "XL (Base: 50 + ₹18/km)"; }
}
