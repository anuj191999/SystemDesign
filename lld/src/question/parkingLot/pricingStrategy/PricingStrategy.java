package question.parkingLot.pricingStrategy;

import question.parkingLot.invoice.Ticket;

public interface PricingStrategy {
    double calculatePrice(Ticket ticket, long exitTimeMillis);
}
