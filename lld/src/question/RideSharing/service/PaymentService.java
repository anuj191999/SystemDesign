package question.RideSharing.service;

import question.RideSharing.models.Ride;

public class PaymentService {

    public void processPayment(Ride ride) {
        if (ride.getFare() <= 0) {
            System.out.println("  [Payment] No fare to collect.");
            return;
        }

        System.out.printf("  [Payment] ₹%.2f charged to %s for Ride %s. ✓%n",
                ride.getFare(), ride.getRider().getName(), ride.getId());
    }
}
