package question.RideSharing.system;

import question.RideSharing.command.RideCommandFactory;
import question.RideSharing.enums.DriverStatus;
import question.RideSharing.enums.RideType;
import question.RideSharing.models.Driver;
import question.RideSharing.models.Location;
import question.RideSharing.models.Ride;
import question.RideSharing.models.Rider;
import question.RideSharing.observer.DriverNotificationObserver;
import question.RideSharing.observer.RideEventPublisher;
import question.RideSharing.observer.RiderNotificationObserver;
import question.RideSharing.service.DriverMatchingService;
import question.RideSharing.service.FareCalculationService;
import question.RideSharing.service.PaymentService;
import question.RideSharing.service.RatingService;

import java.util.*;

public class RideSharingSystem {

    private static RideSharingSystem instance;

    private final List<Driver> drivers=new ArrayList<>();
    private final List<Rider> riders=new ArrayList<>();
    private final Map<String, Ride> activeRides=new HashMap<>();

    private final RideEventPublisher publisher;
    private final RideCommandFactory commandFactory;
    private final DriverMatchingService matchingService;
    private final FareCalculationService fareService;
    private final PaymentService paymentService;
    private final RatingService ratingService;

    private RideSharingSystem(){
        publisher =new RideEventPublisher();
        commandFactory=new RideCommandFactory(publisher);
        matchingService=new DriverMatchingService();
        fareService=new FareCalculationService();
        paymentService=new PaymentService();
        ratingService=new RatingService();

        publisher.subscribe(new RiderNotificationObserver());
        publisher.subscribe(new DriverNotificationObserver());
    }

    public static RideSharingSystem getInstance(){
        if(instance==null){
            instance=new RideSharingSystem();
        }
        return instance;
    }

    // Registration

    public void registerDriver(Driver driver){
        drivers.add(driver);
        System.out.println("Registered : "+driver);
    }

    public void registerRider(Rider rider){
        riders.add(rider);
        System.out.println("Registered: " + rider);
    }

    public void showFareEstimate(Location pickup, Location dropoff, RideType rideType) {
        double distance = pickup.distanceTo(dropoff);
        double estimate = fareService.estimateFare(distance, rideType);
        System.out.printf("Fare Estimate [%s] for %.2f km → ₹%.2f%n", rideType, distance, estimate);
    }

    // ── Rider: Book Ride ──────────────────────────────────────────────────────

    public Ride bookRide(Rider rider, Location pickup, Location dropoff, RideType rideType) {
        System.out.println("\n=== Booking Ride ===");
        Ride ride = new Ride(rider, pickup, dropoff, rideType);

        // Calculate & set fare upfront
        double fare = fareService.calculateFare(ride);
        ride.setFare(fare);

        // Match nearest driver
        Optional<Driver> matched = matchingService.findNearestDriver(ride, drivers);

        if (matched.isEmpty()) {
            System.out.println("No available drivers for " + rideType + ". Try again later.");
            return null;
        }

        // Auto-accept (platform assigns driver)
        commandFactory.acceptRide(matched.get(), ride).execute();
        activeRides.put(ride.getId(), ride);
        return ride;
    }

    // ── Driver: Start Ride ────────────────────────────────────────────────────

    public void startRide(String rideId) {
        Ride ride = getRide(rideId);
        if (ride == null) return;
        System.out.println("\n=== Starting Ride ===");
        commandFactory.startRide(ride).execute();
    }

    // ── Driver: End Ride ──────────────────────────────────────────────────────

    public void endRide(String rideId) {
        Ride ride = getRide(rideId);
        if (ride == null) return;
        System.out.println("\n=== Ending Ride ===");
        commandFactory.endRide(ride).execute();
        paymentService.processPayment(ride);
        activeRides.remove(rideId);
    }

    // ── Cancel Ride ───────────────────────────────────────────────────────────

    public void cancelRide(String rideId) {
        Ride ride = getRide(rideId);
        if (ride == null) return;
        System.out.println("\n=== Cancelling Ride ===");
        commandFactory.cancelRide(ride).execute();
        activeRides.remove(rideId);
    }

    // ── Track Ride ────────────────────────────────────────────────────────────

    public void trackRide(String rideId) {
        Ride ride = getRide(rideId);
        if (ride == null) return;
        System.out.println("\n=== Tracking Ride ===");
        System.out.println(ride);
        if (ride.getDriver() != null) {
            System.out.println("Driver Location: " + ride.getDriver().getCurrentLocation());
        }
    }

    // ── Rating ────────────────────────────────────────────────────────────────

    public void rateDriver(Driver driver, double rating) {
        ratingService.rateDriver(driver, rating);
    }

    public void rateRider(Rider rider, double rating) {
        ratingService.rateRider(rider, rating);
    }

    // ── Driver Availability ───────────────────────────────────────────────────

    public void showAvailableDrivers(RideType type) {
        System.out.println("\nAvailable Drivers for " + type + ":");
        drivers.stream()
                .filter(d -> d.getStatus() == DriverStatus.AVAILABLE && d.getVehicleType() == type)
                .forEach(d -> System.out.println("  " + d));
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    private Ride getRide(String rideId) {
        Ride ride = activeRides.get(rideId);
        if (ride == null) {
            System.out.println("Ride not found: " + rideId);
        }
        return ride;
    }

}
