package RideSharing.strategy;

public interface FareStrategy {
    double calculateFare(double distanceKm);
    String getDescription();
}
