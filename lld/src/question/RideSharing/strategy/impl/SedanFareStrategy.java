package question.RideSharing.strategy.impl;

import question.RideSharing.strategy.FareStrategy;

public class SedanFareStrategy implements FareStrategy {

    private static final double BASE_FARE=30.0;
    private static final double PER_KM_RATE=12.0;

    @Override
    public double calculateFare(double distanceKm) {
        return BASE_FARE+(PER_KM_RATE*distanceKm);
    }

    @Override
    public String getDescription() {
        return "Sedan (Base: 20 + 12/km";
    }
}
