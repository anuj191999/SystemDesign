package parkingLot.pricingStrategy;

import parkingLot.invoice.Ticket;

public interface PricingStrategy {
    double calculatePrice(Ticket ticket, long exitTimeMillis);
}
