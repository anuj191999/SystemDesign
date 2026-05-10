package RideSharing;

import RideSharing.enums.RideType;
import RideSharing.models.Driver;
import RideSharing.models.Location;
import RideSharing.models.Ride;
import RideSharing.models.Rider;
import RideSharing.system.RideSharingSystem;

public class Main {
    public static void main(String[] args) {

        RideSharingSystem platform = RideSharingSystem.getInstance();

        // ── 1. Register Drivers ───────────────────────────────────────────────
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║     Ride Sharing System - Demo       ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        System.out.println("--- Registering Drivers ---");
        Driver driver1 = new Driver("D1", "Ramesh", "9999000001", RideType.SEDAN, new Location(28.6139, 77.2090));
        Driver driver2 = new Driver("D2", "Suresh", "9999000002", RideType.BIKE,  new Location(28.6200, 77.2150));
        Driver driver3 = new Driver("D3", "Mahesh", "9999000003", RideType.XL,    new Location(28.6050, 77.2000));

        platform.registerDriver(driver1);
        platform.registerDriver(driver2);
        platform.registerDriver(driver3);

        // ── 2. Drivers go online ──────────────────────────────────────────────
        System.out.println("\n--- Drivers Going Online ---");
        driver1.goOnline();
        driver2.goOnline();
        driver3.goOnline();

        // ── 3. Register Rider ─────────────────────────────────────────────────
        System.out.println("\n--- Registering Rider ---");
        Rider rider = new Rider("R1", "Priya", "8888000001", new Location(28.6129, 77.2295));
        platform.registerRider(rider);

        // ── 4. Fare Estimate ──────────────────────────────────────────────────
        System.out.println("\n--- Fare Estimates ---");
        Location pickup  = new Location(28.6129, 77.2295); // Connaught Place
        Location dropoff = new Location(28.5355, 77.3910); // Noida Sector 18

        platform.showFareEstimate(pickup, dropoff, RideType.BIKE);
        platform.showFareEstimate(pickup, dropoff, RideType.SEDAN);
        platform.showFareEstimate(pickup, dropoff, RideType.XL);

        // ── 5. Book a Sedan Ride ──────────────────────────────────────────────
        Ride ride = platform.bookRide(rider, pickup, dropoff, RideType.SEDAN);

        if (ride != null) {

            // ── 6. Track Ride ─────────────────────────────────────────────────
            platform.trackRide(ride.getId());

            // ── 7. Update driver location (simulating movement) ───────────────
            System.out.println("\n--- Driver Moving to Pickup ---");
            driver1.updateLocation(new Location(28.6130, 77.2290));

            // ── 8. Start Ride ─────────────────────────────────────────────────
            platform.startRide(ride.getId());

            // ── 9. End Ride ───────────────────────────────────────────────────
            platform.endRide(ride.getId());

            // ── 10. Ratings ───────────────────────────────────────────────────
            System.out.println("\n--- Post Ride Ratings ---");
            platform.rateDriver(driver1, 5.0);
            platform.rateRider(rider, 4.5);
        }

        // ── 11. Book a Bike ride + Cancel it ─────────────────────────────────
        System.out.println("\n\n--- Booking a Bike Ride (will be cancelled) ---");
        Rider rider2 = new Rider("R2", "Arjun", "8888000002", new Location(28.6200, 77.2100));
        platform.registerRider(rider2);

        Ride bikeRide = platform.bookRide(rider2,
                new Location(28.6200, 77.2100),
                new Location(28.6300, 77.2200),
                RideType.BIKE);

        if (bikeRide != null) {
            platform.cancelRide(bikeRide.getId());
        }

        // ── 12. Show driver status after rides ────────────────────────────────
        System.out.println("\n--- Final Driver Availability (SEDAN) ---");
        platform.showAvailableDrivers(RideType.SEDAN);
    }
}
