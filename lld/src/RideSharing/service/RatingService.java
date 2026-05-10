package RideSharing.service;

import RideSharing.models.Driver;
import RideSharing.models.Rider;

public class RatingService {
    public void rateDriver(Driver driver, double rating) {
        validate(rating);
        double updated = (driver.getRating() + rating) / 2.0;
        driver.setRating(updated);
        System.out.printf("  [Rating] Driver %s rated %.1f → New avg: %.2f%n",
                driver.getName(), rating, updated);
    }

    public void rateRider(Rider rider, double rating) {
        validate(rating);
        double updated = (rider.getRating() + rating) / 2.0;
        rider.setRating(updated);
        System.out.printf("  [Rating] Rider %s rated %.1f → New avg: %.2f%n",
                rider.getName(), rating, updated);
    }

    private void validate(double rating) {
        if (rating < 1.0 || rating > 5.0) {
            throw new IllegalArgumentException("Rating must be between 1.0 and 5.0");
        }
    }
}
