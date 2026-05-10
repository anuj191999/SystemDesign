package RideSharing.models;

import RideSharing.enums.RideStatus;
import RideSharing.enums.RideType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ride {

    private final String id;
    private final Rider rider;
    private Driver driver;
    private final Location pickupLocation;
    private final Location dropoffLocation;
    private final RideType rideType;
    private RideStatus status;
    private double fare;
    private double distanceKm;
    private LocalDateTime requestedAt;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;

    public Ride(Rider rider, Location pickupLocation, Location dropoffLocation, RideType rideType) {
        this.id = UUID.randomUUID().toString();
        this.rider = rider;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.rideType = rideType;
        this.status = RideStatus.REQUESTED;
        this.distanceKm = pickupLocation.distanceTo(dropoffLocation);
        this.requestedAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public Location getDropoffLocation() {
        return dropoffLocation;
    }

    public RideType getRideType() {
        return rideType;
    }

    public RideStatus getStatus() {
        return status;
    }

    public double getFare() {
        return fare;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    @Override
    public String toString() {
        return String.format(
                "Ride[ID: %s | Rider: %s | Driver: %s | Type: %s | Status: %s | Distance: %.2f km | Fare: ₹%.2f]",
                id,
                rider.getName(),
                driver != null ? driver.getName() : "N/A",
                rideType,
                status,
                distanceKm,
                fare
        );
    }
}
